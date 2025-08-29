class Solution {
    int check(int sum, int ind, int[] arr, int n) {
    int l = ind, r = n-1, last = ind-1;
    while(l <= r) {
        int mid = l + (r-l)/2;
        if(arr[mid] < sum) { // strictly less
            last = mid;
            l = mid+1;
        } else {
            r = mid-1;
        }
    }
    return last - ind + 1; // number of valid sides
}

    public int countTriangles(int arr[]) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int de = check(arr[i]+arr[j],j+1,arr,n);
                ans += de;
            }
        }
        return ans;
    }
}