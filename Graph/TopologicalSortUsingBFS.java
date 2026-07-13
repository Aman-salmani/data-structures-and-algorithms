/* createGraph - 
    5 → 0 ← 4
    ↓       ↓
    2 → 3 → 1
*/
import java.util.*;
public class TopologicalSortUsingBFS{
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
             Queue<Integer> q = new LinkedList<>();
            int[] inDegree = new int[graph.length];
                for(int i = 0 ; i < graph.length ; i++){ // to traverse every node//
                    for(Edge e : graph[i]){     // to traverse every neighbor//
                        inDegree[e.dest]++;
                    }
                } 
            for(int i =0; i < graph.length ; i++){   //add all inDegree 0 nodes into Queue//
                if(inDegree[i]==0){
                q.add(i);
                }
            }
            topologicalBFS(graph,inDegree,q);

        }
        public static void topologicalBFS(ArrayList<Edge>[]graph,int[] inDegree,Queue<Integer> q){
            while(!q.isEmpty()){
             int node = q.remove();
             System.out.print(node+" ");
            for(Edge e : graph[node]){
                inDegree[e.dest]--;
               if(inDegree[e.dest]==0){
                q.add(e.dest);
               }
                }
            }
         
            }
    public static void main(String[] args) {
        int V  = 6 ;
        ArrayList<Edge>[] graph = new ArrayList[V]; 
        for(int i = 0 ;  i < V ; i++){
            graph[i] =  new ArrayList<>();
        }
        createGraph(graph);
        topological(graph);
       
        }
}