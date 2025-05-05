import org.example.ReflectionDemo;
import org.example.myObjects.Dog;
import org.example.myObjects.Human;
import org.example.myObjects.Student;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestReflection {
    Human productH_1 = new Human("Иван", "Иванов", "Иваныч", 25);
    Human productH_2 = new Human("Петр", "Иванов", "Олегович", 20);
    Student productS_1 = new Student("Василий", "Грекович", "Кириллович", 25, "ФЦТК");
    Student productS_2 = new Student("Роман", "Гнусарев", "Викторович", 25, "ФЦТК");
    Dog productD_1 = new Dog(4, "Шарик");

    ReflectionDemo reflection = new ReflectionDemo();
    Object obj = new Object();


    @Test
    public void getListSuperClassTest()
        /*
        Для объекта получить список (в виде списка строк)
        имен всех его супер классов до класса Object включительно
        */ {
        List<String> test = new ArrayList<>();
        test.add(productS_1.getClass().getName());
        test.add(productS_1.getClass().getSuperclass().getName());
        test.add(obj.getClass().getName());

        List<String> actual = reflection.getListSuperClass(productS_1);

        assertEquals(test, actual);
    }

    @Test
    public void getListSuperClassTest_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            reflection.getListSuperClass(null);
        }, "Object = null!");
    }
}
