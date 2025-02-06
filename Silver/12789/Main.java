package Silver12789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        int order = 1;

        for(int i = 0 ; i < count; i++){
            int num = Integer.parseInt(input[i]);

            if(num == order) order++;
            else stack.push(num);
            while(!stack.isEmpty() && stack.peek() == order){
                stack.pop();
                order++;
            }
//            System.out.println("order: " + order + " num: " + i);
        }
//        System.out.println("------------");
        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }
}
