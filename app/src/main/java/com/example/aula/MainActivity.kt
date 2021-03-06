package com.example.aula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }


    fun init() {
        experimente.setOnClickListener {
            val novaTela = Intent(this, HomeActivity::class.java)
            startActivity(novaTela)
        }

        cadastro.setOnClickListener {
            val telaCadastral = Intent(this, RegisterActivity::class.java)
            startActivity(telaCadastral)
        }
    }
}

