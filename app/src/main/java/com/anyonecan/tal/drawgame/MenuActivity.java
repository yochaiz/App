package com.anyonecan.tal.drawgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MenuActivity extends MenusActivity {

    boolean continueMusic;
    protected RelativeLayout b_music = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button layout_start = (Button) findViewById(R.id.menuStart);
        layout_start.setOnTouchListener(listener(VideoSong1Activity.class));
        Button layout_15 = (Button) findViewById(R.id.menu15);
        layout_15.setOnTouchListener(listener(VideoSong1Activity.class));
        Button layout_610 = (Button) findViewById(R.id.menu610);
        layout_610.setOnTouchListener(listener(VideoSong3Activity.class));
        Button layout_games = (Button) findViewById(R.id.menuGames);
        layout_games.setOnTouchListener(listener(GamesMenuActivity.class));
        Button layout_story = (Button) findViewById(R.id.menuStory);
        layout_story.setOnTouchListener(listener(VideoStory1Activity.class));

        RelativeLayout logo = (RelativeLayout) findViewById(R.id.logo);
        ScaleOnClick anim = new ScaleOnClick(logo, 0.5f, 2000, -1);
        anim.click();


        //background music
        //game_mp = MediaPlayer.create(getBaseContext(), R.raw.music);
        b_music = (RelativeLayout) findViewById(R.id.menu_music);

        RelativeLayout bf = (RelativeLayout) findViewById(R.id.butterfly);
        SlideOnClick anim3 = new SlideOnClick(bf, 100, 200, -1, 8000);
        anim3.click();
        RelativeLayout bf2 = (RelativeLayout) findViewById(R.id.butterfly2);
        SlideOnClick anim2 = new SlideOnClick(bf2, -100, -200, -1, 7500);
        anim2.click();

        /*
        if (game_mp != null) {
            game_mp.setLooping(true);
            game_mp.setVolume(1, 1);
        }
        if (game_mp != null && state.getSoundStatus()) {
            game_mp.start();
        }
        if (!state.getSoundStatus()){
            b_music.setBackgroundResource(R.drawable.mute);
        }

*/

        b_music.setOnClickListener(musicButton);

    }


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
                MusicManager.start(MenuActivity.this, MusicManager.MUSIC_MENU);
                MusicManager.musicStopByMe = false;
                b_music.setBackgroundResource(R.drawable.unmute);
            }
        }
    };

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
