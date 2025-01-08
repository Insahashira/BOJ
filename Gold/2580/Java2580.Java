import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

class Java2580{
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[][] sudocu  = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String[] temp = input.readLine().split(" ");
            for (int ii = 0; ii < 9; ii++) sudocu[i][ii] = Integer.parseInt(temp[ii]);
        }

        recur(sudocu);
    }

    public static boolean recur(int[][] grid){
        for(int i = 0; i < 9; i++) {
            for(int ii = 0; ii < 9; ii++) {
                if(grid[i][ii] == 0){
                    Iterator<Integer> itr = check(grid, i, ii);
                    if(!itr.hasNext()) return false;
                    while(itr.hasNext()){
                        int num = itr.next();
                        grid[i][ii] = num;
                        if(recur(grid)) return true;
                        grid[i][ii] = 0;
                    }
                    return false;
                }
            }
        }
        for(int[] str : grid){
            for(int inte: str) System.out.print(inte + " ");
            System.out.println();
        }
        return true;
    }


    public static Iterator<Integer> check(int[][] grid, int row, int col) {
        HashSet<Integer> hs = new HashSet();
        for (int i = 0; i < 9; i++) hs.add(i + 1);

        for (int i = 0; i < 9; i++) {
            hs.remove(grid[i][col]);
            hs.remove(grid[row][i]);
        }
        for (int i = 0; i < 3; i++) {
            for (int ii = 0; ii < 3; ii++) hs.remove(grid[row - row % 3 + i][col - col % 3 + ii]);
        }
        Iterator<Integer> itr = hs.iterator();
        return itr;
    }
}