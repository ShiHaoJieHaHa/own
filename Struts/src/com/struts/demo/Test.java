package com.struts.demo;

public class Test {
    public static void main(String[] args) {
        for (int i=9;i>=1;i--){
            for (int j=1;j<=i;j++){
                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
            System.out.println();
        }
    }
}
