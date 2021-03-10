package javaBasics.extendz;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class Person {
    private String name = "no name";
    private int age = 1;

    public static void main(String[] args) {
        Person person = new Person();
        person.privateMethod();
    }

    private void privateMethod() {
        System.out.println("private ");
    }

    void friendlyMethod() {

        System.out.println("friend");
    }

    public void protectedMethod() {
        System.out.println("protected");
    }


}