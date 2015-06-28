package com.anyonecan.tal.drawgame;

import android.os.Bundle;

public class VideoStory2Activity extends VideoActivity  {

    public void onCreate(Bundle b) {
        setIDs(R.layout.activity_video_story2, R.raw.video_story_2);
        super.onCreate(b);

        setPage(R.id.video_story_animation2);
    }
}
