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
import android.widget.Toast;

public class UnitActivity extends AppCompatActivity implements View.OnClickListener {

    Button but_len ;
    Button but_wei ;
    Button but_v ;
    Button but_area ;
    Button but_cal;
    Button but_rata;
    Button but_sys;
    Button but_unit;
    Button but_help;
    public void initial(){
         but_len = findViewById(R.id.length);
         but_wei = findViewById(R.id.weight);
         but_v = findViewById(R.id.v);
         but_area = findViewById(R.id.area);

         but_cal = findViewById(R.id.but_cal);
         but_rata = findViewById(R.id.but_rate);
         but_sys = findViewById(R.id.but_sys);
         but_unit = findViewById(R.id.but_unit);
         but_help = findViewById(R.id.help);

         but_len.setOnClickListener(this);
         but_wei.setOnClickListener(this);
         but_v.setOnClickListener(this);
         but_area.setOnClickListener(this);

         but_cal.setOnClickListener(this);
         but_rata.setOnClickListener(this);
         but_sys.setOnClickListener(this);
         but_unit.setOnClickListener(this);
         but_help.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        initial();
        ActionBar actionbar =getSupportActionBar();
        if (actionbar !=null){
            actionbar.hide();
        }
    }

    @Override
    public void onClick(View view){
    switch (view.getId()){
        case R.id.length:
            Log.d("rate", "onClick: ");
            Intent intent1=new Intent(UnitActivity.this, LengthActivity.class);
            startActivity(intent1);
            break;
        case R.id.weight:
            Log.d("sys", "onClick: ");
            Intent intent2=new Intent(UnitActivity.this, WeightActivity.class);
            startActivity(intent2);
            break;
        case R.id.area:
            Log.d("unit", "onClick: ");
            Intent intent3=new Intent(UnitActivity.this, AreaActivity.class);
            startActivity(intent3);
            break;
        case R.id.v:
            Log.d("unit", "onClick: ");
            Intent intent4=new Intent(UnitActivity.this, VActivity.class);
            startActivity(intent4);
            break;
        case R.id.but_cal:
            Log.d("rate", "onClick: ");
            Intent intent_cal=new Intent(UnitActivity.this, MainActivity.class);
            startActivity(intent_cal);
            break;
        case R.id.but_rate:
            Log.d("rate", "onClick: ");
            Intent intent_rate=new Intent(UnitActivity.this, RateActivity.class);
            startActivity(intent_rate);
            break;
        case R.id.but_sys:
            Log.d("sys", "onClick: ");
            Intent intent_sys=new Intent(UnitActivity.this, SystemActivity.class);
            startActivity(intent_sys);
            break;
        case R.id.but_unit:
            Log.d("unit", "onClick: ");
            Toast.makeText(UnitActivity.this,"已在当前页面",Toast.LENGTH_SHORT).show();
            break;
        case R.id.help:
            AlertDialog.Builder dialog = new AlertDialog.Builder(UnitActivity.this);
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
    }
    }
}
