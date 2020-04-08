/**
 * DCP19PaintHouses
 */
public class DCP19PaintHouses {

    public static int minCostII(int[][] costs) {
        if(costs.length==0) return 0;
        if (costs.length == 1 && costs[0].length==1) {
            return costs[0][0];
        }
        
        int minVal = Integer.MAX_VALUE, secondMinVal = Integer.MAX_VALUE;
        int minValTemp, secondMinValTemp;
        
        for (int i=0; i<costs.length; i++) {
            minValTemp = Integer.MAX_VALUE;
            secondMinValTemp = Integer.MAX_VALUE;
            for(int j=0; j<costs[0].length; j++){
                if(i!=0){
                    costs[i][j] += (costs[i-1][j]==minVal)? secondMinVal: minVal;
                }
                
                if(costs[i][j]<minValTemp){
                    secondMinValTemp = minValTemp;
                    minValTemp = costs[i][j];
                } else if(costs[i][j]<secondMinValTemp) secondMinValTemp = costs[i][j];
            }
            minVal = minValTemp;
            secondMinVal = secondMinValTemp;
        }
        return minVal;
        // write your code here
    }

    public static void main(String[] args) {
        int [] [] costs = {{1,2,3}, {1,4,6}};
        
        System.out.println(minCostII(costs));
    }
}