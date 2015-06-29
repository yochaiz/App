package com.anyonecan.tal.drawgame;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class BalloonGameActivity extends ImmersiveActivity {

    protected RelativeLayout b_baloon1 = null;
    protected RelativeLayout b_baloon2 = null;
    protected RelativeLayout b_baloon3 = null;
    protected RelativeLayout b_baloon4 = null;
    protected RelativeLayout b_balloon1 = null;
    protected RelativeLayout b_balloon2 = null;
    protected RelativeLayout b_balloon3 = null;
    protected RelativeLayout b_balloon4 = null;
    protected RelativeLayout b_bobby = null;
    protected RelativeLayout b_reload = null;
    protected RelativeLayout b_music = null;
    protected RelativeLayout arrow = null;
    protected TextView t_baloon1 = null;
    protected TextView t_baloon2 = null;
    protected TextView t_baloon3 = null;
    protected TextView t_baloon4 = null;
    protected AutoResizeTextView t_balloon1 = null;
    protected AutoResizeTextView t_balloon2 = null;
    protected AutoResizeTextView t_balloon3 = null;
    protected AutoResizeTextView t_balloon4 = null;
    protected RelativeLayout game = null;
    protected int m_number;
    protected int m_numberSong;
    protected int m_numberSongBaloon;
    protected int m_Ballon1Song;
    protected int m_Ballon2Song;
    protected int m_Ballon3Song;
    protected int m_Ballon4Song;
    protected MediaPlayer mp = null;
    //protected MediaPlayer game_mp = null;
    protected int length_music = 0;
    protected boolean isPlaying;
    protected RelativeLayout b_back = null;
    boolean continueMusic;
    boolean soundFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balloon_game);
        //init members
        findIds();

        if (MusicManager.musicStopByMe) {
            b_music.setBackgroundResource(R.drawable.mute);
        } else {
            b_music.setBackgroundResource(R.drawable.unmute);
        }

        //set balloon text size according to the screen size
        //setTextSize();
        //handle game music
