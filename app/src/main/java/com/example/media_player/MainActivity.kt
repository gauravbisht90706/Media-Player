     package com.example.media_player

     import android.app.Activity
     import android.net.Uri
     import android.os.Bundle
     import android.view.View
     import android.widget.MediaController
     import android.widget.Toast
     import android.widget.VideoView


     class MainActivity : Activity() {
         var videoView: VideoView? = null

         var mediaController: MediaController? = null
         public override fun onCreate(savedInstanceState: Bundle?) {
             super.onCreate(savedInstanceState)
             setContentView(R.layout.activity_main)

             videoView = findViewById<View>(R.id.videoView) as VideoView?

             if(mediaController == null){
                 mediaController = MediaController(this)
                 mediaController!!.setAnchorView(this.videoView)

             }

             videoView!!.setMediaController(mediaController)
             videoView!!.setVideoURI(Uri.parse("android.resource://" +packageName + "/" +R.raw.abc))

             videoView!!.requestFocus()

             videoView!!.start()

             videoView!!.setOnCompletionListener {
                 Toast.makeText(applicationContext, "Video End", Toast.LENGTH_LONG).show()

             }

             videoView!!.setOnErrorListener{ media_player, i, i2 ->
                 Toast.makeText(applicationContext, "Error Occured", Toast.LENGTH_LONG).show()
                 false
             }

         }
     }