
import java.util.Stack;

public class FileExplorer{
    // public static class Node {
    //     String value;
    //     ArrayList<Node> children;
    //     int count = 0; //Maybe this is not necessary

    //     public Node(String value){
    //         this.value = value;
    //         this.children = new ArrayList<>();
    //         this.count = value.length();
    //     }

    //     public Node(String value, int count){
    //         this.value = value;
    //         this.children = new ArrayList<>();
    //         this.count = count;
    //     }

    //     public static int insertNode(Node root, String value){
    //         int numTabs = checkNumTabs(value);
    //         value = value.substring(numTabs);
    //         Node current = root;
    //         int length = root.count;

    //         for (int i = 1; i < numTabs; i++) {
    //             if(current.children.size()<1) return -1;
    //             current = current.children.get(current.children.size()-1);
    //         }

    //         length = current.count +value.length()+1;

    //         Node n = new Node(value, length);
    //         current.children.add(n);

            
    //         return (value.split("\\.").length>1)? length: 0;
    //     }
    // }

    // public static int mkFileSystem(String fileSystem){
    //     String [] elements = fileSystem.split("\n");

    //     Node root = new Node(elements[0].substring(checkNumTabs(elements[0])));
    //     int maxSize = 0;
    //     for(int i=1; i<elements.length; i++){
    //         maxSize = Math.max(Node.insertNode(root, elements[i]), maxSize);
    //     }
    //     return maxSize;
    // }

    public static int checkNumTabs(final String element){
        if(element.length()<2) return 0;

        return element.split("\t").length-1;
    }


    public static int longestPath(final String fileSystem){
        final String [] fileElements = fileSystem.split("\n");

        final Stack<String> dirs = new Stack<>();
        int depthCount = 0;
        int longestPath = 0;
        int currentPath = 0;

        for (String element : fileElements) {
            depthCount = checkNumTabs(element);
            element = element.substring(depthCount);

            while(depthCount < dirs.size()){
                final String deleted = dirs.pop();
                currentPath -= deleted.length();
            }


            if(element.contains(".")){
                longestPath = Math.max(longestPath, currentPath + element.length());
            } else{
                element += "/";
                currentPath += element.length();
                dirs.add(element);
            }
        }
        return longestPath;
    }




    public static void main(final String[] args) {
        // mkFileSystem("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ex");

        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println(longestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        
        
        // System.out.println("dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext");
        // System.out.println(mkFileSystem("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));

        // System.out.println("");
        // System.out.println("");

        // System.out.println("dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext");
        // System.out.println(mkFileSystem("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

}