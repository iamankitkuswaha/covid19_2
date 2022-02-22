package com.example.covid19_2;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid19_2.Controller.ISelectSymptoms;
import com.example.covid19_2.Controller.SelectSymptoms;
import com.example.covid19_2.View.IReportView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IReportView{
    private TextView symname;
    private EditText edtname;
    private Button nextbtn,yesbtn,nobtn,subbtn,clearbtn;
    int symptomlist[] = {R.string.fever,R.string.body_pain,R.string.runny_nose,R.string.scratchy_throat,R.string.cough,R.string.tierdness};
    ArrayList<String>data = new ArrayList<>();
    ISelectSymptoms selectesymptoms;
    int counter = 0;
    @Override
    public void onClick(View view) {
        int v = view.getId();

        // Next Button
        if(v == R.id.nextbtn && counter < symptomlist.length-1)
        {
            //Toast.makeText(this,"fever",Toast.LENGTH_SHORT).show();
            yesbtn.setBackgroundColor(Color.BLUE);
            nobtn.setBackgroundColor(Color.BLUE);
            if(counter == symptomlist.length-2)
                nextbtn.setBackgroundColor(Color.LTGRAY);
            counter++;
        }
        symname.setText(symptomlist[counter]);


        // Submit Button
        if(view.getId()==R.id.submitbtn)
        {

            data.add(0,edtname.getText().toString());

            if(selectesymptoms.selectedSymptoms(data))
                sendMessage(view);
            else
            {
                if(data.get(0).length()==0)
                    data.remove(0);
            }
        }

        // Yes Button
        if(v==R.id.yesbtn)
        {
            boolean flag=true;
            for(String s:data)
            {
                if(s==symname.getText().toString())
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
                data.add(symname.getText().toString());

            Toast.makeText(this, symname.getText().toString()+" Selected", Toast.LENGTH_SHORT).show();
            yesbtn.setBackgroundColor(Color.LTGRAY);
            nobtn.setBackgroundColor(Color.BLUE);
        }

        // No Button
        if(v==R.id.nobtn)
        {
            //data.remove(data.size()-1);
            for(String s:data)
                if(s==symname.getText().toString())
                    data.remove(s);
            Toast.makeText(this, symname.getText().toString()+" not selected", Toast.LENGTH_SHORT).show();
            nobtn.setBackgroundColor(Color.LTGRAY);
            yesbtn.setBackgroundColor(Color.BLUE);
        }


        //Clear Button
        if(v==R.id.clearbtn)
        {
            edtname.getText().clear();
            data.clear();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Activity 1st from launch to onCreate", Toast.LENGTH_LONG).show();
        symname = findViewById(R.id.symname);

        edtname = (EditText) findViewById(R.id.edtName);

        nextbtn = (Button)findViewById(R.id.nextbtn);
        subbtn = (Button)findViewById(R.id.submitbtn);
        yesbtn = (Button)findViewById(R.id.yesbtn);
        nobtn  = (Button)findViewById(R.id.nobtn);
        clearbtn = (Button)findViewById(R.id.clearbtn);

        nextbtn.setOnClickListener(this);
        subbtn.setOnClickListener(this);
        yesbtn.setOnClickListener(this);
        nobtn.setOnClickListener(this);
        clearbtn.setOnClickListener(this);

        selectesymptoms = new SelectSymptoms((IReportView) this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Activity 1st from onCreate to onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activity 1st from onStart to onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Activity 1st from onResume to onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Activity 1st from onPause to onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Activity 1st from onStop to onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activity 1st from onStop to onDestroy", Toast.LENGTH_SHORT).show();
    }

    public void sendMessage(View v)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("key", data);
        startActivity(intent);
    }

    @Override
    public void nameSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void nameError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}