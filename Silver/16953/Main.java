package Silver16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        if(!bfs(input, 0)){
            System.out.println(-1);
        }
    }

    static boolean bfs(long input, int count){
        count++;
        if (input == target) {
            System.out.println(count);
            return true;
        }else if(input > target){
            return false;
        }
        if(bfs(input * 10 + 1, count) || bfs(input * 2, count)){
            return true;
        }
        return false;
    }
}

