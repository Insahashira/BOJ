package Silver15903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        st.nextToken();
        int count = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            pq.add((long) Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < count; i++) {
            long temp1 = pq.poll();
            long temp2 = pq.poll();

            long result = temp1 + temp2;
            pq.add(result);
            pq.add(result);
        }
        long result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }
        System.out.println(result);
    }
}
