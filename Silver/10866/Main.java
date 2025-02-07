package Silver10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        LinkedList<Integer> ll = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push_front":
                    ll.addFirst(Integer.parseInt(input[1]));
                    continue;
                case "push_back":
                    ll.addLast(Integer.parseInt(input[1]));
                    continue;
                case "pop_front":
                    System.out.println(ll.isEmpty() ? "-1" : ll.removeFirst());
                    continue;
                case "pop_back":
                    System.out.println(ll.isEmpty() ? "-1" : ll.removeLast());
                    continue;
                case "size":
                    System.out.println(ll.size());
                    continue;
                case "empty":
                    System.out.println(ll.isEmpty() ? "1" : "0");
                    continue;
                case "front":
                    System.out.println(ll.isEmpty() ? "-1" : ll.getFirst());
                    continue;
                case "back":
                    System.out.println(ll.isEmpty() ? "-1" : ll.getLast());
                    continue;
                default:
                    continue;
            }
        }
    }
}
