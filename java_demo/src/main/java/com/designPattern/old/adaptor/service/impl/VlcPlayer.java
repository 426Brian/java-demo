package com.designPattern.old.adaptor.service.impl;

import com.designPattern.old.adaptor.service.AdvancedMediaPlayer;

/**
 * Created by Brian in 18:25 2018/5/11
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("playing vlc file: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
    }
}
