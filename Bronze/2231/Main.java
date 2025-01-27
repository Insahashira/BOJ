package Java2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int ori = 1;
        int temp;

        while(true){
            ori++;
            temp = ori + converter(""+ori);
            if (input == temp){
                System.out.println(ori);
                break;
            }
            if (temp > 1000000){
                System.out.println(0);
                break;
            }
        }
    }

    static int converter(String input){
        int result = 0;
        for(int i = 0; i < input.length(); i++){
            result += (int)input.charAt(i) - 48;
        }
        return result;
    }
}