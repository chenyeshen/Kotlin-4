package com.fujisoft.daikin.kotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.fastjson.JSON
import kotlinx.android.synthetic.main.activity_internet.*
import org.jetbrains.anko.async
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

/**
 * Created by 860115039 on 2017/05/26.
 */

class InternetActivity : AppCompatActivity() {
//    val URLStr = "http://172.0.0.1:8080/RCPT//userInfoapp/login.app?account=kongwei2541&pwd=2465973"
    val URLStr = "http://172.29.140.35:8080/hello"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet)
        initViews()

//        getNetData()
    }

    private fun getNetData(){
        async {
            var htmlText = Request(URLStr).run()
            uiThread {
                toast("请求执行")
                val json = JSON.parseObject(htmlText)
                resultTv.text = json.get("result").toString()+"\n"+json.get("msg")
//                resultTv.text = htmlText
            }
        }
    }

    private fun initViews() {

        tapBackBtn.setOnClickListener({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        })
        getNetDataBtn.setOnClickListener({
            getNetData()
        })
    }


}