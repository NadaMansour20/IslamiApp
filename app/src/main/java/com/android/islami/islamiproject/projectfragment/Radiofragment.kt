package com.android.islami.islamiproject.projectfragment

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.android.islami.R
import com.android.islami.islamiproject.Api.BuildRetrofit
import com.android.islami.islamiproject.Api.RadioResponse
import com.android.islami.islamiproject.Api.RadiosItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Radiofragment:Fragment() {

    lateinit var player:MediaPlayer
    lateinit var radio_text:TextView
    lateinit var buttonStop:ImageButton
    lateinit var buttonnext:ImageButton
    lateinit var buttonprev:ImageButton
    lateinit var progressBar: ProgressBar
    lateinit var radio_item:List<RadiosItem>
    var position=0
    var mediaPlayer=MediaPlayer()
    var is_play=0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.radiofragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        get_radio_api()
        progressBar.isVisible=false

    }
    fun init(){
        radio_text=requireView().findViewById(R.id.ezaa)
        progressBar=requireView().findViewById(R.id.progress)
        buttonStop=requireView().findViewById(R.id.play)
        buttonnext=requireView().findViewById(R.id.next)
        buttonprev=requireView().findViewById(R.id.prev)



        buttonStop.setOnClickListener {
            progressBar.isVisible=true
            radio_text.text=radio_item[position].name
            if(is_play==0) {
                play_sound(position)
                buttonStop.setImageDrawable(resources.getDrawable(R.drawable.ic_pause_radio))
                is_play=1
            }
            else{
                progressBar.isVisible=false
                mediaPlayer.stop()
                buttonStop.setImageDrawable(resources.getDrawable(R.drawable.ic_play_radio))
                is_play=0

            }


        }
        buttonnext.setOnClickListener {
            position++

            radio_text.text=radio_item[position].name

            if(mediaPlayer.isPlaying){
                mediaPlayer.stop()

            }
            play_sound(position)

        }
       buttonprev.setOnClickListener {
           position--
           if(position<0||mediaPlayer.isPlaying){
               mediaPlayer.stop()
           }
           else {
               radio_text.text = radio_item[position].name
               play_sound(position)
           }
        }

    }

    fun get_radio_api(){

        BuildRetrofit.get_api().get_radio().enqueue(object :Callback<RadioResponse>{
            override fun onResponse(call: Call<RadioResponse>, response: Response<RadioResponse>) {
                radio_item= (response.body()?.radios as List<RadiosItem>)
            }

            override fun onFailure(call: Call<RadioResponse>, t: Throwable) {

            }

        })
    }

    fun play_sound(position:Int){
        val url = radio_item[position].uRL
         mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            prepareAsync() // might take long! (for buffering, etc)
        }
        mediaPlayer.setOnPreparedListener(object :MediaPlayer.OnPreparedListener{
            override fun onPrepared(mp: MediaPlayer?) {
                progressBar.isVisible=false
                mp?.start()
            }

        })
    }


}