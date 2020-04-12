import java.util.ArrayList;

/**
 * JustifyText
 */

 /*
    Write an algorithm to justify text. Given a sequence of words and an integer line length k,
     return a list of strings which represents each line, fully justified.

    you should have as many words as possible in each line. There should be at least one space between each word. 
    Pad extra spaces when necessary so that each line has exactly length k. Spaces should be distributed as equally 
    as possible, with the extra spaces, if any, distributed starting from the left.
    */
public class JustifyText {

    public static String buildString(String[] words, int low, int high, int k, int wordsLength){
        String str = "";
        int numSpaces;

        if(low==high){
            str += words[low];
            numSpaces = k-wordsLength;
            for(int i=0; i<numSpaces;i++){
                str+=" ";
            }

        } else{
            numSpaces = (k - wordsLength) / (high-low);
            int extraSpaces = (k - wordsLength) % (high-low);
    
            for(int i=low; i<=high;i++){
                str += words[i];
                if(i==high) break;
                for(int j = 0; j<numSpaces; j++){
                    str += " ";
                }
                str += (extraSpaces>0)? " ": "";
                extraSpaces--;
            }
        }

        return str;
    }

    public static ArrayList<String> justifyText(String[] words, int k){
        ArrayList<String> justifiedText = new ArrayList<>();

        int i=0;

        int low=0;
        int high=0;
        int wordsLength;
        int numWords;

        
        while(i<words.length){
            wordsLength = 0;
            numWords = 0;

            while(i<words.length){
                if(wordsLength+words[i].length() + numWords-1<=k){
                    wordsLength += words[i].length();
                    numWords +=1;
                    high = i;
                    i++;
                } else{
                    break;
                }
            }

            justifiedText.add(buildString(words, low, high, k, wordsLength));
            

            low = high+1;
        }

        return justifiedText;
    }

    public static void main(String[] args) {
        String [] words= {"the", "quick", "brown", "paranguaricuti", "fox", "jumps", "over", "the", "lazy", "dog"};

        ArrayList<String> justifiedText = justifyText(words, 16);

        for (String string : justifiedText) {
            System.out.println(string);
        }
    }
}