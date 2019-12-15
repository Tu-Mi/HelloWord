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

public class RateActivity extends AppCompatActivity implements View.OnClickListener{

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
        setContentView(R.layout.activity_rate);

        initial();
        ActionBar actionbar =getSupportActionBar();
        if (actionbar !=null){
            actionbar.hide();
        }

    }
    private void initial(){
        et=findViewById(R.id.e1);
        con_tv =findViewById(R.id.t1);

        spinner1=findViewById(R.id.s1);
        spinner2 = findViewById(R.id.s2);

        but_con = findViewById(R.id.convert);
        but_con_cal =findViewById(R.id.but_cal);
        but_con_sys = findViewById(R.id.but_sys);
        but_con_rate = findViewById(R.id.but_rate);
        but_con_unit =findViewById(R.id.but_unit);
        but_help = findViewById(R.id.help);

        but_con_cal.setOnClickListener(this);
        but_con_rate.setOnClickListener(this);
        but_con_sys.setOnClickListener(this);
        but_con_unit.setOnClickListener(this);
        but_con.setOnClickListener(this);
        but_help.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.but_rate:
                Log.d("rate", "onClick: ");
                Toast.makeText(RateActivity.this,"已在当前页面",Toast.LENGTH_SHORT).show();
                break;
            case R.id.but_cal:
                Log.d("rate", "onClick: ");
                Intent intent1=new Intent(RateActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.but_sys:
                Log.d("sys", "onClick: ");
                Intent intent2=new Intent(RateActivity.this, SystemActivity.class);
                startActivity(intent2);
                break;
            case R.id.but_unit:
                Log.d("unit", "onClick: ");
                Intent intent3=new Intent(RateActivity.this, UnitActivity.class);
                startActivity(intent3);
                break;
            case R.id.help:
                AlertDialog.Builder dialog = new AlertDialog.Builder(RateActivity.this);
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
                if (spinner1.getSelectedItem().toString().equals("美元")
                ) {
                    if(spinner2.getSelectedItem().toString().equals("人民币")) {

                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i * 7.09 + "");
                        con_tv.setText(String.valueOf(bg));
                    }else  if(spinner2.getSelectedItem().toString().equals("日元")) {

                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i * 107.55 + "");
                        con_tv.setText(String.valueOf(bg));
                    }else  if(spinner2.getSelectedItem().toString().equals("欧元")) {

                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i* 0.907 + "");
                        con_tv.setText(String.valueOf(bg));
                    }
                    else{
                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i + "");
                        con_tv.setText(String.valueOf(bg));
                    }
                }else  if (spinner1.getSelectedItem().toString().equals("人民币")
                ) {
                    if(spinner2.getSelectedItem().toString().equals("美元")) {

                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i * 0.141 + "");
                        con_tv.setText(String.valueOf(bg));
                    }else  if(spinner2.getSelectedItem().toString().equals("日元")) {

                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i * 15.16+ "");
                        con_tv.setText(String.valueOf(bg));
                    }else  if(spinner2.getSelectedItem().toString().equals("欧元")) {

                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i * 0.128 + "");
                        con_tv.setText(String.valueOf(bg));
                    }
                    else{
                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i + "");
                        con_tv.setText(String.valueOf(bg));
                    }
                }else  if (spinner1.getSelectedItem().toString().equals("欧元")
                ) {
                    if(spinner2.getSelectedItem().toString().equals("美元")) {

                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i * 1.1017 + "");
                        con_tv.setText(String.valueOf(bg));
                    }else  if(spinner2.getSelectedItem().toString().equals("日元")) {

                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i * 118.4878 + "");
                        con_tv.setText(String.valueOf(bg));
                    }else  if(spinner2.getSelectedItem().toString().equals("人民币")) {

                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i *7.812 + "");
                        con_tv.setText(String.valueOf(bg));
                    }
                    else{
                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i + "");
                        con_tv.setText(String.valueOf(bg));
                    }
                }else  if (spinner1.getSelectedItem().toString().equals("日元")
                ) {
                    if(spinner2.getSelectedItem().toString().equals("美元")) {

                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i * 0.009298 + "");
                        con_tv.setText(String.valueOf(bg));
                    }else  if(spinner2.getSelectedItem().toString().equals("人民币")) {

                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i * 0.06593 + "");
                        con_tv.setText(String.valueOf(bg));
                    }else  if(spinner2.getSelectedItem().toString().equals("欧元")) {

                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i * 0.00844 + "");
                        con_tv.setText(String.valueOf(bg));
                    }
                    else{
                        double i = Double.valueOf(et.getText().toString()).doubleValue();
                        BigDecimal bg = new BigDecimal(i + "");
                        con_tv.setText(String.valueOf(bg));
                    }
                }

            }
        }
    }
}
