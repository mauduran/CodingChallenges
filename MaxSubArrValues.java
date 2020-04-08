import java.util.Deque;
import java.util.LinkedList;

public class MaxSubArrValues{
    public static void getMaxValFromSubarrays(int [] array, int k){
        int max = 0;

        for (int i = 0; i <= array.length-k; i++) {
            max = array[i];
            for (int j = 1; j < k; j++) {
                if(array[i+j]>max) max = array[i+j];
            }
            System.out.println(max);
        }
        
    }



    public static void getMaxValFromSubarraysSlidingWindow(int [] array, int k){
        Deque<Integer> maxVals = new LinkedList<>();
        int i = 0;
        for(i=0; i < array.length; i++){  
            while(maxVals.size()>0 && maxVals.peekFirst()<i-k+1){
                maxVals.pollFirst();
            }
            while(maxVals.size()>0 && array[i]>array[maxVals.peekFirst()]){
                maxVals.pollFirst();
            }
            
            maxVals.addLast(i);
            if(i+1>=k){
                System.out.println(array[maxVals.peekFirst()]);
            } 
        }
    }


    public static void main(String[] args) {
        int [] array = {10, 5, 2, 7, 8, 7};
        getMaxValFromSubarrays(array, 3);

        System.out.println("");
        System.out.println("");
        getMaxValFromSubarraysSlidingWindow(array, 3);

    }
}