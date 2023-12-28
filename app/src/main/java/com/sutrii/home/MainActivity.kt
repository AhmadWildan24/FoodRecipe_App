package com.sutrii.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sutrii.home.api.ApiInterface
import com.sutrii.home.api.FoodInfo
import com.sutrii.home.bookmark.BookmarkFragment
import com.sutrii.home.databinding.ActivityMainBinding
import com.sutrii.home.home.HomeFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.spoonacular.com/recipes/716429/information/"
class MainActivity : AppCompatActivity() {

    private lateinit var textView : TextView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navmenu
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
        getFoodData();
    }

    private fun getFoodData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<FoodInfo>?> {
            override fun onResponse(
                call: Call<List<FoodInfo>?>,
                response: Response<List<FoodInfo>?>
            ) {
                val responseBody = response.body()!!

                val myStringBuilder = StringBuilder()
                for(FoodInfo in responseBody) {
                    myStringBuilder.append(FoodInfo.id)
                    myStringBuilder.append("\n")
                }

                textView = findViewById(R.id.tesApi)
                textView = findViewById(R.id.tesApi)
                if (textView != null) {
                    textView.text = myStringBuilder.toString()
                } else {
                    Log.e("MainActivity", "TextView not found")
                }
            }

            override fun onFailure(call: Call<List<FoodInfo>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: "+t.message)
            }
        })
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}