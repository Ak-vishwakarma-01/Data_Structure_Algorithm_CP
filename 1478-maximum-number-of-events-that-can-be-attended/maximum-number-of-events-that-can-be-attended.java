class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a,b)-> {
            return a[0] - b[0];
        });
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int day = events[0][0];
        int count = 0;
        int i = 0;
        while(!pq.isEmpty() || i<n){
            while(i<n && events[i][0]==day){
                pq.add(events[i][1]);
                i++;
            }
            if(!pq.isEmpty()){
                pq.poll();
                count++;
            }

            day++;

            while(!pq.isEmpty() && pq.peek()<day){
                pq.poll();
            }
        }
        
        return count;
    }
}