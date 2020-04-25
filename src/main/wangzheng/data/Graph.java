package data;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    public int vertex;
    public List<List<Integer>> edges;

    public Graph(int vertex) {
        this.vertex = vertex;
        edges = new LinkedList<>();
        for (int i = 0; i < vertex; i++) {
            edges.add(i, new LinkedList<>());
        }
    }

    public void addEdge(int start, int end) {
        edges.get(start).add(end);
        edges.get(end).add(start);
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
}
