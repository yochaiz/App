package com.anyonecan.tal.drawgame;


import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class SongActivity extends BaseActivity {

    private Integer playBtn = R.drawable.play;
    private MediaPlayer mpVerse = null;
    private Integer curMpID = null;
    private boolean mpVerseWasPlayed = false;

    protected void setClickableVerseRelativeLayout(final int tvId, final int mediaID, final PointerAnim ptrAnim) {
        RelativeLayout tv = (RelativeLayout) findViewById(tvId);
        tv.setOnClickListener(new VerseMediaPlayerOnClickListener(mediaID, ptrAnim));
    }

    protected void setClickableVerseRelativeLayout(final int tvId, final int mediaID) {
        RelativeLayout tv = (RelativeLayout) findViewById(tvId);
        tv.setOnClickListener(new VerseMediaPlayerOnClickListener(mediaID));
    }

    private class VerseMediaPlayerOnClickListener implements View.OnClickListener {
        private Integer mediaID = null;
        private PointerAnim ptrAnim = null;

        public VerseMediaPlayerOnClickListener(final int mediaID) {
            this.mediaID = mediaID;
        }

        public VerseMediaPlayerOnClickListener(final int mediaID, final PointerAnim ptrAnim) {
            this.mediaID = mediaID;
            this.ptrAnim = ptrAnim;
        }

        @Override
        public void onClick(View v) {
            if (ptrAnim != null) {
                ptrAnim.stopAnimation();
            }
            if ((stoppableBtn != null) && (stoppableMp != null) && (stoppableMp.isPlaying())) {
                stoppableMp.pause();
                stoppableMp.seekTo(0);
                stoppableBtn.setBackgroundResource(R.drawable.play);
            }
            if ((mpVerse == null) || (curMpID != mediaID)) { //play new media
                if (mpVerse != null) {
                    mpVerse.release();
                }
                mpVerse = MediaPlayer.create(getBaseContext(), mediaID);
                curMpID = mediaID;
                mpVerse.start();
            } else { //(mpVerse != null) &&( curMpID == mediaID)
                if (mpVerse.isPlaying()) {
                    mpVerse.pause();
                } else {
                    mpVerse.start();
                }
            }
        }
    }

    protected void createStoppableMediaButton(int mediaID) {
        stoppableBtn = (Button) findViewById(R.id.playBtn);
        if (stoppableBtn != null) {
            stoppableBtn.setBackgroundResource(playBtn);
            stoppableBtn.setOnClickListener(new StoppableMediaPlayerOnClickListener(mediaID));
        }
    }

    private class StoppableMediaPlayerOnClickListener implements View.OnClickListener {

        public StoppableMediaPlayerOnClickListener(Integer mediaID) {
            stoppableMp = MediaPlayer.create(getBaseContext(), mediaID);
            stoppableMp.setOnCompletionListener(mpOnComplete);
        }

        private MediaPlayer.OnCompletionListener mpOnComplete = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stoppableMp.seekTo(0);
                stoppableBtn.setBackgroundResource(playBtn);
            }
        };

        @Override
        public void onClick(View v) {
            if (mpVerse != null) {
                mpVerse.release();
                mpVerse = null;
            }
            if (stoppableMp.isPlaying()) {
                stoppableMp.pause();
                stoppableBtn.setBackgroundResource(playBtn);
            } else {
                stoppableMp.start();
                stoppableBtn.setBackgroundResource(R.drawable.pause);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if ((mpVerse != null) && (mpVerseWasPlayed == true)) {
            mpVerse.start();
            mpVerseWasPlayed = false;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if ((stoppableMp != null) && (stoppableMp.isPlaying())) {
            stoppableMp.pause();
            stoppableBtn.setBackgroundResource(playBtn);
        }
        if ((mpVerse != null) && (mpVerse.isPlaying())) {
            mpVerse.pause();
            mpVerseWasPlayed = true;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (stoppableMp != null) {
            stoppableMp.release();
            stoppableMp = null;
        }
        if (mpVerse != null) {
            mpVerse.release();
            mpVerse = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if ((stoppableMp != null) && (stoppableMp.isPlaying())) {
            stoppableMp.pause();
            stoppableBtn.setBackgroundResource(playBtn);
        }
        if ((mpVerse != null) && (mpVerse.isPlaying())) {
            mpVerse.pause();
            mpVerseWasPlayed = true;
        }
    }
}
