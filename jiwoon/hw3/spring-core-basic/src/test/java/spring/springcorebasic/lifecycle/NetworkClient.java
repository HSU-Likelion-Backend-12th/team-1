package spring.springcorebasic.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    // 빈 등록을 초기화 메소드
    @PostConstruct // 애노테이션 사용 // 편리하게 초기화, 종료 사용 가능
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    // 빈 등록 소멸 메소드
    @PreDestroy // 애노테이션 사용 // 편리하게 초기화, 종료 사용 가능
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
