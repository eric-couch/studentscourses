package com.company;
import java.util.ArrayList;

public class Student {
    private String name;
    private String id;

    // constructor
    public Student (String name, String id)
    {
        this.name = name;
        this.id = id;
    }

    //copy constructor
    public Student (Student other)
    {
        this.name = other.name;
        this.id = other.id;
    }

    public String getName() {
        return name;
    }

    public String getID(){
        return id;
    }

    public String toString()
    {
        return "name: " + name + " id: " + id;
    }

    public boolean equals(Object other){
        System.out.println("in equals(Object)");
        boolean result = false;
        if (other instanceof Student) {
            Student otherStudent = (Student) other;
            result = id.equals(otherStudent.getID());
        }
        return result;
    }


    public static void main(String[] args){
        Student eric = new Student("Eric","1111");
        Student othereric = new Student(eric);
        Student tim = new Student("Tim", "2222");

        System.out.println(eric);
        System.out.println(tim);
        System.out.println("eric equals other eric? " + tim.equals(othereric));
        System.out.println("eric == other eric? " + (eric == othereric));

        ArrayList<Student> students = new ArrayList<Student>();
        students.add(eric);
        students.add(tim);
        System.out.println("students.contains(othereric): " + students.contains(othereric));

    }
}