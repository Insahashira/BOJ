package Silver2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, maxCount;
    static Queue<int[]> q;
    static int[][] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int maximum = 0;
        maxCount = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ii = 0;

            while (st.hasMoreTokens()) {
                arr[i][ii] = Integer.parseInt(st.nextToken());
                maximum = Math.max(maximum, arr[i][ii]);
                ii++;
            }
        }

        for (int i = 0; i < maximum; i++) {
            int count = 0;
            q = new LinkedList<>();
            temp = new int[n][n];

            for (int ii = 0; ii < n; ii++) {temp[ii] = Arrays.copyOf(arr[ii], n);}

            for(int ii = 0; ii < n; ii++) {
                for(int iii = 0; iii < n; iii++) {
                    if(temp[ii][iii] > i){
                        bfs(ii, iii, i);
                        count++;
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        System.out.println(maxCount);
    }
    static void bfs(int row, int col, int height) {
        q.add(new int[]{row, col});
        temp[row][col] = -1;
        int[] rowTable = {1, -1, 0 ,0};
        int[] colTable = {0, 0, 1, -1};
        while(!q.isEmpty()) {
            int[] tempArr = q.poll();
            row = tempArr[0];
            col = tempArr[1];
            for (int i = 0; i < 4; i++) {
                if (row + rowTable[i] >= 0 && row + rowTable[i] < n && col + colTable[i] >= 0 && col + colTable[i] < n && temp[row + rowTable[i]][col + colTable[i]] >  height) {
                    temp[row + rowTable[i]][col + colTable[i]] = -1;
                    q.add(new int[]{row + rowTable[i], col + colTable[i]});
                }
            }
        }
    }
}

