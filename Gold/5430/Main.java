package Gold5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) helper();
    }

    static void helper() throws IOException {
        LinkedList<Integer> ll = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        boolean order = true;

        char[] command = br.readLine().toCharArray();
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

        while (st.hasMoreTokens()) ll.add(Integer.parseInt(st.nextToken()));

        for(char c : command) {
            if(c == 'R') order = !order;
            else if(c == 'D'){
                if(ll.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                if(order)ll.removeFirst();
                else ll.removeLast();
            }
        }
        sb.append("[");
        while(!ll.isEmpty()) {
            if(order) sb.append(ll.removeFirst());
            else sb.append(ll.removeLast());
            if(!ll.isEmpty()) sb.append(",");
        }
        sb.append("]\n");
        System.out.print(sb);
    }
}
