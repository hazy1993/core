package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
       //이넘은 비교타입을 == 가능
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
       }else {
            return 0;
        }
    }
}
