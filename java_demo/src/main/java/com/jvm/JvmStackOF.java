package com.jvm;

/**
 * JVM stackOverFlowError
 * VM options: -Xss180k 可以改变看执行效果
 * Created by Brian in 18:08 2018/5/29
 */
public class JvmStackOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JvmStackOF jvmStackOF = new JvmStackOF();
        try {
            jvmStackOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stackLength == " + jvmStackOF.stackLength);
//            e.printStackTrace();
        }
    }
}

