package p2_Package;

public class BaseClass {
    public BaseClass( )
    {

    }

    public BaseClass( BaseClass baseClassToCopy )
    {

    }

    /**
     * holds base of given value
     */
    protected int base;

    /**
     * base 10 constant used in code
     */
    private static int BASE_10;

    /**
     * Array for holding digits in the given number
      */
    protected char[] digitArray;

    /**
     * Higest base value that can be used
     */
    private static int MAX_BASE_VALUE;

    /**
     * Maximum digits that can be stored in digitArray
     */
    protected int maxDigits;

    /**
     * Lowest base value that can be used
     */
    private static int MIN_BASE_VALUE;

    /**
     * Current number of digits held for this value
     */
    protected int numDigits;

    /**
     * Flag set if register is overflowed by any operation
     */
    protected boolean overFlow;
}
