class Pair{
    int node;
    int weight;
    public Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    private void dfs(int node, List<Pair> list[], Set<Integer> nodes,TreeSet<Integer> weights, boolean visit[]){
        if(visit[node]) return;
        visit[node] = true;
        nodes.add(node);
        for(Pair p: list[node]){
            if(visit[p.node]) {
                weights.add(p.weight);
                continue;
            }
            nodes.add(p.node);
            weights.add(p.weight);
            dfs(p.node, list, nodes, weights, visit);
        }
    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        List<Pair> list[]  = new ArrayList[n]; // connectings nodes with Weight;
        for(int i=0;i<n;i++) list[i] = new ArrayList<>();
        for(int i[]: edges){
            list[i[0]].add(new Pair(i[1], i[2])); 
            list[i[1]].add(new Pair(i[0], i[2]));
        }
        boolean visit[] = new boolean[n];
        Map<Set<Integer>,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!visit[i]){
                Set<Integer> nodes = new HashSet<>();
                TreeSet<Integer> weights = new TreeSet<>();
                dfs(i,list, nodes, weights, visit);
                int minValue =  weights.isEmpty() ? 0:  weights.first();
                for(int val: weights) {
                    System.out.print(val+"  ");
                    minValue &= val;
                }
                mp.put(nodes,minValue);
            }
            System.out.println(i+"iska tha");
        }
        int len = query.length;
        int ans[] = new int[len];
        Arrays.fill(ans,-1);
        for(int i=0;i<len;i++){
            for(Map.Entry<Set<Integer>,Integer> values: mp.entrySet()){
                Set<Integer> nodes = values.getKey();
                if(nodes.contains(query[i][0]) && nodes.contains(query[i][1])){
                    ans[i] = values.getValue();
                    break;
                } 
            }
        }
        return ans;
    }
}