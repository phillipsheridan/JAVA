
/*
 Phillip Sheridan
 CSCI 2410
 due: 10/19/15
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Exercise24_03 {

    public static void main(String[] args) {
        TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();
        System.out.print("Enter 5 integers: ");
        Scanner input = new Scanner(System.in);
        double[] v = new double[5];
        for (int i = 0; i < 5; i++) {
            v[i] = input.nextDouble();
        }

        list.add(v[1]);
        list.add(v[2]);
        list.add(v[3]);
        list.add(v[4]);
        list.add(0, v[0]);
        list.add(2, 10.55);
        list.remove(3);

        java.util.ListIterator<Double> iterator1 = list.listIterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }

        java.util.ListIterator<Double> iterator2 = list.listIterator(list.size() - 1);
        System.out.println();
        while (iterator2.hasPrevious()) {
            System.out.print(iterator2.previous() + " ");
        }
    }

    static class TwoWayLinkedList<E> implements MyList<E> {

        private Node<E> head, tail;
        private int size;

        /**
         * Create a default list
         */
        public TwoWayLinkedList() {
        }

        /**
         * Create a list from an array of objects
         */
        public TwoWayLinkedList(E[] objects) {
            for (E e : objects) {
                add(e);
            }
        }

        /**
         * Return the head element in the list
         */
        public E getFirst() {
            if (size == 0) {
                return null;
            } else {
                return head.data;
            }
        }

        /**
         * Return the last element in the list
         */
        public E getLast() {
            if (size == 0) {
                return null;
            } else {
                return tail.data;
            }
        }

        /**
         * Add an element to the beginning of the list
         */
        public boolean add(E e) {
            addLast(e);
            return true;
        }
        public void addFirst(E e) {
            Node<E> newNode = new Node<>(e);
            newNode.next = head;
            head = newNode;
            size++;

            if (tail == null) {

                head = new Node<>(e);
                tail = head;

            } else {
                Node<E> node = new Node<>(e, head, null);
                head.prev = node;
                node.next = head;
                head = node;

                size++;

            }
        }

        /**
         * Add an element to the end of the list
         */
        public void addLast(E e) {
            Node<E> newNode = new Node<>(e, null, tail); // Create a new for element e

            if (size == 0) {
                head = tail = new Node(e);
                
// The new node is the only node in list
            } else {
                tail = newNode;
                if (size == 1) {
                    head.next = tail;
                    tail.prev = head;
                    
                }
                if (size == 2) {
                   head.next = new Node<>(e, tail, head); 
                }
                
                         // Link the new with the last node

            }

            size++; // Increase size

        }

        /**
         * Add a new element at the specified index in this list The index of
         * the head element is 0
         */
        public void add(int index, E e) {

            if (index == 0) {
                addFirst(e);
            } else if (index >= size) {
                addLast(e);
            } else {
                Node<E> current = head;
              
                

                for (int i = 0; i < size; i++) {

                   current = current.next;
                }
                    if (i == index) {
                        E curr = temp.data;
                        temp.data = e;
                        temp.next.data = curr;

                    }
                    if (i > index) {
                        temp.next.data = temp.data;

                    }
                }
                size++;
            }
        

        /**
         * Remove the head node and return the object that is contained in the
         * removed node.
         */
        public E removeFirst() {
            if (size == 0) {
                return null;
            } else {
                Node<E> temp = head;
                head = head.next;
                size--;
                if (head == null) {
                    tail = null;
                }
                return temp.data;
            }
        }

        /**
         * Remove the last node and return the object that is contained in the
         * removed node.
         */
        public E removeLast() {
            if (size == 0) {
                return null;
            } else {
                Node<E> temp = tail;
                tail = tail.prev;
                size--;
                if (tail == null) {
                    head = null;
                }
                return temp.data;

            }
        }

        /**
         * Remove the element at the specified position in this list. Return the
         * element that was removed from the list.
         */
        public E remove(int index) {
            if (index < 0 || index >= size) {
                return null;
            } else if (index == 0) {
                return removeFirst();
            } else if (index == size - 1) {
                return removeLast();
            } else {
                Node<E> previous = head;

                for (int i = 1; i < index; i++) {
                    previous = previous.next;
                }

                Node<E> current = previous.next;
                previous.next = current.next;
                
                current.next.prev = previous; // For a two-way linked list
                size--;
                return current.data;
            }
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("[");

            Node<E> current = head;
            for (int i = 0; i < size; i++) {
                result.append(current.data);
                current = current.next;
                if (current != null) {
                    result.append(", "); // Separate two elements with a comma
                } else {
                    result.append("]"); // Insert the closing ] in the string
                }
            }

            return result.toString();
        }

        /**
         * Clear the list
         */
        public void clear() {
            head = tail = null;
        }

        /**
         * Return true if this list contains the element o
         */
        public boolean contains(Object e) {
            LinkedListIterator iterator = (LinkedListIterator) this.listIterator();
            int i = 0;
            while (iterator.hasNext()) {

                if ((E) e == this.get(i)) {
                    return true;
                }
                i++;
            }
            return false;
        }

        /**
         * Return the element from this list at the specified index
         */
        public E get(int index) {
            LinkedListIterator it = new LinkedListIterator(index);
            return it.current.data;
        }

        /**
         * Return the index of the head matching element in this list. Return -1
         * if no match.
         */
        public int indexOf(Object e) {
            ArrayList<E> list = new ArrayList<>(this);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == e) {
                    return i;
                }
            }

            return -1;
        }

        /**
         * Return the index of the last matching element in this list Return -1
         * if no match.
         */
        public int lastIndexOf(Object e) {
            ArrayList<E> list = new ArrayList<>(this);
            for (int i = list.size() - 1; i < 0; i--) {
                if (list.get(i) == e) {
                    return i;
                }
            }
            return -1;
        }

        /**
         * Replace the element at the specified position in this list with the
         * specified element.
         */
        @Override
        public E set(int index, Object e) {
            LinkedListIterator it = new LinkedListIterator(index);
            it.current.data = (E) e;
            return it.current.data;
        }

        class LinkedListIterator implements java.util.ListIterator<E> {

            private Node<E> current = head; // Current index
            private Node<E> post = current.next;
            private Node<E> prev = current.prev;
            int index;

            public LinkedListIterator() {
            }

            public LinkedListIterator(int index) {
                if (index < 0 || index >= size) {
                    throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
                            + size);
                }
                for (int nextIndex = 0; nextIndex < index; nextIndex++) {
                    current = current.next;
                }
            }

            public void add(E e) {

            }

            @Override
            public boolean hasNext() {
                return (current.next != null);
            }

            @Override
            public E next() {
                current = current.next;
                E e = current.data;
                return e;
            }

            @Override
            public void remove() {
                while (this.hasNext()) {
                    current = current.next;
                }
                tail = tail.getPrevious();
                tail.next = null;
                size--;
            }

            @Override
            public boolean hasPrevious() {
                return (current.prev != null);
            }

            @Override
            public int nextIndex() {
                if (this.hasNext()) {
                    return indexOf(next());
                }
                return -1;
            }

            @Override
            public E previous() {
                E e = current.data;
                current = current.getPrevious();
                return e;
            }

            @Override
            public int previousIndex() {
                if (this.hasPrevious()) {
                    return indexOf(previous());
                }
                return 0;
            }

            @Override
            public void set(E e) {
                current.data = e; // TODO Auto-generated method stub
            }
        }

        public class Node<E> {

            private E data;
            private Node prev;
            private Node next;

            public Node(E element) {

                this(element, null, null);

            }

            public Node(E element, Node n) {

                this(element, n, null);

            }

            public Node(E element, Node n1, Node n2) {

                this.data = element;
                this.prev = n2;
                this.next = n1;

            }

            public void setPrevious(Node n) {

                this.prev = n;
                n.next = this;
            }

            public void setNext(Node n) {

                this.next = n;
                n.prev = this;

            }

            public Node getNext() {

                return this.next;

            }

            public Node getPrevious() {

                return this.prev;
            }

            public void setData(E element) {
                this.data = element;

            }

            public E getData() {

                return this.data;

            }
        }

        @Override
        public int size() {
            return size;
        }

        public ListIterator<E> listIterator() {
            return new LinkedListIterator();
        }

        public ListIterator<E> listIterator(int index) {
            return new LinkedListIterator(index);

        }

        @Override
        public Iterator<E> iterator() {
            // TODO Auto-generated method stub
            return null;
        }
    }

    static interface MyList<E> extends java.util.Collection<E> {

        /**
         * Add a new element at the specified index in this list
         */
        /**
         * Return the element from this list at the specified index
         */
        /**
         * Return the index of the first matching element in this list. Return
         * -1 if no match.
         */
        public int indexOf(Object e);

        /**
         * Return the index of the last matching element in this list Return -1
         * if no match.
         */
        public int lastIndexOf(E e);

        /**
         * Remove the element at the specified position in this list Shift any
         * subsequent elements to the left. Return the element that was removed
         * from the list.
         */
        public E remove(int index);

        /**
         * Replace the element at the specified position in this list with the
         * specified element and returns the new set.
         */
        public E set(int index, E e);

        @Override
        /**
         * Add a new element at the end of this list
         */
        public boolean add(E e);

        @Override
        /**
         * Return true if this list contains no elements
         */
        public default boolean isEmpty() {
            return size() == 0;
        }

        @Override
        /**
         * Remove the first occurrence of the element e from this list. Shift
         * any subsequent elements to the left. Return true if the element is
         * removed.
         */
        public default boolean remove(Object e) {
            if (indexOf(e) >= 0) {
                remove(indexOf(e));
                return true;
            } else {
                return false;
            }
        }

        @Override
        public default boolean containsAll(Collection<?> c) {
            // Left as an exercise
            return true;
        }

        @Override
        public default boolean addAll(Collection<? extends E> c) {
            // Left as an exercise
            return true;
        }

        @Override
        public default boolean removeAll(Collection<?> c) {
            // Left as an exercise
            return true;
        }

        @Override
        public default boolean retainAll(Collection<?> c) {
            // Left as an exercise
            return true;
        }

        @Override
        public default Object[] toArray() {
            // Left as an exercise
            return null;
        }

        @Override
        public default <T> T[] toArray(T[] array) {
            // Left as an exercise
            return null;
        }
    }
}
