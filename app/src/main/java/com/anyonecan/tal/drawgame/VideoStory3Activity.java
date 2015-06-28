package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class VideoStory3Activity extends VideoActivity  {

    public void onCreate(Bundle b) {
        setIDs(R.layout.activity_video_story3, R.raw.video_story_3);
        super.onCreate(b);

        setPage(R.id.video_story_animation3);
    }
}
