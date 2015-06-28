package com.anyonecan.tal.drawgame;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class VideoActivity extends BaseActivity {

    protected VideoView mPlayer = null;
    protected Button mPlayButton = null;
    private Integer videoID = null;
    private Integer layoutID = null;
    protected Integer videoPosition = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutID);

        // Setup a play button to start the video
        mPlayButton = (Button) findViewById(R.id.play_button);
        mPlayer = (VideoView) findViewById(R.id.video_view);

        mPlayer.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + videoID));
        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                mediaPlayer.pause();
                mediaPlayer.seekTo(videoPosition); // it works, because of we called start(
            }
        });

        mPlayer.setOnCompletionListener(mPlayerOnComplete);
        mPlayer.setOnTouchListener(mPlayerOnTouch);

        mPlayButton.setOnClickListener(mButtonClick);
    }

    protected void setIDs(Integer layoutID, Integer videoID) {
        this.layoutID = layoutID;
        this.videoID = videoID;
    }

    private MediaPlayer.OnCompletionListener mPlayerOnComplete = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            mPlayButton.setVisibility(View.VISIBLE);
            //finish();
        }
    };

    private View.OnClickListener mButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPlayer.start();
            // hide button once playback starts
            mPlayButton.setVisibility(View.GONE);
        }
    };

    private Integer nonNegative(Integer value) {
        Integer backwardsFactor = 500;
        value -= backwardsFactor;
        if (value < 0) {
            value = 0;
        }
        return value;
    }

    protected View.OnTouchListener mPlayerOnTouch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (mPlayer.isPlaying()) {
                videoPosition = nonNegative(mPlayer.getCurrentPosition());
                mPlayer.pause();
                mPlayButton.setVisibility(View.VISIBLE);
            }
            return false;
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        if (mPlayer.isPlaying()) {
            videoPosition = nonNegative(mPlayer.getCurrentPosition());
            mPlayer.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //mPlayer = (VideoView) findViewById(R.id.video_view);
        //Button mPlayButton = (Button) findViewById(R.id.play_button);
        mPlayButton.setVisibility(View.VISIBLE);
        //mPlayer.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + videoID));
        if (!mPlayer.isPlaying()) {
            mPlayer.seekTo(videoPosition);
        }
    }
}
