package Platinum31412;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) al.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) al2.add(Integer.parseInt(st.nextToken()));

        Collections.sort(al, Collections.reverseOrder());
        Collections.sort(al2, Collections.reverseOrder());
        int max_item = al.get(0);

        int pointer;
        long boxes, low = 0, mid, high = (long) N * max_item;

        while(low <= high){
            mid = (low + high) / 2;

            pointer = 0;
            Iterator<Integer> it = al2.iterator();
            while(true){
                int ppl = it.next();
                boxes = 0;
                while (pointer < N && (((boxes + (long) al.get(pointer) + (long)ppl - 1)/ (long) ppl) <= mid)){
                    boxes += al.get(pointer);
                    pointer++;
                }
                if(pointer == N) {
                    high = mid - 1;
                    break;
                }else if(!it.hasNext()){
                    low = mid + 1;
                    break;
                }
            }
        }
        System.out.println(low);
    }
}