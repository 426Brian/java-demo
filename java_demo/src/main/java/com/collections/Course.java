package com.collections;

import java.util.Objects;

/**
 * Created by Brian in 21:47 2018/4/1
 */
public class Course implements Comparable {
    private String id;
    private String name;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
                Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public int compareTo(Object o) {
        Course course;
        if (o instanceof Course) {
            course = (Course) o;
            return this.getId().compareTo(course.getId());
        }
        return 0;
    }

    public static void main(String[] args) {
        Course course = new Course("1", "a");
        Course course2 = new Course("1", "a");

        System.out.println("course == " + course);
        System.out.println("course2 == " + course2);

        System.out.println(course == course2);
        System.out.println(course.equals(course2));
    }


}
