package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class Page3Activity extends BaseActivity {

    private final static int kidsSound = R.raw.b_1_3_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        setPage(R.id.page3);

        childBubble = new TextBubble(R.string.p2_bobby, R.drawable.pink_bubble, R.drawable.kidsbutton, this);

        createMediaButton(R.drawable.kidsbutton, R.id.kidsBtn, kidsSound, childBubble);

        setClickableRelativeLayout(R.id.rl_p3_children, kidsSound, childBubble);
    }
}
