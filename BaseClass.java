package p2_Package;

public class BaseClass implements Comparable{

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
        digitArray = initializeDigits();
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
      overFlow = baseClassToCopy.overFlow;
      maxDigits = baseClassToCopy.maxDigits;
      numDigits = baseClassToCopy.numDigits;
      digitArray = initializeDigits();

      for( currentChar = 0; currentChar < numDigits; currentChar++ ) // copy other's array
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
    private static int MIN_BASE_VALUE = 2;

    /**
     * Current number of digits held for this value
     */
    protected int numDigits;

    /**
     * Flag set if register is overflowed by any operation
     */
    protected boolean overFlow;


    /**
     * Creates new digit array and zeroes out the array
     * @return new integer array created, and initialized with all zeroes
     */
    public char[] initializeDigits()
    {
       char[] returnArray = new char[ maxDigits ];
       return digitArray;
    }

    /**
     * Raises an integer to a power
     * @param intToRaise The integer to raise to power
     * @param power The power we are raising the integer to
     * @return intToRaise ^ power
     */
    private int intToPow( int intToRaise, int power )
    {
        if( power == 0 )
        {
            return 1;
        }
        return intToRaise * intToPow( intToRaise, power - 1 );
    }

    /**
     * Translates integer value to character
     * @param intToConvert The int to be converted to character value
     * @return The character value of the integer
     */
    private char intToDigit( int intToConvert )
    {
       return ( char ) ( intToConvert + '0' );
    }

    /**
     * Translates character digit to integer value
      * @param digit The digit to be converted
     * @return An integer of the character value
     */
    private int digitToInt( char digit )
    {
        return ( int ) ( digit - '0');
    }
    /**
     * Converts given positive decimal integer as string input to the
     * specified base as a character array within the object.
     * @param decValue
     * @return
     */
    private char[] decToBase( String decValue )
    {
        char[] returnArray = new char[ maxDigits ];
    }
    /**
     * Implements the compareTo required of the Comparable class
     * @param value BaseClass data to be compared with this
     * @return value specifying result: for this greater than value: +1, for equal: 0,
     *         for this less than value: -1
     */
    public int compareTo( BaseClass value )
    {

    }
}
