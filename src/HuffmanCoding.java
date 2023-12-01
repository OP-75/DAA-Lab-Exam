import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    char c;
    Node left, right;
    int freq;

    Node(char _c, int _freq){
        c = _c;
        freq = _freq;

        left = null;
        right = null;
    }
    
    Node(int _freq, Node _left, Node _right){
        freq = _freq;
        left = _left;
        right = _right;
    }

    @Override
    public int compareTo(Node o) {
        return this.freq - o.freq;
    }
}

public class HuffmanCoding {
    
    //Time O(nlogn), space O(n)
    
    static Node makeHuffmanTree(char[] carr, int[] freqArr){

        PriorityQueue<Node> pq = new PriorityQueue<>();

        //adding all the chars to PQ
        for (int i = 0; i < freqArr.length; i++) {
            pq.add(new Node(carr[i], freqArr[i]));
        }


        while (pq.size()>1) {
            //pop until only 1 node remains (ie root node)

            //pop 2 elements with lowest freq
            Node n1 = pq.poll();
            Node n2 = pq.poll();

            Node newNode = new Node(n1.freq+n2.freq, n1, n2);

            pq.add(newNode);
        }

        return pq.peek();
    }

    static void printEncodings(Node root, String enc){
        //recursive tree traversal

        //base case:
        if (root.left==null && root.right==null) {
            System.out.println(root.c + " - " + enc);
            return; // ! return caz we cant go any further down
        }

        printEncodings(root.left, enc+"0");
        printEncodings(root.right, enc+"1");
    }


    public static void main(String[] args) {

        char[] carr = {'a', 'b', 'c'};
        int[] freqArr = {3, 2 , 1}; 

        Node root = makeHuffmanTree(carr, freqArr);
        printEncodings(root, "");
    }

}
