import java.util.*;
public class NumberOfConnectedComponents{
    static class Edge{
        int src,dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph){
         /*for vertex 0  */
        graph[0].add(new Edge (0,1));
        /*for vertex 1 */
        graph[1].add(new Edge (1,2));
        graph[1].add(new Edge (1,0));

        /*for vertex 2 */
        graph[2].add(new Edge (2,1));

         /*for vertex 3 */
        graph[3].add(new Edge (3,4));
         /*for vertex 4 */
        graph[4].add(new Edge (4,3));
        }
        public static int connectedComponents(ArrayList<Edge>[]graph){
            boolean[] vis = new boolean[graph.length]; 
            int count = 0;
            for(int i = 0 ; i < graph.length ; i++){
                if(!vis[i]){
                    count++;
                    dfsTraversal(i, graph, vis);
                }
            }
            return count;
        }
        public static void dfsTraversal(int curr,ArrayList<Edge>[]graph,boolean[] vis){
           vis[curr] = true;
         for(Edge e : graph[curr]){
            if(!vis[e.dest]){
                dfsTraversal(e.dest, graph, vis);
            }
         }
                        
                    }
    public static void main(String[] args) {
        int V  = 5 ;
         @SuppressWarnings("unchecked")
        ArrayList<Edge>graph[] = new ArrayList[V]; /*line dataType[] arrName = new dataType[size]*/
        for(int i = 0 ;  i < V ; i++){
            graph[i] =  new ArrayList<>();
        }
        createGraph(graph);
       int ans= connectedComponents(graph);
       System.out.println("Total connected components : " + ans);
       
        }
}