package com.sylphid.android_itunes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sylphid.android_itunes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //implement viewBinding
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
    }
}