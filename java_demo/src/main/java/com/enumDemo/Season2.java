package com.enumDemo;

/**
 * Created by Brian in 19:47 2018/11/19
 */
public enum Season2 {
    SPRING("spring", "春暖花开"),
    SUMMER("spring", "夏日炎炎"),
    AUTUMN("spring", "秋高气爽"),
    WINTER("spring", "白雪皑皑");

    private String name;
    private String desc;

    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season2{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String str = "SPRING";
        Season2 season2 = Season2.valueOf(str);
//        System.out.println(season2.toString());

        Thread.State[] states = Thread.State.values();
        for (Thread.State state : states) {
            System.out.println(state);
        }
    }


}
