package p2_Package;


public class BaseClassTest {
    public static void main(String[] args)
    {
        BaseClass baseClass = new BaseClass( 16, 16, "17532");
        BaseClass baseClass2 = new BaseClass(16, 16, "4810");
        BaseClass baseClass3 = new BaseClass(16, 16, "5810");
        BaseClass baseClass4 = new BaseClass(16, 16, "4510");
        BaseClass baseClass5 = new BaseClass(16, 16, "810");

        GenericArithmeticClass<BaseClass> ac = new GenericArithmeticClass<>( 5 );
        ac.setValueAt(0, baseClass);
        ac.setValueAt(1, baseClass2);
        ac.setValueAt(2, baseClass3);
        ac.setValueAt(3, baseClass4);
        ac.setValueAt(4, baseClass5);

        ac.runInsertionSort(ac.getCurrentCappacity());
        for(int i = 0; i < ac.getCurrentCappacity(); i++)
        {
            System.out.println(ac.getValueAt(i).toString());
        }

    }
}
