package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("모든 빈 출력하기")
    void    findAllBean(){
       String[] BeanDefinitionNames = ac.getBeanDefinitionNames() ;
        for (String beanDefinitionName : BeanDefinitionNames) {
           Object bean =  ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + "object = " + bean);
        }
    }

    @Test
    @DisplayName("모든 빈 출력하기")
    void    findApplicationBean(){
       String[] BeanDefinitionNames = ac.getBeanDefinitionNames() ;
        for (String beanDefinitionName : BeanDefinitionNames) {
        BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
        //Bean 에대한 정보

            if(beanDefinition.getRole()== beanDefinition.ROLE_APPLICATION){
                Object bean =  ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "object = " + bean);
            }
        }
    }
}
