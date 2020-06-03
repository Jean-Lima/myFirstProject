package com.example.aula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_toolbar.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initToolbar()

        initButtom()
    }

    private fun initButtom() {
        cardView.setOnClickListener {
            val novaTela = Intent(this, SendActivity::class.java)
            startActivity(novaTela)
        }
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "BEM VINDO"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }



}
