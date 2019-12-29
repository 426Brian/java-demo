package com.designPattern.old.adaptor.service.impl;

import com.designPattern.old.adaptor.service.MediaPlayer;

/**
 * Created by Brian in 18:37 2018/5/11
 */
public class AudioPlayer implements MediaPlayer {
    MediaPlayer mediaPlayer;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("playing mp3 file: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaPlayer = new MediaAdapter(audioType);
            mediaPlayer.play(audioType, fileName);
        } else {
            System.out.println("invalid media " + audioType + " fromat not supported");
        }
    }
}
