public class StringTrie{

    TrieNode root;

    public StringTrie(){
        this.root = new TrieNode();
    }

    public class TrieNode {
        String value = "";
        TrieNode[] children;
        boolean isFinal = false;

        public TrieNode(){
            this.children = new TrieNode[26];

            for(int i=0; i<26; i++){
                this.children[i] = null;
            }
        }

        public TrieNode(String value){
            this();
            this.value = value;
        }

    }

    public boolean insertNode(String value){
        if(value=="") return false;

        return insertNodeHelper(this.root, value, 0);
    }

    private boolean insertNodeHelper(TrieNode node, String value, int index){
        if(index>=value.length()) return false;

        char c = value.charAt(index);

        int position = valueOf(c);

        if(node.children[position]==null){
            node.children[position] = new TrieNode(value.substring(0, index+1));
            if(index+1 == value.length()) {
                node.children[position].isFinal = true;
                return true;
            }
        } else if(index+1 == value.length()){
            return false;
        }
        return insertNodeHelper(node.children[position], value, index+1);
    }

    public TrieNode lookup(String value){
        if(value==""){
            return null;
        }

        return lookupHelper(this.root, value, 0);

    }

    private TrieNode lookupHelper(TrieNode node, String value, int index){
        if(index>=value.length()) return null;
        int position = valueOf(value.charAt(index));

        if(node.children[position]==null) return null;
        else if( index + 1 == value.length() ) return node.children[position];

        return lookupHelper(node.children[position], value, index+1);

    }

    public void fillTrie(String[] words){
        for(String word: words){
            this.insertNode(word);
        }
    }

    public static int valueOf(char c){
        return c - 'a';
    }
}