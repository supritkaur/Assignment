package com.sk.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class dialer : AppCompatActivity() {
    lateinit var btnDialer: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialer)
        btnDialer=findViewById(R.id.btnDialer)

        btnDialer.setOnClickListener {
            System.out.println("Dialer Clicked")
            val intent= Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse("tel:9999922222")
            startActivity(intent);
        }
    }
}


