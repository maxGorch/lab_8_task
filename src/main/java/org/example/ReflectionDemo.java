package org.example;

import org.example.myObjects.Human;
import org.example.myObjects.Student;
import org.example.myObjects.Dog;

import java.lang.reflect.*;
import java.util.*;

/*
TODO:
    1. Дан список объектов произвольных типов. Найдите количество элементов списка, которые
    являются объектами типа Human или его подтипами.
    2. Для объекта получить список имен его открытых методов.
    3. Для объекта получить список (в виде списка строк) имен всех его супер классов до класса
    Object включительно.
    4. *Напишите интерфейс Executable с методом void execute();
    Напишите метод, который для списка объектов находит его элементы, реализующие этот
    интерфейс, и выполняет в таких объектах метод execute(). Метод возвращает количество
    найденных элементов.
    5. *Для объекта получить список его геттеров и сеттеров (в виде списка строк). Геттером
    считаем открытый нестатический метод без параметров, значение которого не void, а имя
    начинается с get. Сеттером считаем открытый нестатический метод с одним параметром, с
    результатом типа void, а имя метода начинается с set.
 */
public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Human productH_1 = new Human("Иван", "Иванов", "Иваныч", 25);
        Human productH_2 = new Human("Петр", "Иванов", "Олегович", 20);

        Student productS_1 = new Student("Василий", "Грекович", "Кириллович", 25, "ФЦТК");
        Student productS_2 = new Student("Роман", "Гнусарев", "Викторович", 25, "ФЦТК");

        Dog productD_1 = new Dog(4,"Шарик");

        ReflectionDemo reflection = new ReflectionDemo();

        Class<?> clazz = Class.forName("java.util.ArrayList");

        Constructor<?> constructor = clazz.getDeclaredConstructor();

        Object list = constructor.newInstance();

        Method addMethod = clazz.getMethod("add",Object.class);

        addMethod.invoke(list,productD_1);

        

        System.out.println(list);

    }
    int countHumans(List<?> list)
        /*
         TODO: 1. Дан список объектов произвольных типов.
          Найдите количество элементов списка, которые являются объектами типа Human или его подтипами.
        */
    {
        int counter = 0;

        for (Object i: list)
        {
            if(i instanceof Human)
            {
                counter++;
            }
        }

        return counter;
    }


}