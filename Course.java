package com.company;
import java.util.ArrayList;

public class Course {

    private String courseName;
    private ArrayList<Student> students;

    public Course(String courseName){
        this.courseName = courseName;
        students = new ArrayList<Student>();
    }

    public String getCourseName() {
        return courseName;
    }

    public int size() {
        return students.size();
    }

    public boolean add(Student student){

        if (!students.contains(student)){
            students.add(student);
            return true;
        }
        return false;
    }

    public void remove(Student student){
        students.remove(student);
    }

    public void remove(int i){
        students.remove(i);
    }


    public Student getStudent(int i){
        return students.get(i);
    }

    public int indexOf(Student student){
        return students.indexOf(student);
    }

    public boolean contains(Student student) {
        return students.contains(student);
    }
    public String toString(){
        String res = "course: " + courseName + "  number of students: " + size();
        for (Student s: students) {
            res = res + "\n" + s;
        }

        return res;
    }

    public Course intersect(Course other){
        Course intersection = new Course("intersection");
        for (Student s: students) {
            if (other.contains(s)) {
                intersection.add(s);
            }
        }
        return intersection;
    }

    public static void main(String[] args) {

        Course course = new Course("Java 101");

        Student eric = new Student("Eric", "1111");
        Student tim = new Student("Tim", "2222");
        Student jacob = new Student("Jacob", "3333");
        Student lashele = new Student("LaShele", "4444");
        Student ben = new Student("Ben", "5555");
        course.add(eric);
        course.add(tim);
        course.add(jacob);
        course.add(lashele);
        course.add(ben);

        System.out.println(course);

        System.out.println("contains Eric: " + course.contains(eric));
        System.out.println("contains Eric: " + course.students.contains(eric));

        System.out.println("indexOf Eric: " + course.students.indexOf(eric));
        Student otherEric = new Student(eric);
        System.out.println("indexOf otherEric: " + course.indexOf(otherEric));

        System.out.println("Attempting to insert Tim again");
        if (course.add(tim)){
            System.out.println( "**ERROR " + tim.getName() + " is inserted but is already in student database");
        }
        else {
            System.out.println("OK " + tim.getName() + " not inserted again");
        }

        course.remove(1);
        System.out.println(course);

        Course course2 = new Course("Java 101");

        course2.add(tim);
        course2.add(jacob);
        System.out.println(course2);

        Course course3 = course.intersect(course2);
        System.out.println(course3);

    }
}
