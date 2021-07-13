package com.example.monkeymealproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class CustomerInfo implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "Email")
    public String CustomerEmail;

    @ColumnInfo(name = "Name")
    public  String CustomerName;

    @ColumnInfo(name = "Password")
    public String CustomerPassword;

    @ColumnInfo(name = "NickName")
    public  String CustomerNickName;


    public CustomerInfo(String customerName, String customerEmail, String customerPassword, String customerNickName) {
        CustomerName = customerName;
        CustomerEmail = customerEmail;
        CustomerPassword = customerPassword;
        CustomerNickName = customerNickName;
    }

    public CustomerInfo(){

    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return CustomerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        CustomerPassword = customerPassword;
    }

    public String getCustomerNickName() {
        return CustomerNickName;
    }

    public void setCustomerNickName(String customerNickName) {
        CustomerNickName = customerNickName;
    }

}
