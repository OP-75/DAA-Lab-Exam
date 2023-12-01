public class LCP {
    
    //Time O(nlogn), space O(logn) (stack space)
    static String LongestCommonPrefix(String[] arr, int start, int end){

        if (start==end) {
            return arr[start];
        }

        int mid = (start+end)/2;

        String leftCommon = LongestCommonPrefix(arr, start, mid);
        String rightCommon = LongestCommonPrefix(arr, mid+1, end);

        String commonBetweenThem = commonPrefix(leftCommon, rightCommon);

        return commonBetweenThem;

    }

    private static String commonPrefix(String leftCommon, String rightCommon) {
        
        String common = "";
        
        for (int i = 0; i < leftCommon.length() && i < rightCommon.length(); i++) {
            if (leftCommon.charAt(i)==rightCommon.charAt(i)) {
                common = common + leftCommon.charAt(i);
            }
            else{
                //! IMP condition
                break;
            }
        }

        return common;

    }

    public static void main(String[] args) {
        String[] arr = {"technique", "technician", "technology", "technical"};
        System.out.println(LongestCommonPrefix(arr, 0, arr.length-1));

        arr = new String[]{"techie", "technician", "technology", "technical"};
        System.out.println(LongestCommonPrefix(arr, 0, arr.length-1));
    }

}
