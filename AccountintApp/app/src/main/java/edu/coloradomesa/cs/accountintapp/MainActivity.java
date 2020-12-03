package edu.coloradomesa.cs.accountintapp;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.AccountsException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Account> Accounts = new ArrayList<Account>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Account> tempAccounts = getIntent().getParcelableArrayListExtra("accountsList");
        if(tempAccounts != null) Accounts = tempAccounts;
    }

    public void addAccount(View view) {
        String acct, val, type;
        TextView tAcct = (TextView) findViewById(R.id.name_on_account);
        TextView tVal = (TextView) findViewById(R.id.amount_start);
        Spinner spinner = (Spinner)findViewById(R.id.type_account);
        type = spinner.getSelectedItem().toString();
        acct = tAcct.getText().toString();
        val = tVal.getText().toString();
        TextView error = (TextView) findViewById(R.id.error_message);
        if(acct.equals("") || val.equals("")) {
            error.setText(R.string.error_mssg);
        }
        else {
            // Only for the purpose of the demonstration
            if(acct.equals("Super") && val.equals("Secret")) {
                Account a0 = new Account("Cash", "Asset", 10000);
                Account a1 = new Account("Accounts Receivable", "Asset", 5000);
                Account a2 = new Account("Inventory", "Asset", 2000);
                Account a3 = new Account("Supplies", "Asset", 500);
                Account a4 = new Account("Accounts Payable", "Liability", 3000);
                Account a5 = new Account("Unearned Revenue", "Liability", 500);
                Account a6 = new Account("Taxes Payable", "Liability", 1000);
                Account a7 = new Account("Common Stock", "Owner's Equity", 7000);
                Account a8 = new Account("Retained Earnings", "Owner's Equity", 3000);
                Account a9 = new Account("AOCI", "Owner's Equity", 3000);
                Account a10 = new Account("Goodwill", "Asset", 1000);
                Accounts.add(a0);
                Accounts.add(a1);
                Accounts.add(a2);
                Accounts.add(a3);
                Accounts.add(a4);
                Accounts.add(a5);
                Accounts.add(a6);
                Accounts.add(a7);
                Accounts.add(a8);
                Accounts.add(a9);
                Accounts.add(a10);
            }
            else {
                error.setText(acct + " added");
                Account knew = new Account(acct, type, Integer.parseInt(val));
                Accounts.add(knew);
                tAcct.setText("");
                tVal.setText("");
            }
        }
    }

    public void toTransactionPage(View view) {
        Intent i = new Intent(this, TransactionActivity.class);
        i.putParcelableArrayListExtra("accountsList",Accounts);
        startActivity(i);
    }

    public void toStatementPage(View view) {
        Intent i = new Intent(this, StatementActivity.class);
        i.putParcelableArrayListExtra("accountsList",Accounts);
        startActivity(i);
    }
}