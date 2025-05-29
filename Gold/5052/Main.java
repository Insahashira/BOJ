package Gold5052;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<String> arr;

        int test_num = Integer.parseInt(br.readLine());
        for (int i = 0; i < test_num; i++){
            set = new HashSet<>();
            int count = Integer.parseInt(br.readLine());
            arr = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < count; j++) arr.add(br.readLine());
            finder(arr);
        }
        br.close();
    }

    public static void finder(PriorityQueue<String> arr) {
        int count = arr.size();

        for (int i = 0; i < count; i++) {
            String number = arr.poll();
            int len = number.length();
            if(set.contains(number)) {
                System.out.println("NO");
                return;
            }

            for (int ii = 1; ii <= len; ii++) for (int j = 0; j + ii <= len; j++) {
                String str = number.substring(0, j + ii);
                set.add(str);
            }
        }
        System.out.println("YES");
    }
}