package silver10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        br.readLine();
        int temp;

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            temp = Integer.parseInt(st.nextToken());
            if(!hm.containsKey(temp)) {
                hm.put(temp, 1);
            } else {
                hm.put(temp, hm.get(temp) + 1);
            }
        }

        br.readLine();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            temp = Integer.parseInt(st.nextToken());

            if(!hm.containsKey(temp)) {
                sb.append("0 ");
            } else {
                sb.append(hm.get(temp)).append(" ");
            }
        }

        System.out.println(sb);
    }
}
