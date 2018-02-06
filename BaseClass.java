package p2_Package;

import java.util.Arrays;

public class BaseClass implements Comparable<BaseClass> {

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
        digitArray = decToBase( decValSet );
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

      digitArray = copyArray( baseClassToCopy.digitArray );
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
       int currentChar = 0;

       for( currentChar = 0; currentChar < maxDigits; currentChar++ )
       {
           returnArray[ currentChar ] = '0';
       }
       return returnArray;
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
        if( 0 <= intToConvert && intToConvert <= 9)
        {
            return ( char ) ( intToConvert + '0');
        }
        return ( char ) ( intToConvert - 10 + 'A' );
    }

    /**
     * Translates character digit to integer value
      * @param digit The digit to be converted
     * @return An integer of the character value
     */
    private int digitToInt( char digit )
    {
        if( '0' <= digit && digit <= '9' )
        {
            return ( int ) ( digit - '0');
        }
        return ( int ) ( 10 + digit - 'A' );
    }

    /**
     * Checks to see if the number stored in this object is zero
     * @return True if the number is equal to zero
     */
    public boolean isZero()
    {
        return ( digitArray[0] == 0 && numDigits <= 1 );
    }
    /**
     * Converts a string of numbers and letters into its equivalent int.
     * @param stringToConvert The string to be converted to an integer
     * @return The Integer value of the string
     */
    private int convertStringToInt( String stringToConvert )
    {
        int currentDigit = 0;
        char currentChar;
        int total = 0;
        int intAtPlace = 0;
        int stringLength = stringToConvert.length();

        for( currentDigit = 0; currentDigit < stringLength; currentDigit++ )
        {
          currentChar = stringToConvert.charAt( currentDigit );
          intAtPlace = intToPow( BASE_10, ( stringLength - 1 - currentDigit ) ) ;
          total += ( intAtPlace * digitToInt( currentChar ) ) ;
        }

        return total;
    }

    /**
     * Converts given positive decimal integer as string input to the
     * specified base as a character array within the object.
     * @param decValue
     * @return Char array containing the converted value
     */
    private char[] decToBase( String decValue )
    {
        char[] returnArray = initializeDigits();
        int currentDigit = 0;
        int decValueToConvert = convertStringToInt( decValue );
        int digitCounter = 0;

        if( ( base < MIN_BASE_VALUE ) || ( base > MAX_BASE_VALUE ) )
        {
            return null;
        }

        for( digitCounter = 0; digitCounter < maxDigits; digitCounter++ )
        {
            if( decValueToConvert == 0) // we don't want to divide by zero
            {
                numDigits = digitCounter;
                return returnArray;
            }

            currentDigit = decValueToConvert % base;
            decValueToConvert /= base;

            returnArray[ digitCounter ] = intToDigit( currentDigit );

        }

        if( decValueToConvert > 0 )
        {
            overFlow = true;
            return null;
        }

        numDigits = currentDigit;
        return returnArray;
    }

    /**
     * Converts number in base to decimal number.
     * @return A decimal number as specified.
     */
    private int baseToDec( char[] baseNumToConvert )
    {
       int convertedDecNumber = 0;
       int currentDigit = 0;
       int currentInt = 0;

       for( currentDigit = 0; currentDigit < numDigits; currentDigit++ )
       {
           currentInt = digitToInt( baseNumToConvert[ currentDigit ]); // convert the char to an int
           convertedDecNumber += currentInt * intToPow( base, currentDigit );
       }
       return convertedDecNumber;
    }

    /**
     * Reverses array of char type
     * @param array The array that is going to be reversed
     * @return A new array with the elements reversed
     */
    private char[] reverseCharArray(  char[] array )
    {
        int index = 0;
        char[] returnArray = initializeDigits();
        for( index = 0; index < numDigits; index++ )
        {
           returnArray[ maxDigits - 1 - index ] = array[ index ]; // reverse the array
        }

        return returnArray;
    }

    /**
     * Copies a character array
     * @param array The array to be copied
     * @return A new array, with the same elements as array
     */
    private char[] copyArray( char[] array )
    {
        char[] returnArray = initializeDigits();
        int index = 0;
        for( index = 0; index < array.length; index++ )
        {
            returnArray[ index ] = array[ index ];
        }
        return returnArray;
    }

    /**
     * Turns a character array into a string, removes leading zeroes.
     * @param arrayToConvert
     * @return
     */
    private String charArrayToString(char[] arrayToConvert )
    {
       String convertedString = "";
       int index = 0;
       for( index = ( maxDigits - numDigits ); index < maxDigits; index++) // cut off leading zeroes
       {
          convertedString += arrayToConvert[ index ];
       }

       return convertedString;
    }
    /**
     * Overrides toString method and provides output as both the base and
     * a decimal value.
     * <p>
     * Note: Output must be in the form (base number) decimal number
     * <p>
     * Example "(4E56) 20054"
     * @returns String result as specified
     */
    public String toString()
    {
      String returnString = "";
      char[] digitArrayCopy = copyArray( digitArray );
      char[] reversedArray = reverseCharArray( digitArrayCopy );

      String digitArrayString = charArrayToString( reversedArray );
      returnString = "(" + digitArrayString + ") " + baseToDec( digitArrayCopy );

      return returnString;

    }

    /**
     * Access decimal value directly
     *
     * <p>
     *     Note: If value is overflowed, returns 0
     * @return Integer value in decimal form
     */
    public int getValueAsDecimal()
    {
        if( overFlow )
        {
            return 0;
        }

        return baseToDec( digitArray );
    }

    /**
     * Accesses the value directly
     * <p>
     *     Exception: If the value is overflowed, returns dummy string
     * @return String value in base form
     */
    public String getValueAsBase()
    {
        String dummyString = "The value has been overflowed.";
        if( overFlow )
        {
            return dummyString;
        }
        return Arrays.toString(digitArray);
    }

    /**
     * Compares two registers to determine the max.
     * @param secondDigit The digit we are comparing this to.
     * @return true if firstDigit > secondDigit, false otherwise
     */
    private boolean compareRegisters( BaseClass secondDigit )
    {
            BaseClass thisCopy = new BaseClass( this );
            BaseClass valueCopy = new BaseClass( secondDigit );

            int currentDigit = numDigits - 1;
            int thisCopyInt = digitToInt( thisCopy.digitArray[ currentDigit ] );
            int valueCopyInt = digitToInt( valueCopy.digitArray[ currentDigit ] ) ;

            if( thisCopy.numDigits > valueCopy.numDigits )
            {
                return true;
            }
            else if( thisCopy.numDigits < valueCopy.numDigits )
            {
                return false;
            }

            while( thisCopyInt <= valueCopyInt )
            {
                thisCopyInt = digitToInt( thisCopy.digitArray[ currentDigit ] );
                valueCopyInt = digitToInt( valueCopy.digitArray[ currentDigit ] ) ;

                if( ( currentDigit == 0 ) || ( valueCopyInt > thisCopyInt ) )
                {
                    return false;
                }
                currentDigit--;
            }

    return true;
    }
    /**
     * Implements the compareTo required of the Comparable class
     * @param value BaseClass data to be compared with this
     * @return value specifying result: for this greater than value: +1, for equal: 0,
     *         for this less than value: -1
     */
    public int compareTo( BaseClass value )
    {
        if( compareRegisters( value )  )
        {
            return 1;
        }
        return -1;
    }
}
