package Silver18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
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
                        sb.append("-1\n");
                    }else{
                        sb.append(q.removeFirst()).append("\n");
                    }
                    continue;
                case "front":
                    if(q.isEmpty()){
                        sb.append("-1\n");
                    }else {
                        sb.append(q.getFirst()).append("\n");
                    }
                    continue;
                case "back":
                    if(q.isEmpty()){
                        sb.append("-1\n");
                    }else {
                        sb.append(q.getLast()).append("\n");
                    }
                    continue;
                case "size":
                    sb.append(q.size()).append("\n");
                    continue;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    continue;
            }
        }
        System.out.println(sb);
    }
}
