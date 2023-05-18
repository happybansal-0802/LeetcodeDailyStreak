Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.

Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.

Notice that you can return the vertices in any order.

 solution:
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        
        for(List<Integer> list: edges){
            indegree[list.get(1)]++;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                list.add(i);
            }
        }
        return list;
    }
}
