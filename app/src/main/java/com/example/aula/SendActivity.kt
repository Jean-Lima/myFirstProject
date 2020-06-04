package com.example.aula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_send.*
import kotlinx.android.synthetic.main.include_toolbar.toolbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)
        initToolbar()
        request()
    }

    fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "MINHA LISTA"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    fun request() {
        Api().retrofit.create(ApiInterface::class.java).getList()
            .enqueue(object : Callback<List<PostModel>> {
                override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                    d("testando", "falhou")
                }

                override fun onResponse(
                    call: Call<List<PostModel>>,
                    response: Response<List<PostModel>>
                ) {
                    var lista = response.body()
                    initAdapter(lista)
                }

            })
    }

    private fun initAdapter(lista: List<PostModel>?) {
        val recyclerView = listview
        recyclerView.adapter = SendAdapter(lista!!)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        recyclerView.layoutManager = layoutManager
    }

}
