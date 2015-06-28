package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class VideoSong3Activity extends VideoActivity  {

    public void onCreate(Bundle b) {
        setIDs(R.layout.activity_video_song3, R.raw.video_song_3);
        super.onCreate(b);

        setPage(R.id.video_song_animation3);
    }
}