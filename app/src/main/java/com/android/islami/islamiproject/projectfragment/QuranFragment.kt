package com.android.islami.islamiproject.projectfragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.android.islami.Constent
import com.android.islami.R
import com.android.islami.islamiproject.main.SuraDetailes
import com.android.islami.islamiproject.recyclerview.QranAdapter

class QuranFragment: Fragment() {
    lateinit var recyclerview:RecyclerView
    lateinit var quranadapter:QranAdapter
    val datalist= arrayListOf("الفاتحه","البقرة","آل عمران","النساء","المائدة","الأنعام","الأعراف","الأنفال","التوبة","يونس","هود"
        ,"يوسف","الرعد","إبراهيم","الحجر","النحل","الإسراء","الكهف","مريم","طه","الأنبياء","الحج","المؤمنون"
        ,"النّور","الفرقان","الشعراء","النّمل","القصص","العنكبوت","الرّوم","لقمان","السجدة","الأحزاب","سبأ"
        ,"فاطر","يس","الصافات","ص","الزمر","غافر","فصّلت","الشورى","الزخرف","الدّخان","الجاثية","الأحقاف"
        ,"محمد","الفتح","الحجرات","ق","الذاريات","الطور","النجم","القمر","الرحمن","الواقعة","الحديد","المجادلة"
        ,"الحشر","الممتحنة","الصف","الجمعة","المنافقون","التغابن","الطلاق","التحريم","الملك","القلم","الحاقة","المعارج"
        ,"نوح","الجن","المزّمّل","المدّثر","القيامة","الإنسان","المرسلات","النبأ","النازعات","عبس","التكوير","الإنفطار"
        ,"المطفّفين","الإنشقاق","البروج","الطارق","الأعلى","الغاشية","الفجر","البلد","الشمس","الليل","الضحى","الشرح"
        ,"التين","العلق","القدر","البينة","الزلزلة","العاديات","القارعة","التكاثر","العصر",
        "الهمزة","الفيل","قريش","الماعون","الكوثر","الكافرون","النصر","المسد","الإخلاص","الفلق","الناس")



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.quranfragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview=view.findViewById(R.id.quranrecycler)
        quranadapter=QranAdapter(datalist)

        quranadapter.suranameonclick=object:QranAdapter.Suranameclicklistener{
            override fun suraonclick(pos: Int, suraname: String) {
                suradetailes(pos,suraname)
            }
        }
        recyclerview.adapter=quranadapter

    }
    fun suradetailes(pos:Int,suraname:String){
        var intent= Intent(context,SuraDetailes::class.java)
        intent.putExtra(Constent.name,suraname)
        intent.putExtra(Constent.pos,pos)
        startActivity(intent)
    }


}