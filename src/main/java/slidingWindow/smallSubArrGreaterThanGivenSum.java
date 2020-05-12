package src.main.java.slidingWindow;

public class smallSubArrGreaterThanGivenSum {
    public static void main(String[] args) {

        int arr[] = {1,2,5,2,3,1,2,2,7};
        int givenSum = 7;
        int resultMinLength = getMinLength(arr,givenSum);
        System.out.println("Minimum sub array length is "+resultMinLength);
    }

    private static int getMinLength(int[] arr, int givenSum) {
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        for(int end=0; end < arr.length; end++){
            sum += arr[end];
            while(sum>=givenSum && start<=end){
                minLength = Math.min(minLength, (end-start+1));
                sum -= arr[start++];
            }
        }
        return minLength;
    }
}
