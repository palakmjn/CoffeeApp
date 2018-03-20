package com.example.android.coffeeapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.name;
import static android.R.id.text1;

public class MainActivity extends AppCompatActivity {
int q=3;

    String name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View view){
        q++;
        display(q);
    }
    public void decrement(View view){
        q--;
        display(q);
    }
    public int getPrice(int q1,int pr1){
        CheckBox c1=(CheckBox)findViewById(R.id.check1);
        boolean ch1=c1.isChecked();
        CheckBox c2=(CheckBox)findViewById(R.id.check2);
        boolean ch2=c2.isChecked();
        if(ch1){pr1+=5;}
        if(ch2){pr1+=7;}
        return (pr1*q1);
    }
    public void SubmitOrder(View view){
        EditText text=(EditText) findViewById(R.id.edit_text);
        String value=text.getText().toString();
        int p=5;
        int p1=getPrice(q,p);
        name+="NAME: "+value+"\nQUANTITY: "+q+"\nPRICE: "+p1;
        name+="\nTHANK YOU!!.A mail regarding your order summary will be send.";
        Intent intent=new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_TEXT,name);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }

        displaym(name);
    }
    private void display(int n){
        TextView text=(TextView)findViewById(R.id.quant);
        text.setText(""+n);
    }
    private void displaym(String t1){
        TextView text=(TextView)findViewById(R.id.price);
        text.setText(t1);
    }
}
