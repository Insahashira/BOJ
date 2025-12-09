package Platinum1799;

import java.io.*;
import java.util.*;

public class Main {
    static short count;
    static boolean[][] table;
    static short[][] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        count = Short.parseShort(br.readLine());

        table = new boolean[count][count];
        visited = new short[count][count];

        for(short i = 0; i < count; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            for(int ii = 0; ii < count; ii++) table[i][ii] = s.nextToken().charAt(0) == '1';
        }

        bfs((short) 0, (short) 0);

        System.out.println(max);
    }

    public static void bfs(short row, short col){
        if(check_answer()) process_answer();

        make_move(row, col);

        if(col + 1 < count) bfs(row, (short) (col + 1));
        else if(row + 1 < count) bfs((short) (row + 1), (short) 0);
        
        undo_move(row, col);

        if(col + 1 < count) bfs(row, (short) (col + 1));
        else if(row + 1 < count) bfs((short) (row + 1), (short) 0);
    }

    public static void make_move(short row, short col){
        visited[row][col]++;
    }

    public static void undo_move(short row, short col){

    }

    public static boolean check_answer(){
        return true;
    }

    public static void process_answer(){

    }
}