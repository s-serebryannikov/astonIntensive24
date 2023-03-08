package ru.serebryannikov.arrayListImp;

import java.util.Comparator;

public class MainTest {
    public static void main(String[] args) {
        ArrayListImp<Person> persons = new ArrayListImp<>();

        persons.add(new Person("Bob", 24));
        persons.add(new Person("Fred", 21));
        persons.add(new Person("Alan", 32));

        SotrUtil.quickSort(persons);

        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i));
        }

        System.out.println("=====================");

        SotrUtil.quickSort(persons, Comparator.comparing(Person::getAge));

        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i));
        }
    }
}
