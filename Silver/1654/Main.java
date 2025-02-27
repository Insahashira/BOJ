package Silver12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int already = Integer.parseInt(st.nextToken());
        int needed = Integer.parseInt(st.nextToken());
        long max = 0;
        long min = 0;

        int[] arr = new int[already];

        for(int i = 0; i < already; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long slice = 0;
        for(int i = 0; i < already; i++) slice += arr[i] / max;
        if(slice == needed){
            System.out.println(max);
            return;
        }

        long up = max;
        long pointer = max/2;
        while(pointer < up){
            pointer = min != 0 ? (max + min)/2 : max/2;
            if(pointer == min){
                System.out.println(pointer);
                return;
            }

            slice = 0;
            for(int i = 0; i < already; i++) slice += arr[i] / pointer;

            if (slice < needed) max = pointer;
            else min = pointer;
        }
        System.out.println(pointer + 1);
    }
}
