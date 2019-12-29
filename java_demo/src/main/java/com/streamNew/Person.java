package com.streamNew;

/**
 * Created by Brian in 17:24 2018/5/26
 */
public class Person {
    public Person() {
    }

    public Person(String name, Sex gender, int age, double height) {
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
    }

    public static enum Sex{
        MALE, FEMALE;
    }

    private String name;
    private Sex gender;
    private int age;
    private double height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
