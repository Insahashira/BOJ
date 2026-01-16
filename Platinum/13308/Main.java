// package Platinum13308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int city, road;
        
        city = Integer.parseInt(st.nextToken());
        road = Integer.parseInt(st.nextToken());

        int[] prices = new int[city];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Collections.reverseOrder());
        Edge[] edges = new Edge[road];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < city; i++){
            prices[i] = Integer.parseInt(st.nextToken());
        }

        //a-b-weight
        for(int i = 0; i < city; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Edge edge = new Edge(from, to, weight);
            pq.add(edge);
            edges[i] = edge;
        }

        Edge current = edges[0];
        int curPrice = 0;

        while(current != edges[road-1]){
            
        }
    }
}
