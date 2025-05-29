package Gold6051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
    private static class Node {
        private int val;
        private Node prev;
        
        public Node(int val, Node prev) {
            this.val = val;
            this.prev = prev;
        }

        public int getVal() {return val;}

        public Node getPrev() {return prev;}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int count = Integer.parseInt(st.nextToken());
        int temp;
        Node[] list = new Node[count + 1];

        for (int i = 1; i < count + 1; i++) {
            st = new StringTokenizer(in.readLine());
            switch (st.nextToken().charAt(0)) {
                case 'a':
                    temp = Integer.parseInt(st.nextToken());
                    list[i] = new Node(temp, list[i - 1]);
                    printer(list[i]);
                    continue;
                case 's':
                    list[i] = list[i - 1].getPrev();
                    printer(list[i]);
                    continue;
                case 't':
                    temp = Integer.parseInt(st.nextToken());
                    list[i] = list[temp - 1];
                    printer(list[i]);
            }
        }
    }

    public static void printer(Node n){
        if(n == null) System.out.println(-1);
        else System.out.println(n.getVal());
    }
}
