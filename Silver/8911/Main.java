package Silver8911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dx, dy, xDir, yDir, curDir;;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            dx = 0;
            dy = 0;
            xDir = 0; //0: left, 1: right
            yDir = 0; //0: up, 1: down
            curDir = 1; //0: x, 1: y
            StringTokenizer st = new StringTokenizer(br.readLine(), "");
            while (st.hasMoreTokens()) {
                switch (st.nextToken()) {
                    case "F":
                        mover(true);
                        continue;
                    case "B":
                        mover(false);
                        continue;
                    case "L":

                }
            }
        }
    }
    public static void mover(boolean dir){
        int i;
        if(dir) {
            if (curDir == 1) {
                i = yDir == 0 ? dy++ : dy--;
            } else {
                i = xDir == 0 ? dx-- : dx++;
            }
        } else {
            if (curDir == 1) {
                i = yDir == 0 ? dy-- : dy++;
            } else {
                i = xDir == 0 ? dx++ : dx--;
            }
        }
    }
}
