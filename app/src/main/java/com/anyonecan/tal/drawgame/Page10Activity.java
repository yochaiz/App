package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class Page10Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_19;
    private final static int childSound = R.raw.b_1_3_18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page10);

        setPage(R.id.page10);

        bobbyBubble = new TextBubble(R.string.p10_bobby, R.drawable.blue_bubble, R.drawable.bobbybutton, this);
        childBubble = new TextBubble(R.string.p10_child, R.drawable.pink_bubble, R.drawable.child5, this);


        createMediaButton(R.drawable.child5, R.id.child5Btn, childSound, childBubble);
        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound, bobbyBubble);

        setClickableRelativeLayout(R.id.rl_p10_bobby, bobbySound, bobbyBubble);
        setClickableRelativeLayout(R.id.rl_p10_child, childSound, childBubble);
    }
}
