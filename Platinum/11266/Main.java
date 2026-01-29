import java.io.*;
import java.util.*;

public class Main {
    static int[] visit_order;
    static int visit_counter = 1;
    static int vertice, edge;
    static Stack<Object> stack = new Stack();
    static ArrayList<Integer>[] e;
    static ArrayList<Integer>cut_node = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertice = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        visit_order = new int[vertice];

        e = (ArrayList<Integer>[]) new ArrayList[vertice];
        for(int i = 0; i < edge; i++){
            e[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int from, to;
            from = Integer.parseInt(st.nextToken()) - 1;
            to = Integer.parseInt(st.nextToken()) - 1;

            e[from].add(to);
            e[to].add(from);
        }

        DFS(0);
        node_dump();
    }

    public static void DFS(int index){
        stack.push(index);
        int prev_level = 0x7fffffff;

        while(!stack.isEmpty()){
            int idx = (int) stack.pop();

            if(visit_order[idx] != 0){
                if(prev_level < idx){
                    //올라갈 수 있는 상황
                }else{
                    //못올라감
                }
            } else {
                visit_order[idx] = visit_counter++;
                cut_node.add(idx);
            }

            ArrayList ar = e[idx];
            for(int i = 0; i < ar.size(); i++){
                int next = (int) ar.get(i);
                if(next != idx) stack.push(ar.get(i));
            }
        }
    }

    public static void node_dump(){
        for(int i = 0; i < cut_node.size(); i++){
            System.out.println(cut_node.get(i));
        }
    }
}
