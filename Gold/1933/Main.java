package Gold1933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Entry implements Comparable<Entry> {
        int left, height;
        boolean isLeft;

        public Entry(int left, int height, boolean isLeft) {
            this.left = left;
            this.height = height;
            this.isLeft = isLeft;
        }

        public int compareTo(Entry o) {
            return left - o.left;
        }
    }
    static TreeMap<Integer, Integer> highest = new TreeMap<Integer, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> ll = new LinkedList<>();
        PriorityQueue<Entry> pq = new PriorityQueue<Entry>();

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            pq.add(new Entry(left, height, true));
            pq.add(new Entry(right, height, false));
        }

        int curHeight = -1;
        int maxLeft, maxRight;
        while(!pq.isEmpty()) {
            maxLeft = 0;
            maxRight = 0;
            Entry temp;

            do{
                temp = pq.poll();
                if (!temp.isLeft){
                    maxRight = Math.max(maxRight, temp.height);
                    if(highest.containsKey(temp.height) && highest.get(temp.height) > 1) highest.put(temp.height, highest.get(temp.height) - 1);
                    else if(highest.containsKey(temp.height) && highest.get(temp.height) == 1) highest.remove(temp.height);
                }
                else {
                    maxLeft = Math.max(maxLeft, temp.height);
                    if(highest.containsKey(temp.height)) highest.put(temp.height, highest.get(temp.height) + 1);
                    else highest.put(temp.height, 1);
                }
            } while (!pq.isEmpty() && pq.peek().left == temp.left);

            if (curHeight == -1) curHeight = maxLeft;
            else {
                if (maxRight != -1 && maxRight == curHeight) {
                    if (maxLeft == maxRight || highest.containsKey(maxRight)) continue;
                    if(!highest.isEmpty()) curHeight = highest.lastKey();
                    else curHeight = 0;
                }
                else if (maxLeft != -1 && curHeight < maxLeft) curHeight = maxLeft;
                else continue;
            }
            ll.add(temp.left);
            ll.add(curHeight);
        }


        StringBuilder sb = new StringBuilder();

        while (!ll.isEmpty()) sb.append(ll.removeFirst()).append(" ");

        System.out.print(sb);
    }

}

