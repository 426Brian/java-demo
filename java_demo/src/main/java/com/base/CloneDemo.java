package com.base;

/**
 * Created by Brian in 2:21 2018/11/26
 */
public class CloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Test2 test = Test2.getTest2();
        Test2 test2 = (Test2) test.clone();
        System.out.println(test.hashCode());
        test.de();

        System.out.println(test2.getClass().getName()+" "+test2.hashCode());
        test2.de();


    }


}

class Test2 implements Cloneable {
    private static final Test2 test2 = new Test2();
    private Test2() {
    }

    public static Test2 getTest2() {
        return test2;
    }

    public void de(){
        System.out.println("he he");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
