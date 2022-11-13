package com.shubham.myfinances;

public class CheckingAccounts {
    private int checkingAccountID;
    private String account_number;
    private String current_balance;

    public int getCheckingAccountID() {
        return checkingAccountID;
    }

    public void setCheckingAccountID(int checkingAccountID) {
        this.checkingAccountID = checkingAccountID;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(String current_balance) {
        this.current_balance = current_balance;
    }
}
