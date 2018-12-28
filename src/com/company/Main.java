package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.setExtension(191);
        boolean[] a = new boolean[191];
        for(int i = 0; i < 191; i++){
            a[i] = true;
        }
        boolean[] arr = obj.getInverse(a);
        System.out.println(Arrays.toString(obj.mulGalois(arr,a)));


    }
}
