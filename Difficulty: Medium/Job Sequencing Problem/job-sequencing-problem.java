//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

import java.util.*;

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        int[][] jobs = new int[n][2];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = deadline[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(b[1], a[1]));

        int maxDeadline = Arrays.stream(deadline).max().orElse(0);
        boolean[] slot = new boolean[maxDeadline + 1];  
        int jobCount = 0, maxProfit = 0;

        for (int[] job : jobs) {
            int d = job[0];  
            int p = job[1];  

            for (int j = d; j > 0; j--) {
                if (!slot[j]) {  
                    slot[j] = true;
                    jobCount++;
                    maxProfit += p;
                    break;  
                }
            }
        }

        return new ArrayList<>(Arrays.asList(jobCount, maxProfit));
    }
}



//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends