import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Java1931 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Entry> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            pq.add(new Entry(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
        while(true){
            
        }
    }

    private static class Entry implements Comparable<Entry> {
        private int start, end, time;

        public Entry(int start, int end) {
            this.start = start;
            this.end = end;
            this.time = start - end;
        }

        public int compareTo(Entry o) {
            return time - o.time;
        }
    }
}
