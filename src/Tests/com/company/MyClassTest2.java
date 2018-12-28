package com.company;

import com.company.MyClass;
import com.sun.jdi.Value;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class MyClassTest2 {

    private String valueA;

    public MyClassTest2(String valueA){
        this.valueA=valueA;
    }
    @Parameterized.Parameters(name = "{index}: {1} ^(p-1) = 1 mod p ")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {"1"},
                {"11111111"},
        });
    }

    private boolean Correctness(boolean[] arr){
        int len = arr.length;
        if(!arr[0]){ return false; }
        for(int i = 1; i < len; i++){
            if(arr[i]){return !arr[i];}
        }
        return true;
    }

    @Test
    public void main(){
        MyClass obj = new MyClass();
        String power_str = "111";
        boolean[] power = obj.getBooleanArray(power_str);
        obj.setExtension(3);
        obj.setGenerator();
        boolean[] a = obj.getBooleanArray(this.valueA);
        boolean[] res = obj.getPower(a,power_str);
        System.out.println(Arrays.toString(res));
        assertEquals(Correctness(res),true);
    }
}