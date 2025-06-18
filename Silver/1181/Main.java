package Silver1181;

//따로 클래스 만들어서 pq로 정렬

import java.io.*;
import java.util.*;

public class Main {
    private static class Node implements Comparable<Node> {
        private String name;
        private int size;

        public Node(String name) {
            this.name = name;
            this.size = name.length();
        }

        public int compareTo(Node o) {
            if (this.size == o.size) return name.compareTo(o.name);
            return this.size - o.size;
        }

        public boolean equals(Object o) {
            return this.name.equals(((Node)o).name);
        }

        public String getString(){
            return this.name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++){
            Node temp = new Node(br.readLine());
            if(pq.contains(temp)){continue;}
            pq.add(temp);
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) sb.append(pq.poll().getString()).append("\n");
        System.out.print(sb.toString());
    }
}