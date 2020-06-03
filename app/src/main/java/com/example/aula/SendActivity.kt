package com.example.aula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_send.*
import kotlinx.android.synthetic.main.include_toolbar.*
import kotlinx.android.synthetic.main.include_toolbar.toolbar

class SendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)
        initToolbar()
        initList()
    }

    fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "MINHA LISTA"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun initList() {
        val COMPRAS = arrayOf(
            "Arroz",
            "Feijão",
            "Carne",
            "Tempero",
            "Leite",
            "Oleo",
            "Salgadinho",
            "Biscoito",
            "Margarina"
        )

        listview.adapter = ArrayAdapter(
            this,
            R.layout.adapter_compras,
            COMPRAS
        )

    }


}
