import java.io.*;
import java.util.*;

public class Main {
    static int[] visit_order;
    static int visit_counter = 1;
    static int vertice, edge;
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

    public static void add_cutting_node(int index){
        if(!cut_node.contains(index)) cut_node.add(index);
    }

    public static int DFS(int idx){
        if(visit_order[idx] != 0){
            return idx;
        }else{
            visit_order[idx] = visit_counter++;
            for(int i = 0; i < e[idx].size(); i++){
                int candidate = e[idx].get(i);
                int result = DFS(candidate);
            }
        }
        
        return 0;

    }

    public static void node_dump(){
        System.out.println(cut_node.size());
        Collections.sort(cut_node);
        for(int i = 0; i < cut_node.size(); i++){
            System.out.print(cut_node.get(i)+ 1 + " ");
        }
    }
}
