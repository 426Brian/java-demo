package com.exception;

/**
 * Created by Brian in 20:44 2018/4/1
 */
public class ChainTest {
    public static void main(String[] args) {

        ChainTest chainTest = new ChainTest();
        try{
            chainTest.test2();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void test1() throws DrunkException {
        throw new DrunkException("喝酒别开车");

    }

    public void test2(){
        try {
            test1();
        } catch (DrunkException e) {
            RuntimeException newExc = new RuntimeException(e);
            throw newExc;
        }
    }
    
}
