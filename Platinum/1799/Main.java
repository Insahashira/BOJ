import java.io.*;
import java.util.*;

public class Main {
    static int count;
    static boolean[][] table;
    static int[][] visited;
    static int max = 0;

    static int black_max = 0;
    static int white_max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        count = Integer.parseInt(br.readLine());

        table = new boolean[count][count];
        visited = new int[count][count];

        for(int i = 0; i < count; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            for(int ii = 0; ii < count; ii++) table[i][ii] = s.nextToken().charAt(0) == '0';
        }

        bfs(0, 0, 0, false);
        bfs(0, 1, 0, true);
        // bfs(0,0,0);

        System.out.println(black_max + white_max);
        // System.out.println(max);
    }

    public static void bfs(int row, int col, int curMax){
        if(check_answer(row, col)){
            make_move(row, col);
            max = Math.max(curMax + 1, max);
            if(col + 1 < count) bfs(row, (col + 1), (curMax + 1));
            else if(row + 1 >= count){
//                System.out.println("finished, local max: " + curMax);
            }
            else bfs((row + 1), 0, (curMax + 1));

            undo_move(row, col);
    
            if(col + 1 < count)      bfs(row, (col + 1), curMax);
            else if(row + 1 < count) bfs((row + 1), 0, curMax);
        }
        if(col + 1 < count)      bfs(row, (col + 1), curMax);
        else if(row + 1 < count) bfs((row + 1), 0, curMax);
    }

    //블랙이면 홀수
    public static void bfs(int row, int col, int curMax, boolean is_black){
        if(check_answer(row, col)){
            make_move(row, col);

            if(is_black) black_max = Math.max(curMax + 1, black_max);
            else         white_max = Math.max(curMax + 1, white_max);

            if(col + 2 < count)  bfs(row, (col + 2), (curMax + 1), is_black);
            else if(row + 1 < count){
                if(row % 2 == 0) bfs(row + 1, is_black ? 0 : 1, (curMax + 1), is_black);
                else             bfs(row + 1, is_black ? 1 : 0, (curMax + 1), is_black);
            }
            
            undo_move(row, col);
        }

        if(col + 2 < count)  bfs(row, (col + 2), curMax, is_black);
        else if(row + 1 < count){
            if(row % 2 == 0) bfs(row + 1, is_black ? 0 : 1, curMax, is_black);
            else             bfs(row + 1, is_black ? 1 : 0, curMax, is_black);
        }
    }

    public static void make_move(int row, int col){
        int tempX = row, tempY = col;
        while(tempX < count && tempY < count){
            visited[tempX][tempY]++;
            tempX++;
            tempY++;
        }

        tempX = row; 
        tempY = col;

        while(tempX >= 0 && tempY < count){
            visited[tempX][tempY]++;
            tempX--;
            tempY++;
        }

        tempX = row; 
        tempY = col;

        while(tempX < count && tempY >= 0){
            visited[tempX][tempY]++;
            tempX++;
            tempY--;
        }

        tempX = row;
        tempY = col;

        while(tempX >= 0 && tempY >= 0){
            visited[tempX][tempY]++;
            tempX--;
            tempY--;
        }
    }

    public static void undo_move(int row, int col){
        int tempX = row, tempY = col;
        while(tempX < count && tempY < count){
            visited[tempX][tempY]--;
            tempX++;
            tempY++;
        }

        tempX = row; 
        tempY = col;

        while(tempX >= 0 && tempY < count){
            visited[tempX][tempY]--;
            tempX--;
            tempY++;
        }

        tempX = row; 
        tempY = col;

        while(tempX < count && tempY >= 0){
            visited[tempX][tempY]--;
            tempX++;
            tempY--;
        }

        tempX = row;
        tempY = col;

        while(tempX >= 0 && tempY >= 0){
            visited[tempX][tempY]--;
            tempX--;
            tempY--;
        }
    }

    public static boolean check_answer(int row, int col){
        if(table[row][col]) return false;
        else if(visited[row][col] != 0) return false;
        return true;
    }
}