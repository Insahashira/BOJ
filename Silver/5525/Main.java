package Silver5525;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int p1 = 0;
        int counter = 0;
        int result = 0;
        while(p1 < length){
            if((counter % 2 == 0 && str.charAt(p1) == 'I') ||
                (counter % 2 == 1 && str.charAt(p1) == 'O') ||
                    (counter == 0 && str.charAt(p1) == 'I')
            )
                counter++;
            else counter = 0;
            if (counter == 2 * count + 1) {
                result++;
                counter = 1;
            }
            p1++;
        }
        System.out.println(result);
    }
}