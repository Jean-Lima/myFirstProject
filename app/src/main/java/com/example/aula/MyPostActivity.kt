package com.example.aula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_post.*

class MyPostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_post)
        initIntent()
    }

    private fun initIntent() {
        var myPost: PostModel? = intent?.getSerializableExtra("myPost") as PostModel?

        myTitle.text = myPost?.title
        myDescription.text = myPost?.body
    }
}
