package org.example;

import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleTest {
    private static Logger logger = (Logger) LoggerFactory.getLogger(AppTest.class);

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        logger.error("error");
        logger.debug("debug");

        assertTrue( true );
    }

    private static Triangle triangle;

    @BeforeAll
    public static void createNewTriangle() {
        triangle = new Triangle();
    }

    @Test
    public void positiveSides() {
        triangle.setA(9);
        triangle.setB(7);
        triangle.setC(3);
        Assertions.assertEquals(8.78564169540279, triangle.triangleArea(), 0);
    }

    @Test
    public void oneSideZero() {
        triangle.setA(0);
        ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> triangle.triangleArea());
        Assertions.assertEquals("Одна из сторон равна нулю!", exception.getMessage());
    }

    @Test
    public void oneSideNegative() {
        triangle.setA(-8);
        ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> triangle.triangleArea());
        Assertions.assertEquals("Одна из сторон имеет отрицательное значение!", exception.getMessage());
    }

}




