package p2_Package;


public class BaseClassTest {
    public static void main(String[] args)
    {
        BaseClass baseClass = new BaseClass( 16, 16, "17532");
        BaseClass baseClass2 = new BaseClass(16, 16, "45810");
        System.out.println(baseClass.subtractRegisters(baseClass, baseClass2));

    }
}
