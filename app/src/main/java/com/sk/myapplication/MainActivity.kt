package com.sk.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.*
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var etPhone: EditText
    lateinit var tvForgotPassword:TextView
    lateinit var btnLogin: Button
    lateinit var rgGender:RadioGroup
    lateinit var etEnterOtherGender:EditText
    lateinit var rbShe:RadioButton
    lateinit var rbHe:RadioButton
    lateinit var rbOthers:RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etPhone=findViewById(R.id.etPhone)
        tvForgotPassword=findViewById(R.id.tvForgotPassword)
        btnLogin = findViewById(R.id.btnLogin)
        etEnterOtherGender=findViewById(R.id.etEnterOtherGender)
        rbShe=findViewById(R.id.rbShe)
        rbHe=findViewById(R.id.rbHe)
        rbOthers=findViewById(R.id.rbOthers)
        rgGender=findViewById(R.id.rgGender)


            btnLogin.setOnClickListener {
            System.out.println("Login Clicked")
            etPassword.doOnTextChanged { text, start, before, count ->
            if ((text?.length?:0)<6){
                etPassword.error=resources.getString(R.string.please_enter_Password)
            }else{
                etPassword.error=null
            }
            }
                tvForgotPassword=findViewById(R.id.tvForgotPassword)
                tvForgotPassword.setOnClickListener {
                    var intent = Intent(this, ForgotPasswordActivity::class.java)
                    startActivity(intent)
                }

        rgGender.setOnCheckedChangeListener { radioGroup, int ->
            when (int) {
                R.id.rbOthers -> {
                    etEnterOtherGender.visibility = View.VISIBLE
                }
                else -> {
                    etEnterOtherGender.visibility = View.GONE

                }
            }
        }


    var Email = etEmail.text.toString()
    var Password = etPassword.text.toString()
    var Phone =etPhone.text.toString()
            System.out.println("Email $Email")
            if (Email.isNullOrEmpty()) {
                etEmail.error = resources.getString(R.string.please_enter_Email)
                etEmail.requestFocus()
            } else if (Password.isNullOrEmpty()) {
                etPassword.error = resources.getString(R.string.please_enter_Password)
                etPassword.requestFocus()
            } else if(Phone.isNullOrEmpty()) {
                etPhone.error = "please enter Phone"
                etPhone.requestFocus()
            }else {
                Toast.makeText(
                    this,
                    resources.getString(R.string.Login_Successfully),
                    Toast.LENGTH_LONG
                ).show();
                var intent = Intent(this, ForgotPasswordActivity::class.java)
                startActivity(intent)
                finish()
            }
            }
    }
}