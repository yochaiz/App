package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class Page8Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_14;
    private final static int childSound = R.raw.b_1_3_15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page8);

        setPage(R.id.page8);

        setClickableRelativeLayout(R.id.bobbyBtn, bobbySound);
        setClickableRelativeLayout(R.id.child1Btn, childSound);

        setClickableRelativeLayout(R.id.rl_p8_bobby, bobbySound);
        setClickableRelativeLayout(R.id.rl_p8_child_top, childSound);
        setClickableRelativeLayout(R.id.rl_p8_child_bottom, childSound);
    }
}
