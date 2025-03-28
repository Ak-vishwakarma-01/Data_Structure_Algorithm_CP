class Solution {
    int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m  = grid.length;
        int n  = grid[0].length;
        int k = queries.length;
        int arr[][] = new int[k][2];
        for(int i=0;i<k;i++){
            arr[i][0] = queries[i];
            arr[i][1] = i;  
        } 
        Arrays.sort(arr, (a ,b)-> Integer.compare(a[0],b[0]));
        boolean visit[][] = new boolean[m][n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.value-b.value);
        int i = 0;
        int points = 0;
        pq.add(new Pair(grid[0][0],0,0));
        while(!pq.isEmpty() && i<k){
            if(pq.peek().value<arr[i][0]){
                points++;
                Pair de = pq.poll();
                int x = de.x;
                int y = de.y;
                visit[x][y] = true;
                for(int dir[]: directions){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX<m && newX>=0 && newY<n && newY>=0 && !visit[newX][newY]){
                        pq.add(new Pair(grid[newX][newY],newX ,newY));
                        visit[newX][newY] = true;
                    }
                }
            }else{
                queries[arr[i][1]] = points;
                i++;
            }
        }

        while (i < k) {
            queries[arr[i][1]] = points;
            i++;
        }
        
        return queries;
    }
}
class Pair{
    int value;
    int x;
    int y;
    public Pair(int value, int x, int y){
        this.value = value;
        this.x = x;
        this.y = y;
    }
}