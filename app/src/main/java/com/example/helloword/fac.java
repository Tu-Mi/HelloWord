package com.example.helloword;

public class fac {
    public static double toFac(double num){
        double result=1;
        if(num==0){
            result=1;
        }else
        for(int i=1;i<=num;i++){
            result *=i;
        }
        return result;
    }
}
