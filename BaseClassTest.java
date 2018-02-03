package p2_Package;


public class BaseClassTest {
    public static void main(String[] args)
    {
        BaseClass baseClass = new BaseClass( 6, 10, "100");
        BaseClass baseClass2 = new BaseClass( baseClass );
        System.out.println(baseClass.toString());
        System.out.println(baseClass.getValueAsDecimal());
        System.out.println(baseClass.getValueAsBase());
        System.out.println(baseClass2.getValueAsDecimal());
        System.out.println(baseClass2.getValueAsBase());
    }
}
