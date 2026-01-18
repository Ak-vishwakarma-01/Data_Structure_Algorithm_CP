class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        List<Cap> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            int ca = capacity[i];
            int co = costs[i];
            li.add(new Cap(ca,co));
        }
        Collections.sort(li,(a,b)->Integer.compare(a.co, b.co));
        int maxarr[] = new int[n];
        maxarr[0] = li.get(0).ca;
        for(int i=1;i<n;i++){
            maxarr[i] = Math.max(li.get(i).ca,maxarr[i-1]);
        }
        int ans = 0;
        for(int i=n-1;i>=0;i--){
            int l = 0,r=i-1;
            if(li.get(i).co<budget){
                int capi = li.get(i).ca;
                int costi = li.get(i).co;
                ans = Math.max(ans,capi);
                while(l<=r){
                    int mid = l + (r-l)/2;
                    if(li.get(mid).co<budget-costi){
                        ans = Math.max(ans,capi+maxarr[mid]);
                        l = mid+1;
                    }else r = mid-1;
                }
            }
        }
        return ans;
    }
}


class Cap{
    int ca;
    int co;
    public Cap(int ca,int co){
        this.ca = ca;
        this.co =co;
    }
}