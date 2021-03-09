package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int firstCand;
    int secondCand;
    int thirdCand;

    ArrayList<String> candList =new ArrayList<String>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        firstCand =intent.getExtras().getInt("cand1");
        secondCand =intent.getExtras().getInt("cand2");
        thirdCand =intent.getExtras().getInt("cand3");
        final EditText names=findViewById(R.id.editText1);
        final EditText id=findViewById(R.id.editText2);
        final Spinner selection=findViewById(R.id.spinner);
        final ToggleButton agree=findViewById(R.id.toggleButton);
        final Button btn=findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String id_v=id.getText().toString();
                String name_v=names.getText().toString();
                String select=selection.getItemAtPosition(0).toString();
                String selected=selection.getSelectedItem().toString();

                if(agree.isChecked() && !id_v.isEmpty() && !name_v.isEmpty() && !selected.equals(select)){
                    if(!candList.contains(id_v)){
                        candList.add(id_v);
                        Log.d("Result", "onClick: Success");
                        Context tstmsgs=getApplicationContext();
                        CharSequence txtmsg="Voting Successful";
                        int duration= Toast.LENGTH_LONG;
                        Toast t=Toast.makeText(tstmsgs,txtmsg,duration);
                        t.show();
                        if(selected.equals(selection.getItemAtPosition(1).toString())){
                            firstCand++;
                        }
                        else if(selected.equals(selection.getItemAtPosition(2).toString())){
                            secondCand++;
                        }
                        else {
                            thirdCand++;
                        }
                    }
                    else{

                        Log.d("Result", "onClick: Failed");
                        Context tstmsgf=getApplicationContext();
                        CharSequence txtmsg="Sorry. Double vote detected";
                        int duration= Toast.LENGTH_LONG;
                        Toast t=Toast.makeText(tstmsgf,txtmsg,duration);
                        t.show();
                    }
                }
                else{
                    Context tstmsg=getApplicationContext();
                    CharSequence txtmsg="Please select all fields";
                    int duration= Toast.LENGTH_LONG;
                    Toast t=Toast.makeText(tstmsg,txtmsg,duration);
                    t.show();
                }
            }
        });

    }

    public void onBackPressed(){
        Intent i=new Intent();
        i.putExtra("can1upd", firstCand);
        i.putExtra("can2upd", secondCand);
        i.putExtra("can3upd", thirdCand);
        setResult(RESULT_OK,i);
        finish();


    }

}