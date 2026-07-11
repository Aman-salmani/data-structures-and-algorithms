/* conditions for cycle detection in undirected graph....
Unvisited neighbor
    → DFS

Visited neighbor + neighbor != parent
    → Cycle exists

Visited neighbor + neighbor == parent
    → Ignore*/

import java.util.*;
public class UndirectedCycleDetection{
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
        graph[0].add(new Edge (0,3));

        /*for vertex 1 */
        graph[1].add(new Edge (1,2));
        graph[1].add(new Edge (1,0));

        /*for vertex 2 */
        graph[2].add(new Edge (2,1));
       // graph[2].add(new Edge (2,3));//


         /*for vertex 3 */
        graph[3].add(new Edge (3,4));
        graph[3].add(new Edge (3,0));
       // graph[3].add(new Edge (3,2));//

         /*for vertex 4 */
        graph[4].add(new Edge (4,3));
        /*for vertex 5 */
        graph[5].add(new Edge (5,6));
        /*for vertex 6 */
        graph[6].add(new Edge (6,5));
        }
        public static boolean hasCycle(ArrayList<Edge>[]graph){
            boolean[] vis = new boolean[graph.length]; 
            for(int i = 0 ; i < graph.length ; i++){
                if(!vis[i]){                                   // To check every component//
                boolean ans = detectCycleDFS(i, -1, graph, vis);
                if(ans){
                    return true;
                }
                }
            }
            return false;
        }
        public static boolean detectCycleDFS(int curr,int parent,ArrayList<Edge>[]graph,boolean[] vis){
           vis[curr] = true;
         for(Edge e : graph[curr]){
        // Case 1: Neighbor is unvisited//
            if(!vis[e.dest]){
                if(detectCycleDFS(e.dest, curr, graph, vis)){
                    return true;
                }
                }
// Case 2: Neighbor is visited and is not the parent -> cycle exists//
           else if( e.dest != parent){
                return true;
            }
                    }
                return false;
            }
    public static void main(String[] args) {
        int V  = 7 ;
        ArrayList<Edge>graph[] = new ArrayList[V]; /*line dataType[] arrName = new dataType[size]*/
        for(int i = 0 ;  i < V ; i++){
            graph[i] =  new ArrayList<>();
        }
        createGraph(graph);
       System.out.println("Cycle exist  : " + hasCycle(graph));
       
        }
}