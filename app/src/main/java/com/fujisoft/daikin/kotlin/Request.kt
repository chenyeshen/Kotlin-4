package com.fujisoft.daikin.kotlin

import android.util.Log
import java.net.URL

/**
 * Created by 860115039 on 2017/05/26.
 */

class Request(val url:String){
    public fun run(): String {
        //url是我们传入的请求地址，通过readText()方法就可以直接返回数据
        val forecastJsonStr = URL(url).readText()
        Log.d("zfw","返回的数据:"+forecastJsonStr)
        return forecastJsonStr
    }
}
