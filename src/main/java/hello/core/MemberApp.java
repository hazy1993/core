package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService =applicationContext.getBean("memberService",MemberService.class);
        //name 은 매서드명 뒤에는 반환값
        //applicationContext는 줄여서 ac라고 적는다고함.

    //  MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        //컨트트 +알트+V
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());
        //sout+v
    }
}
