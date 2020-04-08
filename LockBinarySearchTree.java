
public class LockBinarySearchTree<T extends Comparable<T>> {
    static class Node<T extends Comparable<T>>{
        T value;
        Node<T> parent = null;
        Node<T> left = null;
        Node<T> right = null;
        boolean isLocked;
        int childrenLocked;

        Node(T value){
            this.value = value;
            this.isLocked = false;
            this.childrenLocked = 0;
        }

        Node(T value, Node<T> parent){
            this(value);
            this.parent = parent;
        }

        boolean isLocked(){
            return this.isLocked;
        }

        boolean isValidNode(){

            if(this.childrenLocked>0) return false;

            Node<T> current = this.parent;
            while(current!=null){
                if(current.isLocked) return false;
                current = current.parent;
            }
            return true;

        }
    }

    int size;
    Node<T> root;

    LockBinarySearchTree(){
        this.size = 0;
        this.root = null;
    }

    public boolean isLocked(Node<T> node){
        return node.isLocked;
    }

    public boolean isLocked(T value){
        Node<T> n = this.search(value);

        if(n==null || !n.isLocked) return false;
        return true;
    }

    public boolean LockNode(Node<T> node){
        if(node==null || node.childrenLocked>0) return false;

        if(!node.isValidNode()) return false;

        node.isLocked = true;

        Node<T> current = node.parent;

        while(current!=null){
            current.childrenLocked++;
            current = current.parent;
        }

        return true;
    }

    public boolean LockNode(T value){
        return LockNode(this.search(value));
    }

    public boolean UnlockNode(Node<T> node){
        if(node==null || node.childrenLocked>0) return false;

        if(!node.isValidNode()) return false;

        node.isLocked = false;

        Node<T> current = node.parent;

        while(current!=null){
            current.childrenLocked--;
            current = current.parent;
        }

        return true;
    }

    public boolean UnlockNode(T value){
        return UnlockNode(this.search(value));
    }


    public Node<T> search(T value){
        if(this.root == null) return null;
        
        Node<T> current = this.root;

        while(current!=null){
            int result = value.compareTo(current.value);
            if(result==0) return current;

            if(result<0){
                if(current.left== null){
                    return null;
                } else{
                    current = current.left;
                }
            } else{
                if(current.right== null){
                    return null;
                } else{
                    current = current.right;
                }
            }
        }
        return null;
    }

    public boolean add(T value){
        if(this.root == null){
            this.root = new Node<T>(value);   
            this.size++;
            return true;     
        }
        
        Node<T> current = this.root;

        while(current!=null){
            int result = value.compareTo(current.value);
            if(result==0) return false;

            if(result<0){
                if(current.left== null){
                    this.size++;
                    current.left = new Node<T>(value, current);
                    return true;
                } else{
                    current = current.left;
                }
            } else{
                if(current.right== null){
                    this.size++;
                    current.right = new Node<T>(value, current);
                    return true;
                } else{
                    current = current.right;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        LockBinarySearchTree<Integer> tree= new LockBinarySearchTree<>();

        tree.add(8);
        tree.add(3);
        tree.add(10);
        tree.add(1);
        tree.add(6);
        tree.add(14);
        tree.add(4);
        tree.add(7);
        tree.add(13);


        tree.LockNode(6);

        System.out.println(tree.LockNode(3));

        tree.UnlockNode(6);


        System.out.println(tree.LockNode(3));

        System.out.println("\n\nHola\n\n");
    }
}