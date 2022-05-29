package org.example;

import java.math.BigDecimal;

public class Differentiated extends Credit{
    private final int sum;
    private final double rate;
    private final int period;
    public Differentiated(int sum, int period, double rate){
        this.sum = sum;
        this.period = period;
        this.rate = rate;
    }

    @Override
    public BigDecimal monthlyPayment() {
        return generalSum().divide(BigDecimal.valueOf(period)).setScale(2,BigDecimal.ROUND_DOWN);
    }


    @Override
    public BigDecimal generalSum() {
        double [] payment = new double[period];
        double res = 0;
        for (int i = 0; i<period; i++) {
            payment[i] = ((rate / 100) * sum * (double) ((period - i) / period)) + (double) (sum / period);
            res +=  payment[i];
        }
        return BigDecimal.valueOf(res).setScale(2,BigDecimal.ROUND_DOWN);
    }

    @Override
    public BigDecimal overpayment() {
        return generalSum().subtract(BigDecimal.valueOf(sum)).setScale(2,BigDecimal.ROUND_DOWN);
    }
}
