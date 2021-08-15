/**
 * 按右下左上的顺序从左上角开始顺序输出二维数组
 *
 * 0ms, 37 MB
 */
class Solution {
    private static final int[] DIRR = { 0, 1, 0, -1 };
    private static final int[] DIRC = { 1, 0, -1, 0 };
    private static int[][] visited;

    private boolean canVisit(int r, int c, int row, int column) {
        return r >= 0 && r < row && c >= 0 && c < column && visited[r][c] == 0;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        visited = new int[row][column];
        List<Integer> result = new ArrayList<>();
        int r = 0, c = 0;
        int order = 0;
        boolean end = false;
        visited[r][c] = 1;
        result.add(matrix[r][c]);
        while (!end) {
            end = true;
            int nr, nc, step;
            step = order + 4;
            for (; order < step; order++) {
                int o = order % 4;
                nr = r + DIRR[o];
                nc = c + DIRC[o];
                if (canVisit(nr, nc, row, column)) {
                    r = nr;
                    c = nc;
                    visited[r][c] = 1;
                    result.add(matrix[r][c]);
                    end = false;
                    break;
                }
            }
        }
        return result;
    }
}
