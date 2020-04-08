import java.util.HashSet;

/**
 * HappyNumbers
 */
public class HappyNumbers {
    public static int calculateSquaredDigitSum(int number){
        int value = 0;
        int i = 10;

        while(number > 0){
            value += (number%i)*(number%i);
            number -= number%i;
            number/=10;
        }
        return value;
    }

    public static boolean isHappyNumber(int number){
        if(number<1) return false;

        HashSet<Integer> encounteredNumbers = new HashSet<>();
        while(true){
            if(number==1) return true;
            number = calculateSquaredDigitSum(number);
            if(encounteredNumbers.contains(number)) return false;
            encounteredNumbers.add(number);
        }

    }
    public static void main(String[] args) {
        System.out.println(isHappyNumber(19));
        System.out.println(calculateSquaredDigitSum(100));
    }
}