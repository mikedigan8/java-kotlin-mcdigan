package edu.coloradomesa.cs.accountintapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
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
        ArrayList<Account> tempAccounts = getIntent().getParcelableArrayListExtra("accountsList");
        if(tempAccounts != null) Accounts = tempAccounts;
    }

    public void toMainAct(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putParcelableArrayListExtra("accountsList",Accounts);
        startActivity(i);
    }

    public void toStatementAct(View view) {
        Intent i = new Intent(this, StatementActivity.class);
        i.putParcelableArrayListExtra("accountsList",Accounts);
        startActivity(i);
    }

    public void postTransaction(View view) {
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
        RadioGroup acct1 = (RadioGroup)findViewById(R.id.dr_cr_account1_transaction);
        RadioGroup acct2 = (RadioGroup)findViewById(R.id.dr_cr_account2_transaction);
        RadioGroup acct3 = (RadioGroup)findViewById(R.id.dr_cr_account3_transaction);
        RadioGroup acct4 = (RadioGroup)findViewById(R.id.dr_cr_account4_transaction);
        ans1 = acct1.getCheckedRadioButtonId();
        ans2 = acct2.getCheckedRadioButtonId();
        ans3 = acct3.getCheckedRadioButtonId();
        ans4 = acct4.getCheckedRadioButtonId();
        char acct1Type, acct2Type, acct3Type, acct4Type;
        TextView error = (TextView) findViewById(R.id.error_transaction);
        error.setText("");
        if(ans1 == -1 || ans2 == -1 || acct1Name.equals("") || acct2Name.equals("") || acct1Val.equals("") || acct2Val.equals("")) {
            error.setText(R.string.error_transaction);
        }
        else {
            int i, j, k, l, debits = 0, credits = 0;
            if(ans3 == -1 && ans4 == -1) {
                if (((RadioButton)findViewById(R.id.dr_account1_transaction)).isChecked()) acct1Type = 'd';
                else acct1Type = 'c';
                if (((RadioButton)findViewById(R.id.dr_account2_transaction)).isChecked()) acct2Type = 'd';
                else acct2Type = 'c';
                if(Integer.parseInt(acct1Val) != Integer.parseInt(acct2Val)) error.setText(R.string.dr_cr_dont_equal);
                else if(acct1Type == acct2Type) error.setText(R.string.one_dr_cr);
                else {
                    for (i = 0; i < Accounts.size(); i++) {
                        if (Accounts.get(i).getAcctName().equals(acct1Name)) break;
                    }
                    for (j = 0; j < Accounts.size(); j++) {
                        if (Accounts.get(j).getAcctName().equals(acct2Name)) break;
                    }
                    if(Accounts.get(i).getAcctType().equals("Asset")) {
                        if(acct1Type == 'd') Accounts.get(i).setValue(Integer.parseInt(acct1Val));
                        else Accounts.get(i).setValue(-1 * Integer.parseInt(acct1Val));
                    }
                    else {
                        if(acct1Type == 'd') Accounts.get(i).setValue(-1 * Integer.parseInt(acct1Val));
                        else Accounts.get(i).setValue(Integer.parseInt(acct1Val));
                    }
                    if(Accounts.get(j).getAcctType().equals("Asset")) {
                        if(acct2Type == 'd') Accounts.get(j).setValue(Integer.parseInt(acct2Val));
                        else Accounts.get(j).setValue(-1 * Integer.parseInt(acct2Val));
                    }
                    else {
                        if(acct2Type == 'd') Accounts.get(j).setValue(-1 * Integer.parseInt(acct2Val));
                        else Accounts.get(j).setValue(Integer.parseInt(acct2Val));
                    }
                }
            }
            else if(ans4 == -1) {
                if(acct3Name.equals("") || acct3Val.equals("")) error.setText(R.string.error_transaction);
                else {
                    if (((RadioButton) findViewById(R.id.dr_account1_transaction)).isChecked())
                        acct1Type = 'd';
                    else acct1Type = 'c';
                    if (((RadioButton) findViewById(R.id.dr_account2_transaction)).isChecked())
                        acct2Type = 'd';
                    else acct2Type = 'c';
                    if (((RadioButton) findViewById(R.id.dr_account3_transaction)).isChecked())
                        acct3Type = 'd';
                    else acct3Type = 'c';
                    if (acct1Type == acct2Type && acct1Type == acct3Type)
                        error.setText(R.string.one_dr_cr);
                    else {
                        for (i = 0; i < Accounts.size(); i++) {
                            if (Accounts.get(i).getAcctName().equals(acct1Name)) break;
                        }
                        for (j = 0; j < Accounts.size(); j++) {
                            if (Accounts.get(j).getAcctName().equals(acct2Name)) break;
                        }
                        for (k = 0; k < Accounts.size(); k++) {
                            if (Accounts.get(k).getAcctName().equals(acct3Name)) break;
                        }
                        if (acct1Type == 'd') debits += Integer.parseInt(acct1Val);
                        else credits += Integer.parseInt(acct1Val);
                        if (acct2Type == 'd') debits += Integer.parseInt(acct2Val);
                        else credits += Integer.parseInt(acct2Val);
                        if (acct3Type == 'd') debits += Integer.parseInt(acct3Val);
                        else credits += Integer.parseInt(acct3Val);
                        if (debits != credits) error.setText(R.string.dr_cr_dont_equal);
                        else {
                            if(Accounts.get(i).getAcctType().equals("Asset")) {
                                if(acct1Type == 'd') Accounts.get(i).setValue(Integer.parseInt(acct1Val));
                                else Accounts.get(i).setValue(-1 * Integer.parseInt(acct1Val));
                            }
                            else {
                                if(acct1Type == 'd') Accounts.get(i).setValue(-1 * Integer.parseInt(acct1Val));
                                else Accounts.get(i).setValue(Integer.parseInt(acct1Val));
                            }
                            if(Accounts.get(j).getAcctType().equals("Asset")) {
                                if(acct2Type == 'd') Accounts.get(j).setValue(Integer.parseInt(acct2Val));
                                else Accounts.get(j).setValue(-1 * Integer.parseInt(acct2Val));
                            }
                            else {
                                if(acct2Type == 'd') Accounts.get(j).setValue(-1 * Integer.parseInt(acct2Val));
                                else Accounts.get(j).setValue(Integer.parseInt(acct2Val));
                            }
                            if(Accounts.get(k).getAcctType().equals("Asset")) {
                                if(acct3Type == 'd') Accounts.get(k).setValue(Integer.parseInt(acct3Val));
                                else Accounts.get(k).setValue(-1 * Integer.parseInt(acct3Val));
                            }
                            else {
                                if(acct3Type == 'd') Accounts.get(k).setValue(-1 * Integer.parseInt(acct3Val));
                                else Accounts.get(k).setValue(Integer.parseInt(acct3Val));
                            }
                        }
                    }
                }
            }
            else {
                if(acct4Name.equals("") || acct4Val.equals("")) error.setText(R.string.error_transaction);
                else {
                    if (((RadioButton) findViewById(R.id.dr_account1_transaction)).isChecked())
                        acct1Type = 'd';
                    else acct1Type = 'c';
                    if (((RadioButton) findViewById(R.id.dr_account2_transaction)).isChecked())
                        acct2Type = 'd';
                    else acct2Type = 'c';
                    if (((RadioButton) findViewById(R.id.dr_account3_transaction)).isChecked())
                        acct3Type = 'd';
                    else acct3Type = 'c';
                    if (((RadioButton) findViewById(R.id.dr_account4_transaction)).isChecked())
                        acct4Type = 'd';
                    else acct4Type = 'c';
                    if (acct1Type == acct2Type && acct1Type == acct3Type && acct1Type == acct4Type)
                        error.setText(R.string.one_dr_cr);
                    else {
                        for (i = 0; i < Accounts.size(); i++) {
                            if (Accounts.get(i).getAcctName().equals(acct1Name)) break;
                        }
                        for (j = 0; j < Accounts.size(); j++) {
                            if (Accounts.get(j).getAcctName().equals(acct2Name)) break;
                        }
                        for (k = 0; k < Accounts.size(); k++) {
                            if (Accounts.get(k).getAcctName().equals(acct3Name)) break;
                        }
                        for (l = 0; l < Accounts.size(); l++) {
                            if (Accounts.get(l).getAcctName().equals(acct4Name)) break;
                        }
                        if (acct1Type == 'd') debits += Integer.parseInt(acct1Val);
                        else credits += Integer.parseInt(acct1Val);
                        if (acct2Type == 'd') debits += Integer.parseInt(acct2Val);
                        else credits += Integer.parseInt(acct2Val);
                        if (acct3Type == 'd') debits += Integer.parseInt(acct3Val);
                        else credits += Integer.parseInt(acct3Val);
                        if (acct3Type == 'd') debits += Integer.parseInt(acct4Val);
                        else credits += Integer.parseInt(acct4Val);
                        if (debits != credits) error.setText(R.string.dr_cr_dont_equal);
                        else {
                            if(Accounts.get(i).getAcctType().equals("Asset")) {
                                if(acct1Type == 'd') Accounts.get(i).setValue(Integer.parseInt(acct1Val));
                                else Accounts.get(i).setValue(-1 * Integer.parseInt(acct1Val));
                            }
                            else {
                                if(acct1Type == 'd') Accounts.get(i).setValue(-1 * Integer.parseInt(acct1Val));
                                else Accounts.get(i).setValue(Integer.parseInt(acct1Val));
                            }
                            if(Accounts.get(j).getAcctType().equals("Asset")) {
                                if(acct2Type == 'd') Accounts.get(j).setValue(Integer.parseInt(acct2Val));
                                else Accounts.get(j).setValue(-1 * Integer.parseInt(acct2Val));
                            }
                            else {
                                if(acct2Type == 'd') Accounts.get(j).setValue(-1 * Integer.parseInt(acct2Val));
                                else Accounts.get(j).setValue(Integer.parseInt(acct2Val));
                            }
                            if(Accounts.get(k).getAcctType().equals("Asset")) {
                                if(acct3Type == 'd') Accounts.get(k).setValue(Integer.parseInt(acct3Val));
                                else Accounts.get(k).setValue(-1 * Integer.parseInt(acct3Val));
                            }
                            else {
                                if(acct3Type == 'd') Accounts.get(k).setValue(-1 * Integer.parseInt(acct3Val));
                                else Accounts.get(k).setValue(Integer.parseInt(acct3Val));
                            }
                            if(Accounts.get(l).getAcctType().equals("Asset")) {
                                if(acct4Type == 'd') Accounts.get(l).setValue(Integer.parseInt(acct4Val));
                                else Accounts.get(l).setValue(-1 * Integer.parseInt(acct4Val));
                            }
                            else {
                                if(acct4Type == 'd') Accounts.get(l).setValue(-1 * Integer.parseInt(acct4Val));
                                else Accounts.get(l).setValue(Integer.parseInt(acct4Val));
                            }
                        }
                    }
                }
            }
        }
        tAcct1.setText("");
        tAcct2.setText("");
        tAcct3.setText("");
        tAcct4.setText("");
        tVals1.setText("");
        tVals2.setText("");
        tVals3.setText("");
        tVals4.setText("");
        acct1.clearCheck();
        acct2.clearCheck();
        acct3.clearCheck();
        acct4.clearCheck();
        error.setText(R.string.posted);
    }

    public void clearBoard(View view) {
        TextView tAcct1 = (TextView) findViewById(R.id.account1_transaction);
        TextView tAcct2 = (TextView) findViewById(R.id.account2_transaction);
        TextView tAcct3 = (TextView) findViewById(R.id.account3_transaction);
        TextView tAcct4 = (TextView) findViewById(R.id.account4_transaction);
        TextView tVals1 = (TextView) findViewById(R.id.amount_account1_transaction);
        TextView tVals2 = (TextView) findViewById(R.id.amount_account2_transaction);
        TextView tVals3 = (TextView) findViewById(R.id.amount_account3_transaction);
        TextView tVals4 = (TextView) findViewById(R.id.amount_account4_transaction);
        RadioGroup acct1 = (RadioGroup)findViewById(R.id.dr_cr_account1_transaction);
        RadioGroup acct2 = (RadioGroup)findViewById(R.id.dr_cr_account2_transaction);
        RadioGroup acct3 = (RadioGroup)findViewById(R.id.dr_cr_account3_transaction);
        RadioGroup acct4 = (RadioGroup)findViewById(R.id.dr_cr_account4_transaction);
        TextView error = (TextView) findViewById(R.id.error_transaction);
        tAcct1.setText("");
        tAcct2.setText("");
        tAcct3.setText("");
        tAcct4.setText("");
        tVals1.setText("");
        tVals2.setText("");
        tVals3.setText("");
        tVals4.setText("");
        acct1.clearCheck();
        acct2.clearCheck();
        acct3.clearCheck();
        acct4.clearCheck();
        error.setText("");
    }
}