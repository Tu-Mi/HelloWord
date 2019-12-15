package com.example.helloword;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class SystemActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et;
    TextView con_tv;
    Button but_con;
    Button but_con_cal;
    Button but_con_sys;
    Button but_con_unit;
    Button but_con_rate;
    Button but_help;
    Spinner spinner1 ;
    Spinner spinner2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);

        initial();
        ActionBar actionbar =getSupportActionBar();
        if (actionbar !=null){
            actionbar.hide();
        }

    }
    private void initial(){

        et = findViewById(R.id.e1);
        con_tv = findViewById(R.id.t1);

        spinner1 = findViewById(R.id.s1);
        spinner2 = findViewById(R.id.s2);

        but_con = findViewById(R.id.convert);
        but_con_cal = findViewById(R.id.but_cal);
        but_con_rate = findViewById(R.id.but_rate);
        but_con_unit = findViewById(R.id.but_unit);
        but_con_sys = findViewById(R.id.but_sys);
        but_help = findViewById(R.id.help);

        but_con_cal.setOnClickListener(this);
        but_con_rate.setOnClickListener(this);
        but_con_sys.setOnClickListener(this);
        but_con_unit.setOnClickListener(this);
        but_con.setOnClickListener(this);
        but_help.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
    switch (view.getId()){
        case R.id.but_rate:
            Log.d("rate", "onClick: ");
            Intent intent0=new Intent(SystemActivity.this, RateActivity.class);
            startActivity(intent0);
            break;
        case R.id.but_cal:
            Log.d("rate", "onClick: ");
            Intent intent1=new Intent(SystemActivity.this, MainActivity.class);
            startActivity(intent1);
            break;
        case R.id.but_sys:
            Log.d("sys", "onClick: ");
            Toast.makeText(SystemActivity.this,"已在当前页面",Toast.LENGTH_SHORT).show();
            break;
        case R.id.but_unit:
            Log.d("unit", "onClick: ");
            Intent intent3=new Intent(SystemActivity.this, UnitActivity.class);
            startActivity(intent3);
            break;
        case R.id.help:
            AlertDialog.Builder dialog = new AlertDialog.Builder(SystemActivity.this);
            dialog.setTitle("This is help");
            dialog.setMessage("this is help page");
            dialog.setCancelable(false);
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.setNegativeButton("Cancl", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();
            break;

        case R.id.convert:
        {
            if (spinner1.getSelectedItem().toString().equals("十进制")
            ) {
                if(spinner2.getSelectedItem().toString().equals("十六进制")) {

                    int i = Integer.valueOf(et.getText().toString()).intValue();
                    BigDecimal bg = new BigDecimal(i + "");
                    con_tv.setText(String.valueOf(Integer.toHexString(i)));
                }else  if(spinner2.getSelectedItem().toString().equals("二进制")) {

                    int i = Integer.valueOf(et.getText().toString()).intValue();
                    BigDecimal bg = new BigDecimal(i + "");
                    con_tv.setText(String.valueOf(Integer.toBinaryString(i)));
                }else  if(spinner2.getSelectedItem().toString().equals("八进制")) {

                    int i = Integer.valueOf(et.getText().toString()).intValue();
                    BigDecimal bg = new BigDecimal(i + "");
                    con_tv.setText(String.valueOf(Integer.toOctalString(i)));
                }else {
                    int i = Integer.valueOf(et.getText().toString()).intValue();
                    BigDecimal bg = new BigDecimal(i + "");
                    con_tv.setText(String.valueOf(i));
                }
            }else if (spinner1.getSelectedItem().toString().equals("十六进制")
            ) {
                if(spinner2.getSelectedItem().toString().equals("十进制")) {
                    con_tv.setText(String.valueOf(Integer.valueOf(et.getText().toString(),16).toString()));
                }else  if(spinner2.getSelectedItem().toString().equals("二进制")) {

                    int i = Integer.valueOf(String.valueOf(Integer.valueOf(et.getText().toString(),16).toString())).intValue();
                    BigDecimal bg = new BigDecimal(i + "");
                    con_tv.setText(String.valueOf(Integer.toBinaryString(i)));
                }else  if(spinner2.getSelectedItem().toString().equals("八进制")) {

                    int i = Integer.valueOf(String.valueOf(Integer.valueOf(et.getText().toString(),16).toString())).intValue();
                    BigDecimal bg = new BigDecimal(i + "");
                    con_tv.setText(String.valueOf(Integer.toOctalString(i)));
                }else {
                    int i = Integer.valueOf(et.getText().toString()).intValue();
                    BigDecimal bg = new BigDecimal(i + "");
                    con_tv.setText(String.valueOf(i));
                }
            }else if (spinner1.getSelectedItem().toString().equals("八进制")
            ) {
                if(spinner2.getSelectedItem().toString().equals("十进制")) {
                    con_tv.setText(String.valueOf(Integer.valueOf(et.getText().toString(),8).toString()));
                }else  if(spinner2.getSelectedItem().toString().equals("二进制")) {

                    int i = Integer.valueOf(String.valueOf(Integer.valueOf(et.getText().toString(),8).toString())).intValue();
                    BigDecimal bg = new BigDecimal(i + "");
                    con_tv.setText(String.valueOf(Integer.toBinaryString(i)));
                }else  if(spinner2.getSelectedItem().toString().equals("十六进制")) {

                    int i = Integer.valueOf(String.valueOf(Integer.valueOf(et.getText().toString(),8).toString())).intValue();
                    BigDecimal bg = new BigDecimal(i + "");
                    con_tv.setText(String.valueOf(Integer.toHexString(i)));
                }
                else {
                    int i = Integer.valueOf(et.getText().toString()).intValue();
                    BigDecimal bg = new BigDecimal(i + "");
                    con_tv.setText(String.valueOf(i));
                }
            }else if (spinner1.getSelectedItem().toString().equals("二进制")
            ) {
                if(spinner2.getSelectedItem().toString().equals("十进制")) {
                    con_tv.setText(Integer.valueOf(et.getText().toString(),2).toString());
                }else  if(spinner2.getSelectedItem().toString().equals("十六进制")) {

                    int i = Integer.valueOf(String.valueOf(Integer.valueOf(et.getText().toString(),2).toString())).intValue();
                    BigDecimal bg = new BigDecimal(i + "");
                    con_tv.setText((Integer.toHexString(i)));
                }else  if(spinner2.getSelectedItem().toString().equals("八进制")) {

                    int i = Integer.valueOf((Integer.valueOf(et.getText().toString(),2).toString())).intValue();
                    BigDecimal bg = new BigDecimal(i + "");
                    con_tv.setText(String.valueOf(Integer.toOctalString(i)));
                }else {
                    int i = Integer.valueOf(et.getText().toString()).intValue();
                    BigDecimal bg = new BigDecimal(i + "");
                    con_tv.setText(String.valueOf(i));
                }
            }

        }
    }

    }
}
