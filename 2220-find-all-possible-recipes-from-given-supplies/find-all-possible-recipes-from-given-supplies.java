class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String , Integer> indegree = new HashMap<>();
        int n = recipes.length;
        for(int i=0;i<n;i++){
            for(String ingr: ingredients.get(i)){
                graph.putIfAbsent(ingr, new ArrayList<>());
                graph.get(ingr).add(recipes[i]);
                
            }
            indegree.put(recipes[i], ingredients.get(i).size());
        }
        Queue<String> q = new LinkedList<>();
        for(String le: supplies) q.offer(le);
        List<String> ans = new ArrayList<>();
        while(!q.isEmpty()){
            String ing = q.peek(); q.poll();
            if (!graph.containsKey(ing)) continue; 
            for(String rec: graph.get(ing)){
                if (!indegree.containsKey(rec)) continue;
                indegree.put(rec, indegree.get(rec) - 1);
                
                if (indegree.get(rec) == 0) {
                    ans.add(rec);
                    q.offer(rec); 
                }
            }
        }
        return ans;
    }
}