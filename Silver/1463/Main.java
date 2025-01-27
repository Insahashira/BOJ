package Silver1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int[] arr= new int[input+1];
        br.close();

        int pointer = 1;
        while(pointer != input+1){
            if(pointer == 1) arr[pointer] = 0;
            else if(pointer % 2 == 0 && pointer % 3 == 0) arr[pointer] = Math.min(arr[pointer-1], Math.min(arr[pointer/2], arr[pointer/3])) + 1;
            else if(pointer % 2 == 0) arr[pointer] = Math.min(arr[pointer-1], arr[pointer/2]) + 1;
            else if(pointer % 3 == 0) arr[pointer] = Math.min(arr[pointer-1], arr[pointer/3]) + 1;
            else arr[pointer] = arr[pointer-1] + 1;
            pointer++;
        }
        System.out.println(arr[input]);
        for(int a : arr) System.out.print(a + " ");
        // DFS Failed (Memory Issue) Using DP
//        int[] temp = {input, 0};
//        stack.push(temp);
//        while(!stack.isEmpty()){
//            int[] target = stack.pop();
//
//            if(target[0] == 1) {
//                if (count == -1) count = target[1];
//                else if (target[1] < count) count = target[1];
//                continue;
//            }
//            if(target[0] % 2 == 0) {
//                int[] newNum = {target[0] / 2, target[1] + 1};
//                stack.push(newNum);
//            }
//            if(target[0] % 3 == 0){
//                int[] newNum = {target[0] / 3, target[1] + 1};
//                stack.push(newNum);
//            }
//            target[0]--;
//            target[1]++;
//            stack.push(target);
//        }
    }
}
