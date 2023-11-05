package EserciziBacktracking.Esercitazione.LongestRun;

public class LongestPathMatrix {
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int longestPath(int[][] grid) {
        int longest = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] memo = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                longest = Math.max(longest, dfs(grid, i, j, memo));
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%d\t", memo[i][j]);
            }

            System.out.println("");
        }

        return longest;
    }

    public static int dfs(int[][] grid, int row, int col, int[][] memo) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int longest = 1;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < grid.length &&
                newCol >= 0 && newCol < grid[0].length &&
                grid[newRow][newCol] < grid[row][col]) {
                int len = 1 + dfs(grid, newRow, newCol, memo);
                longest = Math.max(longest, len);
            }
        }

        memo[row][col] = longest;
        return longest;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {56, 14, 51, 58, 88},
            {26, 94, 24, 39, 41},
            {24, 16, 8, 51, 51},
            {76, 72, 77, 43, 10},
            {38, 50, 59, 84, 81},
            {5, 23, 37, 71, 77},
            {96, 10, 93, 53, 82},
            {94, 15, 96, 69, 9},
            {74, 0, 62, 38, 96},
            {37, 54, 55, 82, 38}
        };

        int longest = longestPath(grid);
        System.out.println("La lunghezza del percorso più lungo è: " + longest);
    }
}
