package com.naufal.tugas5

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class convert_suhu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_convert_suhu)
        val inputC = findViewById<EditText>(R.id.inputC)
        val btnHitung = findViewById<Button>(R.id.btnHitung)
        val Fahr = findViewById<TextView>(R.id.Fahr)
        val Kelv = findViewById<TextView>(R.id.kelv)
        val Ream = findViewById<TextView>(R.id.Ream)
        val btnBack: Button = findViewById(R.id.btnBack)

        btnHitung.setOnClickListener {
            val Celcius = inputC.text.toString().toDoubleOrNull()

            if (Celcius != null){
                val Fahreinheit = (9.0/5.0) * Celcius +32
                val Kelvin = Celcius + 273.15
                val Reamur = (4.0/5.0) * Celcius

                Fahr.text = "Fahreinheit : $Fahreinheit"
                Kelv.text = "Kelvin : $Kelvin"
                Ream.text = "Reumur : $Reamur"
            }else{
                Fahr.text="Inputan Salah"
                Kelv.text="Inputan Salah"
                Ream.text="Inputan Salah"
            }
        }


        btnBack.setOnClickListener {
            startActivity(Intent(this@convert_suhu, MainActivity::class.java))
            finish()

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}
