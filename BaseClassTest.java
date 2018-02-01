package p2_Package;

import java.util.Arrays;

public class BaseClassTest {
    public static void main(String[] args)
    {
        BaseClass baseClass = new BaseClass( 2, 10, "100");
        System.out.println(Arrays.toString(baseClass.decToBase("100")));
    }
}
