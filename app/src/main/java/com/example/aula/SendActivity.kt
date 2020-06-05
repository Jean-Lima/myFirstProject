package com.example.aula

import android.app.AlertDialog
import android.content.Intent
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

    var lista: ArrayList<PostModel> = ArrayList()
    var adapter: SendAdapter? = null

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

                    AlertDialog.Builder(this@SendActivity)
                        .setTitle("Erro")
                        .setMessage("Você está sem conexão com a internet")
                        .setNegativeButton("OK", null)
                        .create()
                        .show()
                }

                override fun onResponse(
                    call: Call<List<PostModel>>,
                    response: Response<List<PostModel>>
                ) {
                    response.body()?.let { lista.addAll(it) }
                }

            })

        initAdapter(lista)

    }

    private fun initAdapter(lista: List<PostModel>?) {
        adapter = SendAdapter(lista!!) {
            val novaTela = Intent(this, MyPostActivity::class.java)
            novaTela.putExtra("myPost", it)
            startActivity(novaTela)

        }
        val recyclerView = listview
        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        initButtom()
    }

    fun initButtom() {
        addbuttom.setOnClickListener {
            var newPost = PostModel(
                id = 0, body = "TESTE", title = "TESTE TITULO", userId = 1
            )

            lista.add(newPost)
            adapter?.notifyDataSetChanged()

        }

    }

}
