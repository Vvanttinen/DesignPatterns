package strategy.algorithms;

import strategy.SortingStrategy;

/**
 * QuickSort implementation adapted from:
 * <a href="https://www.geeksforgeeks.org/quick-sort/">...</a>
 */
public class QuickSort implements SortingStrategy {
  @Override
  public void sort(int[] array) {
    quickSort(array, 0, array.length - 1);
  }

  private void quickSort(int[] array, int low, int high) {
    if (low < high) {
      // pi is the partition return index of pivot
      int pi = partition(array, low, high);

      // recursion calls for smaller elements
      // and greater or equals elements
      quickSort(array, low, pi - 1);
      quickSort(array, pi + 1, high);
    }
  }

  private int partition(int[] array, int low, int high) {
    // choose the pivot
    int pivot = array[high];

    // index of smaller element and indicates
    // the right position of pivot found so far
    int i = low - 1;

    // traverse array[low..high] and move all smaller
    // elements to the left side. Elements from low to
    // i are smaller after every iteration
    for (int j = low; j <= high - 1; j++) {
      if (array[j] < pivot) {
        i++;
        swap(array, i, j);
      }
    }

    // Move pivot after smaller elements and
    // return its position
    swap(array, i + 1, high);
    return i + 1;
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
