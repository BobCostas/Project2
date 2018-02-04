package p2_Package;

/**
 * Description: Class wrapper for a Java array of generic data (classes), with
 * additional management operations.
 * <p>
 *     Note: Only works with classes that extend Comparable, as shown in class
 *     declaration.
 * <p>
 *  Note: Maintains a capacity value for maximum number of items that can be stored.
 *
 * @param <GenericData> The data type used in the class
 */
public class GenericArithmeticClass <GenericData> {

    /**
     * Default constructor, initializes array to default capacity.
     */
    public GenericArithmeticClass ()
    {
        localArray = ( GenericData[] ) new Object[ DEFAULT_CAPACITY ];
        arrayCapacity = DEFAULT_CAPACITY;
    }

    /**
     * Copy constructor, intitializes array to capacity of copied array, then copies the
     * elements up to the given capacity.
     * @param copied The GenericArithmeticClass object to be copied
     */
    public GenericArithmeticClass( GenericArithmeticClass<GenericData> copied )
    {
       arrayCapacity = copied.arrayCapacity;
       int currentData = 0;

       for( currentData = 0; currentData < copied.arrayCapacity; currentData++ )
       {
           localArray[ currentData ] = copied.localArray[ currentData ];
       }
    }

    /**
     * Initializing constructor, initializes array to specified capacity.
     * @param capacity Integer maximum capacity specification for the array
     */
    public GenericArithmeticClass ( int capacity )
    {
       arrayCapacity = capacity;
       localArray = ( GenericData[] ) new Object[ arrayCapacity ];
    }

    /**
     * Holds the capacity of the array
     */
    private int arrayCapacity = 0;

    /**
     * Holds default capacaty of array if it is not specified.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Holds local array of generic items
     */
    private GenericData[] localArray;

    /**
     * Sets element into array at index.
     * @param index location in array to place data
     * @param newValue Value to be appended to array
     * @return Boolean success if element set at index, false if index outside boundaries
     */
    public boolean setValueAt( int index, GenericData newValue )
    {
       if( index > arrayCapacity )
       {
           return false;
       }

       localArray[ index ] = newValue;

       return true;
    }

    /**
     * Acquires data at specified element
     * @param index index of element to be returned
     * @return GenericData item retrieved from array; null if index outside boundaries
     */
    public GenericData getValueAt( int index )
    {
       if( index > arrayCapacity )
       {
           return null;
       }

       return localArray[ index ];

    }

    /**
     * Description: Resets array capacity, and current array capacity value.
     * <p> Exception: Method will not resize capacity below current capacity,
     * returns false if this attempted, true otherwise
     * @param newCapacity
     * @return
     */
    public boolean resize( int newCapacity )
    {
        GenericData[] newLocalArray = ( GenericData[] ) new Object[ newCapacity ];
        int currentElement = 0;

        if( newCapacity < arrayCapacity )
        {
            return false;
        }
        for( currentElement = 0; currentElement < arrayCapacity; currentElement++ )
        {
            newLocalArray[ currentElement ] = localArray[ currentElement ];
        }

        arrayCapacity = newCapacity; // reset size of array

        return true;
    }

    /**
     * Description: Gets current capacity of array
     * <p> Note: capacity of array indicates number of values the array can hold
     * @return Capacity of array
     */
    public int getCurrentCappacity()
    {
       return arrayCapacity;
    }

    /**
     * Swaps one element in the local array at a given index with another element
     * in the array at the other given element
     * @param firstIndex Index of one of two elements to be swapped
     * @param secondIndex Index of second of two elements to be swapped
     */
    private void swapElements( int firstIndex, int secondIndex )
    {
       GenericData tempElement = localArray[ secondIndex ];

       localArray[ secondIndex ] = localArray[ firstIndex ];
       localArray[ firstIndex ] = tempElement;

    }
}
