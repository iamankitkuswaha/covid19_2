package com.example.covid19_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayMessageActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView sym1,sym2,sym3,sym4,sym5,sym6,txtname,txtreport;
    private Button check;
    ArrayList<String> symptomList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toast.makeText(this, "Activity 2nd onCreate", Toast.LENGTH_LONG).show();

        setContentView(R.layout.activity_display_message);
        sym1 = findViewById(R.id.symptom1);
        sym2 = findViewById(R.id.symptom2);
        sym3 = findViewById(R.id.symptom3);
        sym4 = findViewById(R.id.symptom4);
        sym5 = findViewById(R.id.symptom5);
        sym6 = findViewById(R.id.symptom6);
        txtname = findViewById(R.id.txtname);
        txtreport = findViewById(R.id.txtreport);

        check = (Button)findViewById(R.id.check);
        check.setOnClickListener(this);
        ArrayList<TextView> symtxt = new ArrayList<>();
        symtxt.add(txtname);
        symtxt.add(sym1);
        symtxt.add(sym2);
        symtxt.add(sym3);
        symtxt.add(sym4);
        symtxt.add(sym5);
        symtxt.add(sym6);
        symptomList = (ArrayList<String>) getIntent().getSerializableExtra("key");  //

        for (int i = 0; i < symptomList.size(); i++)
        {
            if(i==0)
            {
                String s = String.valueOf(symptomList.get(i))+ " ,your symptoms:";
                symtxt.get(i).setText(s);
            }
            else
                symtxt.get(i).setText(String.valueOf(symptomList.get(i)));
        }
        if(symptomList.size()==1) {
            symtxt.get(3).setText("Your all symptoms are Negative!");
            symtxt.get(3).setTextColor(ContextCompat.getColor(this, R.color.green));
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.check)
        {
            check.setBackgroundColor(Color.LTGRAY);
            if(symptomList.size()-1<=3)
            {
                txtreport.setText("You do not need to go for Covid19 testing.");
                txtreport.setTextColor(ContextCompat.getColor(this, R.color.green));
            }
            else
            {
                txtreport.setText("You should go for Covid19 testing.");
                txtreport.setTextColor(ContextCompat.getColor(this, R.color.red));
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Activity 2nd from onCreate to onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activity 2nd from onStart to onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Activity 2nd from onResume to onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Activity 2nd from onPause to onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Activity 2nd from onStop to onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activity 2nd from onStop to onDestroy", Toast.LENGTH_SHORT).show();
    }
}