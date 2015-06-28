package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class WordPage2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_page2);

        setPage(R.id.wordbook_page2);

        setClickableRelativeLayout(R.id.rl_word_numbers, R.raw.word_numbers);
        setClickableRelativeLayout(R.id.rl_word_six, R.raw.word_six);
        setClickableRelativeLayout(R.id.rl_word_seven, R.raw.word_seven);
        setClickableRelativeLayout(R.id.rl_word_eight, R.raw.word_eight);
        setClickableRelativeLayout(R.id.rl_word_nine, R.raw.word_nine);
        setClickableRelativeLayout(R.id.rl_word_ten, R.raw.word_ten);
    }
}
