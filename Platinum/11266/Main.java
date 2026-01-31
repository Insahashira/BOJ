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
        for(int i = 0; i < vertice; i++){
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
        for(int i = 0; i < vertice; i++) if(visit_order[i] == 0) DFS(i, i);
        node_dump();
    }

    public static void add_cutting_node(int index){
        if(!cut_node.contains(index)) cut_node.add(index);
    }

    public static int DFS(int par, int idx){
        int cur_order = visit_order[idx];
        if(cur_order == 0){
            visit_order[idx] = visit_counter++;
            cur_order = visit_order[idx];

            if(e[idx].isEmpty() ||(e[idx].size() == 1 && par != idx)) return cur_order;

            int lowest = 0x7fffffff; 
            for(int i = 0; i < e[idx].size(); i++){
                int candidate = e[idx].get(i);
                if(i != par){
                    int result = DFS(idx, candidate);
                    lowest = Math.min(lowest, result);
                }
            }
            if(lowest >= cur_order) add_cutting_node(idx);
            return lowest;
        }else return cur_order;
    }

    public static void node_dump(){
        System.out.println(cut_node.size());
        Collections.sort(cut_node);
        for(int i = 0; i < cut_node.size(); i++){
            System.out.print(cut_node.get(i) + 1 + " ");
        }
    }
}
