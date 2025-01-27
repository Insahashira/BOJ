package Gold11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int busNum = Integer.parseInt(br.readLine());

        int[][] map = new int[count][count];

        for(int i = 0; i < count; i++) {
            for(int ii = 0; ii < count; ii++) {
                map[i][ii] = i == ii ? 0 : Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < busNum; i++) {
            String[] line = br.readLine().split(" ");
            int from, to, weight;
            from = Integer.parseInt(line[0])-1;
            to = Integer.parseInt(line[1])-1;
            weight = Integer.parseInt(line[2]);
            map[from][to] = Math.min(weight, map[from][to]);
        }

        for(int i = 0; i < count; i++) {
            for(int ii = 0; ii < count; ii++) {
                for(int iii = 0; iii < count; iii++) {
                    if(map[ii][i] == Integer.MAX_VALUE || map[i][iii] == Integer.MAX_VALUE) continue;
                    map[ii][iii] = Math.min(map[ii][iii], map[ii][i] + map[i][iii]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++) {
            for(int ii = 0; ii < count; ii++) {
                sb.append(map[i][ii] == Integer.MAX_VALUE ? 0 : map[i][ii]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
