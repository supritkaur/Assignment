package com.sk.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.EditText

class otpactivity : AppCompatActivity() {

        var email: String = ""
        lateinit var etEmail: EditText
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_otpactivity)
            intent?.let { abc->
                if(abc.hasExtra("email"))
                    email = abc.getStringExtra("email") as String

            }?:kotlin.run {  }
            etEmail = findViewById(R.id.etEmail)

            etEmail.setText(email)

        }
    }
