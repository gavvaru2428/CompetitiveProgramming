package src.main.java.slidingWindow;

public class MaximumSubArray {
    public static void main(String[] args) {
        int arr[]={2,1,5,1,3,2};
        int k=3;
        int maximum=getMaximum(arr,k);
        System.out.println("Max Value is "+maximum);
        int arr1[]={2,3,4,1,5};
        int k1=2;
        maximum=getMaximum(arr1,k1);
        System.out.println("Max Value is "+maximum);
    }

    private static int getMaximum(int[] arr, int k) {
        int max = 0;
        int sum = 0;
        for(int i=0;i<k;i++)
            sum += arr[i];
        max = Math.max(max,sum);
        for(int j=k; j<arr.length; j++) {
            sum = sum + arr[j]-arr[j-k];
            max = Math.max(max,sum);
        }
        return max;
    }
}
