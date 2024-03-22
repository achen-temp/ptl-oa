package com.ptl.exercise.altimetrik.hackerrank;

public class BankChatBot {

}

interface IBankAccountOperation {
    void deposit(double d);

    void withdraw(double d);

    double processOperations(String message);
}

//this is the class you need to implement between the INTERFACE and OUTCOME class
class BankOperations implements IBankAccountOperation {

    private double account = 0.0;

    @Override
    public void deposit(double d) {
        this.account += d;
    }

    @Override
    public void withdraw(double d) {
        if (this.account >= d) {
            this.account -= d;
        }
    }

    @Override
    public double processOperations(String message) {
        String msg = message.toLowerCase();
        if (msg.contains("see") || msg.contains("show")) {
            return this.account;
        } else {
            String[] words = msg.split("\\s+");
            double d = 0;
            for (String word : words) {
                try {
                    d = Double.parseDouble(word);
                    if (d > 0) {
                        break;
                    }
                } catch (Exception e) {
                }
            }
            if (msg.contains("deposit") || msg.contains("put") || msg.contains("invest") || msg.contains("transfer")) {
                this.deposit(d);
            }
            if (msg.contains("withdraw") || msg.contains("pull")) {
                this.withdraw(d);
            }
            return this.account;
        }

    }

}