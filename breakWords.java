import java.util.ArrayList;
import java.util.List;

public class breakWords {
    public static ArrayList<String> wordBreak(String s, List<String> wordDict) {
        ArrayList<String> solution = new ArrayList<>();
        // wordDict.sort((a,b)->a.length()<b.length()? -1: b.length()<a.length()? -1: 0);
        return (recursiveWordBreak(s, wordDict, solution))?solution: null;

    }


    private static boolean recursiveWordBreak(String s, List<String> wordDict, ArrayList<String> solution){
        if(s.length()==0 || s==null) return true;
        for(String word: wordDict){
            if(s.startsWith(word)){
                solution.add(word);

                if(recursiveWordBreak(s.substring(word.length()), wordDict, solution)) return true;

                solution.remove(word);
            }
        }

        return false;
    }

    public static ArrayList<ArrayList<String>> wordBreak2(String s, List<String> wordDict) {
        ArrayList<String> solution = new ArrayList<>();
        ArrayList<ArrayList<String>> solSet = new ArrayList<>();
        // wordDict.sort((a,b)->a.length()<b.length()? -1: b.length()<a.length()? 1: 0);
        recursiveWordBreak2(s, wordDict, solution, solSet);

        return solSet;
    }

    private static boolean recursiveWordBreak2(String s, List<String> wordDict, ArrayList<String> solution, ArrayList<ArrayList<String>> solSet){
        if(s.length()==0 || s==null) return true;
        for(String word: wordDict){
            if(s.startsWith(word)){
                solution.add(word);

                if(recursiveWordBreak2(s.substring(word.length()), wordDict, solution, solSet)){
                    solSet.add(new ArrayList<>(solution));
                }

                solution.remove(word);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> wordDict = List.of("bed", "bath", "bedbath", "and", "beyond");

        ArrayList<ArrayList<String>> solSet = wordBreak2("bedbathandbeyond", wordDict);
        // System.out.println(wordBreak("bedbathandbeyond", wordDict));


        System.out.println("\n\nInicio");
        for(ArrayList<String> solution: solSet){
            System.out.println(solution);
        }

        System.out.println("Fin");
    }
}