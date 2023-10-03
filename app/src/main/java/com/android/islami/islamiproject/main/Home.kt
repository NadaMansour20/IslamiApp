package com.android.islami.islamiproject.main

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.android.islami.R
import com.android.islami.islamiproject.projectfragment.Hadethfragment
import com.android.islami.islamiproject.projectfragment.QuranFragment
import com.android.islami.islamiproject.projectfragment.Radiofragment
import com.android.islami.islamiproject.projectfragment.Tasbehfragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarMenuView
import com.google.android.material.navigation.NavigationBarView

class Home : AppCompatActivity() {
    lateinit var  bottomnavigation:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomnavigation = findViewById(R.id.buttonnavigation)
        bottomnavigation.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {
            if(it.itemId==R.id.quran)
                supportFragmentManager.beginTransaction().replace(R.id.homefragment,QuranFragment()).commit()
            else if(it.itemId==R.id.radio) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.homefragment, Radiofragment()).commit()

            }
            else if(it.itemId==R.id.hadeth)
                supportFragmentManager.beginTransaction().replace(R.id.homefragment,Hadethfragment()).commit()
            else if(it.itemId==R.id.sebha)
                supportFragmentManager.beginTransaction().replace(R.id.homefragment,Tasbehfragment()).commit()
            return@OnItemSelectedListener true
        })
        bottomnavigation.selectedItemId=R.id.quran
    }
}
