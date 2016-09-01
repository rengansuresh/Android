package com.androidapp.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HistoryActivity extends AppCompatActivity {

    final static String hisAnss[]={"","","","","","","","","",""};
    final static String hisExpp[]={"","","","","","","","","",""};
    final static String hisAns[]={"1","2","3","4","5","6","7","8","9","10"};
    final static String hisExp[]={"11","12","13","14","15","16","17","18","19","110"};
    final static String hisAnst[]={"51","52","53","54","55","56","57","58","59","60"};
    final static String hisExpt[]={"61","62","63","64","65","66","67","68","69","70"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);
        final Intent intent=getIntent();
        for(int i=0;i<=9;i++){
            hisAnss[i]=intent.getStringExtra(hisAns[i]);
            hisExpp[i]=intent.getStringExtra(hisExp[i]);
            Log.d("History Intent",hisExpp[i]+"="+hisAnss[i]);
        }
        Button ansbtn1=(Button)findViewById(R.id.ansBtn1);
        ansbtn1.setText(intent.getStringExtra(hisExp[0])+" = "+intent.getStringExtra(hisAns[0]));
        ansbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1,intent);
                finish();
            }
        });

        Button ansbtn2=(Button)findViewById(R.id.ansBtn2);
        ansbtn2.setText(intent.getStringExtra(hisExp[1])+" = "+intent.getStringExtra(hisAns[1]));
        ansbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(2,intent);
                finish();}
        });

        Button ansbtn3=(Button)findViewById(R.id.ansBtn3);

        ansbtn3.setText(intent.getStringExtra(hisExp[2])+" = "+intent.getStringExtra(hisAns[2]));
        ansbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(3,intent);
                finish();}
        });
        Button ansbtn4=(Button)findViewById(R.id.ansBtn4);

        ansbtn4.setText(intent.getStringExtra(hisExp[3])+" = "+intent.getStringExtra(hisAns[3]));
        ansbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(4,intent);
                finish();}
        });
        Button ansbtn5=(Button)findViewById(R.id.ansBtn5);

        ansbtn5.setText(intent.getStringExtra(hisExp[4])+" = "+intent.getStringExtra(hisAns[4]));
        ansbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(5,intent);
                finish();}
        });
        Button ansbtn6=(Button)findViewById(R.id.ansBtn6);

        ansbtn6.setText(intent.getStringExtra(hisExp[5]) + " = " + intent.getStringExtra(hisAns[5]));
        ansbtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(6,intent);
                finish();}
        });
        Button ansbtn7=(Button)findViewById(R.id.ansBtn7);

        ansbtn7.setText(intent.getStringExtra(hisExp[6])+" = "+intent.getStringExtra(hisAns[6]));
        ansbtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(7,intent);
                finish();}
        });
        Button ansbtn8=(Button)findViewById(R.id.ansBtn8);

        ansbtn8.setText(intent.getStringExtra(hisExp[7])+" = "+intent.getStringExtra(hisAns[7]));
        ansbtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(8,intent);
                finish();}
        });
        Button ansbtn9=(Button)findViewById(R.id.ansBtn9);

        ansbtn9.setText(intent.getStringExtra(hisExp[8])+" = "+intent.getStringExtra(hisAns[8]));
        ansbtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(8,intent);
                finish();}
        });
        Button ansbtn10=(Button)findViewById(R.id.ansBtn10);

        ansbtn10.setText(intent.getStringExtra(hisExp[9])+" = "+intent.getStringExtra(hisAns[9]));
        ansbtn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(10,intent);
                finish();}
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        for (int q=0;q<=9;q++) {
            outState.putString(hisExpt[q], hisExpp[q]);
            outState.putString(hisAnst[q], hisAnss[q]);
        }
    }
}
