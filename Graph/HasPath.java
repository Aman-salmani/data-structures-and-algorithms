import java.util.*;
public class HasPath{
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
        graph[0].add(new Edge (0,1,1));
        graph[0].add(new Edge (0,2,1));

        /*for vertex 1 */
        graph[1].add(new Edge (1,3,1));
        graph[1].add(new Edge (1,0,1));
        /*for vertex 2 */
        graph[2].add(new Edge (2,0,1));
        graph[2].add(new Edge (2,4,1));
         /*for vertex 3 */
        graph[3].add(new Edge (3,1,1));
        graph[3].add(new Edge (3,4,1));
        graph[3].add(new Edge (3,5,1));

         /*for vertex 4 */
        graph[4].add(new Edge (4,2,1));
        graph[4].add(new Edge (4,3,1));
        graph[4].add(new Edge (4,5,1));
        /*for vertex 5 */
        graph[5].add(new Edge (5,3,1));
        graph[5].add(new Edge (5,4,1));
        graph[5].add(new Edge (5,6,1));
         /*for vertex 6 */
        graph[6].add(new Edge (6,5,1));


        }
        public static boolean haspath(int st,int endpoint,ArrayList<Edge>[]graph){
            if(st == endpoint){   /* Source and destination are the same*/
                return true;
            }
            Queue<Integer> q = new LinkedList<>();
            boolean[] vis = new boolean[graph.length];
            q.add(st); 
            vis[st] = true;  // add starting point into queue//
            while(!q.isEmpty()){
                int curr = q.remove();
                    for(Edge e : graph[curr]){
                        if(!vis[e.dest]){
                            if(e.dest == endpoint){   /*Path exist */
                                return true;
                            }
                            vis[e.dest] = true;
                            q.add(e.dest);
                        }
                    }
                }
                return false;
            }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V]; /*line dataType[] arrName = new dataType[size]*/
        for(int i = 0 ;  i < V ; i++){
            graph[i] =  new ArrayList<>();
        }
        int st = 0;
        int endpoint = 5;
        createGraph(graph);
        System.out.println("Path exist ? "+ haspath(st,endpoint,graph));
       
        }
}