package com.example.helloword;

import android.util.Log;

import java.util.Stack;

public class toValue {
    public static Double toValue(StringBuffer postfix) {
        Stack<Double> num_stack = new Stack<Double>();
        double value=0;
        int flag=0;
        double poin = 1;
        for (int i=0; i<postfix.length(); i++)
        {
            char ch = postfix.charAt(i);
            if(ch>='0'&&ch<='9'||ch=='.'){
                value  =0;
                while(ch!=' ') {
                    if(ch=='.'){
                        flag=1;
                        ch=postfix.charAt(++i);
                    }
                    if (flag==0) {
                        value = value * 10 + ch - '0';
                        ch = postfix.charAt(++i);
                    }
                    else if(flag==1){
                        poin=poin*0.1;
                        value=value+(ch-'0')*poin;
                        ch = postfix.charAt(++i);
                    }
                }
                flag=0;
                poin=1;
                num_stack.push(value);
            }
            else
            if(ch!=' '){
                double y= num_stack.pop(), x = num_stack.pop();
                Log.d("x", Double.toString(x));
                Log.d("y", Double.toString(y));
                switch (ch){
                    case '+': value=x+y; break;
                    case '-': value=x-y; break;
                    case '*': value=x*y; break;
                    case '/': value=x/y; break;
                }
                num_stack.push(value);
                Log.d("value2",Double.toString(value));
            }
        }
        return num_stack.pop();
    }
}
