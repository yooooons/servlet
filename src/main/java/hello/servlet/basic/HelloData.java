package hello.servlet.basic;

//json은 통상 그냥 사용하는게 아니라 객체를 활용해서 사용한다

import lombok.Getter;
import lombok.Setter;

@Getter @Setter //lombok사용
public class HelloData {
    private String username;
    private int age;

}
