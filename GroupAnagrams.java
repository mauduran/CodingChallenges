import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {


    public static List<List<String>> groupAnagramsI(String[] strs){
        // List<List<String>> groups = new ArrayList<>();

        HashMap<String, ArrayList<String>> anagrams = new HashMap<>();

        for(String str: strs){
            char [] temp = str.toCharArray();
            Arrays.sort(temp);
            String tmp = new String(temp);

            if(!anagrams.containsKey(tmp)){
                anagrams.put(tmp, new ArrayList<>());
            }

            anagrams.get(tmp).add(str);
        }

        // for(ArrayList<String> list: anagrams.values()){
        //     groups.add(list);
        // }

        return new ArrayList<>(anagrams.values());

    }

    


    public static void main(String[] args) {

        String [] strs ={"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = groupAnagramsI(strs);

        for(List<String> list: result){
            System.out.println(list);
        }
    }
}