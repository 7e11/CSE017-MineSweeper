import java.util.Random;
import java.util.ArrayList;

//-------------------------------------------------------------------------
/**
 * This class represents an implementation of a bag collection
 * that internally uses an ArrayList to hold the items.
 *
 * This is a PARTIAL IMPLEMENTATION that needs completion.
 *
 * @param <T> The type of items this bag will hold.
 *
 * @author Evan Hruskar
 * @version 2018.03.30
 */
public class ListBasedBag<T>
    implements Bag<T>
{
    //~ Instance/static variables .............................................

    // The default initial capacity of the bag
    private static final int DEFAULT_CAPACITY = 100;

    // A single random number generator shared by all bags
    private static Random rand = sofia.util.Random.generator();

    // You write the declaration for this field:
    private ArrayList<T> contents;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates an empty bag using the default capacity.
     */
    public ListBasedBag()
    {
        this(DEFAULT_CAPACITY);
        //this calls the default construtor with DEFAULT_CAPACITY
    }


    // ----------------------------------------------------------
    /**
     * Creates an empty bag using the specified capacity.
     * @param initialCapacity initial array size.
     */
    public ListBasedBag(int initialCapacity)
    {
        contents = new ArrayList<T>(initialCapacity);
    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Adds the specified element to the bag.
     *
     * @param element item to be added
     * @precondition parameter element is not null
     */
    public void add(T element)
    {
        if (element != null) {
            contents.add(element);
        }
    }


    // ----------------------------------------------------------
    /**
     * Removes and returns the specified element from the bag.  If multiple
     * copies of the same element appear in the bag, only one is removed.
     *
     * @param target item to be removed
     * @return the item removed or null if not found
     * @precondition parameter target is not null
     * @postcondition returned value x.equals(target)
     */
    public T remove(T target)
    {
        if (target != null) {
            int index = contents.indexOf(target);
            if (index >= 0) {
                //if it's out of bounds, it will return null.
                return contents.remove(index);
            }
        }
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Removes and returns a random element from the bag.
     *
     * @return the element removed or null if the bag is empty
     */
    public T removeRandom()
    {
        if (isEmpty()) {
            return null;
        }
        int randomIndex = rand.nextInt(size());
        //we want it to go to size - 1
        return contents.remove(randomIndex);
    }


    // ----------------------------------------------------------
    /**
     * Determines if the bag contains the specified element.
     *
     * @param target element to be found
     * @return true if target is in the collection, false otherwise
     * @precondition parameter target is not null
     */
    public boolean contains(T target)
    {
        if (target != null) {
            return contents.contains(target);
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Determines if the bag contains no elements.
     *
     * @return true if collection is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }


    // ----------------------------------------------------------
    /**
     * Determines the number of elements currently in the bag.
     *
     * @return the number of elements in the bag
     */
    public int size()
    {
        return contents.size();
        //we're using an arraylist container
        //just used the given methods.
    }


    // ----------------------------------------------------------
    /**
     * Returns a string representation of this bag.  A bag's string
     * representation is written as a comma-separated list of its
     * contents (in some arbitrary order) surrounded by curly braces,
     * like this:
     * <pre>
     * {52, 14, 12, 119, 73, 80, 35}
     * </pre>
     * <p>
     * An empty bag is simply {}.
     * </p>
     *
     * @return a string representation of the bag and its contents
     */
    public String toString()
    {
        if (isEmpty()) {
            return "{}";
        }
        String result = "{ ";
        
        for (int i = 0; i < size() - 1; i++) {
            result += contents.get(i).toString() + ", ";
        }
        result += contents.get(size() - 1).toString() + " }";
        //last element because we don't add a ", " to it
        return result;
    }
}
