package Gold7662;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeMap<Integer, Integer> tm;

        int count = Integer.parseInt(br.readLine());
        char command;
        int val;

        for (int i = 0; i < count; i++) {
            int n = Integer.parseInt(br.readLine());
            tm = new TreeMap<>(Collections.reverseOrder());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                command = st.nextToken().charAt(0);
                val = Integer.parseInt(st.nextToken());
                if(command == 'I'){
                    if(!tm.containsKey(val)) tm.put(val, 1);
                    else tm.put(val, tm.get(val) + 1);
                }else if(command == 'D'){
                    if(!tm.isEmpty()){
                        if(val == 1){
                            if(tm.get(tm.firstKey()) <= 1) tm.remove(tm.firstKey());
                            else tm.put(tm.firstKey(), tm.get(tm.firstKey()) - 1);
                        }
                        else{
                            if(tm.get(tm.lastKey()) <= 1) tm.remove(tm.lastKey());
                            else tm.put(tm.lastKey(), tm.get(tm.lastKey()) - 1);
                        }
                    }
                }
            }
            String result;
            if(tm.isEmpty()) result = "EMPTY";
            else result = tm.firstKey() + " " + tm.lastKey();
            System.out.println(result);
        }
    }
}