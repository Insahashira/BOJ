package silver10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] num = br.readLine().split(" ");

        HashSet<String> ts = new HashSet<>(Arrays.asList(num));

        StringBuilder sb = new StringBuilder();
        num = br.readLine().split(" ");
        for(String n : num){
            sb = ts.contains(n) ? sb.append("1") : sb.append("0");
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
