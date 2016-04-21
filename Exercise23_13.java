
import java.util.ArrayList;


/*
 Phillip Sheridan
 CSCI 2410
 due: 10/14/15
 */
public class Exercise23_13 {

    public static void main(String[] args) {
        System.out.printf("%30s%25s%25s%25s%25s%25s\n\n", "Selection Sort",
                "Bubble Sort",
                "Merge Sort", "Quick Sort", "Heap Sort",
                "Radix Sort");
        long startTime;
        long endTime;
        long executionTime;

        for (int i = 50000; i <= 300000; i += 50000) {
            System.out.print(i);
            startTime = System.nanoTime();
            selectionSort(makeArray(i));
            endTime = System.nanoTime();
            executionTime = endTime - startTime;
            System.out.printf("%25s", executionTime / 1000000);

            startTime = System.nanoTime();
            bubbleSort(makeArray(i));
            endTime = System.nanoTime();
            executionTime = endTime - startTime;
            System.out.printf("%25s", executionTime / 1000000);

            startTime = System.nanoTime();
            mergeSort(makeArray(i));
            endTime = System.nanoTime();
            executionTime = endTime - startTime;
            System.out.printf("%25s", executionTime / 1000000);

            startTime = System.nanoTime();
            quickSort(i, makeArray(i));
            endTime = System.nanoTime();
            executionTime = endTime - startTime;
            System.out.printf("%25s", executionTime / 1000000);

            startTime = System.nanoTime();
            heapSort(makeIntArray(i));
            endTime = System.nanoTime();
            executionTime = endTime - startTime;
            System.out.printf("%25s", executionTime / 1000000);

            startTime = System.nanoTime();
            radixSort(makeArray(i));
            endTime = System.nanoTime();
            executionTime = endTime - startTime;
            System.out.printf("%25s\n", executionTime / 1000000);

        }

    }

    public static int[] makeArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        return array;
    }

    public static Integer[] makeIntArray(int length) {
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        return array;
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int currentMin = array[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (currentMin > array[j]) {
                    currentMin = array[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                array[currentMinIndex] = array[i];
                array[i] = currentMin;
            }
        }
       
    }

    public static int[] bubbleSort(int[] list) {
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++) {
            // Array may be sorted and next pass not needed
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    // Swap list[i] with list[i + 1]
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true; // Next pass still needed
                }
            }
        }
        return list;
    }

    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);

        }
    }

    /**
     * Merge two sorted lists
     */
    public static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2]) {
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }
        }

        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
        }

        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
    }

    public static void quickSort(final int size, int[] arr) {
        int l = 0;
        int r = size - 1;
        int q, i = 0;
        int tmpr = r;
        while (true) {
            i--;
            while (l < tmpr) {
                q = partition(l, tmpr, arr);
                arr[tmpr] = -arr[tmpr];
                tmpr = q - 1;
                ++i;
            }
            if (i < 0) {
                break;
            }
            l++;
            tmpr = findNextR(l, size, arr);
            arr[tmpr] = -arr[tmpr];
        }
    }

    private static int findNextR(final int l, final int size, int[] arr) {
        for (int i = l; i < size; ++i) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return size - 1;
    }

    private static int partition(int l, int r, int[] arr) {
        int pivot = arr[(l + r) / 2];
        while (l <= r) {
            while (arr[r] > pivot) {
                r--;
            }
            while (arr[l] < pivot) {
                l++;
            }
            if (l <= r) {
                int tmp = arr[r];
                arr[r] = arr[l];
                arr[l] = tmp;
                l++;
                r--;
            }
        }
        return l;
    }

    public static void radixSort(int[] list) {
        ArrayList<Integer>[] bucket = new ArrayList[10];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }
        boolean maxLength = false;
        int temp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;
            for (Integer i : list) {
                temp = i / placement;
                bucket[temp % 10].add(i);
                if (maxLength && temp > 0) {
                    maxLength = false;
                }

            }
            int a = 0;
            for (int b = 0; b < 10; b++) {
                for (Integer i : bucket[b]) {
                    list[a++] = i;
                }
                bucket[b].clear();
            }
            placement *= 10;

        }
    }

    public static void heapSort(Integer[] list) {
        Heap<Integer> heap = new Heap<>(list);
        int[] result = new int[list.length];
        for (int i = list.length - 1; i >= 0; i--) {
            result[i] = heap.remove();
        }
        

    }

    static class Heap<E extends Comparable<E>> {

        private ArrayList<Integer> list = new ArrayList<>();

        /**
         * Create a default heap
         */
        public Heap() {
        }

        /**
         * Create a heap from an array of objects
         */
        public Heap(Integer[] objects) {
            for (int i = 0; i < objects.length; i++) {
                add(objects[i]);
            }
        }

        /**
         * Add a new object into the heap
         */
        public void add(Integer newObject) {
            list.add(newObject); // Append to the heap
            int currentIndex = list.size() - 1; // The index of the last node

            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;
                // Swap if the current object is greater than its parent
                if (list.get(currentIndex).compareTo(
                        list.get(parentIndex)) > 0) {
                    Integer temp = list.get(currentIndex);
                    list.set(currentIndex, list.get(parentIndex));
                    list.set(parentIndex, temp);
                } else {
                    break; // the tree is a heap now
                }
                currentIndex = parentIndex;
            }
        }

        /**
         * Remove the root from the heap
         */
        public Integer remove() {
            if (list.size() == 0) {
                return null;
            }

            Integer removedObject = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            int currentIndex = 0;
            while (currentIndex < list.size()) {
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;

                // Find the maximum between two children
                if (leftChildIndex >= list.size()) {
                    break; // The tree is a heap
                }
                int maxIndex = leftChildIndex;
                if (rightChildIndex < list.size()) {
                    if (list.get(maxIndex).compareTo(
                            list.get(rightChildIndex)) < 0) {
                        maxIndex = rightChildIndex;
                    }
                }

                // Swap if the current node is less than the maximum
                if (list.get(currentIndex).compareTo(
                        list.get(maxIndex)) < 0) {
                    Integer temp = list.get(maxIndex);
                    list.set(maxIndex, list.get(currentIndex));
                    list.set(currentIndex, temp);
                    currentIndex = maxIndex;
                } else {
                    break; // The tree is a heap
                }
            }

            return removedObject;
        }

        /**
         * Get the number of nodes in the tree
         */
        public int getSize() {
            return list.size();
        }
    }
}
