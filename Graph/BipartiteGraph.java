import java.util.*;
public class BipartiteGraph{
    static class Edge{
        int src,dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void creatingGraph(ArrayList<Edge>[]graph){
         /*for vertex 0  */
        graph[0].add(new Edge (0,1));
        graph[0].add(new Edge (0,2));
        /*for vertex 1 */
        graph[1].add(new Edge (1,3));
        graph[1].add(new Edge (1,0));
        /*for vertex 2 */
        graph[2].add(new Edge (2,0));
        graph[2].add(new Edge (2,4));
         /*for vertex 3 */
        graph[3].add(new Edge (3,1));
        graph[3].add(new Edge (3,4));
         /*for vertex 4 */
        graph[4].add(new Edge (4,2));
        graph[4].add(new Edge (4,3));

        }
        public static boolean bipartite(ArrayList<Edge>[]graph){
            int[] color = new int[graph.length];
            for(int i = 0 ; i < color.length ; i++){
                color[i] = -1;
            }
            for(int i = 0 ; i < graph.length ; i++){
                if(color[i] == -1 ){
                boolean ans = bipartiteUtil(i , graph , color);
                    if(!ans){
                        return false;
                    }
                }
            }
            return true;
        }
        public static boolean bipartiteUtil(int curr, ArrayList<Edge>[]graph , int[]color){
            Queue<Integer> q = new LinkedList<>();
            q.add(curr); 
            color[curr] = 0 ;  // add starting point into queue//
            while(!q.isEmpty()){
                int col = q.remove();
                    for(Edge e : graph[col]){
                        if(color[e.dest] == -1){         ///neighbor is unnvisited//
                                color[e.dest] = 1 - color[col];
                        }
                        else if(color[e.dest] == color[col]){
                            return false;
                        }
                    }
            }
                    return true;
                        
                }
    public static void main(String[] args) {
        int V  = 5 ;
        ArrayList<Edge>[] graph = new ArrayList[V]; /*line dataType[] arrName = new dataType[size]*/
        for(int i = 0 ;  i < V ; i++){
            graph[i] =  new ArrayList<>();
        }
        creatingGraph(graph);
      System.out.println(bipartite(graph));  
       
        }
}