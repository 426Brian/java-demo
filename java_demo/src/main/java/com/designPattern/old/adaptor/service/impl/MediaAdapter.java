package com.designPattern.old.adaptor.service.impl;

import com.designPattern.old.adaptor.service.AdvancedMediaPlayer;
import com.designPattern.old.adaptor.service.MediaPlayer;

/**
 * Created by Brian in 18:28 2018/5/11
 */
public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer = new VlcPlayer();
        }else  if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc("fileName");
        }else  if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4("fileName");
        }
    }
}
