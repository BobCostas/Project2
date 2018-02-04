package p2_Package;

import java.util.Arrays;

public class GenericArithmeticClassMain {
    public static void main(String[] args)
    {
        BaseClass firstBase = new BaseClass( 3, 10, "200");
        BaseClass secondBase = new BaseClass( 3, 10, "400");
        BaseClass thirdBase = new BaseClass( 3, 10, "450");
        BaseClass fourthBase = new BaseClass( 3, 10, "550");

        GenericArithmeticClass<BaseClass> gac = new GenericArithmeticClass<>( 3 );
        gac.setValueAt( 0, firstBase );
        gac.setValueAt( 2, secondBase );

    }
}
