 package com.naufal.tugas5

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val ActButton1 = findViewById<Button>(R.id.btnSuhu)
        ActButton1.setOnClickListener {
            val Intent = Intent(this, convert_suhu::class.java)
            startActivity(Intent)
        }

        val ActButton2 = findViewById<Button>(R.id.btnDiskon)
        ActButton2.setOnClickListener {
            val Intent = Intent(this, diskon::class.java)
            startActivity(Intent)
        }

        val ActButton3 = findViewById<Button>(R.id.btnLuas)
        ActButton3.setOnClickListener {
            val Intent = Intent(this, hitung_luas::class.java)
            startActivity(Intent)
        }

        val ActButton4 = findViewById<Button>(R.id.btnBilangan)
        ActButton4.setOnClickListener {
            val Intent = Intent(this, bilangan::class.java)
            startActivity(Intent)
        }

        val buttonExit: Button = findViewById(R.id.btnExit)
        buttonExit.setOnClickListener {
            finishAffinity()
        }

        val ActButtonLogin = findViewById<Button>(R.id.btnLogin)
        ActButtonLogin.setOnClickListener {
            val Intent = Intent(this, Login_Page::class.java)
            startActivity(Intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        }
    }
