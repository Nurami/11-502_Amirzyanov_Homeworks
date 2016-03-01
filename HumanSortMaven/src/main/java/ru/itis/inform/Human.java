package ru.itis.inform;


/**
 * Created by Nurami on 24.02.2016.
 */
public class Human   {
    private String age;
    private String name;

    public Human(String name, String age) {
        this.age = age;
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
