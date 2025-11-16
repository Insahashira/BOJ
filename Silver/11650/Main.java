package Silver11650;

//따로 클래스 만들어서 pq로 정렬

import java.io.*;
import java.util.*;

public class Main {
    private static class Node implements Comparable<Node> {
        private int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Node o) {
            if (this.x == o.x) {return this.y - o.y;}
            return this.x - o.x;
        }

        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Node(x, y));
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) sb.append(pq.poll().toString()).append("\n");
        System.out.print(sb.toString());
    }
}