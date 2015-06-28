package com.anyonecan.tal.drawgame;

import android.app.Activity;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;

import java.util.Random;


public class ImmersiveActivity extends Activity {

    private final static int uiType = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_FULLSCREEN
            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

    private Runnable decor_view_settings = new Runnable() {
        public void run() {
            getWindow().getDecorView().setSystemUiVisibility(uiType);
        }
    };

    private Handler mHandler = new Handler();

    @Override
    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            mHandler.postDelayed(decor_view_settings, 500);
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            mHandler.post(decor_view_settings);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.post(decor_view_settings);
    }

    protected static AnimateOnClick randomAnimation(View layout, int flipVal) {
        Random rand = new Random();
        int max = 3;
        int randomNum = rand.nextInt((max) + 1);
        AnimateOnClick anim = null;
        switch (randomNum) {
            case 0:
                anim = new ScaleOnClick(layout);
                break;

            case 1:
                anim = new SlideOnClick(layout, flipVal);
                break;

            case 2:
                anim = new RotateOnClick(layout);
                break;

            case 3:
                anim = new FadeOnClick(layout);
                break;
        }
        return anim;
    }
}
