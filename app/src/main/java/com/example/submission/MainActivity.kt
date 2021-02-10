package com.example.submission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    private lateinit var dataList: ArrayList<UserGithub>
    private lateinit var userGithub: UserGithub
    private lateinit var adapterUserGithub: AdapterUserGithub
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataList = ArrayList()

        addData()

        setSupportActionBar(tb_main)
        supportActionBar?.title = "GithubUserApp"
        Log.e("_data", "$dataList")

        rv_main.setHasFixedSize(true)
        rv_main.layoutManager = LinearLayoutManager(this)
        adapterUserGithub = AdapterUserGithub(dataList, applicationContext)
        adapterUserGithub.notifyDataSetChanged()
        rv_main.adapter = adapterUserGithub

    }

    private fun addData(){
        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val inputStream: InputStream = assets.open("githubuser.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset )
        }catch (e: IOException){
            e.printStackTrace()
        }

        try {
            val obj = JSONObject(json!!)
            val mArray: JSONArray = obj.getJSONArray("users")

            for (i in 0..mArray.length()){
                val objInside = mArray.getJSONObject(i)
                userGithub = UserGithub(
                    objInside.getString("username"),
                    objInside.getString("name"),
                    objInside.getString("avatar"),
                    objInside.getString("company"),
                    objInside.getString("location"),
                    objInside.getInt("repository"),
                    objInside.getInt("follower"),
                    objInside.getInt("following")
                )

                dataList.add(userGithub)

            }

        }catch (e: JSONException){
            e.printStackTrace()
        }

    }
}