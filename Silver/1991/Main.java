package Silver1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Character, char[]> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        char head = ' ';
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            if (i == 0) head = root;
            hm.put(root, new char[] {st.nextToken().charAt(0), st.nextToken().charAt(0)});
        }

        pre(head);
        System.out.println();

        in(head);
        System.out.println();

        post(head);
    }

    static void pre(char par) {
        char[] children = hm.get(par);
        System.out.print(par);
        if(children[0] != '.') pre(children[0]);
        if(children[1] != '.') pre(children[1]);
    }

    static void in(char par) {
        char[] children = hm.get(par);
        if(children[0] != '.') in(children[0]);
        System.out.print(par);
        if(children[1] != '.') in(children[1]);
    }

    static void post(char par) {
        char[] children = hm.get(par);
        if(children[0] != '.') post(children[0]);
        if(children[1] != '.') post(children[1]);
        System.out.print(par);
    }
}
