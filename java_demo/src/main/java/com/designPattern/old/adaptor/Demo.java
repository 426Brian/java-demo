package com.designPattern.old.adaptor;

import com.designPattern.old.adaptor.service.impl.AudioPlayer;

/**
 * Created by Brian in 18:41 2018/5/11
 */
public class Demo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond thd horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}

