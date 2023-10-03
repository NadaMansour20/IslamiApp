package com.android.islami.islamiproject.projectfragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.android.islami.R


class Radiofragment:Fragment() {

    lateinit var player:MediaPlayer
    lateinit var twasheh:MediaPlayer
    lateinit var buttonplay:ImageButton
    lateinit var buttonnext:ImageButton
    lateinit var buttonprev:ImageButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.radiofragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonplay=view.findViewById(R.id.play)
        buttonnext=view.findViewById(R.id.next)
        buttonprev=view.findViewById(R.id.prev)
        buttonplay.setOnClickListener {
            playmusic()

        }
        buttonnext.setOnClickListener {
            playtwashih()

        }
        buttonprev.setOnClickListener {
            twasheh.stop()
            playmusic()

        }
    }

   fun playmusic() {
        player=MediaPlayer.create(context,R.raw.radio)
        player.start()
    }
    fun playtwashih(){
        player.stop()
        twasheh=MediaPlayer.create(context,R.raw.twashih)
        twasheh.start()
    }

}