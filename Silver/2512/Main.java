package Silver2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < count; i++) {
            temp = Integer.parseInt(st.nextToken());
            pq.add(temp);
            sum += temp;
        }
        int budget = Integer.parseInt(br.readLine());
        if(sum > budget) {
            int avg = budget / count;
            while(!pq.isEmpty() && pq.peek() <= avg) {
                temp = pq.poll();
                budget -= temp;
//                sum -= temp;
                count--;
                avg = budget / count;
            }
            System.out.println(avg);

        } else {
            int max = 0;
            while(!pq.isEmpty()) {
                max = pq.poll();
            }
            System.out.println(max);

        }
    }
}
