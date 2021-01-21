package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
//@Target이 즁요. 어디에 붙는지 적어주는것
//필드에 붙나 클레스에 붙나 설정
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
//MyIncludeComponent 애가 붙은것은 컴포넌트 스캔에 추가한다는 뜻 뜻

}
