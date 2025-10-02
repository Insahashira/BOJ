package GOold1275;

import java.util.*;
import java.io.*;

public class Main {
    static long[] arr;
    static int padded_size, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        count = Integer.parseInt(st.nextToken());
        int operations = Integer.parseInt(st.nextToken());

        padded_size = find_sq(count);

        arr = new long[padded_size * 2];

        // fill leaf node of tree
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) arr[padded_size + i - 1] = Integer.parseInt(st.nextToken());

        build();

        // operate it
        for (int i = 0; i < operations; i++) {
            int from, to;
            st = new StringTokenizer(br.readLine());
            int in1 = Integer.parseInt(st.nextToken()) - 1;
            int in2 = Integer.parseInt(st.nextToken()) - 1;

            if(in1 > in2){
                from = in2;
                to = in1;
            }else{
                from = in1;
                to = in2;
            }

            find(padded_size + from - 1, padded_size + to - 1);

            int index = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());

            arr[index + padded_size - 1] = value;
            update(index + padded_size - 1);
        }
    }

    public static int find_sq(int count){
        int eee = 1;
        while(eee < count) eee = eee << 1;
        return eee;
    }

    //bottom-up build of segment tree
    public static void build(){
        for (int i = padded_size - 2; i >= 0; --i){
            int left, right;
            left = ((i + 1) << 1) -1;
            right = ((i + 1) << 1);
            arr[i] = arr[left] + arr[right];
        }
    }

    //bottom-up update of segment tree
    public static void update(int index){
        for (int i = (index - 1) >> 1; i >= 0; i = (i - 1) >> 1) {
            int left, right;
            left = ((i + 1) << 1) - 1;
            right = ((i + 1) << 1);
            arr[i] = arr[left] + arr[right];
        }
    }

    public static void find(int from, int to){
        long sum = 0;
        if(from == to){
            System.out.println(arr[from]);
            return;
        }

        while(from < to){
            if(from % 2 == 0){
                sum += arr[from];
                from = from >> 1;
            }else{
                from = (from - 1) >> 1;
            }

            if(to % 2 == 0){
                to = (to - 1) >> 1;
            }else{
                sum += arr[to];
                to = (to - 2) >> 1;
            }

            if(from == to){
                sum += arr[from];
                break;
            }
        }
        System.out.println(sum);
    }
}