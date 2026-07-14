
import java.util.*;
public class DijkstraAlgo{
    static class Edge{
        int src,dest,wt;
        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph){
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
         static class Pair implements Comparable<Pair>{
            int n;
            int p;
            Pair(int n, int p){
                this.n = n;
                this.p = p;
            }

            @Override
            public int compareTo(Pair p2){
                            return this.p - p2.p;
        }
    }
        public static void dijkstra(int src,ArrayList<Edge>[]graph){
            PriorityQueue<Pair>pq = new PriorityQueue<>();
            int [] dist = new int[graph.length];
            for(int i = 0 ; i < graph.length ; i++){
                if(i!=src){
                    dist[i] = Integer.MAX_VALUE;
                }
            }
            pq.add(new Pair(src,0));
            while(!pq.isEmpty()){
                Pair curr = pq.remove();
                for(Edge e : graph[curr.n]){
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u]+ e.wt < dist[v]){
                        dist[v] = dist[u]+ e.wt ;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
            for(int i = 0 ; i < dist.length ; i++){
                System.out.print(dist[i]+" ");
            }
            }
    public static void main(String[] args) {
        int V  = 5 ;
        ArrayList<Edge>[] graph = new ArrayList[V]; /*line dataType[] arrName = new dataType[size]*/
        for(int i = 0 ;  i < V ; i++){
            graph[i] =  new ArrayList<>();
        }
        int src = 0;
        createGraph(graph);
        dijkstra(src,graph);
       
        }
}