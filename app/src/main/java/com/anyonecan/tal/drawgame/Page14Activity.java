package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class Page14Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_27;
    private final static int childSound = R.raw.b_1_3_26;
    private final static int song = R.raw.b_1_3_28;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page14);

        setPage(R.id.page14);

        bobbyBubble = new TextBox(R.string.p14_bobby, R.drawable.blue_box, this);
        childBubble = new TextBox(R.string.p14_child, R.drawable.pink_box, this);

        invertFlip();
        createMediaButton(R.drawable.child6, R.id.child6Btn_1, childSound, childBubble);
        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound, bobbyBubble);
        createMediaButton(R.drawable.child6, R.id.child6Btn_2, song);

        setClickableRelativeLayout(R.id.rl_p14_bobby, bobbySound, bobbyBubble);
        setClickableRelativeLayout(R.id.rl_p14_child, childSound, childBubble);
    }
}
