public class LinkedList<E> implements IList<E> {
    private Node<E> first;
    private int size;

    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    @Override
    public void add(E e) {
        Node<E> node = new Node<>(e);
        if (isEmpty()) {
            first = node;
        } else {
            Node<E> cursor = first;
            while (cursor.getNext() != null) {
                cursor = cursor.getNext();
            }
            cursor.setNext(node);
        }
        size++;
    }

    @Override
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            first = new Node<>(e, first);
        } else {
            Node<E> cursor = first;
            for (int i = 0; i < index - 1; i++) {
                cursor = cursor.getNext();
            }
            Node<E> node = new Node<>(e);
            node.setNext(cursor.getNext());
            cursor.setNext(node);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> aux;
        if (index == 0) {
            aux = first;
            first = first.getNext();
        } else {
            Node<E> cursor = first;
            for (int i = 0; i < index - 1; i++) {
                cursor = cursor.getNext();
            }
            aux = cursor.getNext();
            cursor.setNext(aux.getNext());
        }
        size--;
        return aux.getInfo();
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> cursor = first;
        for (int i = 0; i < index; i++) {
            cursor = cursor.getNext();
        }
        return cursor.getInfo();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}