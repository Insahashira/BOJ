package Gold23309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(st.nextToken());
        int steps = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());

        int[][] stations = new int[1000001][2]; // 0 prev, 1 next
        int[] init = new int[count];

        for (int i = 0; i < count; i++) {
            init[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < count; i++) {
            if (i == count - 1){
                stations[init[0]][0] = init[i];
            }if(i == 0){
                stations[init[count -1]][1] = init[i];
            }else{
                stations[init[i]][0] = init[i - 1];
                stations[init[i - 1]][1] = init[i];
            }
        }
        
        for (int i = 0; i < steps; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int temp, prev, next;
            switch (type) {
                case "BN":
                    prev = Integer.parseInt(st.nextToken());
                    temp = Integer.parseInt(st.nextToken());
                    next = stations[prev][1];
                    stations[prev][1] = temp;
                    stations[next][0] = temp;
                    stations[temp][0] = prev;
                    stations[temp][1] = next;
                    sb.append(next).append("\n");
                    continue;
                case "BP":
                    next = Integer.parseInt(st.nextToken());
                    temp = Integer.parseInt(st.nextToken());
                    prev = stations[next][0];
                    stations[prev][1] = temp;
                    stations[next][0] = temp;
                    stations[temp][0] = prev;
                    stations[temp][1] = next;
                    sb.append(prev).append("\n");
                    continue;
                case "CN":
                    prev = Integer.parseInt(st.nextToken());
                    temp = stations[prev][1];
                    next = stations[temp][1];
                    stations[prev][1] = next;
                    stations[next][0] = prev;
                    sb.append(temp).append("\n");
                    continue;
                default:
                    next = Integer.parseInt(st.nextToken());
                    temp = stations[next][0];
                    prev = stations[temp][0];
                    stations[prev][1] = next;
                    stations[next][0] = prev;
                    sb.append(temp).append("\n");
            }
        }
        System.out.print(sb);
    }
}
