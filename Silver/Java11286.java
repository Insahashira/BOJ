import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Java11286 {

    private static class Entry implements Comparable<Entry> {
        private int raw;
        private int abs;

        public Entry(int raw) {
            this.raw = raw;
            this.abs = Math.abs(raw);
        }

        public int compareTo(Entry o) {
            if(this.abs == o.abs){
                return this.raw > o.raw ? 1 : -1;
            }
            return this.abs - o.abs;
        }

        public int val(){
            return this.raw;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Entry> pq = new PriorityQueue<>();

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                System.out.println(pq.isEmpty() ? "0" : pq.poll().val());
            } else {
                pq.add(new Entry(input));
            }
        }
    }
}

