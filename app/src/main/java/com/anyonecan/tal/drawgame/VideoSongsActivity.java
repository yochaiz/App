package com.anyonecan.tal.drawgame;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class VideoSongsActivity extends VideoActivity {

    private VideoView videoView1 = null;
    private VideoView videoView2 = null;
    private VideoView videoView3 = null;

    public void onCreate(Bundle b) {
        setIDs(R.layout.activity_video_songs, R.raw.video_song_1);
        super.onCreate(b);
        //setContentView(R.layout.activity_video_songs);
        setPage(R.id.video_songs_animation);

        // Setup a play button to start the video
        //final Button mPlayButton = (Button) findViewById(R.id.play_button);
        videoView1 = (VideoView) findViewById(R.id.video_view);
        videoView2 = (VideoView) findViewById(R.id.video_view2);
        videoView3 = (VideoView) findViewById(R.id.video_view3);
        videoView1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_song_1));
        videoView2.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_song_2));
        videoView3.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_song_3));
        videoView2.setVisibility(View.GONE);
        videoView3.setVisibility(View.GONE);

        //videoView1.seekTo(100);

        videoView1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView1.stopPlayback();
                videoView2.setVisibility(View.VISIBLE);
                videoView1.setVisibility(View.GONE);
                //videoView2.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_song_2));
                videoView2.start();
                mPlayer = videoView2;
            }
        });

        videoView2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView2.stopPlayback();
                videoView3.setVisibility(View.VISIBLE);
                videoView2.setVisibility(View.GONE);
                //videoView3.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_song_3));
                videoView3.start();
                mPlayer = videoView3;
            }
        });

        videoView3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView3.stopPlayback();
                videoView1.setVisibility(View.VISIBLE);
                videoView3.setVisibility(View.GONE);
                mPlayer = videoView1;
                videoPosition = 500;
                mPlayer.seekTo(videoPosition);
                mPlayButton.setVisibility(View.VISIBLE);
            }
        });

        videoView2.setOnTouchListener(mPlayerOnTouch);
        videoView3.setOnTouchListener(mPlayerOnTouch);

//        mPlayButton.setOnClickListener(new View.OnClickListener() {
//                                           @Override
//                                           public void onClick(View v) {
//                                               videoView1.setVisibility(View.VISIBLE);
//                                               videoView3.setVisibility(View.GONE);
//                                               videoView2.setVisibility(View.GONE);
//                                               videoView1.start();
//                                               // hide button once playback starts
//                                               mPlayButton.setVisibility(View.GONE);
//                                           }
//                                       }
//        );
    }

//    public void onResume() {
//        super.onResume();
//        videoView1 = (VideoView) findViewById(R.id.video_view);
//        Button mPlayButton = (Button) findViewById(R.id.play_button);
//        mPlayButton.setVisibility(View.VISIBLE);
//        videoView1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_song_1));
//        videoView1.setVisibility(View.VISIBLE);
//        videoView3.setVisibility(View.GONE);
//        videoView2.setVisibility(View.GONE);
//        if (!videoView1.isPlaying()) {
//            videoView1.seekTo(100);
//        }
//    }

}
