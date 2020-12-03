package edu.coloradomesa.cs.accountintapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TransactionActivity extends AppCompatActivity {
    private ArrayList<Account> Accounts = new ArrayList<Account>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        Accounts = getIntent().getParcelableArrayListExtra("accountsList");
    }

    public void toMainAct(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putParcelableArrayListExtra("accountsList",Accounts);
        startActivity(i);
    }

    public void postTransaction(View view) {
        RadioGroup acct1, acct2, acct3, acct4;
        int ans1, ans2, ans3, ans4;
        String acct1Name, acct1Val, acct2Name, acct2Val, acct3Name, acct3Val, acct4Name, acct4Val;
        TextView tAcct1 = (TextView) findViewById(R.id.account1_transaction);
        TextView tAcct2 = (TextView) findViewById(R.id.account2_transaction);
        TextView tAcct3 = (TextView) findViewById(R.id.account3_transaction);
        TextView tAcct4 = (TextView) findViewById(R.id.account4_transaction);
        acct1Name = tAcct1.getText().toString();
        acct2Name = tAcct2.getText().toString();
        acct3Name = tAcct3.getText().toString();
        acct4Name = tAcct4.getText().toString();
        TextView tVals1 = (TextView) findViewById(R.id.amount_account1_transaction);
        TextView tVals2 = (TextView) findViewById(R.id.amount_account2_transaction);
        TextView tVals3 = (TextView) findViewById(R.id.amount_account3_transaction);
        TextView tVals4 = (TextView) findViewById(R.id.amount_account4_transaction);
        acct1Val = tVals1.getText().toString();
        acct2Val = tVals2.getText().toString();
        acct3Val = tVals3.getText().toString();
        acct4Val = tVals4.getText().toString();
        acct1 = (RadioGroup)findViewById(R.id.dr_cr_account1_transaction);
        acct2 = (RadioGroup)findViewById(R.id.dr_cr_account2_transaction);
        acct3 = (RadioGroup)findViewById(R.id.dr_cr_account3_transaction);
        acct4 = (RadioGroup)findViewById(R.id.dr_cr_account4_transaction);
        ans1 = acct1.getCheckedRadioButtonId();
        ans2 = acct2.getCheckedRadioButtonId();
        ans3 = acct3.getCheckedRadioButtonId();
        ans4 = acct4.getCheckedRadioButtonId();
        if(ans1 == -1 || ans2 == -1 || acct1Name.equals("") || acct2Name.equals("") || acct1Val.equals("") || acct2Val.equals("")) {
            TextView error = (TextView) findViewById(R.id.error_transaction);
            error.setText(R.string.error_transaction);
        }
        else {
            if(ans3 == -1 && ans4 == -1) {

            }
            else if(ans4 == -1) {

            }
            else {

            }
        }
    }
}