package com.sylphid.android_itunes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.sylphid.android_itunes.R
import com.sylphid.android_itunes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val genreArray = arrayOf(
        "Rock",
        "Classic",
        "Pop"
    )

    //implement viewBinding
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.vpViewPager
        val tabLayout = binding.tlTabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.text = genreArray[position]
            when(position){
                0 -> tab.setIcon(R.drawable.rock_icon)
                1 -> tab.setIcon(R.drawable.classic_icon)
                2 -> tab.setIcon(R.drawable.pop_icon)
            }
        }.attach()
    }
}