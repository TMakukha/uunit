package pi101.creditcalc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private HelloController helloController;

    @BeforeEach
    public void setUp() {
        helloController = new HelloController();
    }

    @Test
    public void testCalculateCredit() {
        double amount = 100000;
        double rate = 10;
        int term = 12;

        double expectedMonthlyPayment = 8791.59;

        assertEquals(expectedMonthlyPayment, helloController.calculateCredit(amount, rate, term), 0.01);
    }

    // Здесь можно добавить другие тесты для проверки различных сценариев


}