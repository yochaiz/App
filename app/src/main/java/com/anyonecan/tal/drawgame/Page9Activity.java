package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class Page9Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_16;
    private final static int childSound = R.raw.b_1_3_17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page9);

        setPage(R.id.page9);

        setClickableRelativeLayout(R.id.bobbyBtn, bobbySound);
        setClickableRelativeLayout(R.id.child2Btn, childSound);

        setClickableRelativeLayout(R.id.rl_p9_bobby, bobbySound);
        setClickableRelativeLayout(R.id.rl_p9_child_top, childSound);
        setClickableRelativeLayout(R.id.rl_p9_child_bottom, childSound);
    }
}
