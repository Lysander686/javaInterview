package javaBasics.extendz;

public class Student extends Person {

    public Student() {
        System.out.println(this);
    }


    public static void main(String[] args) {

        Student student = new Student();
//        student.privateMethod();
        student.friendlyMethod();
    }
}
