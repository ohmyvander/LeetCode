/**
 * 二维数组，每个元素是个字母，上下左右表示连续。求是否包含字符串
 *
 * bfs，用的优先队列
 *
 * 372 ms, 39.4 MB
 */
public class Solution {
    static class Node {
        public int r;
        public int c;
        public int deep;
        public int pathHash;
        Node(int r, int c, int deep, int pathHash) {
            this.r = r;
            this.c = c;
            this.deep = deep;
            this.pathHash = pathHash;
        }
    }
    private static final int[] DIRR = { -1, 1, 0, 0 };
    private static final int[] DIRC = { 0, 0, -1, 1 };

    private Queue<Node> queue;

    public boolean bfs(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        Node node;
        while ((node = queue.poll()) != null) {
            int r = node.r;
            int c = node.c;
            int nextDeep = node.deep + 1;
            if (nextDeep == word.length()) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nr = node.r + DIRR[i];
                int nc = node.c + DIRC[i];
                if (nr >= 0 && nr < row && nc >= 0 && nc < column && board[nr][nc] == word.charAt(nextDeep)) {
                    int pathHash = 1 << (nr * column + nc);
                    if ((pathHash & node.pathHash) == 0) {
                        queue.offer(new Node(nr, nc, nextDeep, node.pathHash | pathHash));
                    }
                }
            }
        }
        return false;
    }

    static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            return Integer.compare(n2.deep, n1.deep);
        }
    }

    public boolean exist(char[][] board, String word) {
        queue = new PriorityQueue<>(new NodeComparator());
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == word.charAt(0)) {
                    queue.offer(new Node(i, j, 0, 1 << (i * column + j)));
                }
            }
        }
        return bfs(board, word);
    }
}
