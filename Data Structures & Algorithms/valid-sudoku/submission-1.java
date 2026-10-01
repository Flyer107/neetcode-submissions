class Solution {
     // https://www.youtube.com/watch?v=TjFXEUCMqI8
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        // So double for loop to hit each cell to check -> O(n^2) w/ checking board[r][c]
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                // floor division at play here.
                String squareKey = (r / 3) + "," + (c / 3);

                // hashset per row, col, and square to check
                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) {
                    return false;
                }

                // Just add to it if we have not seen before.
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }
        return true;
    }
}
/*
Logic is actually similar to the brute force solution of checking and adding if not a violation
Time: O(n^2)
Space: O(n^2)
*/
/*
Example 1 and see how the box key (r / 3) * 3 + c / 3 maps every cell to one of 9 box indices.

The board (with row/col indices)
     c=0  c=1  c=2 | c=3  c=4  c=5 | c=6  c=7  c=8
r=0   1    2    .  |  .    3    .  |  .    .    .
r=1   4    .    .  |  5    .    .  |  .    .    .
r=2   .    9    8  |  .    .    .  |  .    .    3
      ------------+-------------+------------
r=3   5    .    .  |  .    6    .  |  .    .    4
r=4   .    .    .  |  8    .    3  |  .    .    5
r=5   7    .    .  |  .    2    .  |  .    .    6
      ------------+-------------+------------
r=6   .    .    .  |  .    .    .  |  2    .    .
r=7   .    .    .  |  4    1    9  |  .    .    8
r=8   .    .    .  |  .    8    .  |  .    7    9
Integer division intuition
r / 3 and c / 3 do floor division — they collapse each group of 3 indices into one value:

0, 1, 2 0 3, 4, 5 1 6, 7, 8 2
Same for columns. So r / 3 gives you the which row-band (0, 1, or 2), and c / 3 gives you the which column-band.

Why (r / 3) * 3 + c / 3 gives a unique box id
This is just flattening a 2D coordinate (rowBand, colBand) into a single number 0–8 — the same way you'd index a 3×3 grid:

        colBand=0   colBand=1   colBand=2
rowBand=0    0           1           2
rowBand=1    3           4           5
rowBand=2    6           7           8
Formula check:

(0,0) → 0*3 + 0 = 0 (top-left box)
(0,2) → 0*3 + 2 = 2 (top-right box)
(1,1) → 1*3 + 1 = 4 (center box)
(2,2) → 2*3 + 2 = 8 (bottom-right box) ✓
*/