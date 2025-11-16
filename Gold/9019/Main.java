//package Gold9019;
//
//import java.io.*;
//import java.util.*;
//
//public class Main {
//    private static class SN{ //StringNode
//        char ch;
//        SN next;
//
//        public SN(char ch, SN next){
//            this.ch = ch;
//            this.next = next;
//        }
//    }
//
//    private static class Node{
//        int val;
//        SN op;
//        Boolean isL;
//
//        public Node(int val, SN op, Boolean isL){
//            this.val = val;
//            this.op = op;
//            this.isL = isL;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        Queue<Node> q;
//        int count = Integer.parseInt(st.nextToken());
//
//        for (int i = 0; i < count; i++) {
//            boolean[] visited = new boolean[10000];
//            q = new LinkedList<>();
//
//            st = new StringTokenizer(br.readLine());
//            int from = Integer.parseInt(st.nextToken());
//            int to = Integer.parseInt(st.nextToken());
//
//            q.add(new Node(to, new SN((char)0, null), null));
//
//            while(!q.isEmpty()) {
//                Node n = q.poll();
//                int temp = n.val;
//                visited[temp] = true;
//
//                SN source = n.op;
//                Boolean isL = n.isL;
//
//                if(temp == from){
//                    StringBuilder sb = new StringBuilder();
//
//                    while(source.ch != 0){
//                        sb.append(source.ch);
//                        source = source.next;
//                    }
//
//                    sb.append("\n");
//                    System.out.print(sb);
//                    break;
//                }
//
//                if(temp % 2 == 0){
//                    if(!visited[temp/2])                         q.add(new Node(temp/2, new SN('D', source), isL));
//                    if(temp < 5000 && !visited[(temp + 5000)/2]) q.add(new Node((temp + 5000)/2, new SN('D', source), isL));
//                }
//
//                if(temp == 9999 && !visited[0]) q.add(new Node(0, new SN('S', source), isL));
//                else if(!visited[temp + 1])     q.add(new Node(temp + 1, new SN('S', source), isL));
//
//                int temp2;
//                if(isL == null || isL) {
//                    temp2 = temp % 10;
//                    temp2 = (temp2 * 1000) + (temp / 10);
//
////                    if(!visited[temp2])
//                    q.add(new Node(temp2, new SN('L', source), true));
//                }
//
//                if(isL == null || !isL) {
//                    temp2 = temp / 1000;
//                    temp2 = temp2 + (temp * 10) % 10000;
//
////                    if(!visited[temp2])
//                    q.add(new Node(temp2, new SN('R', source), false));
//                }
//            }
//        }
//    }
//}