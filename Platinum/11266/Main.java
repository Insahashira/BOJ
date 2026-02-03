import java.io.*;
import java.util.*;

public class Main {
    static int[] visit_order, parent;
    static int visit_counter = 1, vertice, edge;
    static ArrayList<Integer>[] e;
    static ArrayList<Integer>cut_node = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertice = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        visit_order = new int[vertice];
        parent = new int[vertice];

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
        for(int i = 0; i < vertice; i++) if(visit_order[i] == 0) DFS(i, i, i);
        node_dump();
        // visit_dump();
        // parent_dump();
    }

    public static void add_cutting_node(int index){
        if(!cut_node.contains(index)) cut_node.add(index);
    }

    public static void DFS(int par, int idx, int root){
        if(visit_order[idx] > 0) return;
        if(e[idx].isEmpty()) return;

        visit_order[idx] = visit_counter++;
        int cur_order = visit_order[idx];
        int lowest = cur_order;
        int child_cnt = 0;

        for(int i = 0; i < e[idx].size(); i++){
            int candidate = e[idx].get(i);
            if(candidate == par) continue;

            if(visit_order[candidate] > 0) lowest = Math.min(lowest, visit_order[candidate]);
            else{
                child_cnt++;
                DFS(idx, candidate, root);
                int result = parent[candidate];
                
                if(idx != root && result >= cur_order) add_cutting_node(idx);
                lowest = Math.min(lowest, result);
            }
        }

        if(idx == root && child_cnt > 1){
            add_cutting_node(idx);
        }
        parent[idx] = lowest;
    }

    public static void visit_dump(){
        for(int i = 0 ; i < vertice; i++){
            System.out.print(visit_order[i] + " ");
        }
        System.out.println();
    }

    public static void parent_dump(){
        for(int i = 0 ; i < vertice; i++){
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

    public static void node_dump(){
        System.out.println(cut_node.size());
        Collections.sort(cut_node);
        for(int i = 0; i < cut_node.size(); i++){
            System.out.print(cut_node.get(i) + 1 + " ");
        }
        System.out.println();
    }
}
//whtrkxek Tlqkf!!!!!!!!