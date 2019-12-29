package com.streamNew;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Brian in 17:27 2018/5/26
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Person> people = createPeople();

        Stream<Person> stream = people.stream();
        stream.forEach(person -> {
            System.out.println(person.toString());
        });

        System.out.println(" == after filter ==");
        List<Person> people2 = new ArrayList<>();
        people2.addAll(people);
        Stream<Person> stream2 = people2.stream();
      /*  stream2.filter(person -> person.getGender() == Person.Sex.FEMALE).forEach(person -> {
            System.out.println(person.toString());
        });*/

        double avgHeight = stream2.filter(person -> person.getName().indexOf("J") >= 0)
                .mapToDouble(p -> p.getHeight()).average().getAsDouble();
        System.out.println("名字包含J 所有人的身高" + avgHeight);

    }

    static List<Person> createPeople() {
        List<Person> people = new ArrayList<>();
        Person p = new Person("Jack", Person.Sex.MALE, 26, 1.70);
        people.add(p);
        p = new Person("John", Person.Sex.MALE, 26, 1.75);
        people.add(p);
        p = new Person("Lily", Person.Sex.FEMALE, 24, 1.72);
        people.add(p);
        p = new Person("Jim", Person.Sex.FEMALE, 25, 1.69);
        people.add(p);
        return people;
    }
}
