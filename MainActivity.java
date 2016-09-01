package com.androidapp.calculator;

import android.content.Intent;
import android.os.PersistableBundle;
import android.transition.Transition;
import android.util.Log;

        import android.view.MenuItem;
        import android.inputmethodservice.ExtractEditText;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

import java.math.BigDecimal;
import java.math.*;

public class MainActivity extends AppCompatActivity {
    BigDecimal result;
    String total= "", memtotal = "";
    double ms;
    int i=0,rc;
    String pTotal="",pLocal;
    char plus='+',minus='-',mul='*',div='/';
    String historyans[]={"","","","","","","","","","","",""};
    String historyexp[]={"","","","","","","","","","","",""};
    final static String hisAns[]={"1","2","3","4","5","6","7","8","9","10"};
    final static String hisExp[]={"11","12","13","14","15","16","17","18","19","110"};
    String historyanss[]={"21","22","23","24","25","26","27","28","29","30"};
    String historyexpp[]={"31","32","33","34","35","36","37","38","39","40"};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState!=null){
            for(int q=0;q<=9;q++){
                historyans[q]=savedInstanceState.getString(historyanss[q]);
                historyexp[q]=savedInstanceState.getString(historyexpp[q]);
                total=savedInstanceState.getString("total");
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText edit = (EditText) findViewById(R.id.display);
        final EditText mem = (EditText) findViewById(R.id.memdisplay);
        Button percent=(Button)findViewById(R.id.buttonPercent);

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                pTotal="";
                int i=total.length()-1;
                do{
                    pTotal=total.charAt(i)+pTotal;/*
                    Log.d("percent","ttoalatchar"+total.charAt(i));
                    Log.d("percent","pTotal in for"+pTotal);*/
                    i--;

                }while(total.charAt(i)!=plus&&total.charAt(i)!=minus&&total.charAt(i)!=mul&&total.charAt(i)!=div);
             /*   for(int i=total.length()-1;total.charAt(i)!=plus||total.charAt(i)!=minus||total.charAt(i)!=mul||total.charAt(i)!=div;i--){
                    pTotal=total.charAt(i)+pTotal;
                    Log.d("percent","ttoalatchar"+total.charAt(i));
                    Log.d("percent","pTotal in for"+pTotal);

                }
             */   Log.d("Percent", "pTotal=" + pTotal);
                char sign=total.charAt(i);
                mem.setText(total+"%");
                String localpercenttotal=mem.getText().toString();
                String perTotal=total.substring(0, i);
                BigDecimal beforepercent;
                Expression beforePercent=new Expression(perTotal);
                beforepercent=beforePercent.eval();
                perTotal=beforepercent+"";
                Double tempp=Double.parseDouble(perTotal);
                Double temppercent=Double.parseDouble(pTotal);
                Double pcalc = null;
                if(sign==plus)
                {
                    pcalc=(tempp*temppercent/100)+tempp;
                }else if(sign==minus){
                    pcalc=tempp-(tempp*temppercent/100);

                }else if(sign==mul){
                    pcalc=(tempp*temppercent/100)*tempp;

                }else if(sign==div){
                    pcalc=tempp/(tempp*temppercent/100);

                }
                Log.d("Percent","Answer="+pcalc);
                Log.d("Percent","sign"+sign+"  I value"+i+"before oper"+perTotal);
                total=pcalc+"";

                edit.setText(total);
/*
                mem.setText(total + "%");
                String pTotal,pLocal="\0";
                int i=total.length();
                do {
                    pLocal=total.indexOf(i-1)+pLocal;
                    i--;
                }while(total.indexOf(i-1)!='+'||total.indexOf(i-1)!='-'||total.indexOf(i-1)!='*'||total.indexOf(i-1)!='/');
               */
/* for(int i=total.length();total.indexOf(i-1)!='+'||total.indexOf(i-1)!='-'||total.indexOf(i-1)!='*'||total.indexOf(i-1)!='/';i--)
                {
                    pLocal=total.indexOf(i-1)+""+pLocal;

                }*//*

                Log.d("Percent","What percent withsign"+pLocal);

                String sign=pLocal.indexOf(0)+"";
                Log.d("Percent", "sign" + sign);
*/
              /*  int a=pLocal.length();
                String percent=pLocal.substring(1, a);
                Log.d("Percent",percent);
                int b=total.length()-pLocal.length();
                String beforePercent=total.substring(0,b);
                Log.d("Percent","Before Percent"+beforePercent);
                Expression percentEval=new Expression(beforePercent);
                result=percentEval.eval();

                String ppLocal=result+"";
                Double ppResult=Double.parseDouble(ppLocal);
                Double whatPercentage=Double.parseDouble(percent);
                Double rrResult= (whatPercentage/100)*ppResult;
                String happa=result+sign+rrResult;
                Log.d("Percent",happa);
                Expression happaEval=new Expression(happa);
                result=happaEval.eval();
                edit.setText(result+"");
*/
                int his;
                for(his=0;historyans[his]!=""&&his<=10;his++);
                if(his<=9){
                    historyans[his]=total;
                    historyexp[his]=localpercenttotal;
                }else
                {
                    historyexp[i]=localpercenttotal;
                    historyans[i]=total;
                    i++;
                    if(i==9)
                        i=0;
                }}catch (Exception e){
                    Toast.makeText(MainActivity.this,"Invalid Input",Toast.LENGTH_LONG).show();
                    total="";
                    mem.setText("");
                    edit.setText(total);
                    memtotal="";
                }


            }

        });

        Button del=(Button)findViewById(R.id.buttonBackspace);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                total=total.substring(0,total.length()-1);
                edit.setText(total);
            }catch(Exception e){
                total="";
            }}
        });
        Button negate=(Button)findViewById(R.id.buttonNegate);
        negate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                mem.setText("-"+"("+total+")");
                Expression negate=new Expression(total);
                result=negate.eval();
                String negate1=result+"";
                Double negate2=Double.parseDouble(negate1);
                if(negate2<0){
                    negate2=negate2-(2*negate2);
                }else{
                    negate2=-negate2;
                }
                negate1=negate2+"";
                Expression negate3=new Expression(negate1);
                result=negate3.eval();
                edit.setText(result+"");
                total=result+"";}catch (Exception e){
                    Toast.makeText(MainActivity.this,"Invalid Input",Toast.LENGTH_LONG).show();
                    total="";
                    memtotal="";
                    edit.setText(total);
                    mem.setText(memtotal);
                }



            }
        });
        Button oneBy=(Button)findViewById(R.id.buttonOneby);

        oneBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                Expression eval=new Expression(total);
                result=eval.eval();
                String one=result+"";
                mem.setText("1/("+total+")");
                String localoneby;
                localoneby=mem.getText().toString();

                Double d=Double.parseDouble(one);
                d=1/d;
                total=d+"";
                Expression evalOneBy=new Expression(total);
                result=evalOneBy.eval();
                edit.setText(result+"");
                int his;
                for(his=0;historyans[his]!=""&&his<=10;his++);
                if(his<=9){
                    historyans[his]=result+"";
                    historyexp[his]=localoneby;
                }else
                {
                    historyexp[i]=localoneby;
                    historyans[i]=result+"";
                    i++;
                    if(i==10)
                        i=0;
                }}catch (Exception e){
                    Toast.makeText(MainActivity.this,"Invalid Input",Toast.LENGTH_LONG).show();
                    total="";
                    edit.setText(total);
                    mem.setText(total);
                }
            }

        });
        Button mS=(Button)findViewById(R.id.buttonMS);
        mS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                BigDecimal temp;
                Expression ev = new Expression(total);
                temp = ev.eval();
                String t = temp + "";

                ms = Double.parseDouble(t);
            }catch(Exception e){
                    Toast.makeText(MainActivity.this,"No number to copy",Toast.LENGTH_LONG).show();
                }

            }
        });
        Button mC=(Button)findViewById(R.id.buttonMC);
        mC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ms=0;
            }
        });
        Button mR=(Button)findViewById(R.id.buttonMR);
        mR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total=total+ms;
                edit.setText(total);
            }
        });
        Button mPlus=(Button)findViewById(R.id.buttonMplus);
        mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total=total+"+"+ms;
                edit.setText(total);

            }
        });
        Button mMinus=(Button)findViewById(R.id.buttonMminus);
        mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total=total+"-"+ms;
                edit.setText(total);
            }
        });
        Button history=(Button)findViewById(R.id.buttonHistory);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,HistoryActivity.class);
                for(int r=0;r<=9;r++){
                    intent.putExtra(hisAns[r],historyans[r]);
                    intent.putExtra(hisExp[r],historyexp[r]);
                }

                for(int l=0;l<10;l++){
                    Log.d("Intent",historyexp[l]+"="+historyans[l]);}
                startActivityForResult(intent, rc);
            }
        });
        Button buttonSqrt=(Button)findViewById(R.id.buttonSqrt);
        buttonSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                EditText edit = (EditText) findViewById(R.id.display);
                EditText mem = (EditText) findViewById(R.id.memdisplay);
                Expression eval = new Expression(total);
                result = eval.eval();
                mem.setText("SQRT(" + total + ")");
                String sqrtAns = result + "";

                Double d = Double.parseDouble(sqrtAns);
                d = Math.sqrt(d);
                total = d + "";
                Log.d("For SQRT", total);
                Expression evalSqrt = new Expression(total);
                result = evalSqrt.eval();
                edit.setText(result + "");
                Log.d("For SQRT", result + "");
                int his;
                for(his=0;historyans[his]!=""&&his<=10;his++);
                if(his<=9){
                    historyans[his]=result+"";
                    historyexp[his]=total;
                }else
                {
                    historyexp[i]=total;
                    historyans[i]=result+"";
                    i++;
                    if(i==10)
                        i=0;
                }}catch (Exception e){
                    Toast.makeText(MainActivity.this,"Invalid Input",Toast.LENGTH_LONG).show();
                    total="";
                    edit.setText(total);
                    mem.setText("");
                }
            }
        });
    }
    public void onNumberClick(View v){

        Button button = (Button) v;
        String str = button.getText().toString();
        total = total + str;
        EditText edit = (EditText) findViewById(R.id.display);
        edit.setText(total);
    }



   /* public  void onOperatorClick(View v)
    {
        if(total=="")
        {
            Button button=(Button)v;
            String str=button.getText().toString();
            sign=str;
            EditText edit=(EditText)findViewById(R.id.display);
            edit.setText(""+sign);

        }
        else
        {
            try {
                Button button = (Button) v;
                String str = button.getText().toString();
                sign = str;
                v1 = Double.parseDouble(total);
                memtotal = total;
                EditText mem = (EditText)findViewById(R.id.memdisplay);
                total = "";

                EditText edit = (EditText) findViewById(R.id.display);
                edit.setText("" + sign);
                mem.setText(memtotal + sign);
            }
            catch (Exception e)
            {
                Toast.makeText(MainActivity.this,"Invalid input",Toast.LENGTH_LONG).show();
                total="0";
                memtotal="0";
                EditText mem=(EditText)findViewById(R.id.memdisplay);
                mem.setText(memtotal);
                EditText edit=(EditText)findViewById(R.id.display);
                edit.setText(total);
            }
        }


    }
   */ public void onEquals(View v)
    {
        try {

            Expression eval=new Expression(total);
            result=eval.eval();
            int his;
            for(his=0;historyans[his]!=""&&his<=10;his++);
            if(his<=9){
                historyans[his]=result+"";
                historyexp[his]=total;
            }else
            {
                historyexp[i]=total;
                historyans[i]=result+"";
                i++;
                if(i==10)
                    i=0;
            }
            for(int j=0;j<=9;j++){
                Log.d("OnEquals","History"+j+historyexp[j]+"="+historyans[j]);
            }

           /* String str2 = edit.getText().toString();
            grand_total=0;
            v2 = Double.parseDouble(str2);
            if (sign.equals("+")) {
                grand_total = v1 + v2;


            } else if (sign.equals("-")) {
                grand_total = v1 - v2;
                v1 = grand_total;

            } else if (sign.equals("*")) {
                grand_total = v1 * v2;
                v1 = grand_total;
            } else if (sign.equals("/")) {
                grand_total = v1 / v2;
                v1 = grand_total;
            }*/
            EditText edit = (EditText) findViewById(R.id.display);
            EditText mem = (EditText) findViewById(R.id.memdisplay);
/*
            Intent intent=new Intent(MainActivity.this,HistoryActivity.class);
*/
            edit.setText(result + "");
            mem.setText(total + "");
            /*intent.putExtra("MainActivity_Result", edit.getText().toString());
            intent.putExtra("MainActivity_total", total);
*/


            total=result+"";


        }
        catch(Exception e)
        {
            Toast.makeText(MainActivity.this,"Invalid input",Toast.LENGTH_LONG).show();
            total="0";
            memtotal="0";
            EditText mem=(EditText)findViewById(R.id.memdisplay);
            mem.setText(memtotal);
            EditText edit=(EditText)findViewById(R.id.display);
            edit.setText(total);

        }

    }

    public void onClear(View v){
        EditText edit=(EditText)findViewById(R.id.display);
        edit.setText("0");
        total="";
        memtotal="";
        EditText mem=(EditText)findViewById(R.id.memdisplay);
        mem.setText("0");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final EditText edit = (EditText) findViewById(R.id.display);
        final EditText mem = (EditText) findViewById(R.id.memdisplay);

        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 1:
                memtotal=historyexp[0];
                total=historyans[0];
                edit.setText(total);
                mem.setText(memtotal);
                break;
            case 2:
                memtotal=historyexp[1];
                total=historyans[1];
                edit.setText(total);
                mem.setText(memtotal);
                break;
            case 3:
                memtotal=historyexp[2];
                total=historyans[2];
                edit.setText(total);
                mem.setText(memtotal);
                break;
            case 4:
                memtotal=historyexp[3];
                total=historyans[3];
                edit.setText(total);
                mem.setText(memtotal);
                break;
            case 5:
                memtotal=historyexp[4];
                total=historyans[4];
                edit.setText(total);
                mem.setText(memtotal);
                break;
            case 6:
                memtotal=historyexp[5];
                total=historyans[5];
                edit.setText(total);
                mem.setText(memtotal);
                break;
            case 7:
                memtotal=historyexp[6];
                total=historyans[6];
                edit.setText(total);
                mem.setText(memtotal);
                break;
            case 8:
                memtotal=historyexp[7];
                total=historyans[7];
                edit.setText(total);
                mem.setText(memtotal);
                break;
            case 9:
                memtotal=historyexp[8];
                total=historyans[8];
                edit.setText(total);
                mem.setText(memtotal);
                break;
            case 10:
                memtotal=historyexp[9];
                total=historyans[9];
                edit.setText(total);
                mem.setText(memtotal);
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        for(int q=0;q<=9;q++){
            outState.putString(historyanss[q],historyans[q]);
            outState.putString(historyexpp[q],historyexp[q]);
            outState.putString("total",total);

        }
    }
}
