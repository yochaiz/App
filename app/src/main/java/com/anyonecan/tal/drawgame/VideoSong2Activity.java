package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class VideoSong2Activity extends VideoActivity {

    public void onCreate(Bundle b) {
        setIDs(R.layout.activity_video_song2, R.raw.video_song_2);
        super.onCreate(b);

        setPage(R.id.video_song_animation2);
    }
}
