from flask import Flask, render_template, request, redirect, url_for
import tensorflow as tf
import numpy as np
import os
from werkzeug.utils import secure_filename
from PIL import Image
from classes.class_history import CLASS_HIST
from classes.class_names import CLASS_NAME
from classes.class_origin import CLASS_ORIGIN
from classes.class_name import CLASS_NAMES

app = Flask(__name__, template_folder='templates')
UPLOAD_FOLDER = 'static/uploads'
MODEL_PATH = '20_patterns.h5'
model = tf.keras.models.load_model(MODEL_PATH)

@app.route('/', methods=['GET'])
def index():
    return render_template('index.html')

@app.route('/upload', methods=['POST'])
def upload_file():
    if 'file' not in request.files:
        return redirect(request.url)
    file = request.files['file']
    if file.filename == '':
        return redirect(request.url)
    if file:
        file_path = os.path.join(UPLOAD_FOLDER, secure_filename(file.filename))
        print("File path:", file_path)
        file.save(file_path)
        result = detect_batik_pattern(file_path)
        return render_template('result.html', result=result, image_path=file_path)

def detect_batik_pattern(file_path):
    img = Image.open(file_path)
    img = img.resize((224, 224))
    img_array = tf.keras.preprocessing.image.img_to_array(img)
    img_array = np.expand_dims(img_array, axis=0)
    img_array /= 255.0
    prediction = model.predict(img_array)
    predicted_class = np.argmax(prediction)
    pattern_name = CLASS_NAMES.get(predicted_class, 'Unknown')
    name = CLASS_NAME.get(pattern_name, 'No description')
    origin = CLASS_ORIGIN.get(pattern_name, 'Unknown')
    history = CLASS_HIST.get(pattern_name, 'Unknown') 
    return {'result': pattern_name, 'name': name, 'origin': origin, 'history': history}

if __name__ == '__main__':
    app.run(host='0.0.0.0', port='80', debug=False)
    # app.run(debug=True)