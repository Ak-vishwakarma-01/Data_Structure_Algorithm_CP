class Solution {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        PriorityQueue<Pair> nodes = new PriorityQueue<>((p1, p2) -> p1.time - p2.time);
        nodes.add(new Pair(0, 0, 0, 2));

        int[][] res = new int[n][m];
        for (int[] row : res) Arrays.fill(row, Integer.MAX_VALUE);
        res[0][0] = 0;

        while (!nodes.isEmpty()) {
            Pair node = nodes.poll();
            int time = node.time;
            int x = node.x;
            int y = node.y;
            int increaseTime = node.increaseTime;
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int incTime = increaseTime== 1 ? 2:1;
                    int currtime = Math.max(time + incTime, moveTime[nx][ny] + incTime);
                    if (currtime < res[nx][ny]) {
                        res[nx][ny] = currtime;
                        nodes.add(new Pair(currtime, nx, ny, incTime));
                    }
                }
            }
        }
        return res[n-1][m-1];
    }

    class Pair {
        int time;
        int increaseTime = 1;
        int x;
        int y;

        public Pair(int time, int x, int y, int inct) {
            this.time = time;
            this.x = x;
            this.y = y;
            increaseTime = inct;
        }
    }
}
