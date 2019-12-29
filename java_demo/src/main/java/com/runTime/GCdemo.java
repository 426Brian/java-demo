package com.runTime;

/**
 * Created by Brian in 23:50 2018/11/24
 */
public class GCdemo {
    public static void main(String[] args) {
        Member member = new Member();
        try {
            member.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


}

class Member{
    public Member() {
        System.out.println("member 诞生");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("准备回收垃圾");
    }
}
