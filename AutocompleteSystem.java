import java.util.ArrayList;

public class AutocompleteSystem {

    public static ArrayList<String> autocompleteString(StringTrie trie, String value){
        StringTrie.TrieNode  node = trie.lookup(value);
        ArrayList<String> predictedWords = new ArrayList<>();
        
        autocompleteStringHelper(node, predictedWords);

        return predictedWords;

    }

    private static void autocompleteStringHelper(StringTrie.TrieNode node, ArrayList<String> predictedWords){
        if(node==null) return;

        for(StringTrie.TrieNode child: node.children){
            if(child!=null){
                if(child.isFinal){
                    predictedWords.add(child.value);
                } else{
                    autocompleteStringHelper(child, predictedWords);
                }
            }
        }

    }

    public static void main(String[] args) {
        StringTrie autocompleter = new StringTrie();

        String [] words = {"dog", "deer", "deal"};

        autocompleter.fillTrie(words);

        // StringTrie.TrieNode fragment = autocompleter.lookup("de");

        ArrayList<String> result = autocompleteString(autocompleter, "de");

        System.out.println(result.toString());

        System.out.println("success");
    }
}