import java.io.*;
import java.util.*;

public class Main {
    static char[] operations;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q;
        int count = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < count; i++) {
            boolean[] visited = new boolean[10000];
            operations = new char[10000];
            parent = new int[100000];
            q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());


            q.add(from);
            operations[from] = 0;
            parent[from] = -1;

            while(!q.isEmpty()) {
                int n = q.poll();
                visited[n] = true;

                if(n == to){
                    print_process(to);
                    break;
                }

                //D
                int n_D = (n*2)%10000;
                if(!visited[n_D]){
                    q.add(n_D);
                    operations[n_D] = 'D';
                    parent[n_D] = n;
                } 

                //S
                int n_S = n <= 0 ? 9999 : n-1;
                if(!visited[n_S]){
                    operations[n_S] = 'S';
                    parent[n_S] = n;
                    q.add(n_S);
                } 
                    

                //L
                int n_L = (n*10)%10000 + n/1000;
                if(!visited[n_L]){
                    operations[n_L] = 'L';
                    parent[n_L] = n;
                    q.add(n_L);
                } 

                //R
                int n_R = (n/10) + (n%10) * 1000;
                if(!visited[n_R]){
                    operations[n_R] = 'R';
                    parent[n_R] = n;
                    q.add(n_R);
                } 
            }
        }
    }

    static void print_process(int num){
        StringBuilder sb = new StringBuilder();
        Stack<Object> st = new Stack<>();
        while(true){
            st.add(operations[num]);
            // st.add(parent[num]);
            if(parent[num] == -1) break;
            num = parent[num];
        }
        st.pop();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        System.out.println(sb);
    }
}