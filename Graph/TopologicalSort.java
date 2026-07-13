import java.util.*;
public class TopologicalSort{
    static class Edge{
        int src,dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph){
         /*for vertex 0  non */
        /*for vertex 1  non */
        /*for vertex 2 */
        graph[2].add(new Edge (2,3));
         /*for vertex 3 */
        graph[3].add(new Edge (3,1));
         /*for vertex 4 */
        graph[4].add(new Edge (4,0));
        graph[4].add(new Edge (4,1));
         /*for vertex 5 */
        graph[5].add(new Edge (5,0));
        graph[5].add(new Edge (5,2));

        }
        public static void topological(ArrayList<Edge>[]graph){
            boolean[] vis = new boolean[graph.length];
            Stack<Integer>stack = new Stack<>();
            for(int i = 0 ; i < graph.length ; i++){
                if(!vis[i])
                    topologicalDfs(i,graph,vis,stack);
            }
              while(!stack.isEmpty()){
                System.out.print(stack.pop()+" ");
            }
        }
        public static void topologicalDfs(int curr,ArrayList<Edge>[]graph,boolean[] vis,Stack<Integer>stack){
            vis[curr] = true;
            for(Edge e : graph[curr]){
                if(!vis[e.dest]){
                    topologicalDfs(e.dest, graph, vis,stack);
                }
            }
             // Push after processing all neighbors
            stack.push(curr);
        }
    public static void main(String[] args) {
        int V  = 6 ;
        ArrayList<Edge>[] graph = new ArrayList[V]; /*line dataType[] arrName = new dataType[size]*/
        for(int i = 0 ;  i < V ; i++){
            graph[i] =  new ArrayList<>();
        }
        createGraph(graph);
        topological(graph);
       
        }
}