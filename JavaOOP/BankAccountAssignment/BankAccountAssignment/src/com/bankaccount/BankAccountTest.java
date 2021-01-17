package com.bankaccount;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account1=new BankAccount();
        BankAccount account2 = new BankAccount();
        account1.depositMoney(500,"saving");
        account1.depositMoney(500,"checking");
        account1.totalMoney();
        account2.totalMoney();
        account1.withdrawBalance(400,"saving");
        account1.withdrawBalance(200,"saving");
        account1.totalMoney();
        account2.totalMoney();
    }
}
