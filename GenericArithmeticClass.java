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
 * @param <T>
 */
public class GenericArithmeticClass <T> {

    /**
     * Default constructor, initializes array to default capacity.
     */
    public GenericArithmeticClass ()
    {
        localArray = (T[]) new Object[ DEFAULT_CAPACITY ];
        arrayCapacity = DEFAULT_CAPACITY;
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
    private T[] localArray;
}
