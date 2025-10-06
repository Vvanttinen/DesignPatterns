package strategy;

import strategy.algorithms.MergeSort;
import strategy.algorithms.QuickSort;
import strategy.algorithms.SelectionSort;

import java.util.Arrays;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    SortingStrategy[] strategies = {
            new SelectionSort(),
            new QuickSort(),
            new MergeSort()
    };

    int[] smallArray = generateRandomArray(30);
    int[] largeArray = generateRandomArray(100_000);

    System.out.println("Sorting small array (30 elements):");
    runTests(smallArray, strategies);

    System.out.println("Sorting large array (100,000 elements):");
    runTests(largeArray, strategies);
  }

  private static void runTests(int[] array, SortingStrategy[] strategies) {
    for (SortingStrategy strategy : strategies) {
      int[] copy = Arrays.copyOf(array, array.length);
      long start = System.nanoTime();
      strategy.sort(copy);
      long end = System.nanoTime();
      if (!isSorted(copy)) {
        System.out.println(strategy.getClass().getSimpleName() + " failed to sort the array.");
      } else {
        System.out.printf("%s took %.3f ms%n",
                strategy.getClass().getSimpleName(),
                (end - start) / 1_000_000.0);
      }
    }
  }

  private static boolean isSorted(int[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i - 1]) {
        return false;
      }
    }
    return true;
  }

  private static int[] generateRandomArray(int size) {
    Random random = new Random();
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = random.nextInt();
    }
    return array;
  }
}
