package Bronze1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        while(st.hasMoreTokens()){
            int x = Integer.parseInt(st.nextToken());
            if(x == 1){
                count++;
                continue;
            }
            for(int i = 2; i <= Math.sqrt(x); i++){
                if(x % i == 0){
                    count++;
                    break;
                }
            }
        }
        System.out.println(total - count);
    }
}
