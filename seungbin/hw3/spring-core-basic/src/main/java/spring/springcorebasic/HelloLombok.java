package spring.springcorebasic;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("Lombok");

        String name = helloLombok.getName();
        int age = helloLombok.getAge();
        System.out.println(helloLombok.getName() + " " + helloLombok.getAge());
    }
}
