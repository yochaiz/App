package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class WordPage1Activity extends BaseActivity {

    private static PointerAnim ptrAnim = null;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        ptrAnim.addAdjustment();
        ptrAnim.animateIfNeeded(hasFocus);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_page1);

        setPage(R.id.wordbook_page1);

        final TextBox ptrBox = new TextBox(R.string.word_prt, R.drawable.green_box, this);
        ptrAnim = new PointerAnim(R.id.rl_word_three, ptrBox, this);

        setClickableRelativeLayout(R.id.rl_word_number, R.raw.word_number, ptrAnim);
        setClickableRelativeLayout(R.id.rl_word_one, R.raw.word_one, ptrAnim);
        setClickableRelativeLayout(R.id.rl_word_two, R.raw.word_two, ptrAnim);
        setClickableRelativeLayout(R.id.rl_word_three, R.raw.word_three, ptrAnim);
        setClickableRelativeLayout(R.id.rl_word_four, R.raw.word_four, ptrAnim);
        setClickableRelativeLayout(R.id.rl_word_five, R.raw.word_five, ptrAnim);
    }
}
