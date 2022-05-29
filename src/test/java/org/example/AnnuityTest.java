package org.example;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

class AnnuityTest {

    Credit credit;
    private static long suiteStartTime;
    private long testStartTime;

    @BeforeEach
    void setUp() {
        int sum = 100_000;
        double rate = 10;
        int period = 10;
        credit = new Annuity(sum, period, rate);
    }

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running StringTest");
        suiteStartTime = System.nanoTime();
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("StringTest complete: " + (System.nanoTime() - suiteStartTime));
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new nest");
        testStartTime = System.nanoTime();
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete:" + (System.nanoTime() - testStartTime));
    }

    @Test
    @DisplayName("Проверка корректности вычисления ежемесячного платежа")
    void monthlyPayment() {
        BigDecimal expected = BigDecimal.valueOf(10_464.03);
        BigDecimal actual = credit.monthlyPayment();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Проверка корректности вычисления общей суммы к возврату")
    void generalSum() {
        BigDecimal expected = BigDecimal.valueOf(104_640.38);
        BigDecimal actual = credit.generalSum();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка корректности вычисления переплаты")
    void overpayment() {
        BigDecimal expected = BigDecimal.valueOf(4_640.38);
        BigDecimal actual = credit.overpayment();
        Assertions.assertEquals(expected, actual);
    }
}