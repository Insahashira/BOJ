import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Java31423 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] name = new String[count];
        int[] next = new int[count];
        int[] tail = new int[count];
        for (int i = 0; i < count; i++) {
            name[i] = br.readLine();
            tail[i] = i;
        }
        int from = -1, to;
        for (int i = 0; i < count-1; i++) {
            String[] temp = br.readLine().split(" ");
            from = Integer.parseInt(temp[0])-1;
            to = Integer.parseInt(temp[1])-1;
            next[tail[from]] = to;
            tail[from] = tail[to];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(name[from]);
            from = next[from];
        }
        System.out.println(sb.toString());
    }
}