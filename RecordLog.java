import java.util.Arrays;

public class RecordLog{
    int[] records;
    int current = -1;

    public RecordLog(int N){
        this.records = new int[N];
    }

    public void record(int order_id){
        this.current = (this.current+1)%records.length;
        this.records[this.current] = order_id;
    }

    public int get_last(int i){
        return this.records[(this.current-i+this.records.length)%this.records.length];
    }


    public static void main(String[] args) {
        RecordLog myLog = new RecordLog(10);

        for (int i = 1; i < 14; i++) {
            myLog.record(i);
        }

        System.out.println(myLog.get_last(1));

        System.out.println(myLog.get_last(4));

        String [] partials = "hola\ncomo\nestas".split("\n");

        System.out.println(Arrays.toString(partials));
        
        
    }
}

/*
    [1,2,3,4,5] N=5
    0-3+5= 2

    4-2


    if(current-i>0){
        current - i;
    } else{
        current-i +
    }
    
*/