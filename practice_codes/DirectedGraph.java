package first_repo.practice_codes;

import java.util.*;

public class DirectedGraph {
    static class Edge {
    int src;
    int dest;
    int wt;
    public Edge(int s, int d) {
        this.src = s;
        this.dest = d;
    }
    public Edge(int s, int d, int wt) {
        this.src = s;
        this.dest = d;
        this.wt = wt;
    }
}
    //graph1 - true
    // static void createGraph(ArrayList<Edge> graph[]) {
    //     for(int i=0; i<graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }
    //     graph[0].add(new Edge(0, 2));
    //     graph[1].add(new Edge(1, 0));
    //     graph[2].add(new Edge(2, 3));
    //     graph[3].add(new Edge(3, 0));
    // }
    //graph2 - false
    // static void createGraph(ArrayList<Edge> graph[]) {
    //     for(int i=0; i<graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }
    //     graph[0].add(new Edge(0, 1));
    //     graph[0].add(new Edge(0, 2));

    //     graph[1].add(new Edge(1, 3));
    //     graph[2].add(new Edge(2, 3));
    // }
    // Graph 3 Topological Sort
    // static void createGraph(ArrayList<Edge> graph[]) {
    //     for(int i=0; i<graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }
    //     graph[2].add(new Edge(2, 3));
    //     graph[3].add(new Edge(3, 1));
    //     graph[4].add(new Edge(4, 0));
    //     graph[4].add(new Edge(4, 1));
    //     graph[5].add(new Edge(5, 0));
    //     graph[5].add(new Edge(5, 2));
    // }
    //Graph 4 Dijkstra's Algorithm
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
    public static boolean isCyclicUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) { //cycle exists
                return true;
            } 
            else if(!vis[e.dest]) {
                if(isCyclicUtil(graph, e.dest, vis, stack))
                    return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public static boolean isCyclic(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(vis[i] == false) {
                boolean cycle = isCyclicUtil(graph, i, vis, new boolean[vis.length]);
            if(cycle) {
                return true;
            }
            }
        }
        return false;
    }
    static void topologicalSorting(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> stack)
    {
        if(vis[curr])
            return;
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) 
        {
            topologicalSorting(graph, graph[curr].get(i).dest, vis, stack);
        }
        stack.push(curr);
    }
    public static void topoSort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
         Stack<Integer> stack=new Stack<>();
        for(int i=0; i<graph.length; i++) {
            topologicalSorting(graph, i, vis, stack);
        }
        while (!stack.empty()) {
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }
    //helper class
    static class Pair implements Comparable<Pair> {
        int ver;
        int path;
        Pair(int ver, int path)
        {
            this.path=path;
            this.ver=ver;
        } 
        @Override
        public int compareTo(Pair p2)
        {
            return this.path-p2.path;
        }
    }
    //Dijkstr's Algorithem
    public static void shortestPath(ArrayList<Edge>[] graph, int start)
    {
        boolean vis[]=new boolean[graph.length];
        int paths[]=new int[graph.length];
        for (int i = 0; i < graph.length; i++) 
        {
            paths[i]=Integer.MAX_VALUE;
        }
        paths[start]=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair curr=pq.poll();
            if(!vis[curr.ver])
            {
                vis[curr.ver]=true;
                for (int i = 0; i < graph[curr.ver].size(); i++) 
                {
                    Edge e= graph[curr.ver].get(i);
                    int u=e.src;
                    int v=e.dest;
                    if(paths[v]>paths[u]+e.wt)
                    {
                        paths[v]=paths[u]+e.wt;
                        pq.add(new Pair(v, paths[v]));
                    } 
                }
            }
        }
        for (int i = 0; i < graph.length; i++) 
        {
            System.out.print(paths[i]+ " ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCyclic(graph));
        topoSort(graph);
        shortestPath(graph, 0);
    }
}