// There are a total of n courses you have to take, labeled from 0 to n - 1.

// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

// For example:

// 2, [[1,0]]
// There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

// 2, [[1,0],[0,1]]
// There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

// Note:
// The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

// click to show more hints.

// Subscribe to see which companies asked this question

// Hide Tags Depth-first Search Breadth-first Search Graph Topological Sort
// Hide Similar Problems (M) Course Schedule II (M) Graph Valid Tree (M) Minimum Height Trees

// BFS, much faster, refer to Kahn's algorithm on wiki
// Kahn's algorithm[edit]
// One of these algorithms, first described by Kahn (1962), works by choosing vertices in the same order as the eventual topological sort. First, find a list of "start nodes" which have no incoming edges and insert them into a set S; at least one such node must exist in a non-empty acyclic graph. Then:

// L ← Empty list that will contain the sorted elements
// S ← Set of all nodes with no incoming edges
// while S is non-empty do
//     remove a node n from S
//     add n to tail of L
//     for each node m with an edge e from n to m do
//         remove edge e from the graph
//         if m has no other incoming edges then
//             insert m into S
// if graph has edges then
//     return error (graph has at least one cycle)
// else 
//     return L (a topologically sorted order)

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] incoming = new int[numCourses];
        Queue queue = new LinkedList();
        int count=0;
        
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
            
        for(int i=0; i<prerequisites.length;i++){
            incoming[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i=0; i<incoming.length;i++){
            if(incoming[i] == 0){
                queue.add(i);
                count++;
            }
        }
        
        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                incoming[pointer]--;
                if(incoming[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses)
            return true;
        else    
            return false;
    }
}
// DFS
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return true;
        }
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
        
        boolean[] visited = new boolean[numCourses];
        ArrayList[] graph = new ArrayList[numCourses]; // array of arraylist
        // initialize the graph
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        // establish the graph
        for (int i = 0; i < prerequisites.length; i++) {
            //System.out.println(prerequisites[i][1] + " " + prerequisites[i][0]);
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs (ArrayList[] graph, boolean[] visited, int index) {
        if (visited[index]) {
            return false;
        }
        visited[index] = true;
        for (int i = 0; i < graph[index].size(); i++) {
            if (!dfs(graph, visited, (int)graph[index].get(i))) {
                return false;
            }
        }x
        visited[index] = false;
        return true;
    }
}