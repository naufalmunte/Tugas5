package com.naufal.tugas5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class diskon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diskon)

        val btnBack: Button = findViewById(R.id.btnBack)
        val totalB = findViewById<EditText>(R.id.inputTb)
        val  totalD = findViewById<Button>(R.id.btntd)
        val hasilD = findViewById<TextView>(R.id.tvTd)

        totalD.setOnClickListener {
            val tb = totalB.text.toString().toDoubleOrNull()

            if (tb != null){
                var diskon = 0.0

                when{
                    tb < 100000 -> {
                        diskon = 0.0
                    }
                    tb in 100000.0..500000.0 -> {
                        diskon = 0.10 * tb
                    }
                    tb in 500000.0..1000000.0 -> {
                        diskon = 0.20 * tb
                    }
                    tb > 1000000 -> {
                        diskon = 0.30 * tb
                    }
                }
                val totalSetelahDiskon = tb - diskon

                // Menampilkan hasil
                hasilD.text = "Total Belanja: Rp. $tb\n" +
                        "Total Diskon: Rp. $diskon\n" +
                        "---------------------------------------\n" +
                        "Total Setelah Diskon: Rp. $totalSetelahDiskon"
            }else{

            }
        }

        btnBack.setOnClickListener {
            startActivity(Intent(this@diskon, MainActivity::class.java))
            finish()


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}