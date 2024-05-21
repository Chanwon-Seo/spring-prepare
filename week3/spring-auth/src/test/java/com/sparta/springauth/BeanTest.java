package com.sparta.springauth;

import com.sparta.springauth.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {
    /**
     * Food라는 타입으로는 빈이 2개 있다. pizza, chicken
     *
     * @Autowired에서는 기본적으로 Food의 타입으로 빈을 찾는다.
     * 하지만 Food라는 빈에는 1개 이상의 빈이 등록되어 있기 때문에
     * 필드 명으로 찾지만 필드명도 food로 되어 있다면 bean에는 food라는 빈을 찾을 수 없기 때문에
     * 필드 명을 변경하여 특정 빈으로 @Autowired할 수 있다.
     * @Autowired Food food; //ERROR
     */

    /**
     * 방법1
     */
    @Autowired
    Food pizza;

    @Autowired
    Food chicken;

    @Test
    @DisplayName("변수명으로 설정")
    void test1() {
        // given
        // when
        // then
        pizza.eat();
        chicken.eat();
    }

    /**
     * 방법2
     * Chicken 또는 Pizza에 @Primary를 선언
     * 같은 타입이 Bean이 여러개 있더라도
     *
     * @Primary가 붙어 있는 곳이 우선 적으로 빈을 주입
     */
    @Autowired
    Food food;

    @Test
    @DisplayName("@Primary")
    void test2() {
        // given

        // when

        // then
        food.eat();
    }

    /**
     * 방법3
     * Food타입의 빈이 등록된 객체에 @Qualifier("{name}")을 등록하여 사용한다.
     * Pizza라는 클래스에도 선언
     */
    @Qualifier("pizza")
    @Autowired
    Food foodPizza;

    @Test
    @DisplayName("test3")
    void test3() {
        // given

        // when

        // then
        foodPizza.eat();
    }

    /**
     * 범용적으로 사용하는 빈 객체에는 @Primary (큰 범위 | 우선순위가 낮다)
     * 지역적으로 사용하는 빈 객체에는 @Qualifier를 사용한다. (작은 범위 | 우선순위가 높음)
     */
    @Test
    @DisplayName("test4")
    void test4() {
        // given

        // when

        // then
        foodPizza.eat();
    }

}
