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