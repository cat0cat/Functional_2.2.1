package org.example;

public class Main {
    public static void main(String[] args) {
        Credit credit1 = new Annuity(100_000,10,10.00);
        Credit credit2 = new Differentiated(100_000,10,10.00);

        System.out.println("Аннуитетный платеж: ");
        System.out.println(credit1.monthlyPayment());
        System.out.println(credit1.generalSum());
        System.out.println(credit1.overpayment());

        System.out.println("Дифференцированный платеж: ");
        System.out.println(credit2.monthlyPayment());
        System.out.println(credit2.generalSum());
        System.out.println(credit2.overpayment());
    }
}
