package edu.hit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小生成树
 *
 * https://www.nowcoder.com/practice/735a34ff4672498b95660f43b7fcd628?tpId=117&tqId=37869&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class NC159 {

    // 边节点
    class Edge{
        int start;
        int end;
        int cost;
        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    // m表示路的数量
    public int miniSpanningTree (int n, int m, int[][] cost) {
        // 并查集
        int[] unionSet = new int[n + 1];
        // 初始所有节点所在集合的顶点
        Arrays.fill(unionSet, -1);
        // 小根堆
        PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });
        for(int i = 0;i < m;i++){
            queue.add(new Edge(cost[i][0],cost[i][1],cost[i][2]));
        }
        int totalCost = 0;
        // 每次从边集合选出最小的边
        while(!queue.isEmpty()){
            Edge temp = queue.poll();
            // 如果两个顶点不在一个集合，将其并入一个集合
            if(find(unionSet, temp.start) != find(unionSet, temp.end)){
                totalCost += temp.cost;
                union(unionSet, temp.start, temp.end);
            }
        }
        return totalCost;
    }

    // 将两个顶点并入一个集合
    private void union(int[] set, int node1, int node2) {
        int temp1 = find(set, node1);
        int temp2 = find(set, node2);
        if(temp1 != temp2){
            set[temp1] = temp2;
        }
    }

    // 查找顶点所在集合的根顶点
    private int find(int[] set, int node) {
        while(set[node] != -1){
            node = set[node];
        }
        return node;
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        int[][] costs = {{1,3,3}, {1,2,1}, {2,3,1}};
        NC159 nc159 = new NC159();
        System.out.println(nc159.miniSpanningTree(n, m, costs));
    }
}
