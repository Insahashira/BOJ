package Silver10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]){
                case "push":
                    q.add(Integer.parseInt(input[1]));
                    continue;
                case "pop":
                    if(q.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(q.poll());
                    }
                    continue;
                case "front":
                    if(q.isEmpty()){
                        System.out.println(-1);
                    }else {
                        System.out.println(q.peek());
                    }
                    continue;
                case "back":
                    if(q.isEmpty()){
                        System.out.println(-1);
                    }else {
                        System.out.println(q.getLast());
                    }
                    continue;
                case "size":
                    System.out.println(q.size());
                    continue;
                case "empty":
                    System.out.println(q.isEmpty() ? 1 : 0);
                    continue;
            }
        }
    }
}
