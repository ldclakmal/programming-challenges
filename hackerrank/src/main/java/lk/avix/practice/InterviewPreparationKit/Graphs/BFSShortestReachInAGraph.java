package lk.avix.practice.InterviewPreparationKit.Graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

public class BFSShortestReachInAGraph {

    private static final int EDGE_WEIGHT = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        for (int i = 0; i < queries; i++) {
            int nodes = scanner.nextInt();
            Node[] nodesList = new Node[nodes + 1];
            nodesList[0] = null;    // Redundant
            for (int j = 1; j <= nodes; j++) {
                nodesList[j] = new Node();
            }

            int edges = scanner.nextInt();
            for (int j = 0; j < edges; j++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                nodesList[u].addNeighbor(nodesList[v]);
            }

            int startIndex = scanner.nextInt();
            findDistance(nodesList[startIndex]);
            printDistance(nodesList, startIndex);
        }
        scanner.close();
    }

    private static void findDistance(Node start) {
        if (start == null) {
            return;
        }

        ArrayDeque<Node> deque = new ArrayDeque<>();
        start.distance = 0;
        deque.add(start);

        while (!deque.isEmpty()) {
            Node node = deque.remove();
            for (Node neighbor : node.neighbors) {
                if (neighbor.distance == -1) {
                    neighbor.distance = node.distance + EDGE_WEIGHT;
                    deque.add(neighbor);
                }
            }
        }
    }

    private static void printDistance(Node[] nodesList, int startIndex) {
        for (int i = 1; i < nodesList.length; i++) {
            if (i != startIndex) {
                System.out.print(nodesList[i].distance + " ");
            }
        }
        System.out.println();
    }

    private static class Node {

        public HashSet<Node> neighbors;
        public int distance;

        public Node() {
            neighbors = new HashSet<>();
            distance = -1;
        }

        public void addNeighbor(Node neighbor) {
            neighbors.add(neighbor);
            neighbor.neighbors.add(this);
        }
    }
}
