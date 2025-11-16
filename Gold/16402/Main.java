package Gold16402;
//16402 제국

import java.util.*;
import java.io.*;

public class Main {
    static HashMap<String, String> par = new HashMap<>();

    public static String find(String in) {
        if (par.get(in) == null) return in;
        String root = find(par.get(in));
        par.put(in, root);
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<String> kingdoms = new HashSet<>();

        int count = Integer.parseInt(st.nextToken());
        int operations = Integer.parseInt(st.nextToken());

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            st.nextToken();

            String temp = st.nextToken();
            kingdoms.add(temp);
            par.put(temp, null);
        }

        for (int i = 0; i < operations; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            st.nextToken();

            String a  = st.nextToken().split(",")[0];

            st.nextToken();

            String[] temp = st.nextToken().split(",");

            String b = temp[0];
            char c = temp[1].charAt(0);

            String win = c == '1' ? a : b;
            String lose = c == '1' ? b : a;

            String win_parent = find(win);
            String lose_parent = find(lose);

            if(win_parent.equals(lose_parent)){
                par.put(win, null);
                win_parent = win;
            }
            par.put(lose_parent, win_parent);
            kingdoms.add(win_parent);
            kingdoms.remove(lose_parent);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(kingdoms.size()).append("\n");
        for (String a : kingdoms) sb.append("Kingdom of ").append(a).append("\n");
        System.out.print(sb);
    }
}