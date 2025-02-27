package Bronze1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        while(input.charAt(0) != '0') {
            int left, right;
            boolean itIs = true;

            left = 0;
            right = input.length() - 1;
            while(left < right) {
                if(input.charAt(left) != input.charAt(right)){
                    itIs = false;
                    break;
                }
                left++;
                right--;
            }
            System.out.println(itIs ? "yes" : "no");
            input = in.readLine();
        }
    }
}
