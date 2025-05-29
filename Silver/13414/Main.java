package Silver13414;

import java.io.BufferedReader;
import java.util.*;  

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, String> inputs = new HashMap<>();
        HashMap<String, Integer> duplicate = new HashMap<>();
        int limit, count;
        limit = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());

        for(int i = 0; i < count; i++) {
            String user;
            st = new StringTokenizer(br.readLine());
            user = st.nextToken();
            if(duplicate.containsKey(user)){
                inputs.put(i, user);
                duplicate.put(user, duplicate.get(user) + 1);
            }else{
                inputs.put(i, user);
                duplicate.put(user, 0);
            }
        }
        br.close();
        int printed = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count && printed < limit; i++) {
            String temp = inputs.get(i);
            if(duplicate.containsKey(temp) && duplicate.get(temp) >= 1) 
                if(duplicate.get(temp) == 1) duplicate.remove(temp);
                else duplicate.put(temp, duplicate.get(temp) - 1);
            else{
                sb.append(temp).append("\n");
                printed++;
            }
        }
        System.out.print(sb);
    }
}


