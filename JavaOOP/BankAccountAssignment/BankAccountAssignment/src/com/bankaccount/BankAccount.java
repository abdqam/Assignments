package com.bankaccount;

import java.util.Random;

public class BankAccount {
    private String accountNumber="";
    private double checkingBalance=0.0;
    private double savingBalance=0.0;
    private static int numberOfAccounts=0;
    private static double totalAmountOfMoney=0.0;

    public BankAccount() {
        this.accountNumber = accountNumber();
        numberOfAccounts++;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    private String accountNumber(){
        String account="";
        Random r = new Random();
        for(int i=0;i<10;i++){
            account+=r.nextInt(10);
        }
        return account;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public static double getTotalAmountOfMoney() {
        return totalAmountOfMoney;
    }

    public void depositMoney(double amount,String account){
        if(account.equals("checking")) {
            this.checkingBalance += amount;
        }
        else if(account.equals("saving")) {
            this.savingBalance += amount;
        }
        totalAmountOfMoney+=amount;
    }
    public void withdrawBalance(double amount,String account){
        if(account.equals("checking")) {
            if(amount>this.checkingBalance){
                System.out.println("insufficient funds");
            }
            else {
                this.checkingBalance -= amount;
                totalAmountOfMoney -= amount;
            }
        }
        else if(account.equals("saving")) {
            if(amount>this.savingBalance){
                System.out.println("insufficient funds");
            }
            else {
                this.savingBalance -= amount;
                totalAmountOfMoney-=amount;}
        }
    }
    public void totalMoney(){
        System.out.println("Saving Account Money:"+getSavingBalance()+", Checking Account Money:"+getCheckingBalance());
    }
}
