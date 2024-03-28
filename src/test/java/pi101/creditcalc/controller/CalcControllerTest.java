package pi101.creditcalc.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalcControllerTest {

    private CalcController calcController;

    @BeforeEach
    void setUp() {
        calcController = new CalcController();
    }

    @Test
    void testCalculateCredit() {
        double amount = 100000; // Сумма кредита
        double rate = 12.5; // Процентная ставка
        int term = 24; // Срок кредита в месяцах

        // Ожидаемый ежемесячный платеж
        double expectedMonthlyPayment = 4730.73;

        // Расчет ежемесячного платежа
        double actualMonthlyPayment = calcController.calculateCredit(amount, rate, term);

        assertEquals(expectedMonthlyPayment, actualMonthlyPayment, 0.01);
    }
}
