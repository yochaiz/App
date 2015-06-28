package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class Page12Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_23;
    private final static int childSound = R.raw.b_1_3_22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page12);

        setPage(R.id.page12);

        bobbyBubble = new TextBox(R.string.p12_bobby, R.drawable.blue_box, this);
        childBubble = new TextBox(R.string.p12_child, R.drawable.pink_box, this);

        invertFlip();
        createMediaButton(R.drawable.child7, R.id.child7Btn, childSound, childBubble);
        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound, bobbyBubble);

        setClickableRelativeLayout(R.id.rl_p12_bobby, bobbySound, bobbyBubble);
        setClickableRelativeLayout(R.id.rl_p12_child, childSound, childBubble);
    }
}
