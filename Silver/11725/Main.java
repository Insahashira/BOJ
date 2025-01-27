package Silver11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static HashSet<Integer>[] hs;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        hs = new HashSet[count];
        parents = new int[count];

        for(int i = 0; i < count; i++) parents[i] = -1;

        for (int i = 0; i < count; i++) hs[i] = new HashSet<Integer>();

        for (int i = 0; i < count - 1; i++) {
            String[] temp = br.readLine().split(" ");
            hs[Integer.parseInt(temp[0]) - 1].add(Integer.parseInt(temp[1]) - 1);
            hs[Integer.parseInt(temp[1]) - 1].add(Integer.parseInt(temp[0]) - 1);
        }

        br.close();

        helper(0);

        for(int i = 1; i < parents.length; i++) System.out.println(parents[i] + 1);
    }

    public static void helper(int index){
        for (int temp : hs[index]) {
            if (temp == index || parents[temp] != -1) continue;
            parents[temp] = index;
            helper(temp);
        }
    }
}