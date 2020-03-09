package com.jjson.leetcode130;

/**
 * @author jiangjunshen
 * @date 2:22 下午 2020/3/7
 */
public class Solution {
    
    public void solve(char[][] board) {
        if (board == null || board.length < 2 || board[0].length < 2) {
            return;
        }
        int columnSize = board.length;
        int rowSize = board[0].length;

        for (int i = 0; i < columnSize; i++) {
            if (i == 0 || i == columnSize - 1) {
                traverseAll(board, rowSize, i);
            } else {
                traverseBothEnd(board, rowSize, i);
            }
        }

        for (int i = 0; i < columnSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void traverseAll(char[][] board, int rowSize, int i) {
        for (int j = 0; j < rowSize; j++) {
            if (board[i][j] == 'O') {
                dfs(board, i, j);
            }
        }
    }
    
    private void traverseBothEnd(char[][] board, int rowSize, int i) {
        if (board[i][0] == 'O') {
            dfs(board, i , 0);
        }
        if (board[i][rowSize - 1] == 'O') {
            dfs(board, i , rowSize - 1);
        }
    }
    
    private void dfs(char[][] board, int i, int j) {
        if (i < 0
            || i > board.length - 1
            || j < 0
            || j > board[0].length - 1
            || board[i][j] == '#'
            || board[i][j] == 'X') {
            return;
        }
        board[i][j] = '#';
        
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
