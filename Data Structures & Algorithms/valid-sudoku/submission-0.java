class Solution {
    // Brute force method, jjust similar to how I thought and checking each initially
    public boolean isValidSudoku(char[][] board) {
        // Check all the rows
        for (int row = 0 ; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            // We check each position within the row with i. We just add i to seen. if duplicate, then return false
            for (int i = 0; i <  9; i++) {
                if (board[row][i] == '.') continue;
                if (seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            }
        }

        // Check all the columns
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == '.') continue;
                if (seen.contains(board[i][col])) return false;
                seen.add(board[i][col]);
            }
        }

        // check each 3x3
        for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0 ; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }
        return true;
    }
}


/*
Time: O(n^2); pass_1 = O(n^2), pass_2 = O(n^2), pass_3 = O(n^2) = 3n^2 = n^2
Space: O(n); Each seen holds at most n characters. 3n = n
*/