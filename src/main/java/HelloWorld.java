package src.main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HelloWorld{
    public static void main (String[] args) {
        System.out.println("hello World");
        List<List<Integer>> aList=new ArrayList<List<Integer>>();
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(0);
        a1.add(3);
        aList.add(a1);

        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(1);
        a2.add(2);
        aList.add(a2);

        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(0);
        a3.add(2);
        aList.add(a3);
        smallestStringWithSwaps("dcab",aList);
    }
    public static int findRoot(int arr[],int root){
        while(arr[root]!=root){
            root=arr[root];
        }
        return root;
    }
        public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            int strLength=s.length();
            int arr[] = new int[strLength];
            int sizeArr[] = new int[strLength] ;
            int rootArr[] = new int[strLength] ;
            HashMap<Integer,List<Integer>> hashMap = new HashMap<>();

            for(int i=0;i<strLength;i++){
                arr[i]=i;
                sizeArr[i]=1;
                rootArr[i]=i;
            }
            ArrayList<Integer> listOfGivenIndexes = new ArrayList<Integer>();
            for(int j=0; j<pairs.size();j++){
                List<Integer> list=pairs.get(j);

                int x = list.get(0);
                int y = list.get(1);
                listOfGivenIndexes.add(x);
                listOfGivenIndexes.add(y);
                if (sizeArr[x]>sizeArr[y]){
                    arr[y]=arr[x];
                    sizeArr[x]+=sizeArr[y];
                }
                else{
                    arr[x] = arr[y];
                    sizeArr[y]+=sizeArr[x];
                }
            }

            for(int k=0;k<listOfGivenIndexes.size();k=k+2){
                int index1=listOfGivenIndexes.get(k);
                int index2=listOfGivenIndexes.get(k+1);
                int root=findRoot(arr,index1);
                ArrayList<Integer> listOfConnectedIndexes = new ArrayList<Integer>();
                listOfConnectedIndexes.add(index1);
                listOfConnectedIndexes.add(index2);
                if(hashMap.containsKey(root)){
                    ArrayList<Integer> alreadyConnectedIndexes=(ArrayList<Integer> )hashMap.get(root);
                    alreadyConnectedIndexes.addAll(listOfConnectedIndexes);
                    hashMap.replace(root,alreadyConnectedIndexes);
                }
                else {
                    hashMap.put(root,listOfConnectedIndexes);
                }
            }

            return "";
        }

}