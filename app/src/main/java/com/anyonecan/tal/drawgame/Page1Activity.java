package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class Page1Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_2;
    private final static int kidsSound = R.raw.b_1_3_3;
    private final static int threeSound = R.raw.b_1_3_1;
    private static PointerAnim ptrAnim = null;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        ptrAnim.animateIfNeeded(hasFocus);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        setPage(R.id.page1);

        bobbyBubble = new TextBubble(R.string.p1_bobby, R.drawable.blue_bubble, R.drawable.bobbybutton, this);
        childBubble = new TextBubble(R.string.p1_children, R.drawable.pink_bubble, R.drawable.kidsbutton, this);

        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound, bobbyBubble);
        createMediaButton(R.drawable.kidsbutton, R.id.kidsBtn, kidsSound, childBubble);

        final TextBox ptrBox = new TextBox(R.string.p1_ptr, R.drawable.green_box, this);
        ptrAnim = new PointerAnim(R.id.rl_p1_bobby, ptrBox, this);

        setClickableRelativeLayout(R.id.rl_p1_three, threeSound);
        setClickableRelativeLayout(R.id.rl_p1_bobby, bobbySound, bobbyBubble, ptrAnim);
        setClickableRelativeLayout(R.id.rl_p1_children_left, kidsSound, childBubble, ptrAnim);
        setClickableRelativeLayout(R.id.rl_p1_children_right, kidsSound, childBubble, ptrAnim);
        setClickableRelativeLayout(R.id.rl_p1_children_center, kidsSound, childBubble, ptrAnim);
    }
}
