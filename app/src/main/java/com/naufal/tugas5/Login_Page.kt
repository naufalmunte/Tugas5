package com.naufal.tugas5

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login_Page : AppCompatActivity() {

    private lateinit var etUsername : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnLogin : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)

        etUsername=findViewById(R.id.etUsername)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val intent=Intent(this, page2::class.java)
            val nUsername = etUsername.text.toString()
            val nPassword = etPassword.text.toString()

            intent.putExtra("Username", nUsername)
            intent.putExtra("Password", nPassword)
            print("Username :" + nUsername)
            print("Password :" + nPassword)
            startActivity(intent)

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}