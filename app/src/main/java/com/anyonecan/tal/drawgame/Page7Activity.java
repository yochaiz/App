package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class Page7Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_12;
    private final static int childSound = R.raw.b_1_3_13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page7);

        setPage(R.id.page7);

        bobbyBubble = new TextBubble(R.string.p7_bobby, R.drawable.blue_bubble, R.drawable.bobbybutton, this);
        childBubble = new TextBubble(R.string.p7_child, R.drawable.pink_bubble, R.drawable.child4, this);


        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound, bobbyBubble);
        createMediaButton(R.drawable.child4, R.id.child4Btn, childSound, childBubble);

        setClickableRelativeLayout(R.id.rl_p7_bobby_left, bobbySound, bobbyBubble);
        setClickableRelativeLayout(R.id.rl_p7_bobby_right, bobbySound, bobbyBubble);
        setClickableRelativeLayout(R.id.rl_p7_children, childSound, childBubble);
    }
}
