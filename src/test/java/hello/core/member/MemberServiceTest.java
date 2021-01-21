package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {


    MemberService memberService ;


    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();

    }

    @Test
    void join(){
        //given 어떤 상황에서


        Member member = new Member(1L,"MemberA", Grade.VIP);

        //when 했을때
        System.out.println(memberService);
         memberService.join(member);

         memberService.findMember(1L);

        Member findMember = memberService.findMember(1L);

        //then 된다
      Assertions.assertThat(member).isEqualTo(findMember);

    }

}
