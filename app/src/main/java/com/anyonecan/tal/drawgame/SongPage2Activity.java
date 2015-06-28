package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class SongPage2Activity extends SongActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_page2);

        setPage(R.id.songbook_page2);

        createStoppableMediaButton(R.raw.song1_full);

        setClickableVerseRelativeLayout(R.id.rl_song1_verse4, R.raw.song1_verse4);
        setClickableVerseRelativeLayout(R.id.rl_song1_verse5, R.raw.song1_verse5);
    }
}
