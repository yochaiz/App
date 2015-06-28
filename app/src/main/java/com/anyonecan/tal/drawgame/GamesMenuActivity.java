package com.anyonecan.tal.drawgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

public class GamesMenuActivity extends MenusActivity {

    boolean continueMusic;
    protected RelativeLayout b_music = null;
    private RelativeLayout homeLayout = null;
    private Button drawBtn = null;
    private Button balloonBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        boolean inflateSuccess = false;
        while (!inflateSuccess) {
            try {
                setContentView(R.layout.activity_games_menu);
                inflateSuccess = true;
            } catch (Exception e) {
            }
        }

        drawBtn = (Button) findViewById(R.id.drawGame);
        drawBtn.setOnTouchListener(listener(DrawMainActivity.class));

        balloonBtn = (Button) findViewById(R.id.balloonGame);
        balloonBtn.setOnTouchListener(listener(BalloonGameActivity.class));

        homeLayout = (RelativeLayout) findViewById(R.id.homeBtn);
        homeLayout.setOnClickListener(homeClick);

        //play animation on the screen
        b_music = (RelativeLayout) findViewById(R.id.music_games_menu);
        RelativeLayout bf = (RelativeLayout) findViewById(R.id.butterfly);
        SlideOnClick anim = new SlideOnClick(bf, 400, -5, -1, 8000);
        anim.click();
        RelativeLayout bf2 = (RelativeLayout) findViewById(R.id.butterfly2);
        SlideOnClick anim2 = new SlideOnClick(bf2, 400, -5, -1, 7500);
        anim2.click();

/*        //background music
        game_mp = MediaPlayer.create(getBaseContext(), R.raw.music);
        b_music = (RelativeLayout) findViewById(R.id.music_games_menu);

        if(game_mp!= null)
        {
            game_mp.setLooping(true);
            game_mp.setVolume(1,1);
        }
        if (game_mp!=null && state.getSoundStatus() ) {
            game_mp.start();
        }
        if (!state.getSoundStatus()){
            b_music.setBackgroundResource(R.drawable.mute);
        }
*/

        b_music.setOnClickListener(musicButton);

        if (MusicManager.musicStopByMe) {
            b_music.setBackgroundResource(R.drawable.mute);
        } else {
            b_music.setBackgroundResource(R.drawable.unmute);
        }
    }

    View.OnClickListener homeClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            drawBtn.setClickable(false);
            balloonBtn.setClickable(false);
            AnimateOnClick anim = randomAnimation(homeLayout, 1);
            Navigation navigate = new Navigation() {
                @Override
                public void run() {
                    Intent intent = new Intent(getBaseContext(), MenuActivity.class);
                    startActivity(intent);
                    finish();
                }
            };
            anim.click(navigate);

        }
    };


    private View.OnClickListener musicButton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!MusicManager.musicStopByMe) {
                if (!continueMusic) {
                    MusicManager.pause();
                    MusicManager.musicStopByMe = true;
                    b_music.setBackgroundResource(R.drawable.mute);
                }
            } else {
                continueMusic = false;
                MusicManager.start(GamesMenuActivity.this, MusicManager.MUSIC_MENU);
                MusicManager.musicStopByMe = false;
                b_music.setBackgroundResource(R.drawable.unmute);
            }
        }
    };


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        continueMusic = true;
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!continueMusic) {
            MusicManager.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!MusicManager.musicStopByMe) {
            continueMusic = false;
            MusicManager.start(this, MusicManager.MUSIC_MENU);
        }

        if (MusicManager.musicStopByMe) {
            b_music.setBackgroundResource(R.drawable.mute);
        } else {
            b_music.setBackgroundResource(R.drawable.unmute);
        }
    }

}
