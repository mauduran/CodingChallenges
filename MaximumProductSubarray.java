import java.util.Stack;


public class MaximumProductSubarray {
    public static int maxProductOP(int[] nums){
        int currentNegative = Integer.MIN_VALUE;
        int currentPositive = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                currentNegative = Integer.MIN_VALUE;
                currentPositive = Integer.MIN_VALUE;
                max = Math.max(0, max);
            } else if(nums[i] < 0) { // negative
                int tempPositive = currentPositive;
                currentPositive = currentNegative == Integer.MIN_VALUE ? Integer.MIN_VALUE : currentNegative * nums[i];
                currentNegative = tempPositive == Integer.MIN_VALUE ? nums[i] : tempPositive * nums[i];
            } else if(nums[i] > 0) { // positive
                currentPositive = currentPositive == Integer.MIN_VALUE ? nums[i] : currentPositive * nums[i];
                currentNegative = currentNegative == Integer.MIN_VALUE ? Integer.MIN_VALUE : currentNegative * nums[i];
            }
            
            max = Math.max(max, Math.max(currentPositive, currentNegative));
        }
        return max;
    }

    public static int maxProduct(int[] nums) {
        Stack<Integer> negativeIndex = new Stack<>();

        if(nums.length==1) return nums[0];
        int maxProduct = Integer.MIN_VALUE;
        boolean oddNegatives = false;
        int currentProduct = 1;
        int tempProduct = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>maxProduct) maxProduct = nums[i];

            if(nums[i]==0){
                if(!negativeIndex.isEmpty()){
                    tempProduct = 1;
                    for(int j=negativeIndex.pop()+1; j<i; j++){
                        tempProduct *= nums[j];
                        if(tempProduct>maxProduct) maxProduct = tempProduct;
                    }
                    currentProduct=1;
                    oddNegatives = false;
                    continue;
                }
            }

            if(nums[i]<0){
                oddNegatives = !oddNegatives;
                if(oddNegatives) negativeIndex.push(i);
                else negativeIndex.pop();
            }

            currentProduct *= nums[i];

            if(currentProduct>maxProduct) maxProduct = currentProduct;
        }

        if(!negativeIndex.isEmpty()){
            tempProduct = 1;
            for(int j=negativeIndex.pop()+1; j<nums.length; j++){
                tempProduct *= nums[j];
                if(tempProduct>maxProduct) maxProduct = tempProduct;
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int [] array = {2,-5,-2,-4,3};
        System.out.println(maxProduct(array));

        System.out.println(maxProductOP(array));
    }
}