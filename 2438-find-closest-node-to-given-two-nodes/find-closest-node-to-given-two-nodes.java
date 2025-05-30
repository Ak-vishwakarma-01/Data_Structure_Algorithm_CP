class Solution {
    private int[] dijk(int node, int n, List<Integer>[] adj) {
        int[] len = new int[n];
        Arrays.fill(len, Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        len[node] = 0;
        q.add(new Pair(node, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int chi = p.node;
            int dist = p.dist;
            for (int i : adj[chi]) {
                if (dist + 1 < len[i]) {
                    len[i] = dist + 1;
                    q.add(new Pair(i, len[i]));
                }
            }
        }
        return len;
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) adj[i].add(edges[i]);
        }

        int[] first = dijk(node1, n, adj);
        int[] second = dijk(node2, n, adj);
        int minDist = Integer.MAX_VALUE;
        int connectionNode = -1;

        for (int i = 0; i < n; i++) {
            if (first[i] != Integer.MAX_VALUE && second[i] != Integer.MAX_VALUE) {
                int maxDist = Math.max(first[i], second[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    connectionNode = i;
                }
            }
        }
        return connectionNode;
    }
}

class Pair {
    int node;
    int dist;
    public Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
