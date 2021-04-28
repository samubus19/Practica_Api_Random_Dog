package com.example.practica_clase_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var btnPerro : Button
    private lateinit var imgvPerro : ImageView
    private lateinit var tvPrueba : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnPerro    = findViewById(R.id.btnPerro)
        imgvPerro   = findViewById(R.id.imgvDog)
        tvPrueba    = findViewById(R.id.tvPrueba)

        btnPerro.setOnClickListener {
                llamarApi()
        }

    }

    private fun llamarApi() {
        val api     = RetrofitClient.retrofit.create(DogApi::class.java)

        val llamada = api.getDog()

        llamada.enqueue(object : Callback<Dog> {
            override fun onResponse(call: Call<Dog>, response: Response<Dog>) {

                Picasso
                    .get()
                    .load(response.body()?.message ?: "es nulo")
                    .into(imgvPerro)

            }

            override fun onFailure(call: Call<Dog>, t: Throwable) {
                    Toast.makeText(btnPerro.context, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}