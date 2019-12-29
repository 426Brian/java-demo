package com.concurrent.service.impl;

import com.concurrent.service.Test;
import org.springframework.stereotype.Service;

/**
 * Created by Brian in 22:55 2018/3/23
 */

@Service("test")
public class TestImpl implements Test {
    @Override
    public String getName(String name) {
        return name;
    }
}
