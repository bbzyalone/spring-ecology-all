package com.spreco.bbzy;

import com.spreco.bbzy.Record.Book;
import junit.framework.TestCase;


import static java.util.Calendar.*;

public class OtherTest extends TestCase {

    public void test() {
        int dayOfWeek = switch (1) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> 0;
        };
        System.out.println(dayOfWeek);

        String query = """
           SELECT * from USER \
           WHERE `id` = 1 \
           ORDER BY `id`, `name`;\
           """;
        System.out.println(query);
    }

    public void test2(){
        System.out.println(Book.numb);
    }



}
