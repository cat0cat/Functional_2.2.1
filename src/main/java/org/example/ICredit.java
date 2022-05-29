package org.example;

import java.math.BigDecimal;

public interface ICredit {

    BigDecimal monthlyPayment(); //ежемесячный платеж
    BigDecimal generalSum(); //общая сумма к возврату
    BigDecimal overpayment(); //сумма переплат

}
