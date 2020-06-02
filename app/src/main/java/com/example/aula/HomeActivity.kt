package com.example.aula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import kotlinx.android.synthetic.main.include_toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "BEM VINDO"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        request()

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
                    var test = lista
                }

            })
    }

}
