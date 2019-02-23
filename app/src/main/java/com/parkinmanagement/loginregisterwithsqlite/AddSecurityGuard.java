package com.parkinmanagement.loginregisterwithsqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddSecurityGuard extends AppCompatActivity implements View.OnClickListener {

    public static final String DATABASE_NAME = "loopwiki.com";

    EditText editTextName, editTextPhone,editTextAddress;


    SQLiteDatabase mDatabase;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addgurad);


        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPhone = (EditText) findViewById(R.id.editPhone);
        editTextAddress=(EditText)findViewById(R.id.editAddress);

        findViewById(R.id.buttonAddEmployee).setOnClickListener(this);

        //creating a database
        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);

    }

    //this method will validate thebuttonAddEmployee name and salary
    //dept does not need validation as it is a spinner and it cannot be empty
    private boolean inputsAreCorrect(String name, String phone) {
        if (name.isEmpty()) {
            editTextName.setError("Please enter a name");
            editTextName.requestFocus();
            return false;
        }

        if (phone.isEmpty()||phone.length() <= 9) {
            editTextPhone.setError("Please enter phone");
            editTextPhone.requestFocus();
            return false;
        }
        return true;
    }

    //In this method we will do the create operation
    private void addEmployee() {
        String name = editTextName.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();



        //validating the inptus
        if (inputsAreCorrect(name, phone)) {

            String insertSQL = "INSERT INTO employees \n" +
                    "(name, phone, address)\n" +
                    "VALUES \n" +
                    "(?, ?, ?);";


            mDatabase.execSQL(insertSQL, new String[]{name, phone, address});

            Toast.makeText(this, "Guard Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAddEmployee:

                addEmployee();

                break;
        }
    }
}