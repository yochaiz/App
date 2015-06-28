package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class Page6Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_10;
    private final static int childSound = R.raw.b_1_3_11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6);

        setPage(R.id.page6);

        bobbyBubble = new TextBubble(R.string.p6_bobby, R.drawable.blue_bubble, R.drawable.bobbybutton, this);
        childBubble = new TextBubble(R.string.p6_child, R.drawable.pink_bubble, R.drawable.child4, this);


        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound, bobbyBubble);
        createMediaButton(R.drawable.child4, R.id.child4Btn, childSound, childBubble);

        setClickableRelativeLayout(R.id.rl_p6_bobby_left, bobbySound, bobbyBubble);
        setClickableRelativeLayout(R.id.rl_p6_bobby_right, bobbySound, bobbyBubble);
        setClickableRelativeLayout(R.id.rl_p6_children, childSound, childBubble);
    }
}
