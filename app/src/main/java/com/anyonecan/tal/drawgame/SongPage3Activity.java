package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class SongPage3Activity extends SongActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_page3);

        setPage(R.id.songbook_page3);

        createStoppableMediaButton(R.raw.song2_full);

        setClickableVerseRelativeLayout(R.id.rl_song2_verse1, R.raw.song2_verse1);
        setClickableVerseRelativeLayout(R.id.rl_song2_verse2, R.raw.song2_verse2);
        setClickableVerseRelativeLayout(R.id.rl_song2_verse3, R.raw.song2_verse3);
    }
}
