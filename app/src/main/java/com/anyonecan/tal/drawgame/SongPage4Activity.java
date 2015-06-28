package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class SongPage4Activity extends SongActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_page4);

        setPage(R.id.songbook_page4);

        createStoppableMediaButton(R.raw.song2_full);

        setClickableVerseRelativeLayout(R.id.rl_song2_verse4, R.raw.song2_verse4);
        setClickableVerseRelativeLayout(R.id.rl_song2_verse5, R.raw.song2_verse5);
    }
}
