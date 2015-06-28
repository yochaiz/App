package com.anyonecan.tal.drawgame;

import android.app.Activity;
import android.widget.RelativeLayout;

public class PointerAnim {
    private RelativeLayout dstLayout = null;
    private RelativeLayout ptrLayout = null;
    private TextBubble bubble = null;
    private boolean animEnded = false;
    private int width = 0;
    private int height = 0;

    private Navigation navigate = new Navigation() {
        @Override
        public void run() {
            animEnded = true;
        }
    };

    PointerAnim(final int dstID, final TextBubble bubble, final Activity actv) {
        dstLayout = (RelativeLayout) actv.findViewById(dstID);
        ptrLayout = (RelativeLayout) actv.findViewById(R.id.pointer);
        this.bubble = bubble;
    }

    public void stopAnimation() {
        ptrLayout.setBackgroundResource(0);
        bubble.setHidden();
        animEnded = true;
    }

    public void animateIfNeeded(boolean hasFocus) {
        if ((hasFocus) && (!animEnded) && (ptrLayout != null) && (dstLayout != null)) {
            int[] loc1 = new int[2];
            ptrLayout.getLocationOnScreen(loc1);
            int[] loc2 = new int[2];
            dstLayout.getLocationOnScreen(loc2);
            float x = loc2[0] - loc1[0] - width;
            float y = loc2[1] - loc1[1] - height;

            SlideOnClick anim = new SlideOnClick(ptrLayout, x, y, 5, 2000);

            Navigation nav = new Navigation() {
                @Override
                public void run() {
                    navigate.run();
                    ptrLayout.setBackgroundResource(0);
                    bubble.setHidden();
                }
            };

            ptrLayout.setBackgroundResource(R.drawable.hand);
            bubble.setVisible();
            anim.click(nav);
        }
    }

    public void addAdjustment() {
        width = ptrLayout.getWidth() / 2;
        height = ptrLayout.getHeight() / 2;
    }

}
