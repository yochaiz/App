package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class Page2Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        setPage(R.id.page2);

        bobbyBubble = new TextBubble(R.string.p2_bobby, R.drawable.blue_bubble, R.drawable.bobbybutton, this);

        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound, bobbyBubble);

        setClickableRelativeLayout(R.id.rl_p2_bobby, bobbySound, bobbyBubble);
    }
}
