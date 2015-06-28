package com.anyonecan.tal.drawgame;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class DrawMainActivity extends ImmersiveActivity implements View.OnClickListener {

    Button card1;
    Button card2;
    Button card3;
    Button card4;
    Button card5;
    Button card6;
    Button card7;
    Button card8;
    Button card9;
    Button card10;

    Button musicButton;
    Button goBackButton;

    Rect rect;

    boolean continueMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean inflateSuccess = false;
        while (!inflateSuccess) {
            try {
                setContentView(R.layout.activity_draw_main);
                inflateSuccess = true;
            } catch (Exception e) {
            }
        }

        card1 = (Button) findViewById(R.id.btn_card1);
        card1.setOnTouchListener(listener("1"));
        card2 = (Button) findViewById(R.id.btn_card2);
        card2.setOnTouchListener(listener("2"));
        card3 = (Button) findViewById(R.id.btn_card3);
        card3.setOnTouchListener(listener("3"));
        card4 = (Button) findViewById(R.id.btn_card4);
        card4.setOnTouchListener(listener("4"));
        card5 = (Button) findViewById(R.id.btn_card5);
        card5.setOnTouchListener(listener("5"));
        card6 = (Button) findViewById(R.id.btn_card6);
        card6.setOnTouchListener(listener("6"));
        card7 = (Button) findViewById(R.id.btn_card7);
        card7.setOnTouchListener(listener("7"));
        card8 = (Button) findViewById(R.id.btn_card8);
        card8.setOnTouchListener(listener("8"));
        card9 = (Button) findViewById(R.id.btn_card9);
        card9.setOnTouchListener(listener("9"));
        card10 = (Button) findViewById(R.id.btn_card10);
        card10.setOnTouchListener(listener("10"));

        musicButton = (Button) findViewById(R.id.play);
        goBackButton = (Button) findViewById(R.id.back);

        musicButton.setOnClickListener(this);
        goBackButton.setOnClickListener(this);

//        card1.setOnClickListener(this);
//        card2.setOnClickListener(this);
//        card3.setOnClickListener(this);
//        card4.setOnClickListener(this);
//        card5.setOnClickListener(this);
//        card6.setOnClickListener(this);
//        card7.setOnClickListener(this);
//        card8.setOnClickListener(this);
//        card9.setOnClickListener(this);
//        card10.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            //OcrManager.baseApi.end();
            card1.setClickable(false);
            card2.setClickable(false);
            card3.setClickable(false);
            card4.setClickable(false);
            card5.setClickable(false);
            card6.setClickable(false);
            card7.setClickable(false);
            card8.setClickable(false);
            card9.setClickable(false);
            card10.setClickable(false);
            AnimateOnClick anim = randomAnimation(goBackButton, 1);
            Navigation navigate = new Navigation() {
                @Override
                public void run() {
                    Intent intent = new Intent(
                            getBaseContext(), GamesMenuActivity.class);
                    startActivity(intent);
                    finish();
                }
            };
            anim.click(navigate);

        }

        if (view.getId() == R.id.play) {
            if (!MusicManager.musicStopByMe) {
                if (!continueMusic) {
                    MusicManager.pause();
                    MusicManager.musicStopByMe = true;
                    musicButton.setBackgroundResource(R.drawable.draw_play);
                }
            } else {
                continueMusic = false;
                MusicManager.start(this, MusicManager.MUSIC_GAME);
                MusicManager.musicStopByMe = false;
                musicButton.setBackgroundResource(R.drawable.draw_pause);
            }
        }
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
            MusicManager.start(this, MusicManager.MUSIC_GAME);
        }

        if (MusicManager.musicStopByMe) {
            musicButton.setBackgroundResource(R.drawable.draw_play);
        } else {
            musicButton.setBackgroundResource(R.drawable.draw_pause);
        }
    }

    public View.OnTouchListener listener(String number) {
        final String num = number;
        View.OnTouchListener listener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int x = 0;
                int y = 0;
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        view.setScaleX(0.8f);
                        view.setScaleY(0.8f);
                        x = view.getLeft();
                        y = view.getTop();
                        rect = new Rect(x, y, x + view.getWidth(), y + view.getHeight());
                        return false;

                    case MotionEvent.ACTION_UP:
                        view.setScaleX(1f);
                        view.setScaleY(1f);
                        if (rect.contains(x + (int) event.getX(), y + (int) event.getY())) {
                            Intent intent = new Intent(getApplicationContext(), DrawActivity.class);
                            intent.putExtra("intent_var", num);
                            startActivity(intent);
                            finish();
                            break;
                        }
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        if (!rect.contains(x + (int) event.getX(), y + (int) event.getY())) {
                            view.setScaleX(1f);
                            view.setScaleY(1f);
                            return true;
                        }

                    case MotionEvent.ACTION_CANCEL:
                        if (!rect.contains(x + (int) event.getX(), y + (int) event.getY())) {
                            view.setScaleX(1f);
                            view.setScaleY(1f);
                            return true;
                        }
                }
                return false;
            }
        };
        return listener;
    }

}
