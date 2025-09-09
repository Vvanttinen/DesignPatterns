package strategy.algorithms;

import strategy.SortingStrategy;

/**
 * SelectionSort implementation adapted from:
 * <a href="https://www.geeksforgeeks.org/selection-sort/">...</a>
 */
public class SelectionSort implements SortingStrategy {
  @Override
  public void sort(int[] array) {
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {

      // Assume the current position holds
      // the minimum element
      int min_idx = i;

      // Iterate through the unsorted portion
      // to find the actual minimum
      for (int j = i + 1; j < n; j++) {
        if (array[j] < array[min_idx]) {

          // Update min_idx if a smaller element
          // is found
          min_idx = j;
        }
      }

      // Move minimum element to its
      // correct position
      int temp = array[i];
      array[i] = array[min_idx];
      array[min_idx] = temp;
    }
  }
}
