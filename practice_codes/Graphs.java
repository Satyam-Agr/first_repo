package first_repo.practice_codes;
//Using array of arrayList.
import java.util.*;

public class Graphs {
    static class Edge {
        int src;
        int dest;
        int weight;
        Edge(int src, int dest, int weight)
        {
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }
    static void creatGraph(ArrayList<Edge> [] graph)
    {
        for (int i = 0; i < graph.length; i++) 
        {
            graph[i]=new ArrayList<>();
        }
        // graph[0].add(new Edge(0, 2,2));

        // graph[1].add(new Edge(1, 2, 10));
        // graph[1].add(new Edge(1, 3, 0));

        // graph[2].add(new Edge(2, 0, 2));
        // graph[2].add(new Edge(2, 1, 10));
        // graph[2].add(new Edge(2, 3, -1));

        // graph[3].add(new Edge(3, 2, -1));
        // graph[3].add(new Edge(3, 1, 0));
        /*
         0 --- 2 --- 3
                \   /
                  1 
        */
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
        /*
          1 --- 3
         /      | \
        0       |  5 -- 6
         \      | /
          2 ---- 4
        */

    }
    static void printNaeighbours(ArrayList<Edge> [] graph, int edge)
    {
        for (int i = 0; i < graph[edge].size(); i++) 
        {
            System.out.println(graph[edge].get(i).dest);
        }
    }
    static void bfs(ArrayList<Edge> [] graph, boolean []visited, int start)
    {
        LinkedList <Integer> queue=new LinkedList<>();
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int current=queue.removeFirst();
            if(!visited[current])
            {
                visited[current]=true;
                System.out.print(current+" ");
                for (int i = 0; i < graph[current].size(); i++) 
                {
                    queue.add(graph[current].get(i).dest);
                }
            }
        }
    }
    static void dfs(ArrayList<Edge> [] graph, boolean []visited, int current)
    {
        if(visited[current])
            return;
        visited[current]=true;
        System.out.print(current+ " ");
        for (int i = 0; i < graph[current].size(); i++) 
        {
            dfs(graph, visited, graph[current].get(i).dest);
        }
    }
    static void pathsDfs(ArrayList<Edge> [] graph, boolean []visited, int current, int destination, String path)
    {
        if(current==destination){
            System.out.print(path+current+ " ");
            return;
        }
        if(visited[current])
            return;

        visited[current]=true;
        for (int i = 0; i < graph[current].size(); i++) 
        {
            pathsDfs(graph, visited, graph[current].get(i).dest, destination,path+current);
        }
        visited[current]=false;
    }
    static boolean isCycle(ArrayList<Edge> [] graph, boolean []visited, int current, int par)
    {
        visited[current]=true;
        for (int i = 0; i < graph[current].size(); i++) 
        {
            Edge e=graph[current].get(i);
            if(visited[e.dest] && e.dest!=par)
            {   
               return true;
            }
            else if(!visited[e.dest])
            {
                boolean cycle= isCycle(graph, visited, e.dest, current);
                if(cycle)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        int v=7;
        ArrayList<Edge> [] graph=new ArrayList[v];
        creatGraph(graph);
        printNaeighbours(graph, 2);
        boolean[] visited =new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) 
        {
            if(!visited[i])
                bfs(graph, visited, i);
        }
        System.out.println();
        visited =new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) 
        {
            if(!visited[i])
                dfs(graph, visited, i);
        }
        System.out.println();
        visited =new boolean[graph.length];
        pathsDfs(graph, visited, 0, 3, "");
        System.out.println();
        visited =new boolean[graph.length];
        boolean cycle=false;
        for (int i = 0; i < graph.length; i++) 
        {
            if(!visited[i])
            {
                if(isCycle(graph, visited, i, -1))
                {
                    cycle=true;
                    break;
                }
            }
        }
        if(cycle)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
