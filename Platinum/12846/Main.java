import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> stack = new Stack<>();

        int count = Integer.parseInt(in.readLine());
        String[] input = in.readLine().split(" ");
        int max = 0;

        for (int i = 0; i < count; i++) {
            int a = Integer.parseInt(input[i]);
            if (stack.isEmpty()) {
                stack.push(new int[] {i, a});
            } else if (stack.peek()[1] < a) {
                    stack.push(new int[] {i, a});
            } else if (stack.peek()[1] >= a) {
                int[] temp = {i, a};
                while(!stack.isEmpty() && stack.peek()[1] >= a) {
                    temp = stack.pop();
                    max = Math.max(max, temp[1] * (i - temp[0]));
                }
                stack.push(new int[] {temp[0], a});
            }
        }
        while(!stack.isEmpty()) {
            int[] temp = stack.pop();
            max = Math.max(max, temp[1] * (count - temp[0]));
        }
        System.out.println(max);
    }
}
