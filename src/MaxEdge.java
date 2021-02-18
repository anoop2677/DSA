/*
Problem Description

Given a tree with N nodes numbered from 1 to N.

Each edge is bi-directional and has a certain weight assigned to it.

You are given Q queries, in each query you are given two integers u and v and you are required to find the maximum weighted edge in a simple path from u to v.

You have to return the weight of the edge for each queries.



Problem Constraints
2 <= N, Q <= 105

1 <= u, v <= N and u != v

1 <= weight of any edge <= 108



Input Format
First argument is a 2-D array A of size (N-1) x 3 where (A[i][0], A[i][1]) denotes an edge of the tree from node A[i][0] to node A[i][1] with weight A[i][2].

Second argument is a 2-D array B of size Q x 2 denoting the queries, B[i][0] denotes u and B[i][1] denotes v.

Output Format
Return an integer array of size Q denoting the answer for each queries.



Example Input
Input 1:

 A = [  [1, 2, 11]
        [1, 3, 1]
        [2, 4, 12]
        [2, 5, 100]
     ]
 B = [  [3, 5]
        [2, 3]
     ]


Example Output
Output 1:

 [100, 11]


Example Explanation
Explanation 1:

 Query 1: u  = 3 and v = 5 so edge (2 -> 5) is the maximum weighted in the path from u to v so we will return the
 edge weight as the answer for this query.
 Query 2: u = 2 and  v= 3 so edge (2 -> 1) is the maximum weighted in the path from u to v so we will return the
 edge weight as the answer for this query.

 */
import java.util.LinkedList;

public class MaxEdge {
    public class Solution {

        class Edge{
            int n, w;
            Edge(int n , int w){
                this.n=n;
                this.w=w;
            }
        }


        private void dfs(int n1,int depth, LinkedList<Edge>[] adjacencyList,
                         Edge[] parentsEdge,int[] level,boolean[] visited ){
            //
            visited[n1] = true;
            level[n1] = depth;

            for(Edge en2: adjacencyList[n1]){
                if(!visited[en2.n]){
                    parentsEdge[en2.n] = new Edge(n1,en2.w);
                    dfs(en2.n,depth+1,adjacencyList,parentsEdge,level,visited);
                }
            }
        }



        public int[] solve(int[][] edges, int[][] queries) {
            //traverse the tree by depth first search and
            // precompute level[] and parents[]

            int N = edges.length + 1;//number of nodes 1 to N

            Edge[] parentsEdge = new Edge[N+1];//parent edge of node n
            int[] level = new int[N+1];// level of node n
            boolean[] visited = new boolean[N+1];

            LinkedList[]  adjacencyList = new LinkedList[N+1];

            //populare adjacency list
            for(int[] edge : edges){
                int n1 = edge[0], n2= edge[1], w = edge[2];
                if(adjacencyList[n1]==null)  adjacencyList[n1] = new LinkedList<Edge>();
                if(adjacencyList[n2]==null)  adjacencyList[n2] = new LinkedList<Edge>();
                adjacencyList[n1].add(new Edge(n2,w));
                adjacencyList[n2].add(new Edge(n1,w));
            }


            dfs(1,0,adjacencyList,parentsEdge,level,visited);

            int temp;
            int[] ans = new int[queries.length];

            for(int i=0;i<queries.length;i++){
                int u = queries[i][0], v = queries[i][1];
                if(level[u]<level[v]){
                    temp=u;
                    u=v;
                    v=temp;
                }

                //move up u to level of v, update max;
                int maxW = 0;
                while(level[u]!=level[v]){
                    int w = parentsEdge[u].w;
                    maxW = w>maxW?w:maxW;
                    u = parentsEdge[u].n;
                }

                if(u==v) {
                    ans[i] = maxW;
                    continue;
                }

                while(u!=v){
                    int wu =parentsEdge[u].w;
                    int wv =parentsEdge[v].w;
                    maxW = wu>maxW?wu:maxW;
                    maxW = wv>maxW?wv:maxW;
                    u = parentsEdge[u].n;
                    v = parentsEdge[v].n;
                }
                ans[i] = maxW;

            }

            return ans;

        }
    }
}
