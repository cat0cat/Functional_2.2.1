package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Annuity extends Credit{
    private final int sum;
    private final double rate;
    private final int period;


    public Annuity(int sum, int period, double rate){
        this.sum = sum;
        this.period = period;
        this.rate = rate;
    }
    @Override
    public BigDecimal monthlyPayment() {
        double monthRate = (rate / 12) / 100;
        double annuityRate = monthRate*(Math.pow(1+monthRate, period))/((Math.pow(1+monthRate, period))-1);
        return BigDecimal.valueOf(sum * annuityRate).setScale(2,BigDecimal.ROUND_DOWN);
    }

    @Override
    public BigDecimal generalSum() {
        double monthRate = (rate / 12) / 100;
        double annuityRate = monthRate*(Math.pow(1+monthRate, period))/((Math.pow(1+monthRate, period))-1);
        return BigDecimal.valueOf((sum*annuityRate) * period).setScale(2,BigDecimal.ROUND_DOWN);
    }

    @Override
    public BigDecimal overpayment() {
        return generalSum().subtract(BigDecimal.valueOf(sum)).setScale(2,BigDecimal.ROUND_DOWN);
    }
}
