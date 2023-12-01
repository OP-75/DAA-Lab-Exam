import java.util.Arrays;

public class SubsequenceSum {

    //non adjacent subsequence sum 

    //Time O(n), space O(n)
    static int findSum(int[] arr, int i, int[] memo){

        if (i>=arr.length) {
            return 0;
        }

        if (memo[i]!=-1) {
            return memo[i];
        }

        //pick i:
        int pickSum = arr[i] + findSum(arr, i+2, memo);
        //not pick i:
        int notPickSum = findSum(arr, i+1, memo);

        int maxSum = Math.max(pickSum, notPickSum);
        memo[i] = maxSum;

        return maxSum;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,9,4,5,0,4,11,6};
        int[] memo = new int[arr.length];
        Arrays.fill(memo, -1);

        System.out.println(findSum(arr, 0, memo));
    }
}
