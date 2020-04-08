public class StaircaseProblem{
    public static int waysToClimbStairs(int N, int[] steps){
        int [] results = new int[N+1];
        results[N] = 1;
        return climbingStairsHelper(0, N, steps, results);
    }

    static int count = 0;

    public static int climbingStairsHelper(int current, int N, int[] steps, int[] results){
        if(current>N) return 0;

        int sum = 0;

        for (int i : steps) {
            count++;
            if(current+i<=N){
                results[current+i] = (results[current+i]>0)? results[current+i] : climbingStairsHelper(current+1, N, steps, results);
                sum += results[current+i];
            }
        }
        return sum;
    }



    public static void main(String[] args) {
        int[] steps = {1,2};
        System.out.println(waysToClimbStairs(4, steps));

        System.out.println(count);
    }
}