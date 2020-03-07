package Graphs;

import java.util.HashMap;
import java.util.Map;

public class BstCount {
    /*
     * created by Jayaram on 09/12/19
     */
    private Map<Integer, Integer> m = new HashMap<>();
    public int numTrees(int n) {
        if (n <= 1) return 1;
        if (m.containsKey(n)) return m.get(n);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += (numTrees(i-1) * numTrees(n-i));
        }
        m.put(n, res);
        return res;
    }
}
