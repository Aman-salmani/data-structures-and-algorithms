/*  Conditions 
Unvisited neighbor
    → DFS

Visited + in current DFS path
    → Cycle exists

Visited + not in current DFS path
    → Ignore

DFS completed
    → pathVis[curr] = false */
import java.util.*;
public class DirectedCycleDetection{
    static class Edge{
        int src,dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph){
         /*for vertex 0  */
        graph[0].add(new Edge (0,2));

        /*for vertex 1 */
        graph[1].add(new Edge (1,0));

        /*for vertex 2 */
       graph[2].add(new Edge (2,3));


         /*for vertex 3 */
        graph[3].add(new Edge (3,0));
        /* Directed graph - 
        1
        |
        v
        0 ------> 2
        ^         |
        |         |
        +---- 3 <-+

Cycle: 0 -> 2 -> 3 -> 0
*/
        }
        public static boolean hasCycle(ArrayList<Edge>[]graph){
            boolean[] vis = new boolean[graph.length]; 
            boolean[] pathVis = new boolean[graph.length];
            for(int i = 0 ; i < graph.length ; i++){
                if(!vis[i]){                                   // To check every component//
                boolean ans = detectCycleDFS(i, graph, vis,pathVis);
                if(ans){
                    return true;
                }
                }
            }
            return false;
        }
        public static boolean detectCycleDFS(int curr,ArrayList<Edge>[]graph,boolean[] vis , boolean[] pathVis){
            vis[curr] = true;
            pathVis[curr] = true;
            for(Edge e : graph[curr]){
                //neighbor is visited and  present in the current DFS path//
                if(pathVis[e.dest] == true){
                    return true;
                }
                // Neighbor is unvisited//
                else if(!vis[e.dest]){
                        if(detectCycleDFS(e.dest, graph, vis,pathVis)){
                            return true;
                        }
                }
            } 
            // remove current node from the current DFS path// 
            pathVis[curr] = false;
            return false;
        }
    public static void main(String[] args) {
        int V  = 4 ;
        ArrayList<Edge>graph[] = new ArrayList[V]; /*line dataType[] arrName = new dataType[size]*/
        for(int i = 0 ;  i < V ; i++){
            graph[i] =  new ArrayList<>();
        }
        createGraph(graph);
       System.out.println("Cycle exist  : " + hasCycle(graph));
       
        }
}