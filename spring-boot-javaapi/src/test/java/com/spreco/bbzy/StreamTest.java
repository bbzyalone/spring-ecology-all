package com.spreco.bbzy;

import com.spreco.bbzy.module.Person;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
public class StreamTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public StreamTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(StreamTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    /**
     * Java提取集合属性为列表的方法
     */
    public void test1() {

        List<Person> people = Arrays.asList(
                new Person("Alice"),
                new Person("Bob"),
                new Person("Charlie")
        );

        List<String> names = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println(names);
    }
}
