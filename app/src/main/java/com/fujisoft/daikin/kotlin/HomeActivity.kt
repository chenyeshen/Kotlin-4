package com.fujisoft.daikin.kotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.toast

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViews()

    }

    private fun initViews() {
        helloTv.text = "你好"
        tapBtn.text = "click"
        tapBtn.setOnClickListener {
            toast("点击了按钮")
            startActivity(Intent(this, InternetActivity::class.java))
            finish()
        }
    }
}
