import java.util.ArrayList;
import java.util.Comparator;

public class MaxHeap<E> extends Heap {
    //Data items
    ArrayList<E> table;
    Comparator<E> comparator;
    int child;
    int parent;
    int leftChild;
    int rightChild;

    /**
     * Default constructor for MaxHeap
     */
    public MaxHeap() {
        table = new ArrayList<>();
        comparator = null;
    }

    /**
     * Constructor that takes in a comparator object
     * @param comparator the comparator for the generic type
     */
    public MaxHeap(Comparator<E> comparator) {
        table = new ArrayList<>();
        this.comparator = comparator;
    }

    /**
     * Inserts a generic item into the heap
     * @param item the item to be inserted
     */
    @Override
    public void insertItem(Object item) {
        table.add((E)item);
        child = table.size() -1;
        parent = (child - 1)/2;
        //while parent is greater than child
        while(parent >= 0 && compare(table.get(parent), table.get(child)) == -1){
            E temp = table.get(parent);
            table.set(parent, table.get(child));
            table.set(child, temp);
            child = parent;
            parent = (child-1)/2;
        }
    }

    /**
     * Removes the top item in the heap and balances the heap according to how the maxHeap works
     */
    @Override
    public void removeItem() {
        int largestChild;
        if (!(table.isEmpty())) {
            E lastItem = table.get(table.size() - 1);
            table.remove(table.size() - 1);
            table.set(0, lastItem);
            parent = 0;
        }
        leftChild = (parent * 2) + 1;
        rightChild = leftChild + 1;
        while((leftChild < table.size() && rightChild < table.size()) &&
                (compare(table.get(parent), table.get(leftChild)) == -1 || compare(table.get(parent), table.get(rightChild)) == -1) )
        {
            if (compare(table.get(leftChild), table.get(rightChild)) == 1 ) {
                largestChild = leftChild;
            } else {
                largestChild = rightChild;
            }

            E temp = table.get(parent);
            table.set(parent, table.get(largestChild));
            table.set(largestChild, temp);

            parent = largestChild;

            leftChild = (parent * 2) + 1;
            rightChild = leftChild + 1;

            //Case of leaf nodes that will discontinue the while loop or throw an exception
            if ((rightChild >= table.size() && leftChild < table.size())
                && compare(table.get(leftChild), table.get(parent)) == 1) {
                temp = table.get(parent);
                table.set(parent, table.get(leftChild));
                table.set(leftChild, temp);
            }
            if ((leftChild >= table.size() && rightChild < table.size())
                    && compare(table.get(rightChild), table.get(parent)) == 1) {
                temp = table.get(parent);
                table.set(parent, table.get(rightChild));
                table.set(rightChild, temp);
            }
        }
    }

    /**
     * Compares two objects to each other, using a comparator if one exists and compareTo if not
     * @param left the left item in the comparison
     * @param right the right item in the comparison
     * @return 0 if they are equal, 1 if the left is greater than the right, and -1 if the left is less than the right
     */
    @Override
    public int compare(Object left, Object right) {;
        if (comparator != null) {
            return comparator.compare((E)left, (E)right);
        } else {
            return ((Comparable<E>) left).compareTo((E)right);
        }
    }

    /**
     * To string representation of the maxHeap
     * @return a toString of the ArrayList
     */
    @Override
    public String toString() {
        return table.toString();
    }
}

