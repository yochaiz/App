package com.anyonecan.tal.drawgame;

import android.app.Application;

import java.util.HashMap;

public class GlobalState extends Application {
    private HashMap<Integer, Page> pages;

    public GlobalState() {
        pages = new HashMap<>();
        Page page = new Page(MenuActivity.class, VideoSong2Activity.class);
        pages.put(R.id.video_song_animation1, page);
        page = new Page(VideoSong1Activity.class, WordPage1Activity.class);
        pages.put(R.id.video_song_animation2, page);
        page = new Page(VideoSong2Activity.class, SongPage1Activity.class);
        pages.put(R.id.wordbook_page1, page);
        page = new Page(WordPage1Activity.class, SongPage2Activity.class);
        pages.put(R.id.songbook_page1, page);
        page = new Page(SongPage1Activity.class, VideoSong3Activity.class);
        pages.put(R.id.songbook_page2, page);
        page = new Page(WordPage2Activity.class, SongPage4Activity.class);
        pages.put(R.id.songbook_page3, page);
        page = new Page(SongPage3Activity.class, VideoStory1Activity.class);
        pages.put(R.id.songbook_page4, page);
        page = new Page(VideoSong3Activity.class, SongPage3Activity.class);
        pages.put(R.id.wordbook_page2, page);
        page = new Page(SongPage2Activity.class, WordPage2Activity.class);
        pages.put(R.id.video_song_animation3, page);
        page = new Page(SongPage4Activity.class, VideoStory2Activity.class);
        pages.put(R.id.video_story_animation1, page);
        page = new Page(VideoStory1Activity.class, VideoStory3Activity.class);
        pages.put(R.id.video_story_animation2, page);
        page = new Page(VideoStory2Activity.class, Page1Activity.class);
        pages.put(R.id.video_story_animation3, page);
        page = new Page(VideoStory3Activity.class, Page2Activity.class);
        pages.put(R.id.page1, page);
        page = new Page(Page1Activity.class, Page3Activity.class);
        pages.put(R.id.page2, page);
        page = new Page(Page2Activity.class, Page4Activity.class);
        pages.put(R.id.page3, page);
        page = new Page(Page3Activity.class, Page5Activity.class);
        pages.put(R.id.page4, page);
        page = new Page(Page4Activity.class, Page6Activity.class);
        pages.put(R.id.page5, page);
        page = new Page(Page5Activity.class, Page7Activity.class);
        pages.put(R.id.page6, page);
        page = new Page(Page6Activity.class, Page8Activity.class);
        pages.put(R.id.page7, page);
        page = new Page(Page7Activity.class, Page9Activity.class);
        pages.put(R.id.page8, page);
        page = new Page(Page8Activity.class, Page10Activity.class);
        pages.put(R.id.page9, page);
        page = new Page(Page9Activity.class, Page11Activity.class);
        pages.put(R.id.page10, page);
        page = new Page(Page10Activity.class, Page12Activity.class);
        pages.put(R.id.page11, page);
        page = new Page(Page11Activity.class, Page13Activity.class);
        pages.put(R.id.page12, page);
        page = new Page(Page12Activity.class, Page14Activity.class);
        pages.put(R.id.page13, page);
        page = new Page(Page13Activity.class, VideoSongsActivity.class);
        pages.put(R.id.page14, page);
        page = new Page(Page14Activity.class, null);
        pages.put(R.id.video_songs_animation, page);
        page = new Page(null, null);
        pages.put(R.id.gamesMenuPage, page);
    }

    public Page getPage(int id) {//returns null if id doesn't exist
        return pages.get(id);
    }
}