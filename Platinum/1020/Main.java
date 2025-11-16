import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class Main {
    static int itr = 1;
    static int limit;
    static TreeMap<Integer, int[]> tm = new TreeMap<>();
    static int[] lines = {6, 2, 5, 5, 4, 5, 6, 3, 7, 5};
    static int target = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        int[] tar = new int[input.length()];
        for (int i = 0; i < input.length(); i++){
            tar[i] = input.charAt(i) - '0';
            target += lines[tar[i]];
        }

        int count = input.length();
        tar[count - 1] += 1;

        tm.put(2, new int[] {1});
        tm.put(3, new int[] {7});
        tm.put(4, new int[] {4});
        tm.put(5, new int[] {2, 3, 5, 9});
        tm.put(6, new int[] {0, 6});
        tm.put(7, new int[] {8});


        limit = (int) Math.pow(10, input.length());
        helper(tar, 0);
    }

    public static void helper(int[] n, int pointer){
        int total = 0;
        if(itr == limit) Arrays.fill(n, 0);

        for (int i : n) total += lines[i];

        if(target == total){
            System.out.println(itr);
            return;
        }




        int val = n[pointer];
        int val1 = n[pointer + 1];
        if (val1 == val){
            helper(n, pointer + 1);
            return;
        }

        int[] arr = tm.get(lines[val]);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > val1){
                int dx = arr[i] - val;
                n[pointer + 1] += dx;
                itr += dx;
                helper(n, pointer + 1);
                return;
            }
        }
        n[pointer] += 1;
        itr += (int) Math.pow(10, pointer - 1);
        helper(n, pointer);
    }
}
