Alice and Bob have an undirected graph of n nodes and three types of edges:

Type 1: Can be traversed by Alice only.
Type 2: Can be traversed by Bob only.
Type 3: Can be traversed by both Alice and Bob.
Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi, find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.

Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph.

 Solution:
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        int[] rootA = new int[n + 1];
        int[] rootB = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            rootA[i] = i;
            rootB[i] = i;
        }

        int res = 0;
        int aliceEdges = 0;
        int bobEdges = 0;

        
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (union(edge[1], edge[2], rootA)) {
                    aliceEdges++;
                    if (union(edge[1], edge[2], rootB)) {
                        bobEdges++;
                    }
                } else {
                    res++;
                }
            }
        }

        int[] rootA_copy = rootA.clone();

        
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (union(edge[1], edge[2], rootA)) {
                    aliceEdges++;
                } else {
                    res++;
                }
            }
        }

        
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (union(edge[1], edge[2], rootB)) {
                    bobEdges++;
                } else {
                    res++;
                }
            }
        }

        return (aliceEdges == bobEdges && aliceEdges == n - 1) ? res : -1;
    }

    public boolean union(int a, int b, int[] root) {
        int rootA = find(a, root);
        int rootB = find(b, root);
        if (rootA == rootB) {
            return false;
        }
        root[rootA] = rootB;
        return true;
    }

    public int find(int a, int[] root) {
        if (root[a] != a) {
            root[a] = find(root[a], root);
        }
        return root[a];
    }
}
