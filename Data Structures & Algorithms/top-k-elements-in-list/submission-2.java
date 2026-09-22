class Solution {
    // min heap approach
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 1) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            // place in heap but have the frequency as the key and number as the value
            heap.offer(new int[]{entry.getValue(), entry.getKey()});

            // Remove frequencies that are not in bound of k
            if (heap.size() > k) {
                heap.poll(); // remove the top (smallest) element;  kick out the smallest count
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            // [1] b/c remember that we switched frequency and number. so [1] get's the number again.
            res[i] = heap.poll()[1];
            // So empty the heap out so that it has all the top K frequent elements while also filling up the array
        }

        return res;
    }
}
/*
A PriorityQueue puts the element that the comparator considers "smallest" at the top (peek()/poll()).

negative → a before b a is "smaller" zero → equal any order positive → a after b b is "smaller"
So with a[0] - b[0]:

[1, 100] vs [5, 7] → 1 - 5 = -4 (negative) → [1,100] is smaller → it goes to the top.
Result: lowest frequency is always at the top → this is a min-heap.
*/
/*
Heapify: O(n)
Each pop takes O(logn), which we'll do K times = K*logn (better than nlogn)

Time complexity: O(nlogk)

Space complexity: O(n+k)
Where n is the length of the array and k is the number of top frequent elements.
*/

