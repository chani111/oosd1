package com.example.oosd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.oosd.model.Number;
import com.example.oosd.room_db.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private List<Number> mNumbers = new ArrayList<>();
    private AppDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mDatabase = AppDatabase.getInstance(Main2Activity.this);
        Button b1;
        b1=(Button) findViewById(R.id.button_1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m2 = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(m2);
            }
        });

        Button addNumberButton = findViewById(R.id.button3);
        addNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText numberEditText = findViewById(R.id.editText);
                String number = numberEditText.getText().toString();

                RadioGroup type = (RadioGroup)Main2Activity.this.findViewById(R.id.type_radio_group);
                int checkedRadioButtonID = type.getCheckedRadioButtonId();

                RadioButton checkedRadioButton = (RadioButton) Main2Activity.this.findViewById(checkedRadioButtonID);
                String checkedLabel = checkedRadioButton.getText().toString();

                final Number number1 = new Number(0, number, checkedLabel);
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mDatabase.numberDAO().insertNumber(number1);
                    }
                });
                t.start();
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
