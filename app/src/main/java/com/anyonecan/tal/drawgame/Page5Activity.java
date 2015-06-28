package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class Page5Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_8;
    private final static int childSound = R.raw.b_1_3_9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);

        setPage(R.id.page5);

        bobbyBubble = new TextBubble(R.string.p5_bobby, R.drawable.blue_bubble, R.drawable.bobbybutton, this);
        childBubble = new TextBubble(R.string.p5_child, R.drawable.pink_bubble, R.drawable.child2, this);


        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound, bobbyBubble);
        createMediaButton(R.drawable.child2, R.id.child2Btn, childSound, childBubble);

        setClickableRelativeLayout(R.id.rl_p5_bobby, bobbySound, bobbyBubble);
        setClickableRelativeLayout(R.id.rl_p5_child, childSound, childBubble);
    }
}
