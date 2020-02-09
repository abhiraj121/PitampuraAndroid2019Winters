package com.puldroid.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    val list = arrayListOf<User>()
    val adapter = UserAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
        GlobalScope.launch {
            val response = withContext(Dispatchers.IO) { Client.api.getAllUsers() }
            if (response.isSuccessful) {
                response.body()?.let { res ->
                    list.addAll(res)
                    runOnUiThread {
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }
}
