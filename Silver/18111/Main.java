package Silver18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int row, col, blocks;
    static int[] best = {256, 0x7fffffff}; // 0 height, 1 time
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        blocks = Integer.parseInt(st.nextToken());
        grid = new int[row][col];
        int highest = 0;
        int lowest = 0x7fffffff;

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());

            int ii = 0;
            while (st.hasMoreTokens()){
                int temp = Integer.parseInt(st.nextToken());
                grid[i][ii++] = temp;
                highest = Math.max(temp, highest);
                lowest = Math.min(temp, lowest);
            }
        }

        int height = highest;
        while(height >= 0 && height >= lowest - 1){
            helper(height);
            height--;
        }
        System.out.println(best[1] + " " + best[0]);
    }

    static void helper(int height) {
        int time = 0;
        int needed = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int dy = height - grid[i][j];
                if(dy < 0){
                    time += dy * -2;
                    needed += dy;
                }else if(dy > 0){
                    time += dy;
                    needed += dy;
                }
            }
        }
        if(needed > blocks) return;
        else if(time < best[1]){
            best = new int[] {height, time};
        }
    }
}
