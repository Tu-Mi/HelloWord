package com.example.helloword;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv  ;
    TextView resTv;
//    数字按钮0-10  内容 0-9 、e
    Button [] button_num =new Button [11] ;

//    符号按钮0-7 +、-、*、/、=、(、)、小数点、
    Button [] button_sym = new Button[8];

//    三角函数按钮0-2 sin、cos、tan
    Button [] button_fun = new Button[3];

//    其他按钮0-3 开方 rad √、阶乘fac !、清除ace、删除del、
    Button [] button_oth = new Button[4];

//    菜单按钮menu0-2 计算、汇率、进制转换、单位换算
    Button [] button_menu = new Button[4];

    String str1="";
    String str2 ="";
    StringBuffer strBu ;
    double result =0;
    //初始化
    private void initial(){
        tv = findViewById(R.id.but_text);
        resTv = findViewById(R.id.but_result);
        button_num[0] = findViewById(R.id.but_0);
        button_num[1] = findViewById(R.id.but_1);
        button_num[2] = findViewById(R.id.but_2);
        button_num[3] = findViewById(R.id.but_3);
        button_num[4] = findViewById(R.id.but_4);
        button_num[5] = findViewById(R.id.but_5);
        button_num[6] = findViewById(R.id.but_6);
        button_num[7] = findViewById(R.id.but_7);
        button_num[8] = findViewById(R.id.but_8);
        button_num[9] = findViewById(R.id.but_9);
        button_num[10] =findViewById(R.id.but_e);

        button_sym[0] = findViewById(R.id.but_add);
        button_sym[1] = findViewById(R.id.but_sub);
        button_sym[2] = findViewById(R.id.but_mul);
        button_sym[3] = findViewById(R.id.but_div);
        button_sym[4] = findViewById(R.id.but_equ);
        button_sym[5] = findViewById(R.id.but_left);
        button_sym[6] = findViewById(R.id.but_right);
        button_sym[7] = findViewById(R.id.but_poi);

        button_fun[0] = findViewById(R.id.but_sin);
        button_fun[1] = findViewById(R.id.but_cos);
        button_fun[2] = findViewById(R.id.but_tan);

        button_oth[0] = findViewById(R.id.but_rad);
        button_oth[1] = findViewById(R.id.but_fac);
        button_oth[2] = findViewById(R.id.but_ace);
        button_oth[3] = findViewById(R.id.but_del);

        button_menu[0] = findViewById(R.id.but_cal);
        button_menu[1] = findViewById(R.id.but_sys);
        button_menu[2] = findViewById(R.id.but_rate);
        button_menu[3] = findViewById(R.id.but_unit);

//设置监听器
        for (Button num:button_num){
            num.setOnClickListener(this);
        }

        for (Button sym:button_sym){
            sym.setOnClickListener(this);
        }

        for (Button oth:button_oth){
            oth.setOnClickListener(this);
        }

        for (Button fun:button_fun){
            fun.setOnClickListener(this);
        }

        for (Button menu:button_menu){
            menu.setOnClickListener(this);
        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.but_0:
            case R.id.but_1:
            case R.id.but_2:
            case R.id.but_3:
            case R.id.but_4:
            case R.id.but_5:
            case R.id.but_6:
            case R.id.but_7:
            case R.id.but_8:
            case R.id.but_9:
            case R.id.but_poi:
            case R.id.but_add:
            case R.id.but_sub:
            case R.id.but_mul:
            case R.id.but_div:
            case R.id.but_left:
            case R.id.but_right:
                str1 += ((Button) view).getText().toString();
                tv.setText(str1);
            break;
            case R.id.but_ace:
                str1="";
                tv.setText(str1);
                resTv.setText("");
            break;
            case R.id.but_del:
                str1=str1.substring(0,str1.length()-1);
                tv.setText(str1);
            break;
            case R.id.but_e:
                str1=str1+"2.71828";
                tv.setText(str1);
            break;
            case R.id.but_equ:
              strBu= toPostfix.toPostfix(str1);
              result=toValue.toValue(strBu);
              resTv.setText("="+Double.toString(result));
            break;
            case R.id.but_sin:
                double sin=Double.valueOf(str1);
                double retsin = Math.sin(Math.toRadians(sin));
                tv.setText("sin"+str1);
                resTv.setText("="+Double.toString(retsin));
                break;
            case R.id.but_cos:
                double cos=Double.valueOf(str1);
                double retcos = Math.cos(Math.toRadians(cos));
                tv.setText("cos"+str1);
                resTv.setText("="+retcos);
                break;
            case R.id.but_tan:
                double tan=Double.valueOf(str1);
                double rettan = Math.tan(Math.toRadians(tan));
                tv.setText("tan"+str1);
                resTv.setText("="+Double.toString(rettan));
                break;
            case R.id.but_rad:
                double resrad =Math.sqrt(Double.valueOf(str1));
                tv.setText("√"+str1);
                resTv.setText("="+resrad);
                break;
            case R.id.but_fac:
                Log.d("执行fac","fac");
                double resfac =fac.toFac(Double.valueOf(str1));
                tv.setText(str1+"!");
                resTv.setText("="+resfac);
                break;
            case R.id.but_cal:
                Toast.makeText(MainActivity.this,"已在当前页面",Toast.LENGTH_SHORT).show();
                break;
            case R.id.but_rate:
                Log.d("rate", "onClick: ");
                Intent intent1=new Intent(MainActivity.this, RateActivity.class);
                startActivity(intent1);
                break;
            case R.id.but_sys:
                Log.d("sys", "onClick: ");
                Intent intent2=new Intent(MainActivity.this, SystemActivity.class);
                startActivity(intent2);
                break;
            case R.id.but_unit:
                Log.d("unit", "onClick: ");
                Intent intent3=new Intent(MainActivity.this, UnitActivity.class);
                startActivity(intent3);
                break;
            default:
                 str1="";
                 tv.setText("default");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
        ActionBar actionbar =getSupportActionBar();
        if (actionbar !=null){
            actionbar.hide();
        }
    }




}
