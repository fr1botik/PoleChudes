package com.example.polechudes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class options extends AppCompatActivity {

    String [] difficult = {"Легкая","Средняя","Сложная"};
    String [] baraban = {"Первый барабан","Второй барабан","Третий барабан"};
    TextView textView,textView1;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);


        textView = findViewById(R.id.test);
        textView1 = findViewById(R.id.test2);



        Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, difficult);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner1 = findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, baraban);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);


        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int setting1 = spinner.getSelectedItemPosition();
                textView.setText(setting1 + "" );

                }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };

        spinner.setOnItemSelectedListener(itemSelectedListener);

        AdapterView.OnItemSelectedListener itemSelectedListener1 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int setting2 = spinner1.getSelectedItemPosition();
                textView1.setText(setting2 + "");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };

        spinner1.setOnItemSelectedListener(itemSelectedListener1);

        /*textView.setText(setting1 + " " + setting2 );*/

    }

    public void startgame(View view) {

        Intent intent;

        String set = textView.getText().toString();
        String set1 = textView1.getText().toString();
        if (set.equals("0"))
        {
            intent = new Intent(this,first.class);
            intent.putExtra("baraban",set1);
            startActivity(intent);

        }
        else if(set.equals("1")){
            intent = new Intent(this,first.class);
            intent.putExtra("baraban",set1);
            startActivity(intent);
        }
        else if(set.equals("2")){
            intent = new Intent(this,first.class);
            intent.putExtra("baraban",set1);
            startActivity(intent);

        }
    }




}

