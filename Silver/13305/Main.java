package Silver13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cities = Integer.parseInt(br.readLine()) - 1;
        int[] road = new int[cities];
        int[] price = new int[cities];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cities; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cities; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        long totalPrice = 0;
        int i = 0;
        int destination;
        while (i < cities) {
            destination = i + 1;
            for(int ii = i + 1; ii < cities; ii++) {
                if(price[i] <= price[ii]) destination++;
                else break;
            }
            for(int ii = i; ii < destination; ii++) totalPrice += (long) price[i] * road[ii];
            i = destination;
        }

        System.out.println(totalPrice);
    }
}
