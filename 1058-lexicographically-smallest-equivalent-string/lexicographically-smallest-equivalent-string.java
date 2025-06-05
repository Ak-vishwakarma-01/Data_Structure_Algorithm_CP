import java.util.*;

class Solution {
    int[] min = new int[26];
    boolean[] visit;
    Set<Integer> charvisit;
    int minval;

    private void dfs(char c, List<Integer>[] adj) {
        int idx = c - 'a';
        charvisit.add(idx);
        minval = Math.min(minval, idx);
        visit[idx] = true;
        for (int nei : adj[idx]) {
            if (visit[nei]) continue;
            dfs((char)(nei + 'a'), adj);
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = 26;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        int len = s1.length();
        for (int i = 0; i < len; i++) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            adj[u].add(v);
            adj[v].add(u);  
        }

        Arrays.fill(min, -1);
        visit = new boolean[26];

        for (int i = 0; i < 26; i++) {
            if (!visit[i]) {
                minval = Integer.MAX_VALUE;
                charvisit = new HashSet<>();
                dfs((char)(i + 'a'), adj);
                for (int x : charvisit) {
                    min[x] = minval;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            ans.append((char)(min[c - 'a'] + 'a'));
        }

        return ans.toString();
    }
}
