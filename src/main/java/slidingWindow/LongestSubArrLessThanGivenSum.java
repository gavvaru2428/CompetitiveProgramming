package src.main.java.slidingWindow;

public class LongestSubArrLessThanGivenSum {
    public static void main(String[] args) {
        int arr[] = {1,2,5,2,3,1,2,1,0};
        int givenSum = 7;
        int resultMaxLength = getMaxLength(arr,givenSum);
        System.out.println("Maximum sub array length is "+resultMaxLength);
    }

    private static int getMaxLength(int[] arr, int givenSum) {
        int start = 0;
        int maxLength = Integer.MIN_VALUE;
        int sum = 0;
        for(int end=0; end < arr.length; end++){
            sum+= arr[end];
            while(sum>givenSum && start<=end){
                sum-= arr[start++];
            }
            maxLength = Math.max(maxLength, (end-start+1));
        }
        return maxLength;
    }
}
