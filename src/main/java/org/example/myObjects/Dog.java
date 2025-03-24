package org.example.myObjects;

import java.util.Objects;

public class Dog
{
    String name;
    int age;

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setAge(int age)
    {
        this.age = age;
    }
    public void printAgeName()
    {
        System.out.println(name+age);
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dog dog)) return false;
        return age == dog.age && Objects.equals(getName(), dog.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), age);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
