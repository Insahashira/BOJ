package Gold12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String target;
    static boolean yeppie = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> ll = new LinkedList<>();
        target = br.readLine();
        String to = br.readLine();
        for(int i = 0; i < to.length(); i++) ll.add(to.charAt(i));
        br.close();
        System.out.println((dfs(ll) ? 1 : 0));
    }

    public static boolean dfs(LinkedList<Character> ll) {
        if(yeppie) return true;
        if(ll.size() == target.length()){
            StringBuilder sb = new StringBuilder();
            for(char a : ll) sb.append(a);
            if(sb.toString().equals(target)) return yeppie = true;
            else return false;
        }
        LinkedList<Character> temp;
        if(ll.getLast() == 'A'){
            temp = (LinkedList<Character>) ll.clone();
            temp.removeLast();
            dfs(temp);
        } else if(ll.getLast() == 'B'){
            temp = (LinkedList<Character>) ll.clone();
            temp.removeLast();
            Collections.reverse(temp);
            dfs(temp);
        }
        return yeppie;
    }
}
