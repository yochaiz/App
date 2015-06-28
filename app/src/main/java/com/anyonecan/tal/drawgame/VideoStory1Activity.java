package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class VideoStory1Activity extends VideoActivity  {

    public void onCreate(Bundle b) {
        setIDs(R.layout.activity_video_story1, R.raw.video_story_1);
        super.onCreate(b);

        setPage(R.id.video_story_animation1);
    }
}
