package Gold2357;

import java.util.*;
import java.io.*;

class Main {
    static int[] min, max;
    static int count, operations, e;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        count = Integer.parseInt(st.nextToken());
        operations = Integer.parseInt(st.nextToken());

        e = 1;
        while(e < count) e *= 2;

        min = new int[e*2];
        max = new int[e*2];

        for(int i = 0; i < e*2; i++) min[i] = 0x7fffffff;

        for (int i = 0; i < count; i++){
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            min[e + i] = temp;
            max[e + i] = temp;
        }

        createSegTreeMin(1);
        createSegTreeMax(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < operations; i++) {
            st = new StringTokenizer(br.readLine());
            int from = e + Integer.parseInt(st.nextToken()) - 1;
            int to = e + Integer.parseInt(st.nextToken()) - 1;
            int maxVal = 0, minVal = 0x7fffffff;
            if(from == to){
                maxVal = max[to];
                minVal = min[from];
            }else {
                while (from < to) {
                    if (from % 2 != 0) {
                        maxVal = Math.max(maxVal, max[from]);
                        minVal = Math.min(minVal, min[from]);
                        from += 1;
                    }
                    if (to % 2 != 1) {
                        maxVal = Math.max(maxVal, max[to]);
                        minVal = Math.min(minVal, min[to]);
                        to -= 1;
                    }
                    maxVal = Math.max(maxVal, max[from]);
                    minVal = Math.min(minVal, min[from]);
                    maxVal = Math.max(maxVal, max[to]);
                    minVal = Math.min(minVal, min[to]);
                    from /= 2;
                    to /= 2;
                }
            }
            sb.append(minVal).append(" ").append(maxVal).append("\n");
        }
        System.out.print(sb);
    }

    public static int createSegTreeMin(int n){
        if(n < e) return min[n] = Math.min(
                createSegTreeMin(n * 2),
                createSegTreeMin(n * 2 + 1)
        );
        return min[n];
    }

    public static int createSegTreeMax(int n){
        if(n < e) return max[n] = Math.max(
                    createSegTreeMax(n * 2),
                    createSegTreeMax(n * 2 + 1)
        );
        return max[n];
    }
}