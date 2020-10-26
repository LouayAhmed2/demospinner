package com.example.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner sp;
    EditText ed;
    Button btnadd, btnremove;
    List<String> li;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = findViewById(R.id.spinneer);
        ed = findViewById(R.id.ed_lang);
        btnadd = findViewById(R.id.add);
        btnremove = findViewById(R.id.remove);

        li = new ArrayList<String>();
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, li);
        adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp.setAdapter(adp);
        sp.setSelection((li.size() - 1));
        btnadd.setOnClickListener(v -> {
            li.add(ed.getText().toString());
            adp.notifyDataSetChanged();
        });
        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adp.remove((String) sp.getSelectedItem());

            }
        });


    }
}