import java.util.Stack;

/**
 * BackSpaceCompare
 */
public class BackSpaceCompare {
    //Version 1 using stacks
    public static boolean backspaceCompare(String s, String t){
        Stack<Character> stringA = new Stack<>();
        Stack<Character> stringB = new Stack<>();

        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if(temp=='#') {
                if(!stringA.isEmpty()){
                    stringA.pop();
                }   
            }
            else{
                stringA.push(temp);
            }
        }
        
        for (int i = 0; i < t.length(); i++) {
            temp = t.charAt(i);
            if(temp=='#'){
                if(!stringB.isEmpty()){
                    stringB.pop();
                }     
            } 
            else{
                stringB.push(temp);
            }
        }

        return stringA.equals(stringB);
    }

    public static boolean backspaceCompare2(String S, String T){
        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("a#c", "b"));
    }
}