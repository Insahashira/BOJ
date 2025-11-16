package Platinum1799;

import java.io.*;
import java.util.*;

public class Main {
    static int count;
    static HashSet<int[]> available;
    static boolean[][] table, newTable, visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        available = new HashSet<>();

        count = Integer.parseInt(br.readLine());

        table = new boolean[count][count];
        visited = new boolean[count][count];

        for(int i = 0; i < count; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            for(int ii = 0; ii < count; ii++) table[i][ii] = s.nextToken().charAt(0) == '1';
        }

        for(int i = 0; i < count; i++) for(int ii = 0; ii < count; ii++) if(table[i][ii] && !visited[i][ii]) search(i, ii);

        System.out.println(max);
    }

    public static void search(int row, int col) {
        newTable = new boolean[count][count];
        int localCount = 0;

        for(int i = 0 ; i < count ; i++) for(int ii = 0 ; ii < count ; ii++){
            if(table[i][ii] && !newTable[i][ii]){
                gridMarker(i, ii);
                visited[i][ii] = true;
                localCount++;
            }
        }
        visited[row][col] = true;

        max = Math.max(localCount, max);
    }

    public static void gridMarker(int row, int col){
        int tempRow = row;
        int tempCol = col;
//        while(tempRow >= 0 && tempCol >= 0) newTable[tempRow--][tempCol--] = true;

//        tempRow = row;
//        tempCol = col;
        while(tempRow < count && tempCol < count) newTable[tempRow++][tempCol++] = true;

        tempRow = row;
        tempCol = col;
        while(tempRow < count && tempCol >= 0) newTable[tempRow++][tempCol--] = true;

//        tempRow = row;
//        tempCol = col;
//        while(tempRow >= 0 && tempCol < count) newTable[tempRow--][tempCol++] = true;
    }
}
