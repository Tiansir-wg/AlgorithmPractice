package edu.hit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 树的直径
 *
 * https://www.nowcoder.com/practice/a77b4f3d84bf4a7891519ffee9376df3?tpId=117&tqId=37824&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 *
 * 深度优先搜索
 *
 */

public class NC99 {

    class Interval {
        int start;
        int end;
    }

    // 图的边节点
    class Edge{
        int end;
        int value;

    }

    public int solve (int n, Interval[] Tree_edge, int[] Edge_value) {
        if(n == 0 || Tree_edge == null || Edge_value == null || Tree_edge.length != Edge_value.length) return 0;
        // 邻接表法表示图
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int i = 0;i < Tree_edge.length;i++){
            Interval interval = Tree_edge[i];
            // 起点、终点和权重
            int start  = interval.start;
            int end = interval.end;
            int value = Edge_value[i];
            // 构建边节点
            Edge edge1 = new Edge();
            edge1.end = end;
            edge1.value = value;
            if(!graph.containsKey(start)){
                List<Edge> edges = new ArrayList<>();
                graph.put(start,edges);
            }
            graph.get(start).add(edge1);

            // 双向的边节点
            Edge edge2 = new Edge();
            edge2.end = start;
            edge2.value = value;
            if(!graph.containsKey(end)){
                List<Edge> edges = new ArrayList<>();
                graph.put(end,edges);
            }
            graph.get(end).add(edge2);
        }

        // remote[0]表示从节点0开始的最长路径，remote[1]表示最长路径的端点
        int[] remote = new int[]{0,0};

        dfs(graph,0,-1,0,remote);

        int[] res = new int[]{0,0};

        dfs(graph, remote[1], -1, 0, res);

        return res[0];
    }

    private void dfs(Map<Integer, List<Edge>> graph,int from, int prev,int path, int[] remote){
        List<Edge> edges = graph.get(from);
        for(Edge edge : edges){
            if(edge.end != prev){
                path += edge.value;
                if(path > remote[0]){
                    remote[0] = path;
                    remote[1] = edge.end;
                }
                dfs(graph,edge.end, from,path, remote);
                path -= edge.value;
            }
        }
    }
}
