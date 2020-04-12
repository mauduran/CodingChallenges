import java.util.PriorityQueue;

public class LastStone {
    public static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> bigStones = new PriorityQueue<>((x,y)->y-x);

        for (int stone : stones) {
            bigStones.add(stone);
        }


        while(!bigStones.isEmpty()){
            if(bigStones.size()==1) return bigStones.peek();

            int a = bigStones.poll();
            int b = bigStones.poll();

            if(a==b) continue;

            bigStones.add(Math.abs(a-b));
        }
        
        return 0; //All rocks were destroyed
    }

    public static void main(String[] args) {
        int [] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}