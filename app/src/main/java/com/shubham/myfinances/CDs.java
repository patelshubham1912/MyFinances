package com.shubham.myfinances;

public class CDs {
    private int cdID;
    private String account_number;
    private String initial_balance;
    private String current_balance;
    private String interest_rate;

    public int getCdID() {
        return cdID;
    }

    public void setCdID(int cdID) {
        this.cdID = cdID;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getInitial_balance() {
        return initial_balance;
    }

    public void setInitial_balance(String initial_balance) {
        this.initial_balance = initial_balance;
    }

    public String getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(String current_balance) {
        this.current_balance = current_balance;
    }

    public String getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(String interest_rate) {
        this.interest_rate = interest_rate;
    }
}
