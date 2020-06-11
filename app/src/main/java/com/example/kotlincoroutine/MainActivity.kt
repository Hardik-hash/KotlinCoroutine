package com.example.kotlincoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


class MainActivity : AppCompatActivity() {

    val modelListViewArrayList: ArrayList<ModelListView> = ArrayList()
    private lateinit var marvelAdapter: MarvelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycle.layoutManager = LinearLayoutManager(this)
        marvelAdapter = MarvelAdapter(this)
        recycle.adapter = marvelAdapter


        val service = RetrofitFactory.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getData()
            withContext(Dispatchers.Main){
                try {
                    if(response.isSuccessful)
                    {
                     Toast.makeText(applicationContext,"Success",Toast.LENGTH_SHORT).show()
                    // val modelListView = ModelListView()
                     marvelAdapter.setData(response.body()!!)
                    }

                    else
                    {
                   Toast.makeText(applicationContext,"Fail",Toast.LENGTH_SHORT).show()
                    }
                }

                catch (e: HttpException){
                    Toast.makeText(applicationContext,"Exception ${e.message}",Toast.LENGTH_SHORT).show()
                }

                catch (e: Throwable){
                Toast.makeText(applicationContext,"oops:something Went Wrong",Toast.LENGTH_LONG).show()
                }



            }

        }

    }
}
