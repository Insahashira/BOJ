package Silver11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        String[] nums = br.readLine().split(" ");
        int aSize = Integer.parseInt(nums[0]);
        int bSize = Integer.parseInt(nums[1]);

        String[] arr = br.readLine().split(" ");
        for(int i = 0; i < aSize; i++) {
            pq.add(Integer.parseInt(arr[i]));
        }

        arr = br.readLine().split(" ");
        for(int i = 0; i < bSize; i++) {
            pq.add(Integer.parseInt(arr[i]));
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }

        System.out.println(sb);
    }
}
