package proj4;

/**
 * Skeleton of a Stack ADT (uses generics), which is a data structure of ordered items such that items can be inserted
 * and removed only at one end. a stack is a LIFO (last in, first out) data structure".
 *
 * Invariant:
 * 1) the instance var integer count indicates number of elements in the stack. i.e. count = 0 for an empty stack.
 *
 * 2) the instance var integer capacity indicates the capacity of the stack (max number of elements the stack can hold).
 *
 * 3) the instance var integer capacityIncrement indicates the how much the capacity increase when the old capacity
 * is reached.
 * i.e. capacity = 10, capacityIncrement = 5. if capacity is reached, the new capacity will be 15.
 *
 * 4) The Object[] array will hold all elements of this stack. The first element in array is the
 * element at bottom of the stack. The last element in array (at index count-1) will be the top of the stack.
 */
public class Stack<T>
{
    private int count; // number of items in stack
    private int capacity; // length of stack
    private int capacityIncrement;

    private Object[] itemArray;

    public static final int DEFAULT_CAPACITY = 10;
    public static final int DEFAULT_CAPACITY_INCREMENT = 5;

    /**
     * default constructor
     */
    public Stack() {
        count = 0;
        capacity = DEFAULT_CAPACITY;
        capacityIncrement = DEFAULT_CAPACITY_INCREMENT;
        itemArray = new Object[capacity];
    }

    /**
     * check if the stack is empty or not
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {  
    	return size() == 0;
    }

    /**
     * Push a new item onto this stack. The new item may be the null reference
     * @param toPush new item to push
     */
    public void push(T toPush) {
       if (size() == capacity){
           capacity += capacityIncrement;
           Object[] tempArray = new Object[capacity];
           for (int i = 0; i < size(); i++){
               tempArray[i] = itemArray[i];
           }
           itemArray = tempArray;
       } itemArray[count++] = toPush;
    }

    /**
     * Get the top item, removing it from this stack
     * @return the top item of the stack
     */
    public T pop() {
        if (isEmpty()){
    	    return null;
        }
        else{
            return (T) itemArray[--count];
        }
    }

    /**
     * Get the top item of this stack without removing the item
     * @return the top item of the stack
     */
    public T peek() {
        if (isEmpty()){
            return null;
        }
        else {
            return (T) itemArray[count-1];
        }
    }

    /**
     * Accessor method to determine the number of items in this stack
     * @return size of the stack as an integer
     */
    public int size() {
    	return count;
    }

    /**
     * produce a string presentation of the stack, starting with "{>" and ending with "}". An empty stack will look
     * like "{>}". On the other hand, if we push 3 elements into the stack, for instance "A", "B" and "C",
     * the stack will look like "{>C,B<A}".
     * @return a printable string of the stack
     */
    public String toString() {
        String toReturn = "{>";
        if (peek() != null){
            toReturn += peek();
        }
        for (int i = size() - 2; i >= 0; i--){
            toReturn += "," + itemArray[i].toString();
        }
        return toReturn += "}";
    }
} 
   

