package com.shubham.myfinances;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class FinancesDataSource {

    private SQLiteDatabase database ;
    private FinancesDBHelper dbHelper ;
    public FinancesDataSource(Context context) {
        dbHelper = new FinancesDBHelper(context);
    }
    public void open() throws SQLException {
        database = dbHelper .getWritableDatabase();
    }
    public void close() {
        dbHelper.close();
    }

    public boolean insertCDs(CDs cds) {
        boolean didSucceed = false ;
        try {
            ContentValues initialValues = new ContentValues();
            initialValues.put( "account_number" , cds.getAccount_number());
            initialValues.put( "initial_balance" , cds.getInitial_balance());
            initialValues.put( "current_balance" , cds.getCurrent_balance());
            initialValues.put( "interest_rate" , cds.getInterest_rate());
            didSucceed = database .insert( "cds" , null , initialValues) > 0; //4
        }
        catch (Exception e) {

        }
        return didSucceed;
    }

    public boolean insertLoans(Loans loans) {
        boolean didSucceed = false ;
        try {
            ContentValues initialValues = new ContentValues();
            initialValues.put( "account_number" , loans.getAccount_number());
            initialValues.put( "initial_balance" , loans.getInitial_balance());
            initialValues.put( "current_balance" , loans.getCurrent_balance());
            initialValues.put( "payment_amount" , loans.getPayment_amount());
            initialValues.put( "interest_rate" , loans.getInterest_rate());
            didSucceed = database .insert( "loans" , null , initialValues) > 0; //4
        }
        catch (Exception e) {

        }
        return didSucceed;
    }

    public boolean insertCheckingAccounts(CheckingAccounts checkingAccounts) {
        boolean didSucceed = false ;
        try {
            ContentValues initialValues = new ContentValues();
            initialValues.put( "account_number" , checkingAccounts.getAccount_number());
            initialValues.put( "current_balance" , checkingAccounts.getCurrent_balance());
            didSucceed = database .insert( "checking_accounts" , null , initialValues) > 0; //4
        }
        catch (Exception e) {

        }
        return didSucceed;
    }
}
