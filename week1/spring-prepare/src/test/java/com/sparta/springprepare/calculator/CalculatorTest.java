package com.sparta.springprepare.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("더하기 테스트")
    void plus() {
        Calculator calculator = new Calculator();
        Double result = calculator.operate(8, "+", 2);
        System.out.println("result = " + result);

        Assertions.assertEquals(10, result);
    }

    @Test
    @DisplayName("나누기 테스트")
    void div() {
        Calculator calculator = new Calculator();
        Double result = calculator.operate(8, "/", 2);
        System.out.println("result = " + result);

        Assertions.assertEquals(4, result);
    }

    @Test
    @DisplayName("0으로 나누기")
    void byZero() {
        Calculator calculator = new Calculator();
        Double result = calculator.operate(8, "/", 0);
        System.out.println("result = " + result);

        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("default")
    void defaultOperate() {
        Calculator calculator = new Calculator();

        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.operate(8, ")", 0);
        });

        Assertions.assertEquals(e.getMessage(), "잘못된 연산자입니다.");
    }

}