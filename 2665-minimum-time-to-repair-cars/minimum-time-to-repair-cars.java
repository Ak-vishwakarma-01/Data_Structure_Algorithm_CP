class Solution {
    private boolean isPoss(long time, int[] ranks, int cars){
        long count = 0;
        for(int rank: ranks){
            count += (long) Math.sqrt(time / rank);
            if(count >= cars) return true;
        }
        return false;
    }

    public long repairCars(int[] ranks, int cars) {
        long l = 1;
        long r = (long) ranks[0] * (long) cars * (long) cars; 
        for(int rank : ranks) {
            r = Math.min(r, (long) rank * (long) cars * (long) cars);
        }

        long ans = 0;
        while(l <= r){
            long mid = l + (r - l) / 2;
            if(isPoss(mid, ranks, cars)){
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
