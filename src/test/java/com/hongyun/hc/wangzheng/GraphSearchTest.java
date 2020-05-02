package com.hongyun.hc.wangzheng;

import data.Graph;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphSearchTest {
    boolean dfsFound = false;

    @Test
    public void testDFS() {
        Graph graph = Graph.getTestData();
        int vertexSize = graph.v;
        boolean[] visited = new boolean[vertexSize];
        int[] prev = new int[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            prev[i] = -1;
        }

        int s = 0;
        int t = graph.v - 1;
        doDFS(graph, visited, prev, s, t);

        if (dfsFound) {
            print(prev, s, t);
        }
    }

    @Test
    public void testBFS() {
        Graph graph = Graph.getTestData2();
        int vertexSize = graph.v;
        boolean[] visited = new boolean[vertexSize];
        int[] prev = new int[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            prev[i] = -1;
        }

        int s = 0;
        int t = graph.v - 1;
        doBFS(graph, visited, prev, s, t);
    }

    /**
     * dfs prev: -1,0,1,4,5,2,4,6
     * 0-1-2
     * | | |
     * 3-4-5
     * | |
     * 6-7
     */
    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    private void doBFS(Graph graph, boolean[] visited, int[] prev, int s, int t) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (queue.size() != 0) {
            int i = queue.poll();
            List<Integer> connectedVertex = graph.adj.get(i);
            for (Integer vertex : connectedVertex) {
                if (!visited[vertex]) {
                    prev[vertex] = i;
                    if (vertex == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[vertex] = true;
                    queue.add(vertex);
                }
            }
        }
    }

    private void doDFS(Graph graph, boolean[] visited, int[] prev, int s, int t) {
        if (dfsFound) return;
        visited[s] = true;
        if (s == t) {
            dfsFound = true;
            return;
        }
        while (true) {
            List<Integer> list = graph.adj.get(s);
            for (Integer integer : list) {
                if (!visited[integer]) {
                    prev[integer] = s;
                    doDFS(graph, visited, prev, integer, t);
                }
            }

            if (dfsFound) break;
        }
    }
}
