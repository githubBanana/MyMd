package com.xs.mymd;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-05-20 11:18
 * @email Xs.lin@foxmail.com
 */
public class MyModel {

    private String a ;
    private String b;

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }


    @Override
    public String toString() {
        return "MyModel{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
