package com.example.oosd.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "number")
public class Number {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "phone")
    public String number;

    @ColumnInfo(name = "type")
    public String type;

    public Number(int id, String number, String type) {
        this.id = id;
        this.number = number;
        this.type = type;
    }
}
