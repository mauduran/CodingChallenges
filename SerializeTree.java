

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeTree {
	public static class Node{
		String value = "";
		Node left = null;
		Node right = null;
		
		public Node(String value) {
			this.value = value;
		}
		
		public Node(String value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
		public static String serialize(Node n) {
			LinkedList<Node> nodes = new LinkedList<>();
			nodes.add(n);
			String series = "";
			Node current = null;
			while(current!=null || nodes.size()>0) {
				current = nodes.pollFirst();
				
				if(current!=null) {
					nodes.add(current.left);
					nodes.add(current.right);
					
					series = series.concat(current.value + "->");
				} else {
					series = (nodes.size()>0)?series.concat("null->"):series.concat("null");
				}
				
			}
			
			return series;
			
			
		}
		
		private static String recursiveSerialize(Node n) {
			if(n == null) return "null";
			
			return (n==null)? "null": n.value.concat("->" + recursiveSerialize(n.left).concat("->" +recursiveSerialize(n.right)));
		}
		
		public static Node deserialize(String serializeStr) {
			String [] nodesStr = serializeStr.split("->");
			
			LinkedList<String> nodes = new LinkedList<>(Arrays.asList(nodesStr));
			
			return recursiveDeserialize(nodes);
		}
		
		private static Node recursiveDeserialize(LinkedList<String> nodes){
			String n = nodes.pollFirst();
			
			if(n=="null") return null;
			
			Node node = new Node(n);
			
			if(nodes.size()>0) {
				node.left = recursiveDeserialize(nodes);
				node.right = recursiveDeserialize(nodes);
			}
			
			
			return node;
		}
		
	}

	public static void main(String[] args) {
		Node node = new Node("root", new Node("left", new Node("left.left"), null), new Node("right"));

		
		Node temp = Node.deserialize(Node.recursiveSerialize(node));
		System.out.println(temp.left.left.value);
		
//		Node.deserialize(Node.serialize(node)).left.left.value;
		
		System.out.println("ok");
	}
}
