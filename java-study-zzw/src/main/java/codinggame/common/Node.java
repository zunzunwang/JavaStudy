package codinggame.common;

/**
 * Created by zunzunwang
 * Date: 04/04/2025
 */

public class Node{
        Node left,right;
        int value;

        public Node(Node left, Node right, int value){
            this.value = value;
            this.right = right;
            this.left = left;
        }

        public int getValue(){
            return value;
        }

        public Node find(int v) {
            if(v == 0) return new Node(null,null,0);
            else if(v ==this.value) return this;
            else if(this.left == null && this.right == null) return null;
            else if (v > this.value) return this.right.find(v);
            else if (v < this.value) return this.left.find(v);
            else return null;
        }

        public Node findV2(int v) {
            if(this.left == null && this.right == null && this.value != v){
                return null;
            }
            Node current = this;

            while(current != null) {
                if(current.value == v){
                    return current;
                } else {
                    current = current.value < v ? current.right : current.left;
                }
            }
            return current;
        }


    }
