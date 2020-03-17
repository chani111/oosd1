package com.example.oosd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.oosd.adapter.RecyclerViewAdapter;
import com.example.oosd.model.Number;
import com.example.oosd.room_db.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private List<Number> mNumbers = new ArrayList<>();
    private RecyclerViewAdapter mAdapter;
    private AppDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button enter = findViewById(R.id.enter_button);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDatabase = AppDatabase.getInstance(Main3Activity.this);

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        EditText searchEditText = findViewById(R.id.editText2);
                        String search = searchEditText.getText().toString();

                        mNumbers = mDatabase.numberDAO().findWithNumber(search);

                        final RecyclerView recyclerView = findViewById(R.id.result_list);

                        mAdapter = new RecyclerViewAdapter(
                                Main3Activity.this,
                                R.layout.item_number,
                                mNumbers
                        );
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                recyclerView.setLayoutManager(new LinearLayoutManager(Main3Activity.this));
                                recyclerView.setAdapter(mAdapter);
                            }
                        });
                    }
                });
                t.start();
            }
        });

    }
}
