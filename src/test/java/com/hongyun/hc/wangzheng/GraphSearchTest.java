package com.hongyun.hc.wangzheng;

import data.Graph;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphSearchTest {
    boolean dfsFound = false;

    @Test
    public void testDFS() {
        Graph graph = Graph.getTestData();
        int vertexSize = graph.vertex;
        boolean[] visited = new boolean[vertexSize];
        int[] prev = new int[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            prev[i] = -1;
        }

        int s = 0;
        int t = graph.vertex - 1;
        doDFS(graph, visited, prev, s, t);

        if (dfsFound) {
            print(prev, s, t);
        }
    }

    @Test
    public void testBFS() {
        Graph graph = Graph.getTestData();
        int vertexSize = graph.vertex;
        boolean[] visited = new boolean[vertexSize];
        int[] prev = new int[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            prev[i] = -1;
        }

        int s = 0;
        int t = graph.vertex - 1;
        doBFS(graph, visited, prev, s, t);

//        print(prev, s, t);
    }

    private void print(int[] pre, int s, int t) {
        if (pre[t] != -1 && s != t) {
            print(pre, s, pre[t]);
        }
        System.out.print(t + " ");
    }

    private void doBFS(Graph graph, boolean[] visited, int[] prev, int s, int t) {
        Queue<Integer> queue = new ArrayDeque<>(graph.vertex);
        queue.add(s);

        while (queue.size() != 0) {
            Integer i = queue.poll();
            visited[i] = true;
            List<Integer> connectedVertex = graph.edges.get(i);
            for (Integer vertex : connectedVertex) {
                if (!visited[vertex]) {
                    prev[vertex] = i;
                    if (vertex == t) {
                        print(prev, s, t);
                        return;
                    }

                    queue.add(vertex);
                }
            }
        }
    }

    private void doDFS(Graph graph, boolean[] visited, int[] prev, int s, int t) {
        visited[s] = true;
        if (s == t) {
            dfsFound = true;
            return;
        }
        while (true) {
            List<Integer> list = graph.edges.get(s);
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
