package Silver1966;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        Queue<int[]> q = new LinkedList<>();

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int nums, index;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            Queue<int[]> q = new LinkedList<>();

            String[] input = br.readLine().split(" ");
            String[] priority = br.readLine().split(" ");

            nums = Integer.parseInt(input[0]);
            index = Integer.parseInt(input[1]);

            for (int j = 0; j < nums; j++) {
                int num = Integer.parseInt(priority[j]);
                pq.add(-num);
                q.add(new int[]{num, j});
            }

            int ii = 0;
            int[] temp;
            while(!pq.isEmpty() && !q.isEmpty()) {
                if(-pq.peek() == q.peek()[0]){
                    pq.poll();
                    temp = q.poll();
                    ii++;
                    if(temp[1] == index){
                        System.out.println(ii);
                        break;
                    }
                }else{
//                    temp = q.poll();
                    q.offer(q.poll());
                }
            }
        }
    }
}
