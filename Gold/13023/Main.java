package Sikver13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int max, ppl;
    static ArrayList<Integer>[] al;
    static boolean status = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ppl = Integer.parseInt(st.nextToken());
        int relation = Integer.parseInt(st.nextToken());

        al = new ArrayList[ppl];
        for (int i = 0; i < ppl; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < relation; i++) {
            st = new StringTokenizer(br.readLine());
            int ppl1 = Integer.parseInt(st.nextToken());
            int ppl2 = Integer.parseInt(st.nextToken());
            al[ppl1].add(ppl2);
            al[ppl2].add(ppl1);
        }

        max = 0;
        for(int i = 0; i < ppl; i++) if(dfs(i, 0 , new boolean[ppl])) break;

        System.out.println(max >= 4 ? 1 : 0);
    }

    static boolean dfs(int index, int count, boolean[] visited) {
        if(status) return true;
        ArrayList<Integer> ar = al[index];
        visited[index] = true;
        max = Math.max(max, count);
        if(count == 4){
            status = true;
            return true;
        }
        for(int a : ar){
            boolean[] newArr = visited.clone();
            if (!newArr[a]) dfs(a, count + 1, newArr);
        }
        return false;
    }
}
