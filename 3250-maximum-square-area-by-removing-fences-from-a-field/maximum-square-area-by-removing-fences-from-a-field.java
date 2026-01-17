class Solution {

    private Set<Integer> calcst(ArrayList<Integer> dede) {
        Set<Integer> st = new HashSet<>();
        int size = dede.size();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                st.add(dede.get(j) - dede.get(i));
            }
        }
        return st;
    }

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int mod = 1_000_000_007;

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int x : hFences) list1.add(x);
        for (int x : vFences) list2.add(x);

        list1.add(1);
        list1.add(m);
        list2.add(1);
        list2.add(n);

        Collections.sort(list1);
        Collections.sort(list2);

        Set<Integer> st1 = calcst(list1);
        Set<Integer> st2 = calcst(list2);

        long max = -1;
        for (int d : st1) {
            if (st2.contains(d)) {
                max = Math.max(max, (long) d * d);
            }
        }

        return max == -1 ? -1 : (int) (max % mod);
    }
}