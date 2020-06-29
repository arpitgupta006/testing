package com.arpit.retrofitgithubprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val rf = Retrofit.Builder()
//            .baseUrl(RetrofitInterface.baseurl)
//            .addConverterFactory(GsonConverterFactory.create()).build()
//        val api = rf.create(RetrofitInterface::class.java)
//        val call = api.profile
//
//
//
//        call.enqueue(object : Callback<List<Model>> {
//           override fun onFailure(call: Call<List<Model>>, t: Throwable) {
//               TODO("Not yet implemented")
//           }
//
//            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
//                  val data:List<Model> = response.body()!!
//                et
//
//            }
//
//        })

        GlobalScope.launch {
            val response = withContext(Dispatchers.IO) {Client.api.getUser()}
            if (response.isSuccessful){
                response.body()?.let { res->
                    res.let {
                        runOnUiThread {
                            tvUrl.text = it.url
                            tvAvatar_Url.text = it.avatar_url
                            tvLogin.text = it.login
                            tvId.text = it.id.toString()
                        }
                    }
                }
            }
        }
    }
}