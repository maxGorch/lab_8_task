import org.example.ReflectionDemo;
import org.example.myObjects.Dog;
import org.example.myObjects.Human;
import org.example.myObjects.Student;
import org.example.myObjects.Magistrant;
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
   Student productS_1 = new Student("Василий", "Грекович", "Кириллович", 25, "ФЦТК");
    Student magistrant_1 = new Magistrant("Роман", "Гнусарев", "Викторович", 25, "ФЦТК",1);

    ReflectionDemo reflection = new ReflectionDemo();
    Object obj = new Object();


    @Test
    public void getListSuperClassTest()
        /*
        Для объекта получить список (в виде списка строк)
        имен всех его супер классов до класса Object включительно
        */ {
        List<String> test = new ArrayList<>();
        test.add(magistrant_1.getClass().getName());
        test.add(magistrant_1.getClass().getSuperclass().getName());
        test.add(productS_1.getClass().getSuperclass().getName());
        test.add(obj.getClass().getName());

        List<String> actual = reflection.getListSuperClass(magistrant_1);

        assertEquals(test, actual);
    }

    @Test
    public void getListSuperClassTest_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            reflection.getListSuperClass(null);
        }, "Object = null!");
    }
}
