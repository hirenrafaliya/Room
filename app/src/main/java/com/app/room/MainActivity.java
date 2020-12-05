package com.app.room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.room.database.UserDatabase;
import com.app.room.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = "MAINTAGER";
    EditText edtName, edtCompany, edtSalary;
    Button btnAdd, btnGetAllData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtCompany = findViewById(R.id.edtCompany);
        edtSalary = findViewById(R.id.edtSalary);
        btnGetAllData = findViewById(R.id.btnGet);
        btnAdd = findViewById(R.id.btnInsert);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String company = edtCompany.getText().toString();
                String salary = edtSalary.getText().toString();

                User user = new User(1,name, company, salary);

                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        super.run();

                        UserDatabase.getInstance(MainActivity.this).userDao().insertUser(user);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Inserted succesfully", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                };
                thread.start();

                ///

            }
        });

        btnGetAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();

                        List<User> userList = UserDatabase.getInstance(MainActivity.this).userDao().getAllUser();

                        final StringBuilder data = new StringBuilder();

                        for (User user : userList) {
                            data.append("id : ").append(user.getId()).append("\n");
                            data.append("name : ").append(user.getName()).append("\n");
                            data.append("company : ").append(user.getCompany()).append("\n");
                            data.append("salary : ").append(user.getSalary()).append("\n");
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                btnGetAllData.setText(data.toString());
                            }
                        });
                    }
                }.start();

            }
        });

    }
}