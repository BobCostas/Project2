package p2_Package;

public class BaseClass {

    /**
     * Default constructor for BaseClass
     * @param baseSet The base of this class
     * @param maxDigitSet The maximum amount of digits allowed
     * @param decValSet The decimal value to be converted to base
     */
    public BaseClass( int baseSet, int maxDigitSet, String decValSet )
    {
        base = baseSet;
        maxDigits = maxDigitSet;
        digitArray = new char[ maxDigits ];
        initializeDigits();
        numDigits = 0;
    }

    /**
     * Copy constructor for BaseClass
     * @param baseClassToCopy The BaseClass object to be compied to this object
     */
    public BaseClass( BaseClass baseClassToCopy )
    {
      int currentChar = 0;

      base = baseClassToCopy.base;
      maxDigits = baseClassToCopy.maxDigits;
      numDigits = baseClassToCopy.numDigits;
      digitArray = new char[ maxDigits ];
      initializeDigits();

      for( currentChar = 0; currentChar < numDigits; currentChar++) // copy other's array
      {
         digitArray[ currentChar ] = digitArray[ currentChar ];
      }
    }

    /**
     * holds base of given value
     */
    protected int base;

    /**
     * base 10 constant used in code
     */
    private static int BASE_10 = 10;

    /**
     * Array for holding digits in the given number
      */
    protected char[] digitArray;

    /**
     * Higest base value that can be used
     */
    private static int MAX_BASE_VALUE = 16;

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
