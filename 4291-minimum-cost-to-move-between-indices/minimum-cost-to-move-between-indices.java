class Solution {
    public int[] minCost(int[] nums, int[][] qr) {
        int n = nums.length;
        int pref[] = new int[n];
        int suf[] = new int[n];

        pref[0] = 1;
        for(int i=1;i<n-1;i++){
            if(Math.abs(nums[i]-nums[i+1])<Math.abs(nums[i]-nums[i-1])){
                pref[i] = 1 + pref[i-1];
            }else{
                pref[i] = Math.abs(nums[i]-nums[i+1]) + pref[i-1];
            }
        }

        suf[n - 1] = 1;
        for (int i = n - 2; i > 0; i--) {
            int cost;
            if (Math.abs(nums[i] - nums[i - 1]) <= Math.abs(nums[i] - nums[i + 1])) {
                cost = 1;
            } else {
                cost = Math.abs(nums[i] - nums[i - 1]);
            }
            suf[i] = suf[i + 1] + cost;
        }

        suf[0] = suf[1];

        // for(int i=0;i<n;i++){
        //     System.out.println(pref[i]);
        // }

        for(int i=0;i<n;i++){
            System.out.println(suf[n-1-i]);
        }

        int qsize = qr.length;
        int ans[] = new int[qsize];
        for (int i = 0; i < qsize; i++) {
            int ind1 = qr[i][0];
            int ind2 = qr[i][1];
            // System.out.println(ind1 + "    " + ind2);
            if (ind1 < ind2) {
                if (ind1 == 0)
                    ans[i] = pref[ind2 - 1];
                else
                    ans[i] = pref[ind2 - 1] - pref[ind1 - 1];
            } else if (ind1 > ind2) {
                if(ind1==(n-1)) ans[i] = suf[ind2+1];
                else ans[i] = suf[ind2+1] - suf[ind1+1];
            } else
                ans[i] = 0;

            // System.out.println(ans[i]);
        }
        return ans;

    }
}