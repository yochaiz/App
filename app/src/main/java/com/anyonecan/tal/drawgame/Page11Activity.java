package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class Page11Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_21;
    private final static int childSound = R.raw.b_1_3_20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page11);

        setPage(R.id.page11);

        bobbyBubble = new TextBox(R.string.p11_bobby, R.drawable.blue_box, this);
        childBubble = new TextBox(R.string.p11_child, R.drawable.pink_box, this);

        invertFlip();
        createMediaButton(R.drawable.child6, R.id.child6Btn, childSound, childBubble);
        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound, bobbyBubble);

        setClickableRelativeLayout(R.id.rl_p11_bobby, bobbySound, bobbyBubble);
        setClickableRelativeLayout(R.id.rl_p11_child, childSound, childBubble);
    }
}
