import java.util.Arrays;

public class ArraysTypes {
    public static void main (String[] args) {
        int[] numbers = {1, 2, 3, 4, 5}; // One dimensional arrays
        System.out.println(Arrays.toString(numbers));
        int[][] numbers2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(numbers2)); // Two dimensional arrays
        int[][][] numbers3 = {{{1, 2, 3}, {4, 5, 6}}, {{7, 8, 9}, {10, 11, 12}}};
        System.out.println(Arrays.deepToString(numbers3)); // Three dimensional arrays
    }
}
