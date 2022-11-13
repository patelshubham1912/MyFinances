package com.shubham.myfinances;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup accountsGroup;
    RadioButton cds, loans, checkingAccounts;
    Button clearButton, saveButton;
    EditText editText1, editText2, editText3, editText4, editText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountsGroup = (RadioGroup) findViewById(R.id.accountsGroup );

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);

        clearButton = (Button) findViewById(R.id.clearButton);
        saveButton = (Button) findViewById(R.id.saveButton);

        cds = (RadioButton) findViewById(R.id.cds) ;
        loans = (RadioButton) findViewById(R.id.loans) ;
        checkingAccounts = (RadioButton) findViewById(R.id.checkingAccounts) ;

        accountsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(cds.isChecked()){
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                    editText1.setEnabled(true);
                    editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
                    editText2.setEnabled(true);
                    editText2.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                    editText3.setEnabled(true);
                    editText3.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                    editText4.setEnabled(false);
                    editText4.setInputType(InputType.TYPE_NULL);
                    editText5.setEnabled(true);
                    editText5.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                }else if(loans.isChecked()){
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                    editText1.setEnabled(true);
                    editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
                    editText2.setEnabled(true);
                    editText2.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                    editText3.setEnabled(true);
                    editText3.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                    editText4.setEnabled(true);
                    editText4.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                    editText5.setEnabled(true);
                    editText5.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                }else{
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                    editText1.setEnabled(true);
                    editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
                    editText2.setEnabled(false);
                    editText2.setInputType(InputType.TYPE_NULL);
                    editText3.setEnabled(true);
                    editText3.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                    editText4.setEnabled(false);
                    editText4.setInputType(InputType.TYPE_NULL);
                    editText5.setEnabled(false);
                    editText5.setInputType(InputType.TYPE_NULL);
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cds.isChecked()){
                    CDs cds = new CDs();
                    cds.setAccount_number(editText1.getText().toString());
                    cds.setInitial_balance(editText2.getText().toString());
                    cds.setCurrent_balance(editText3.getText().toString());
                    cds.setInterest_rate(editText5.getText().toString());

                    FinancesDataSource financesDataSource = new FinancesDataSource(MainActivity.this);
                    financesDataSource.open();
                    boolean wasSuccessful = financesDataSource.insertCDs(cds);
                    financesDataSource.close();

                    Toast toast = Toast.makeText(getApplicationContext(), "CD saved successfully", Toast.LENGTH_SHORT);
                    toast.show();
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                }else if(loans.isChecked()){
                    Loans loans = new Loans();
                    loans.setAccount_number(editText1.getText().toString());
                    loans.setInitial_balance(editText2.getText().toString());
                    loans.setCurrent_balance(editText3.getText().toString());
                    loans.setPayment_amount(editText4.getText().toString());
                    loans.setInterest_rate(editText5.getText().toString());

                    FinancesDataSource financesDataSource = new FinancesDataSource(MainActivity.this);
                    financesDataSource.open();
                    boolean wasSuccessful = financesDataSource.insertLoans(loans);
                    financesDataSource.close();

                    Toast toast = Toast.makeText(getApplicationContext(), "Loan saved successfully", Toast.LENGTH_SHORT);
                    toast.show();
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                }else if (checkingAccounts.isChecked()){
                    CheckingAccounts checkingAccounts = new CheckingAccounts();
                    checkingAccounts.setAccount_number(editText1.getText().toString());
                    checkingAccounts.setCurrent_balance(editText3.getText().toString());

                    FinancesDataSource financesDataSource = new FinancesDataSource(MainActivity.this);
                    financesDataSource.open();
                    boolean wasSuccessful = financesDataSource.insertCheckingAccounts(checkingAccounts);
                    financesDataSource.close();

                    Toast toast = Toast.makeText(getApplicationContext(), "Checking Account saved successfully", Toast.LENGTH_SHORT);
                    toast.show();
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                }
            }
        });


    }
}