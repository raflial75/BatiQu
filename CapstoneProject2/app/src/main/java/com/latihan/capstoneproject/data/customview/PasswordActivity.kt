package com.latihan.capstoneproject.data.customview

import android.content.Context
import android.graphics.Canvas
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import com.latihan.capstoneproject.R
import com.latihan.capstoneproject.data.validateMinLegth

class PasswordActivity: AppCompatEditText {
    constructor(context: Context): super(context){
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        hint = "Password"
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }

    private fun init(){
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (validateMinLegth(text.toString())) {
                    this@PasswordActivity.error = null
                    if (s.isEmpty()) {
                        error = context.getString(R.string.empty_password)
                    }
                }
                else {
                    this@PasswordActivity.error = context.getString(R.string.alert_password)
                }
            }
            override fun afterTextChanged(s: Editable) {
            }
        })
    }
}