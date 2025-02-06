package Gold3078;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int count = Integer.parseInt(input[0]);
        int space = Integer.parseInt(input[1]);
        int[] length = new int[count];
        int[] lengthCount = new int[19];

        for (int i = 0; i < 19; i++) lengthCount[i] = 0;

        long pairs = 0;

        for (int i = 0; i < count; i++) length[i] = br.readLine().length();

        for (int i = 0; i < count; i++) {
            if (i == 0) {
                for (int j = 0; j <= space; j++) lengthCount[length[j] - 2]++;
                pairs += --lengthCount[length[i] - 2];
            } else {
                if(i + space < count){
//                    System.out.println("Correct");
                    lengthCount[length[i + space] - 2]++;
                }
                pairs += --lengthCount[length[i] - 2];
            }
//            printer(lengthCount);
//            System.out.println(pairs);
        }
        System.out.println(pairs);
    }
//    public static void printer(int[] arr){
//        for(int i : arr){
//            System.out.print(i + " ");
//        }
//        System.out.println();
//    }
}
