package com.anyonecan.tal.drawgame;


import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public final class FadeOnClick extends AnimateOnClick {
    private float from = 1f;
    private float to = 0.2f;

    public FadeOnClick(View layout) {
        super(layout);
    }

    public FadeOnClick(View layout, int repeat, int duration, float from, float to) {
        super(layout);
        this.repeat = repeat;
        this.duration = duration;
        this.from = from;
        this.to = to;
    }

    protected Animation createAnimation() {
        return new AlphaAnimation(from, to);
    }
}
