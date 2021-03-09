package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class page1 extends AppCompatActivity {
    int candi1 =0;
    int candi2 =0;
    int candi3 =0;
    TextView can1;
    TextView can2;
    TextView can3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        can1 =findViewById(R.id.voteCount1);
        can2 =findViewById(R.id.voteCount2);
        can3 =findViewById(R.id.voteCount3);
        can1.setText("Total vote count is: "+ candi1);
        can2.setText("Total vote count is: "+ candi2);
        can3.setText("Total vote count is: "+ candi3);

    }
    public void onActivityResult(int requestCode, int resultCode,Intent i){
        super.onActivityResult(requestCode,resultCode,i);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                candi1 =i.getExtras().getInt("can1upd");
                candi2 =i.getExtras().getInt("can2upd");
                candi3 =i.getExtras().getInt("can3upd");
                can1.setText("Lucifer got "+ candi1 +" votes");
                can2.setText("Amenadiel got "+ candi2 +" votes");
                can3.setText("Michael got "+ candi3 +" votes");
            }
        }
    }
    public void Votingcan(View view){
        Intent i=new Intent(this,MainActivity.class);
        i.putExtra("cand1", candi1);
        i.putExtra("cand2", candi2);
        i.putExtra("cand3", candi3);
        startActivityForResult(i,1);

    }
}