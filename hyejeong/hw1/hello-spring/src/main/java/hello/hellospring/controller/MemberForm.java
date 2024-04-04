package hello.hellospring.controller;

public class MemberForm {
    private String name; //매칭이 되면서 값이 들어옴

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
