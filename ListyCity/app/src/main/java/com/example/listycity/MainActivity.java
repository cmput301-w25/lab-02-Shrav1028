package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    int index;
    ArrayAdapter <String> cityAdapter;
    ArrayList<String> dataList;
    Button addButton;
    Button deleteButton;
    Button confirmButton;

    EditText textBox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityList = findViewById(R.id.city_list);
//        String []cities = {"Edmonton", "Vancouver","Moscow","Sydney","Berlin","Vienna","Tokyo","Beijing","Osaka","New Delhi"};
        String[] cities;

        addButton = findViewById(R.id.add_button);
        deleteButton=findViewById(R.id.delete_button);
        confirmButton=findViewById(R.id.confirm_button);
        textBox = findViewById(R.id.editText);
        dataList = new ArrayList<>();
//        dataList.addAll(Arrays.asList(cities));
        addButton.setOnClickListener(v ->  {confirmButton.setVisibility(View.VISIBLE);
        textBox.setVisibility(View.VISIBLE);
            textBox.setText("");
        });
        cityAdapter = new ArrayAdapter<>(this,R.layout.content,dataList);
        confirmButton.setOnClickListener(v->{
            String user = textBox.getText().toString();
            dataList.add(user);
            cityList.setAdapter(cityAdapter);
            textBox.setText("");
            textBox.setVisibility(View.INVISIBLE);
            confirmButton.setVisibility(View.INVISIBLE);

        });
        cityList.setOnItemClickListener((parent,view,position,id)->{
            index = position;
        });
        deleteButton.setOnClickListener(v->{
            dataList.remove(index);
            cityList.setAdapter(cityAdapter);
        });
        cityList.setAdapter(cityAdapter);
        };
}