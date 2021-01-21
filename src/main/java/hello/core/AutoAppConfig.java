package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member",
//        //"hello.core.member 부터 시작
//        basePackageClasses = AutoAppConfig.class,
//        //AutoAppConfig 위, 즉 hello.core여기서 부터 실행

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //excluderFilters 제외한다
        //AppConfigration과 충돌날수도 있기에 Configraion 제외
        //이전에 예제를 유지하기위해 필터사용

)
public class AutoAppConfig {

//    @Bean(name ="memoryMemberRepository")
//    MemberRepository memberRepository(){
//        return  new MemoryMemberRepository();
//    }

}
