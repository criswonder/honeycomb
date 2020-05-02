package data;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    public int v;
    public List<List<Integer>> adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.add(i, new LinkedList<>());
        }
    }

    public void addEdge(int start, int end) {
        adj.get(start).add(end);
        adj.get(end).add(start);
    }

    /**
     * 括号里面是vertex的index
     * 4(0)-3(1)-2(2)-1(3)
     * |    |         |
     * 5(4)-8(5)------5(6)
     */
    public static Graph getTestData() {
        int vertexSize = 7;
        Graph graph = new Graph(vertexSize);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(1, 5);
        graph.addEdge(3, 6);
        return graph;
    }

    /**
     * 0-1-2
     * | | |
     * 3-4-5
     *   | |
     *   6-7
     */
    public static Graph getTestData2() {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(2,5);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
        return graph;
    }
}
