import java.util.ArrayList;

public class TestDriver {
    public static void main(String[] args) {
        MinHeap<Integer> testHeap = new MinHeap<Integer>();
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        System.out.println(testHeap);
        testHeap.insertItem(6);
        testHeap.insertItem(18);
        testHeap.insertItem(29);
        testHeap.insertItem(20);
        testHeap.insertItem(28);
        testHeap.insertItem(39);
        testHeap.insertItem(66);
        testHeap.insertItem(37);
        testHeap.insertItem(26);
        testHeap.insertItem(76);
        testHeap.insertItem(32);
        testHeap.insertItem(74);
        testHeap.insertItem(89);
        testHeap.insertItem(8);

        System.out.println(testHeap);

        testHeap.removeItem();
        System.out.println(testHeap);
        System.out.println();
        System.out.println();

        maxHeap.insertItem(5);
        maxHeap.insertItem(39);
        maxHeap.insertItem(20);
        maxHeap.insertItem(90);
        maxHeap.insertItem(54);
        maxHeap.insertItem(22);
        maxHeap.insertItem(10);
        maxHeap.insertItem(11);
        maxHeap.insertItem(34);
        maxHeap.insertItem(48);
        maxHeap.insertItem(18);

        System.out.println(maxHeap);

        maxHeap.removeItem();

        System.out.println(maxHeap);



    }

}
