package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class Page4Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_6;
    private final static int childSound = R.raw.b_1_3_7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        setPage(R.id.page4);

        bobbyBubble = new TextBubble(R.string.p4_bobby, R.drawable.blue_bubble, R.drawable.bobbybutton, this);
        childBubble = new TextBubble(R.string.p4_child, R.drawable.pink_bubble, R.drawable.child1, this);

        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound, bobbyBubble);
        createMediaButton(R.drawable.child1, R.id.child1Btn, childSound, childBubble);

        setClickableRelativeLayout(R.id.rl_p4_bobby, bobbySound, bobbyBubble);
        setClickableRelativeLayout(R.id.rl_p4_child, childSound, childBubble);
    }
}
