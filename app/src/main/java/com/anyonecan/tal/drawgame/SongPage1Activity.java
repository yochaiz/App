package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class SongPage1Activity extends SongActivity {

    private static PointerAnim ptrAnim = null;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        ptrAnim.animateIfNeeded(hasFocus);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_page1);

        setPage(R.id.songbook_page1);

        createStoppableMediaButton(R.raw.song1_full);

        final TextBox ptrBox = new TextBox(R.string.song_ptr, R.drawable.green_box, this);
        ptrAnim = new PointerAnim(R.id.rl_song1_verse2, ptrBox, this);

        setClickableVerseRelativeLayout(R.id.rl_song1_verse1, R.raw.song1_verse1, ptrAnim);
        setClickableVerseRelativeLayout(R.id.rl_song1_verse2, R.raw.song1_verse2, ptrAnim);
        setClickableVerseRelativeLayout(R.id.rl_song1_verse3, R.raw.song1_verse3, ptrAnim);
    }
}
