package Platinum_6549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        long[] temp;

        while(!input.equals("0")){
            Stack<long[]> stack = new Stack<>();
            long max = 0;
            String[] raw = input.split(" ");
            int count = Integer.parseInt(raw[0]);
            String[] graph = new String[count];
            System.arraycopy(raw, 1, graph,0, count);

            for (int i = 0; i < graph.length; i++) {
                long height = Integer.parseInt(graph[i]);

                if (stack.isEmpty() || height > stack.peek()[1]) stack.push(new long[]{i, height});

                else if (height < stack.peek()[1]) {
                    long postX = i;
                    while (!stack.isEmpty() && height < stack.peek()[1]) {
                        temp = stack.pop();
                        max = Math.max(max, temp[1] * (i - temp[0]));
                        postX = temp[0];
                    }
                    stack.push(new long[]{postX, height});
                }
            }
            while (!stack.isEmpty()) {
                temp = stack.pop();
                max = Math.max(max, temp[1] * (graph.length - temp[0]));
            }
            System.out.println(max);
            input = br.readLine();
        }
        br.close();
    }
}
