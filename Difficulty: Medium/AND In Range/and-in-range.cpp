class Solution {
  public:
    int andInRange(int l, int r) {
        // code here
        int n = r;
        while(n>l){
            n = n&(n-1);
        }
        return n;
    }
};
