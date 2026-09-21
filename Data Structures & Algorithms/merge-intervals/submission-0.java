class Solution {
    public int[][] merge(int[][] intervals) {
        // Most comparison based sorts at best will be O(nlogn)

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];
            // res.size() -1 -> last elelment of list. [1] -> end interval value
            int lastEnd = res.get(res.size() -1)[1];

            if (start <= lastEnd) {
                // Merge the interval in place by comparing the max of the current end and the "lastEnd"
                res.get(res.size() -1)[1] = Math.max(lastEnd, end);
            } else {
                // Else, there is no overlap so just add it to end of list
                res.add(new int[]{start, end});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

/*
Time: O(nlogn)
Space: O(n) -> for the output list
*/
