package org.example;

import java.math.BigDecimal;


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
        return null;
    }

    @Override
    public BigDecimal generalSum() {
        return null;
    }

    @Override
    public BigDecimal overpayment() {
        return null;
    }
}
