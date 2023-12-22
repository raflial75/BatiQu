# BatiQu - Batik Qualifier and Shopping
**Team CH2-PS382**  
Batik, Indonesia's iconic cultural treasure, faces the risk of fading from modern recognition. BatiQu seeks to revitalize interest in batik by developing a mobile app that leverages technology to seamlessly connect users with its beauty and heritage. The app offers features for pattern recognition, personalized recommendations for local batik stores, and a platform for supporting artists.  

Team Members:  
| Names                        | ID        | Learning Path |
|------------------------------|-----------|---------------|
|Dedi Arianto                  |M312BSY0858|Machine Learning|
|Nabela Afrilia                |M015BSY0051|Machine Learning|
|Muhammad Reza Yoga Putra      |M312BSX1658|Machine Learning|
|Al Kautsar Russetya Tamora    |A179BSY2348|Mobile Development|
|Dzaky Taqiyyudin              |A702BSY2840|Mobile Development|
|Aisya Rahma Yusriyya          |C312BSX3942|Cloud Computing|
|Rafli Alfian                  |C314BSY4168|Cloud Computing|

## Application Interface
![Landing Page](/Documentation/assets/21.png)
![Main Menu](/Documentation/assets/22.png)
![Batik Motif Detection](/Documentation/assets/23.png)
![Maps](/Documentation/assets/24.png)

## BatiQu Services
We're using cloud run to deploy the maps API and the flask app. From the local computer where we develop the apps then push to GitHub. On the Google Cloud Platform, the cloud shell used to do clone request from GitHub with `git clone <repository link>`. In the cloud shell, docker command used to build and tag image before pushed to artifact registery. After that using the `gcloud run deploy <services name>` command to deploy into cloud run.
![Deployment-Solutions](/Documentation/assets/Deployment-solutions.png)

The services start from users then access the app from their phone. Users directed to do register/login. The firebase used to store users regitration information for login purpose. The application serve informations about batik motif. Users also can use some services like finding nearby batik shops and batik motif detection.
![BatiQu Services Flow](/Documentation/assets/BatiQu-Service.png)
## API Services
**Map Services**
- Install express.js using command `npm install express`
- Because this service using Maps Javascript API. Its need to activate the API through GCP.
- After the API enabled, copy the API key and paste it on app.html file
- Run the app.js using command `node src/app.js`
- On the browser open 'http://localhost:8080/public/app.html  
*Directory Tree*
```bash
API
│   .dockerignore
│   .gitignore
│   Dockerfile
│   package-lock.json
│   package.json
│
└───src
    │   app.js
    │   config.js
    │
    └───public
            app.html
            app.js
            index.css
```
**Flask-App**
```bash
requirements:
Flask==2.2.2
tensorflow==2.14.0
pillow==10.0.1
```
- Instal requirement libraries needed `pip install Flask tensorflow pillow`
- After the installation success, run terminal and run command `python app.py`
- On the browser open `http://127.0.0.1:5500/templates/index.html` for detection page.
- Try upload file to detect
- The resut will be served on page `http://127.0.0.1/templates/result.html`  
*Directory Tree*
```bash
Flask-App
├───classes
│   └───__pycache__
├───static
│   ├───css
│   │   └───assets
│   └───uploads
└───templates
    └───main
        └───assets
```

