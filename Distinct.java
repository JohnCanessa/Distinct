import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Distinct
 * Compute number of distinct values in an array.
 * https://app.codility.com/programmers/lessons/6-sorting/distinct/
 */
public class Distinct {


    /**
     * Given an array A consisting of N integers, 
     * return the number of distinct values in array A.
     * 
     * Execution: O(n) - Space: O(n)
     */
    static public int distinct(int[] arr) {

        // **** sanity check(s) ****
        int len = arr.length;
        if (len == 0) return 0;
        if (len == 1) return 1;

        // **** initialization ****
        HashMap<Integer, Integer> hm    = new HashMap<>();
        Integer val                     = null;

        // **** traverse array counting different values - O(n) ****
        for (int v : arr) {
            Integer cnt = hm.get(v);
            if (val == null) hm.put(v, 1);
            else hm.put(v, ++cnt);
        }

        // ???? ????
        System.out.println("<<< hm: " + hm.toString());

        // **** return number of distict values ****
        return hm.size();
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read int[] array ****
        int[] arr = Arrays.stream(br.readLine().trim().split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< arr: " + Arrays.toString(arr));

        // **** call function of interest and display result ****
        System.out.println("main <<< output: " + distinct(arr));
    }

}