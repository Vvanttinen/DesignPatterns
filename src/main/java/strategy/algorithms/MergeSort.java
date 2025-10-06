package strategy.algorithms;

import strategy.SortingStrategy;

/**
 * MergeSort implementation adapted from:
 * <a href="https://www.geeksforgeeks.org/merge-sort/">...</a>
 */
public class MergeSort implements SortingStrategy {
  @Override
  public void sort(int[] array) {
    mergeSort(array, 0, array.length - 1);
  }

  private void mergeSort(int[] array, int left, int right) {
    if (left < right) {
      // Find the middle point
      int mid = (left + right) / 2;

      // Sort first and second halves
      mergeSort(array, left, mid);
      mergeSort(array, mid + 1, right);

      // Merge the sorted halves
      merge(array, left, mid, right);
    }
  }

  private void merge(int array[], int l, int m, int r){

    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    // Create temp arrays
    int L[] = new int[n1];
    int R[] = new int[n2];

    // Copy data to temp arrays
    for (int i = 0; i < n1; ++i)
      L[i] = array[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = array[m + 1 + j];

    // Merge the temp arrays

    // Initial indices of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarray array
    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        array[k] = L[i];
        i++;
      }
      else {
        array[k] = R[j];
        j++;
      }
      k++;
    }

    // Copy remaining elements of L[] if any
    while (i < n1) {
      array[k] = L[i];
      i++;
      k++;
    }

    // Copy remaining elements of R[] if any
    while (j < n2) {
      array[k] = R[j];
      j++;
      k++;
    }
  }
}
