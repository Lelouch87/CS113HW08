public abstract class Heap<E> {
    //Methods that must be implemented
    public abstract void insertItem(E item);
    public abstract void removeItem();
    public abstract int compare(E left, E right);
}
