package spring.springcorebasic;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HelloLombok {
    private String name;
    private int age;

    //lombok : getter와 setter 자동 생성 , 코드가 간결해짐
    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("yamyam");

        String name=helloLombok.getName();
        System.out.println("name = "+name);
    }
}
