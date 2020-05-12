package src.main.java.slidingWindow;

import java.util.Arrays;
import java.util.HashMap;

public class LongSubStrWithGivenNoOfChar {
    public static void main(String[] args) {
        String str="araaaarrrracciiiiicicid";
        int givenNum=2;
        //int result=getLongestSubString(str,givenNum);
        //System.out.println("Longest substring length is "+result);

        char result[]=getLongestSubString(str,givenNum);
        //System.out.println("Longest sub array is "+result);
        for(int j=0;j<result.length;j++)
            System.out.print(result[j]+" ");

    }

    private static char[] getLongestSubString(String str, int givenNum) {

        int start = 0;
        int maxLength = Integer.MIN_VALUE;
        int distinctLength = 0;
        int subStringLength = 0;
        char arr[]=str.toCharArray();
        char[] subArr=null;
        //System.out.println(arr[0]);
        HashMap hashMap=new HashMap<Character,Integer>();
        for(int end=0; end <arr.length; end++){
            subStringLength++;
            if(hashMap.containsKey(arr[end])){
                hashMap.replace(arr[end],(int)hashMap.get(arr[end])+1);
            }
            else{
                hashMap.put(arr[end],1);
                distinctLength++;
                while(distinctLength>givenNum && start<=end ){
                    char character = arr[start++];
                    int charFrequency = (int)hashMap.get(character);
                    if(charFrequency==1){
                        hashMap.remove(character);
                        distinctLength--;
                    }
                    else{
                        hashMap.replace(character,(int)hashMap.get(character)-1);
                    }
                    subStringLength--;
                }
            }
            if(distinctLength==givenNum && subStringLength>maxLength) {
                // maxLength = Math.max(maxLength, subStringLength);
                    maxLength = subStringLength;
                    subArr = Arrays.copyOfRange(arr, start,end+1);
            }
        }
        //return maxLength;
        System.out.println("length is "+maxLength);
        return subArr;
    }
}
