package com.anyonecan.tal.drawgame;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

public final class ScaleOnClick extends AnimateOnClick {
    private float scaleFactor = 1.5f;
    private static float scaleXfrom = 0f;
    private static float scaleXto = 0f;
    private static float scaleYfrom = 0f;
    private static float scaleYto = 0f;
    private static int pivotType = Animation.RELATIVE_TO_SELF;
    private static float pivotX = 0.4f;
    private static float pivotY = 0.5f;

    private void updateValues() {
        scaleXfrom = layout.getScaleX();
        scaleYfrom = layout.getScaleY();
        scaleXto = scaleXfrom * scaleFactor;
        scaleYto = scaleYfrom * scaleFactor;
    }

    public ScaleOnClick(View layout) {
        super(layout);

        updateValues();
    }

    public ScaleOnClick(View layout, float factor) {
        super(layout);
        scaleFactor = factor;

        updateValues();
    }

    public ScaleOnClick(View layout, float factor, int duration) {
        this(layout, factor);
        this.duration = duration;
    }

    public ScaleOnClick(View layout, float factor, int duration, int repeat) {
        super(layout);
        scaleFactor = factor;
        this.duration = duration;
        this.repeat = repeat;
        updateValues();
    }

    public ScaleOnClick(View layout, int duration) {
        this(layout);
        this.duration = duration;
    }

    protected Animation createAnimation() {
        return new ScaleAnimation(scaleXfrom, scaleXto, scaleYfrom, scaleYto, pivotType, pivotX, pivotType, pivotY);
    }
}

