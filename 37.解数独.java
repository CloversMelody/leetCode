/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(int rel=0;rel<9;rel++){
                        board[i][j] = (char)(48+rel);
                        if(checkSudoku(board,i,j))
                            solveSudoku(board);
                        else
                            board[i][j] = '.';
                    }
                }
            }
        }
    }

    private boolean checkSudoku(char[][] board,int i,int j){
        char in = board[i][j];
        //检查插入元素所在行
        for(int c=0;c<9;c++){
            if(c==j) continue;
            if(board[i][c]==in)
                return false;
        }
        //检查插入元素所在列
        for(int r=0;r<9;r++){
            if(r==i) continue;
            if(board[r][j]==in)
                return false;
        }
        //检查所在九宫格
        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                int newR = i/3*3+r;
                int newC = j/3*3+c;
                if(newR==i && newC==j)
                    continue;
                if(board[newR][newC]==in)
                    return false;
            }
        }
        return true;
    }
}
// @lc code=end

