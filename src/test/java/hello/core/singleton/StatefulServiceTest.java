package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자 10000만원 주문
       int userAprice =  statefulService1.order("userA",10000);
        //ThreadA : B사용자 10000만원 주문
        int userBprice =  statefulService2.order("userA",20000);

        //ThreadA : A사용자 주문금액 죠회
    //    int price = statefulService1.getPrice();
        System.out.println("price = "+userAprice);

       // assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

    }
}