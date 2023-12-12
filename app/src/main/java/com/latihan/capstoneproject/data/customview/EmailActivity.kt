package com.latihan.capstoneproject.data.customview

import android.content.Context
import android.graphics.Canvas
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.latihan.capstoneproject.R
import com.latihan.capstoneproject.data.isValidEmail

class EmailActivity: AppCompatEditText {
    constructor(context: Context): super(context){
        init()
    }

    constructor(context: Context, attrs: AttributeSet): super(context, attrs){
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr){
        init()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        hint = "Email"
        textAlignment = TEXT_ALIGNMENT_VIEW_START
    }

    private fun init() {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                val emailPattern = "^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]{2,}[.][a-zA-Z]{2,4}\$"

                if (isValidEmail(text.toString())) {
                    this@EmailActivity.error = null
                }
                else {
                    this@EmailActivity.error = "Email Tidak Valid"
                }

                when{
                    s.isEmpty() -> {
                        error = context.getString(R.string.alert_email)
                    }
                    !s.trim { it <= ' '}
                        .matches(emailPattern.toRegex()) && s.isNotEmpty() -> {
                        error = context.getString(R.string.empty_email)
                    }
                }
            }
        })
    }
}