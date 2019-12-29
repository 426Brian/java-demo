package com.enumDemo;

/**
 * Created by Brian in 19:37 2018/11/19
 */
public class SeasonDemo {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring.toString());
    }
}

// 自定义的方式使用枚举类
class Season {
    private final String seasonName;
    private final String seasonDesc;

    private Season(String seasonName, String seasonDesc) {
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    // 创建枚举类对象
    public static final Season SPRING = new Season("spring", "春暖花开");
    public static final Season SUMMER = new Season("summer", "夏日炎炎");
    public static final Season AUTUMN = new Season("autumn", "秋高气爽");
    public static final Season WINTER = new Season("winter", "白雪皑皑");

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
