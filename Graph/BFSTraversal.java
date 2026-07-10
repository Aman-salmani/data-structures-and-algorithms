import java.util.*;
public class BFSTraversal{
    static class Edge{
        int src,dest,wt;
        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void creatingGraph(ArrayList<Edge>[]graph){
         /*for vertex 0  */
        graph[0].add(new Edge (0,1,5));
        /*for vertex 1 */
        graph[1].add(new Edge (1,2,1));
        graph[1].add(new Edge (1,3,3));
        graph[1].add(new Edge (1,0,5));
        /*for vertex 2 */
        graph[2].add(new Edge (2,1,1));
        graph[2].add(new Edge (2,3,1));
        graph[2].add(new Edge (2,4,2));
         /*for vertex 3 */
        graph[3].add(new Edge (3,1,3));
        graph[3].add(new Edge (3,2,1));
         /*for vertex 4 */
        graph[4].add(new Edge (4,2,2));
        }
        public static void bfsTraversal(ArrayList<Edge>[]graph){
            Queue<Integer> q = new LinkedList<>();
            boolean[] vis = new boolean[graph.length];
            q.add(0); 
            vis[0] = true;  // add starting point into queue//
            while(!q.isEmpty()){
                int curr = q.remove();
                System.out.print(curr+" ");
                    for(int i = 0 ; i < graph[curr].size() ; i++){
                        Edge e = graph[curr].get(i);
                        if(!vis[e.dest]){
                            vis[e.dest] = true;
                            q.add(e.dest);
                        }
                        
                    }
                }
            }
    public static void main(String[] args) {
        int V  = 5 ;
        ArrayList<Edge>[] graph = new ArrayList[V]; /*line dataType[] arrName = new dataType[size]*/
        for(int i = 0 ;  i < V ; i++){
            graph[i] =  new ArrayList<>();
        }
        creatingGraph(graph);
        bfsTraversal(graph);
       
        }
}