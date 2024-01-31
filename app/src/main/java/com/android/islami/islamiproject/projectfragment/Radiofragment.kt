package com.android.islami.islamiproject.projectfragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.android.islami.R


class Radiofragment:Fragment() {

    lateinit var player:MediaPlayer
    lateinit var buttonStop:ImageButton
    lateinit var buttonnext:ImageButton
    lateinit var buttonprev:ImageButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.radiofragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonStop=view.findViewById(R.id.play)
        buttonnext=view.findViewById(R.id.next)
        buttonprev=view.findViewById(R.id.prev)
        buttonStop.setOnClickListener {
                playmusic()

        }
        buttonnext.setOnClickListener {

            player.stop()
            buttonStop.setImageDrawable(resources.getDrawable(R.drawable.baseline_play_arrow_24))
            player = MediaPlayer.create(context, R.raw.radio)
            player.start()

        }
        buttonprev.setOnClickListener {

            playtwashih()
        }
    }
    var play=0
   fun playmusic() {
       if(play==0) {
           play=1
           buttonStop.setImageDrawable(resources.getDrawable(R.drawable.baseline_pause_24))
           player = MediaPlayer.create(context, R.raw.radio)
           player.start()
       }
       else{
           player.stop()
           buttonStop.setImageDrawable(resources.getDrawable(R.drawable.baseline_play_arrow_24))
           play=0
       }
    }
    fun playtwashih(){
        player.stop()
        buttonStop.setImageDrawable(resources.getDrawable(R.drawable.baseline_play_arrow_24))
        player=MediaPlayer.create(context,R.raw.twashih)
        player.start()
    }

}