package com.anyonecan.tal.drawgame;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public final class SlideOnClick extends AnimateOnClick {
    private float xLength = 150f;
    private float yLength = 0f;

    public SlideOnClick(View layout, int flip) {
        super(layout);

        xLength *= flip;
    }

    public SlideOnClick(View layout, float x, float y, int repeat) {
        super(layout, repeat);

        xLength = x;
        yLength = y;
    }

    public SlideOnClick(View layout, float x, float y, int repeat, int duration) {
        this(layout, x, y, repeat);
        this.duration = duration;
    }

    protected Animation createAnimation() {
        return new TranslateAnimation(0, xLength, 0, yLength);
    }
}
