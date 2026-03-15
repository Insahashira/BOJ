    // package Gold9019;

    import java.io.*;
    import java.util.*;

    public class Main {
    private static class SN{ //StringNode
        char ch;
        SN next;

        public SN(char ch, SN next){
            this.ch = ch;
            this.next = next;
        }
    }

    private static class Node{
        int val;
        SN op;

        public Node(int val, SN op){
            this.val = val;
            this.op = op;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Node> q;
        int count = Integer.parseInt(st.nextToken());

        for (int i = 0; i < count; i++) {
            boolean[] visited = new boolean[10000];
            q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to   = Integer.parseInt(st.nextToken());

            q.add(new Node(to, new SN((char)0, null)));
            while(!q.isEmpty()) {
                Node n = q.poll();

                int temp = n.val;
                if(visited[temp] == true) continue;
                visited[temp] = true;

                SN source = n.op;

                if(temp == from){
                    fin(source);
                    break;
                }

                // D
                if(temp % 2 == 0){
                    if(!visited[temp/2])        q.add(new Node(temp/2, new SN('D', source)));
                    if(!visited[temp/2 + 5000]) q.add(new Node(temp/2 + 5000, new SN('D', source)));
                }

                // S
                if(temp == 9999 && !visited[0]) q.add(new Node(0, new SN('S', source)));
                else if(!visited[temp + 1])     q.add(new Node(temp + 1, new SN('S', source)));
                
                int temp2;
                // L
                temp2 = temp % 10;
                temp2 = (temp2 * 1000) + (temp / 10);
                
                if(!visited[temp2]) q.add(new Node(temp2, new SN('L', source)));
                // R
                temp2 = temp / 1000;
                temp2 = temp2 + (temp * 10) % 10000;

                if(!visited[temp2]) q.add(new Node(temp2, new SN('R', source)));
                
            }
        }
    }

    public static void fin(SN source){
        StringBuilder sb = new StringBuilder();

        while(source.ch != 0){
            sb.append(source.ch);
            source = source.next;
        }

        sb.append("\n");
        System.out.print(sb);
    }
    }