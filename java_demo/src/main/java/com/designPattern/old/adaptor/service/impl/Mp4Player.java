package com.designPattern.old.adaptor.service.impl;

import com.designPattern.old.adaptor.service.AdvancedMediaPlayer;

/**
 * Created by Brian in 18:28 2018/5/11
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("playing mp4 file: " + fileName);
    }
}
