package GOold1238;

import java.util.*;
import java.io.*;


public class Main {
    private static class Node implements Comparable<Node> {
        int from, to, weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Node that) {
            return this.weight - that.weight;
        }
    }

    static PriorityQueue<Node> pq = new PriorityQueue<Node>();
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count, roads, target;
        count = Integer.parseInt(st.nextToken());
        roads = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        cost = new int[count];

        for (int i = 0; i < count; i++) cost[i] = 0x7fffffff;

        for (int i = 0; i < roads; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Node(from, to, cost));
        }

        dji(target);
    }

    public static void dji(int target) {

    }
}
