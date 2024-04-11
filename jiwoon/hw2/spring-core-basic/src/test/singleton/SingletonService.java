package spring.springcorebasic.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() { } // 기본 생성자를 private으로 막아뒀기 때문에 더이상 new로 객체 생성을 못함

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}