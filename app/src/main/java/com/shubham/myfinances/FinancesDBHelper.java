package com.shubham.myfinances;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FinancesDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "myfinances.db" ;
    private static final int DATABASE_VERSION = 1;
    // create table cds
    private static final String CREATE_TABLE_CDS = "create table cds (_id integer primary key autoincrement, "
            + "account_number text, initial_balance text, "
            + "current_balance text, interest_rate text);" ;
    //create table loans
    private static final String CREATE_TABLE_LOANS = "create table loans (_id integer primary key autoincrement, "
            + "account_number text, initial_balance text, "
            + "current_balance text, payment_amount text, interest_rate text);" ;
    //create table checkingaccounts
    private static final String CREATE_TABLE_CHECKINGACCOUNTS = "create table checking_accounts (_id integer primary key autoincrement, "
            + "account_number text, current_balance text);" ;

    public FinancesDBHelper(Context context) { //5
        super (context, DATABASE_NAME , null , DATABASE_VERSION );
    }
    @Override
    public void onCreate(SQLiteDatabase database) { //6
        database.execSQL( CREATE_TABLE_CDS );
        database.execSQL( CREATE_TABLE_LOANS );
        database.execSQL( CREATE_TABLE_CHECKINGACCOUNTS );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS cds" );
        db.execSQL( "DROP TABLE IF EXISTS loans" );
        db.execSQL( "DROP TABLE IF EXISTS checking_accounts" );
        onCreate(db);
    }
}
