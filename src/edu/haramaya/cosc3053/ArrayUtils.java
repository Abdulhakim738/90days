package edu.haramaya.cosc3053;
import java.util.Arrays;
public class ArrayUtils {

        // TODO 3.1: Find Minimum Element
        public static int findMin(int[] arr) {

            if (arr == null || arr.length == 0) {
                throw new IllegalArgumentException(
                        "Array cannot be empty or null"
                );
            }

            int min = arr[0];

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }

            return min;
        }

        // TODO 3.2: Find Maximum Element
        public static int findMax(int[] arr) {

            if (arr == null || arr.length == 0) {
                throw new IllegalArgumentException(
                        "Array cannot be empty or null"
                );
            }

            int max = arr[0];

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }

            return max;
        }

        // TODO 3.3: Reverse Array In-Place
        public static void reverse(int[] arr) {

            if (arr == null) {
                return;
            }

            int left = 0;
            int right = arr.length - 1;

            while (left < right) {

                int temp = arr[left];

                arr[left] = arr[right];

                arr[right] = temp;

                left++;
                right--;
            }
        }

        // TODO 3.4: Binary Search
        // IMPORTANT: The array must already be sorted.
        public static int binarySearch(int[] arr, int target) {

            int low = 0;
            int high = arr.length - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (arr[mid] == target) {
                    return mid;
                }

                if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return -1;
        }

        public static void main(String[] args) {

            int[] data = {45, 12, 89, 33, 67, 21};

            System.out.println(
                    "Original: " + Arrays.toString(data)
            );

            System.out.println(
                    "Min: " + findMin(data) +
                            " | Max: " + findMax(data)
            );

            reverse(data);

            System.out.println(
                    "Reversed: " + Arrays.toString(data)
            );

            Arrays.sort(data);

            System.out.println(
                    "Sorted: " + Arrays.toString(data)
            );

            System.out.println(
                    "Binary Search (33): Index " +
                            binarySearch(data, 33)
            );
        }
    }
    /*
What is the time complexity of in-place array reversal?

Time complexity: O(n), because the algorithm visits and swaps elements across the array.
Auxiliary space complexity: O(1), because it uses only a fixed number of extra variables (left, right, and temp).
*/

/*Why is mid = low + (high - low) / 2 safer than mid = (low + high) / 2?

It prevents integer overflow. When low + high exceeds Java's maximum 32-bit integer value (Integer.MAX_VALUE),
 the calculation can produce an incorrect result. The safer formula avoids adding low and high directly.
 */

