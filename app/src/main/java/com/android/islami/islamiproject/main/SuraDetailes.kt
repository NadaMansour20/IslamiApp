package com.android.islami.islamiproject.main

import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.android.islami.Constent
import com.android.islami.R
import com.android.islami.databinding.ActivitySuraDetailesBinding
import com.android.islami.islamiproject.projectfragment.Hadethfragment
import com.android.islami.islamiproject.projectfragment.QuranFragment
import com.android.islami.islamiproject.recyclerview.AyatquranAdapter

class SuraDetailes : AppCompatActivity() {
    lateinit var suratitle:TextView
    lateinit var recyclerView: RecyclerView
    lateinit var ayatadapter:AyatquranAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_detailes)


        suratitle=findViewById(R.id.suradetailes)
        setrecyclerview()


       var posofsura=intent.getIntExtra(Constent.pos,-1)
        var titleofsura=intent.getStringExtra(Constent.name)
        suratitle.text=titleofsura
        readsuracontentfromassets(posofsura)



    }

    fun setrecyclerview(){
        recyclerView=findViewById(R.id.recycleOfAyatAlquran)
        ayatadapter=AyatquranAdapter()
        recyclerView.adapter=ayatadapter
    }


    fun readsuracontentfromassets(pos:Int){
        var filename="${pos+1}.txt"
        var filecontent=assets.open(filename).bufferedReader().use { it.readText() }
        var datalist=filecontent.split("\n")
        ayatadapter.changedata(datalist)

    }


}