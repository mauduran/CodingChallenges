import java.util.HashSet;

public class CountElements {

    public static int countElements(int [] arr){
        int count = 0;

        HashSet<Integer> existingElements = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            existingElements.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if(existingElements.contains(arr[i]+1)) count++;
        }

        return count;
    }
    public static void main(String[] args) {

        // int [] arr = {1,2,3};
        // int [] arr = {1,1,3,3,5,5,7,7};
        int [] arr = {1,3,2,3,5,0};
        // int [] arr = {1,1,2,2};
        System.out.println(countElements(arr));
        
    }
}