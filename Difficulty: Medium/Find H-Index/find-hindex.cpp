class Solution {
  public:
    int hIndex(vector<int>& citations) {
        // code here
        int n=citations.size();
        sort(citations.begin(),citations.end());
        int ans=0;
        if(citations[0]>=n)return n;
        for(int i=0;i<n;i++){
            if(citations[i]>=n-i){
                ans=max(ans,n-i);
            }
        }
        return ans;
    }
};