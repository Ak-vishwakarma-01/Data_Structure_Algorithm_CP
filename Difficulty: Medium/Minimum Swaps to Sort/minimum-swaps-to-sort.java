//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends



class Solution {
    // Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int arr[]) {
        // Code here
        int n = arr.length;
        Pair sortedarr[] = new Pair[n];
        for(int i=0;i<n;i++){
            sortedarr[i] = new Pair(arr[i], i);
        }
        Arrays.sort(sortedarr, (a,b)-> a.val - b.val);
        int swap = 0;
        for(int i=0;i<n;i++){
            int val = sortedarr[i].val;
            int ind = sortedarr[i].ind;
            if(ind != i){
                Pair rand = sortedarr[i];
                sortedarr[i] = sortedarr[ind];
                sortedarr[ind] = rand;
                swap++;
                i--;
            }
        }
        return swap;
    }
}

class Pair{
    int val;
    int ind;
    public Pair(int val, int ind){
        this.val = val;
        this.ind = ind;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int ans = obj.minSwaps(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends