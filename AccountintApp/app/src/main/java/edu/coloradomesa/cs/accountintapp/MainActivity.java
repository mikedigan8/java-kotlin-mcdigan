package edu.coloradomesa.cs.accountintapp;

import androidx.appcompat.app.AppCompatActivity;

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
            error.setText(acct + " added");
            Account knew = new Account(acct,type,Integer.parseInt(val));
            Accounts.add(knew);
            tAcct.setText("");
            tVal.setText("");
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