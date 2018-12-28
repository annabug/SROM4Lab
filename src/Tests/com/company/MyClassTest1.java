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
public class MyClassTest1 {

    private String valueA;
    private String valueB;
    private String valueC;

    public MyClassTest1(String valueA,String valueB,String valueC){
        this.valueA=valueA;
        this.valueB=valueB;
        this.valueC=valueC;
    }
    @Parameterized.Parameters(name = "{index}: Distributivus ({0}+{1})*{2} =   {0}*{2} + {1}*{2}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {"FFF","0","FFFFFF"},
                {"0","1","1"},
                {"1","0","1"},
                {"F", "FFFF", "FFFFFFFFF"},
                {"24124124214","1","8E06E4DFFB37B6"},
                {"3786D3A85E62EC763A05A73A7F08D21EEE3CBCAE207E40854121BFF8258F7B2B293B0D30277CD"
                        ,"424E606126A31B875E3D5E9E9C2E13D6995CC801E60C30247808A6EE01E78895E16EAD95"
                        ,"792081E54F2BBE1CF7A2643ECFE5EE604240778AFFE5B49A1C46B4712562"
                },
                {"B42C28861FB57657E27A1D41D3E61730FAB712FB0E55728443D1A18C27DE41"
                        ,"5DAC08ABDA44199E807A4938658C6EC7CA27C558C226EE5E24E3CA8DA66A74E71"
                        , "111D3A9A9AD293D3770C9F1D7D3B54D2807A7BF2CF2CB2"
                },
                {"BED6162E30FD36D3B6F960A67E1129706EC5A0EF57DD3E45"
                        ,"8FCAA5A2D5E40D532389BC06A797E51A224CA67B43D9FFD3BC6B64FA7BA85804237852F410B5F276C4"
                        ,"13F81407BF29A37A23E1F1B2B0F2BD0A90225E5B2226692D93E71895000DCFB509"
                },
                {"B42C28861FB57657E2FAB712FB0E55728443D1A18C27DE41"
                        ,"5DA44199E807A4938658C6EC7CA27C558C226EE5E24E3CA8DA66A74E71"
                        , "1D3A9A9AD293D3770C9F1D7D3B54D2807A7BF2CF2CB2"
                },
                {"B42C28861FB57657E27A1D41D3E61730FAB712FD1A18C27DE41"
                        ,"5DAC08ABDA44199E807A497CA27C558C226EE5E24E3CA8DA66A74E71"
                        , "111D3A9A9AD293DF1D7D3B54D2807A7BF2CF2CB2"
                },
                {"B42C28861FB57657E27A1D41D3E61730FB0E55728443D1A18C27DE41"
                        ,"5DAC08ABDA44199E8058C6EC7CA27C558C226EE5E24E3CA8DA66A74E71"
                        , "111D3A9A9AD293D333370C9F1D7D3B54D2807A7BF2CF2CB2"
                }
        });
    }

    @Test
    public void main(){
        MyClass obj = new MyClass();
        obj.setExtension(191);
        obj.setGenerator();
        boolean[] a = obj.getBooleanArray(this.valueA);
        boolean[] b = obj.getBooleanArray(this.valueB);
        boolean[] c = obj.getBooleanArray(this.valueC);
        boolean[] res_1 = obj.mulGalois(obj.addGalois(a,b),c);
        boolean[] res_2 = obj.addGalois(obj.mulGalois(a,c),obj.mulGalois(b,c));
        assertArrayEquals(res_1,res_2);
    }
}