/*            game_mp = MediaPlayer.create(getBaseContext(), R.raw.music);


            if(game_mp!= null)
            {
                game_mp.setLooping(true);
                game_mp.setVolume(1,1);
            }
            if (game_mp!=null) {
                game_mp.start();
            }
            */
        b_music.setOnClickListener(new View.OnClickListener() {
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
                    MusicManager.start(BalloonGameActivity.this, MusicManager.MUSIC_BALLOON);
                    MusicManager.musicStopByMe = false;
                    b_music.setBackgroundResource(R.drawable.unmute);
                }
            }
        });

        //play animations
        playAnimation();

        //create textview
        t_balloon1 = createTextBalloon(b_balloon1);
        t_balloon2 = createTextBalloon(b_balloon2);
        t_balloon3 = createTextBalloon(b_balloon3);
        t_balloon4 = createTextBalloon(b_balloon4);

        b_reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScaleOnClick anim = new ScaleOnClick(v, 0.7f, 500, 1);
                anim.click();
                reload();
            }
        });

        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButton(false);
                ScaleOnClick anim = new ScaleOnClick(v, 0.7f, 500, 1);
                Navigation navigate = new Navigation() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getBaseContext(), GamesMenuActivity.class);
                        startActivity(intent);
                        finish();
                    }
                };
                anim.click(navigate);

            }
        });

        //reload project (init the game with new state)
        reload();
        soundFinished = true;
    }


    private void playAnimation() {
        RelativeLayout bf1 = (RelativeLayout) findViewById(R.id.bf1);
        SlideOnClick anim2 = new SlideOnClick(bf1, 400, -5, -1, 7500);
        anim2.click();
        //animate clouds.
        RelativeLayout cl1 = (RelativeLayout) findViewById(R.id.cloud);
        RelativeLayout cl2 = (RelativeLayout) findViewById(R.id.cloud2);
        RelativeLayout bf3 = (RelativeLayout) findViewById(R.id.bf);
        SlideOnClick anim_cl1 = new SlideOnClick(cl1, 200, 0, -1, 11000);
        SlideOnClick anim_cl2 = new SlideOnClick(cl2, 200, 0, -1, 11000);
        SlideOnClick anim_bf3 = new SlideOnClick(bf3, 300, -1, -1, 7000);
        anim_cl1.click();
        anim_cl2.click();
        anim_bf3.click();
    }


    private void findIds() {
        b_back = (RelativeLayout) findViewById(R.id.prev_button);
        b_baloon1 = (RelativeLayout) findViewById(R.id.balloon11);
        b_baloon2 = (RelativeLayout) findViewById(R.id.balloon22);
        b_baloon3 = (RelativeLayout) findViewById(R.id.balloon33);
        b_baloon4 = (RelativeLayout) findViewById(R.id.balloon44);
        b_balloon1 = (RelativeLayout) findViewById(R.id.balloon1);
        b_balloon2 = (RelativeLayout) findViewById(R.id.balloon2);
        b_balloon3 = (RelativeLayout) findViewById(R.id.balloon3);
        b_balloon4 = (RelativeLayout) findViewById(R.id.balloon4);
        t_baloon1 = (TextView) findViewById(R.id.baloon_number1);
        t_baloon2 = (TextView) findViewById(R.id.baloon_number2);
        t_baloon3 = (TextView) findViewById(R.id.baloon_number3);
        t_baloon4 = (TextView) findViewById(R.id.baloon_number4);
        b_bobby = (RelativeLayout) findViewById(R.id.bobby);
        game = (RelativeLayout) findViewById(R.id.game);
        b_reload = (RelativeLayout) findViewById(R.id.reloadBtn);
        b_music = (RelativeLayout) findViewById(R.id.musicBtn);
        arrow = (RelativeLayout) findViewById(R.id.arrow);
        isPlaying = true;
    }

    //set new random background to the game
    private void reloadBackground() {
        Random rand = new Random();
        int max = 3;
        int randomNum = rand.nextInt((max) + 1);
        switch (randomNum) {
            case 0:
                game.setBackgroundResource(R.drawable.back_kids);
                break;
            case 1:
                game.setBackgroundResource(R.drawable.back_kids2);
                break;
            case 2:
                game.setBackgroundResource(R.drawable.back_kids3);
                break;
            case 3:
                game.setBackgroundResource(R.drawable.back_kids4);
                break;
        }
    }

    //get 4 different random numbers.
    private List<Integer> RandomNumbers() {

        List<Integer> numbers = new ArrayList<>();
        List<Integer> return_numbers = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < 4; i++) {
            return_numbers.add(numbers.get(i));
        }
        return return_numbers;
    }

    //function that get number and set drawable for ballon background
    private void picBalloon(RelativeLayout v, int num) {
        switch (num) {
            case 1:
                v.setBackgroundResource(R.drawable.red_baloon);
                break;
            case 2:
                v.setBackgroundResource(R.drawable.green3_baloon);
                break;
            case 3:
                v.setBackgroundResource(R.drawable.pink_baloon);
                break;
            case 4:
                v.setBackgroundResource(R.drawable.purple_balloon);
                break;
            case 5:
                v.setBackgroundResource(R.drawable.baloon_green);
                break;
            case 6:
                v.setBackgroundResource(R.drawable.blue_baloon);
                break;
            case 7:
                v.setBackgroundResource(R.drawable.orange_baloon);
                break;
            case 8:
                v.setBackgroundResource(R.drawable.grey_baloon);
                break;
            case 9:
                v.setBackgroundResource(R.drawable.light_pink_button);
                break;
            case 10:
                v.setBackgroundResource(R.drawable.light_blue_button);
                break;
        }

    }

    //update the balloon texts with the new numbers
    private void updateBalloons(List<Integer> list) {
/*        t_baloon1.setText(list.get(0).toString());
        t_baloon2.setText(list.get(1).toString());
        t_baloon3.setText(list.get(2).toString());
        t_baloon4.setText(list.get(3).toString());*/

        changeTextBalloonValue(t_balloon1, list.get(0).toString());
        changeTextBalloonValue(t_balloon2, list.get(1).toString());
        changeTextBalloonValue(t_balloon3, list.get(2).toString());
        changeTextBalloonValue(t_balloon4, list.get(3).toString());


        m_Ballon1Song = updateBaloonVoice(list.get(0));
        m_Ballon2Song = updateBaloonVoice(list.get(1));
        m_Ballon3Song = updateBaloonVoice(list.get(2));
        m_Ballon4Song = updateBaloonVoice(list.get(3));

        List<Integer> list_numbers = RandomNumbers();
        picBalloon(b_baloon1, list_numbers.get(0));
        picBalloon(b_baloon2, list_numbers.get(1));
        picBalloon(b_baloon3, list_numbers.get(2));
        picBalloon(b_baloon4, list_numbers.get(3));

    }

    private int updateBaloonVoice(int num) {
        int voice;
        if (num == m_number) {
            voice = m_numberSongBaloon;
        } else {
            voice = R.raw.try_again;
        }
        return voice;
    }

    //the function update the right voice according to the number
    private void updateVoice() {
        switch (m_number) {
            case 1:
                m_numberSong = R.raw.one;
                m_numberSongBaloon = R.raw.one_balloon;
                break;
            case 2:
                m_numberSong = R.raw.two;
                m_numberSongBaloon = R.raw.two_balloon;
                break;
            case 3:
                m_numberSong = R.raw.three;
                m_numberSongBaloon = R.raw.three_balloon;
                break;
            case 4:
                m_numberSong = R.raw.four;
                m_numberSongBaloon = R.raw.four_balloon;
                break;
            case 5:
                m_numberSong = R.raw.five;
                m_numberSongBaloon = R.raw.five_balloon;
                break;
            case 6:
                m_numberSong = R.raw.six;
                m_numberSongBaloon = R.raw.six_balloon;
                break;
            case 7:
                m_numberSong = R.raw.seven;
                m_numberSongBaloon = R.raw.seven_balloon;
                break;
            case 8:
                m_numberSong = R.raw.eight;
                m_numberSongBaloon = R.raw.eight_balloon;
                break;
            case 9:
                m_numberSong = R.raw.nine;
                m_numberSongBaloon = R.raw.nine_balloon;
                break;
            case 10:
                m_numberSong = R.raw.ten;
                m_numberSongBaloon = R.raw.ten_balloon;
                break;
        }
    }

    //get random number
    private int randNum() {
        Random rand = new Random();
        int max = 3;
        int randomNum = rand.nextInt((max) + 1);
        return randomNum;
    }

    //reset balloon numbers color and disable buttons
    private void stopBalloonNumbers() {
        setBalloonButton(false);
        t_balloon1.setTextColor(getResources().getColor(android.R.color.transparent));
        t_balloon2.setTextColor(getResources().getColor(android.R.color.transparent));
        t_balloon3.setTextColor(getResources().getColor(android.R.color.transparent));
        t_balloon4.setTextColor(getResources().getColor(android.R.color.transparent));
    }

    //resume balloon numbers color and enable buttons
    private void resumeBalloonNumbers() {
        t_balloon1.setTextColor(getResources().getColor(android.R.color.white));
        t_balloon2.setTextColor(getResources().getColor(android.R.color.white));
        t_balloon3.setTextColor(getResources().getColor(android.R.color.white));
        t_balloon4.setTextColor(getResources().getColor(android.R.color.white));

        final RotateOnClick anim1 = new RotateOnClick((TextView) t_balloon1, 0, 1200);
        anim1.click_no_listener();
        final RotateOnClick anim2 = new RotateOnClick((TextView) t_balloon2, 0, 1200);
        anim2.click_no_listener();
        final RotateOnClick anim3 = new RotateOnClick((TextView) t_balloon3, 0, 1200);
        anim3.click_no_listener();
        final RotateOnClick anim4 = new RotateOnClick((TextView) t_balloon4, 0, 1200);
        anim4.click_no_listener();


    }

    //create new view for game. new background. new numbers. new voice for bobby
    private void reload() {

        //animate bobby button when reload so the player will know he need to push it.
        FadeOnClick anim = new FadeOnClick((RelativeLayout) b_bobby, 5, 1500, 1f, 0.6f);
        anim.click();
        Navigation navigate = new Navigation() {
            @Override
            public void run() {
                arrow.setBackgroundResource(android.R.drawable.screen_background_light_transparent);
            }
        };
        arrow.setBackgroundResource(R.drawable.hand);
        SlideOnClick anim_arrow = new SlideOnClick(arrow, 50, 50, -1, 1500);
        anim_arrow.click(navigate);


        //change background
        reloadBackground();
        //get 4 different random numbers
        List<Integer> list = RandomNumbers();
        //update the view number
        m_number = list.get(randNum());
        //update bobby button voice according to the new number
        updateVoice();
        //update the balloons with new number
        updateBalloons(list);
        stopBalloonNumbers();
        b_bobby.setOnClickListener(new MediaPlayerOnClickListener(m_numberSong));
        //updateBalloons voices
        b_baloon1.setOnClickListener(new MediaPlayerOnClickListener(m_Ballon1Song));
        b_baloon2.setOnClickListener(new MediaPlayerOnClickListener(m_Ballon2Song));
        b_baloon3.setOnClickListener(new MediaPlayerOnClickListener(m_Ballon3Song));
        b_baloon4.setOnClickListener(new MediaPlayerOnClickListener(m_Ballon4Song));

    }

    //function check if the right button was clicked
    private boolean checkSuccess(int media) {
        if (media == R.raw.one_balloon || media == R.raw.two_balloon ||
                media == R.raw.three_balloon || media == R.raw.four_balloon ||
                media == R.raw.five_balloon || media == R.raw.five_balloon ||
                media == R.raw.six_balloon || media == R.raw.seven_balloon ||
                media == R.raw.eight_balloon || media == R.raw.nine_balloon ||
                media == R.raw.ten_balloon) {
            return true;
        }
        return false;
    }

    protected AutoResizeTextView createTextBalloon(RelativeLayout v) {
        if (v == null) {
            return null;
        }
        v.removeAllViews();
        final int maxHeight = 115; //random big value to assure text will be all over the bubble
        com.anyonecan.tal.drawgame.AutoResizeTextView textView = new com.anyonecan.tal.drawgame.AutoResizeTextView(this.getBaseContext());
        textView.setGravity(Gravity.CENTER);
        textView.setMaxLines(1);
        textView.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, maxHeight, this.getResources().getDisplayMetrics()));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        // since we use it only once per each click, we don't need to cache the results, ever
        textView.setEnableSizeCache(false);
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView.setText("");
        textView.setTypeface(null, Typeface.BOLD);
        v.addView(textView);
        return textView;
    }

    protected void changeTextBalloonValue(com.anyonecan.tal.drawgame.AutoResizeTextView textView, String value) {
        textView.setText((CharSequence) value);
    }

    private void setBalloonButton(boolean val) {
        b_baloon1.setEnabled(val);
        b_baloon2.setEnabled(val);
        b_baloon3.setEnabled(val);
        b_baloon4.setEnabled(val);
    }

    private void setButton(boolean val) {
        setBalloonButton(val);
        b_bobby.setEnabled(val);
        b_reload.setEnabled(val);
        b_music.setEnabled(val);
        b_back.setEnabled(val);

    }

    //Generic onClick method to all app media
    class MediaPlayerOnClickListener implements View.OnClickListener {
        private Integer mediaID = null;

        public MediaPlayerOnClickListener(Integer mediaID) {
            this.mediaID = mediaID;
        }

        public MediaPlayerOnClickListener(Integer mediaID, RelativeLayout layout) {
            this(mediaID);
        }


        @Override
        public void onClick(View v) {
            //float factor = 1f;
            setButton(false);

            //handle the start of session
            if (v.getId() == R.id.bobby) {
                arrow.setBackgroundResource(android.R.drawable.screen_background_light_transparent);
                resumeBalloonNumbers();

            }
            ScaleOnClick anim = new ScaleOnClick((RelativeLayout) v, 500);
            anim.click();


            //handle music
            //if (game_mp.isPlaying()){
            //    game_mp.setVolume(0.15f,0.15f);
            //}
            MusicManager.updateVolume(0.2f);

            mp = MediaPlayer.create(getBaseContext(), mediaID);
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    setButton(true);
                    //if (game_mp.isPlaying()){
                    //    game_mp.setVolume(0.8f,0.8f);
                    //}
                    MusicManager.updateVolume(1f);
                    mp.stop();
                    mp.reset();
                    mp.release();
                    if (checkSuccess(mediaID)) {
                        reload();
                    }
                    soundFinished = true;
                }
            });
            soundFinished = false;
            mp.start();
        }
    }

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
        if (!soundFinished) {
            mp.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!MusicManager.musicStopByMe) {
            continueMusic = false;
            MusicManager.start(this, MusicManager.MUSIC_BALLOON);
        }

        if (MusicManager.musicStopByMe) {
            b_music.setBackgroundResource(R.drawable.mute);
        } else {
            b_music.setBackgroundResource(R.drawable.unmute);
        }

        if (!soundFinished) {
            mp.start();
        }
    }
}


