package edu.coloradomesa.cs.accountintapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class StatementActivity extends AppCompatActivity {
    private ArrayList<Account> Accounts = new ArrayList<Account>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_statement);
        ArrayList<Account> tempAccounts = getIntent().getParcelableArrayListExtra("accountsList");
        if(tempAccounts != null) Accounts = tempAccounts;
        printIncomeStatement();
    }

    public void printIncomeStatement() {
        TextView ISTextBox = (TextView) findViewById(R.id.text_box_for_income_statement);
        if(Accounts.size() == 0) ISTextBox.setText(R.string.no_values);
        else {
            String strAssets = "", strLiabilities = "", strOwnersEquity = "", incomeStatement = "";
            int assets = 0, liabilities = 0, ownersEquity = 0;
            for(int i = 0; i < Accounts.size(); i++) {
                if(Accounts.get(i).getAcctType().equals("Asset")) {
                    assets += Accounts.get(i).getValue();
                    strAssets += Accounts.get(i).getAcctName();
                    strAssets += "----------";
                    strAssets += Integer.toString(Accounts.get(i).getValue());
                    strAssets += '\n';
                }
                if(Accounts.get(i).getAcctType().equals("Liability")) {
                    liabilities += Accounts.get(i).getValue();
                    strLiabilities += Accounts.get(i).getAcctName();
                    strLiabilities += "----------";
                    strLiabilities += Integer.toString(Accounts.get(i).getValue());
                    strLiabilities += '\n';
                }
                if(Accounts.get(i).getAcctType().equals("Owner's Equity")) {
                    ownersEquity += Accounts.get(i).getValue();
                    strOwnersEquity += Accounts.get(i).getAcctName();
                    strOwnersEquity += "----------";
                    strOwnersEquity += Integer.toString(Accounts.get(i).getValue());
                    strOwnersEquity += '\n';
                }
            }
            incomeStatement += "ASSETS:\n";
            incomeStatement += strAssets;
            incomeStatement += "TOTAL ASSETS----------";
            incomeStatement += Integer.toString(assets);
            incomeStatement += "\n \n \n";
            incomeStatement += "LIABILITIES:\n";
            incomeStatement += strLiabilities;
            incomeStatement += "TOTAL LIABILITIES----------";
            incomeStatement += Integer.toString(liabilities);
            incomeStatement += "\n \n \n";
            incomeStatement += "OWNER'S EQUITY:\n";
            incomeStatement += strOwnersEquity;
            incomeStatement += "TOTAL OWNER'S EQUITY----------";
            incomeStatement += Integer.toString(ownersEquity);
            incomeStatement += "\n \n \n";
            incomeStatement += "TOTAL LIABILITIES AND OWNER'S EQUITY----------";
            incomeStatement += Integer.toString(liabilities + ownersEquity);
            ISTextBox.setText(incomeStatement);
        }
    }

    public void toTransactionPage(View view) {
        Intent i = new Intent(this, TransactionActivity.class);
        i.putParcelableArrayListExtra("accountsList",Accounts);
        startActivity(i);
    }

    public void toMainPage(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putParcelableArrayListExtra("accountsList",Accounts);
        startActivity(i);
    }
}