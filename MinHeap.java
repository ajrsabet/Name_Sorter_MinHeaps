// Java Program to Implement Min Heap
import java.util.ArrayList;

class MinHeap {
    private ArrayList<String> heap;

    // Constructor to initialize the heap
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Returns the index of the parent node
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Returns the index of the left child node
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // Returns the index of the right child node
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // Swaps the elements at indices i and j
    private void swap(int i, int j) {
        String temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Inserts a new value into the heap
    public void insert(String value) {
        // Add the new value at the end of the heap
        heap.add(value); 
        // Get the index of the newly added value
        int currentIndex = heap.size() - 1; 

        // Bubble up to restore heap property
        while (currentIndex > 0 && heap.get(currentIndex).compareTo(heap.get(parent(currentIndex))) < 0) {
            // Swap with parent if current value is less
            swap(currentIndex, parent(currentIndex)); 
            // Move up to the parent index
            currentIndex = parent(currentIndex); 
        }
    }

    // Extracts and returns the minimum value from the heap
    public String extractMin() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }

        // The minimum value is at the root
        String min = heap.get(0); 
        // Remove the last element
        String lastElement = heap.remove(heap.size() - 1); 

        if (!heap.isEmpty()) {
            // Move the last element to the root
            heap.set(0, lastElement); 

            // Bubble down to restore heap property
            int currentIndex = 0;
            while (true) {
                int left = leftChild(currentIndex);
                int right = rightChild(currentIndex);

                int smallest = currentIndex;

                // Find the smallest value among current, left child, and right child
                if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                    smallest = left;
                }

                if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                    smallest = right;
                }

                if (smallest == currentIndex) {
                    // Heap property is restored
                    break; 
                }

                // Swap with the smallest child
                swap(currentIndex, smallest); 
                // Move down to the smallest child's index
                currentIndex = smallest; 
            }
        }

        // Return the minimum value
        return min; 
    }

    // Checks if the heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}