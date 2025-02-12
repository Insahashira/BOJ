package Silver18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        TreeSet<Integer> ts = new TreeSet<>();
        int[] nums = new int[count];
        int temp;
        int i = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            temp = Integer.parseInt(st.nextToken());
            ts.add(temp);
            nums[i] = temp;
            i++;
        }

        i = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        while(!ts.isEmpty()){
            hm.put(ts.pollFirst(), i++);
        }
        StringBuilder sb = new StringBuilder();

        for(int ii = 0; ii < count; ii++) {
            sb.append(hm.get(nums[ii])).append(" ");
        }
        System.out.println(sb);
    }
}