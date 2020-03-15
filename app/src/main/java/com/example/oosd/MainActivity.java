package com.example.oosd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
     Button m1,m2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m2=(Button)findViewById(R.id.button_1) ;
        m1=(Button)findViewById(R.id.button1);
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m1 = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(m1);
            }
        });
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m2 = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(m2);
            }
        });

    }
}
