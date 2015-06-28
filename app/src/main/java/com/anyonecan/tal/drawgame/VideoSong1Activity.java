package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class VideoSong1Activity extends VideoActivity {

    public void onCreate(Bundle b) {
        setIDs(R.layout.activity_video_song1, R.raw.video_song_1);
        super.onCreate(b);

        setPage(R.id.video_song_animation1);
    }

}

