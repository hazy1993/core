package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
//@Scope("request") value 생략가능
public class MyLogger {

    private String uuid;
    private String requestURL;
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("["+uuid+"]"+"["+requestURL+"]" +message);
    }

    @PostConstruct//최초요청시 실행
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("["+uuid+"] request scope bean create: " +this);
        //겹치지 않는 uuid를 만들어줌
    }

    @PreDestroy //종료 직전 실행
    public  void close(){
        System.out.println("["+uuid+"] request scope bean close: " +this);
    }
}
