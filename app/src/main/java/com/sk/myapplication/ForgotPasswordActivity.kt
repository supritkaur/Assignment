package com.sk.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import java.util.jar.Attributes

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var etName:EditText
    lateinit var etEmail: EditText
    lateinit var etPassword:EditText
    lateinit var etNewPassword:EditText
    lateinit var etPhone:EditText
    lateinit var btnSignup:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)
        etNewPassword = findViewById(R.id.etNewPassword)
        btnSignup=findViewById(R.id.btnSignup)

        etPassword.doOnTextChanged { text, start, before, count ->
            if ((text?.length?:0)<6){
                etPassword.error=resources.getString(R.string.please_enter_Password)
            }else{
                etPassword.error=null
            }
        }

        btnSignup.setOnClickListener {
            System.out.println("Signup Clicked")



        var Name = etName.text.toString()
        var Email = etEmail.text.toString()
        var Password = etPassword.text.toString()
        var Phone = etPhone.text.toString()
        var NewPassword = etNewPassword.text.toString()


        if (Name.isNullOrEmpty()) {
            etName.error = "please enter Name"
            etName.requestFocus()
        } else if (Email.isNullOrEmpty()) {
            etEmail.error = "please enter Email"
            etEmail.requestFocus()
        } else if(Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString()).matches() == false){
            etEmail.error = resources.getString(R.string.enter_valid_email)
            etEmail.requestFocus()
        } else if (Phone.isNullOrEmpty()) {
            etPhone.error = "please enter phone"
            etPhone.requestFocus()
        } else if (Password.isNullOrEmpty()) {
            etPassword.error = "please enter Password"
            etPassword.requestFocus()
        }else if (NewPassword.isNullOrEmpty()){
            etNewPassword.error="please enter NewPassword"
            etNewPassword.requestFocus()
    }else {Toast.makeText(this,"Signup successful",Toast.LENGTH_LONG).show();
            var intent = Intent(this, otpactivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
}
