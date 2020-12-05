package com.app.room.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserTABLE")
public class User {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String company;
    String salary;

    public User(int id, String name, String company, String salary) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.salary = salary;
    }

    @Ignore
    public User(String name, String company, String salary) {
        this.name = name;
        this.company = company;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
