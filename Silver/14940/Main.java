package Silver14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> q = new LinkedList<>();
        int targetRow = -1, targetCol = -1, row, col;
        int[][] grid, distance;
        int[] dx, dy;

        dx = new int[] {-1, 0, 1, 0};
        dy = new int[] {0, -1, 0, 1};

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        grid = new int[row][col];
        distance = new int[row][col];
        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            int ii = 0;
            while(st.hasMoreTokens()){
                grid[i][ii] = Integer.parseInt(st.nextToken());
                if(grid[i][ii] == 0) visited[i][ii] = true;
                else if(grid[i][ii] == 2){
                    targetRow = i;
                    targetCol = ii;
                }
                ii++;
            }
        }

        q.add(new int[]{targetRow, targetCol, 0});
        while(!q.isEmpty()){
            int[] temp = q.poll();
//            if(visited[temp[0]][temp[1]]) distance[temp[0]][temp[1]] = Math.min(distance[temp[0]][temp[1]], temp[2]);
            if(visited[temp[0]][temp[1]]) continue;
            else{
                visited[temp[0]][temp[1]] = true;
                distance[temp[0]][temp[1]] = temp[2];
            }

            temp[2]++;
            for(int i = 0; i < 4; i++) if(temp[0] + dx[i] > -1 && temp[0] + dx[i] < row && temp[1] + dy[i] > -1 && temp[1] + dy[i] < col) q.add(new int[]{temp[0] + dx[i], temp[1] + dy[i], temp[2]});
        }

        for(int i = 0; i < row; i++) for (int j = 0; j < col; j++) if(!visited[i][j]) distance[i][j] = -1;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++) sb.append(distance[i][j]).append(" ");
            sb.append("\n");
        }


        System.out.print(sb);
    }
}
