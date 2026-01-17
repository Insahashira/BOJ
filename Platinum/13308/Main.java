// package Platinum13308;

import java.io.*;
import java.util.*;

public class Main {
    private static class Node implements Comparable<Node>{
        int to, lowestGas; 
        long totalPrice;

        public Node(int to, int lowestGas, long totalPrice){
            this.to = to;
            this.lowestGas = lowestGas;
            this.totalPrice = totalPrice;
        }

        @Override
        public int compareTo(Node e){
            return Long.compare(this.totalPrice, e.totalPrice);
        }
    }

    private static class Edge implements Comparable<Edge>{
        int to, weight;

        public Edge(int to, int weight){
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

        int[] price = new int[city];
        long[][] dis = new long[city][2502];
        ArrayList<Edge>[] al = new ArrayList[city];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < city; i++){
            al[i] = new ArrayList<>();
            price[i] = Integer.parseInt(st.nextToken());
            for(int ii = 1; ii < 2502; ii++) dis[i][ii] = Long.MAX_VALUE;
        }
        
        //a-b-weight
        for(int i = 0; i < road; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            al[from].add(new Edge(to, weight));
            al[to].add(new Edge(from, weight));
        }
        dis[0][price[0]] = 0;

        pq.add(new Node(0, price[0], 0));

        //a-b
        while(!pq.isEmpty()){
            //a
            Node a = pq.poll();
            // System.out.println("polled");

            int a_index = a.to;
            long a_dis = a.totalPrice;
            int gas_price = Math.min(a.lowestGas, price[a_index]);

            if(a_dis > dis[a_index][gas_price]) continue;
            
            for(Edge b: al[a_index]){

                int b_index = b.to;

                int b_weight = b.weight;
                
                long b_dis = dis[b_index][gas_price];
                
                long new_price = a_dis + (b_weight * gas_price);
                
                dis[b_index][2501] = Math.min(dis[b_index][2501], new_price);
                //processing edge
                if(new_price < b_dis){
                    dis[b_index][gas_price] = new_price;
                    pq.add(new Node(b_index, gas_price, new_price));
                }
            }
            if(a.to == city - 1){
                // System.out.println("distance dump");
                // for(int i = 0; i < city; i++){
                //     System.out.print(dis[i][2501] + " ");
                // }
                System.out.println(dis[city-1][2501]);
                break;
            }
        }
    }
}
