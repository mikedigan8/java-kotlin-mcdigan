package edu.coloradomesa.cs.accountintapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements Parcelable {
    private String acctName, acctType;
    private int value;

    public Account(String acctName, String acctType, int value) {
        this.acctName = acctName;
        this.acctType = acctType;
        this.value = value;
    }

    protected Account(Parcel in) {
        acctName = in.readString();
        acctType = in.readString();
        value = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(acctName);
        dest.writeString(acctType);
        dest.writeInt(value);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value += value;
    }

    public String getAcctName() {
        return acctName;
    }

    public String getAcctType() {
        return acctType;
    }
}
