import java.util.Arrays;
import java.util.*;
import java.swing.*;

public class GoBangGame {
  public static final char BLANK='*'; 
  public static final char BLACK='@'; 
  public static final char WHITE='O'; 
  
  public static final int MAX = 16;
  private static final int COUNT = 5;
  //棋盘
  private char[][] board;
  
  public GoBangGame() {
   
  }
  //开始游戏
  public void start() {
    board = new char[MAX][MAX];
    //把二维数组都填充‘*’
    for(char[] ary: board){
      Arrays.fill(ary, BLANK);
    }
  }
  public char[][] getChessBoard(){
    return board;
  }
  public void addBlack(int x, int y) throws ChessExistException{
    //@
    //char blank = '*';
    //System.out.println( x +"," + y + ":" + board[y][x] + "," + BLANK);
    if(board[y][x] == BLANK){// x, y 位置上必须是空的才可以添棋子
      board[y][x] = BLACK;
      return;
    }
    throw new ChessExistException("已经有棋子了！");
  }
  public void addWhite(int x, int y) 
    throws ChessExistException{
    if(board[y][x] == BLANK){// x, y 位置上必须是空的才可以添棋子
      board[y][x] = WHITE;
      return;
    }
    throw new ChessExistException("已经有棋子了！");
  }
  //chess 棋子：'@'/'O'
  public boolean winOnY(char chess, int x, int y){
    //先找到y方向第一个不是 blank的棋子
    int top = y;
    while(true){
      if(y==0 || board[y-1][x]!=chess){
        //如果y已经是棋盘的边缘， 或者的前一个不是chess
        //就不再继续查找了
        break;
      }
      y--;
      top = y;
    }
    //向回统计所有chess的个数，如果是COUNT个就赢了
    int count = 0;
    y = top;
    while(true){
      if(y==MAX || board[y][x]!=chess){
        //如果找到头 或者 下一个子不是chess 就不再继续统计了
        break;
      }
      count++;
      y++;
    }
    return count==COUNT;
  }
  //chess 棋子：'@'/'O'
  public boolean winOnX(char chess, int x, int y){
    //先找到x方向第一个不是 blank的棋子
    int top = x;
    while(true){
      if(x==0 || board[y][x-1]!=chess){
        //如果x已经是棋盘的边缘， 或者的前一个不是chess
        //就不再继续查找了
        break;
      }
      x--;
      top = x;
    }
    //向回统计所有chess的个数，如果是COUNT个就赢了
    int count = 0;
    x = top;
    while(true){
      if(x==MAX || board[y][x]!=chess){
        //如果找到头 或者 下一个子不是chess 就不再继续统计了
        break;
      }
      count++;
      x++;
    }
    return count==COUNT;
  }
  
  //chess 棋子：'@'/'O'
  public boolean winOnXY(char chess, int x, int y){
    //先找MAX向第一个不是 blank的棋子
    int top = y;
    int left = x;
    while(true){
      if(x==0 || y==0 || board[y-1][x-1]!=chess){
        //如果x已经是棋盘的边缘， 或者的前一个不是chess
        //就不再继续查找了
        break;
      }
      x--;
      y--;
      top = y;
      left=x;
    }
    //向回统计所有chess的个数，如果是COUNT个就赢了
    int count = 0;
    x = left;
    y = top;
    while(true){
      if(x==MAX || y==MAX || board[y][x]!=chess){
        //如果找到头 或者 下一个子不是chess 就不再继续统计了
        break;
      }
      count++;
      x++;
      y++;
    }
    return count==COUNT;
  }
  //chess 棋子：'@'/'O'
  public boolean winOnYX(char chess, int x, int y){
    //先找到x方向第一个不是 blank的棋子
    int top = y;
    int left = x;
    while(true){
      if(x==MAX-1 || y==0 || board[y-1][x+1]!=chess){
        //如果x已经是棋盘的边缘， 或者的前一个不是chess
        //就不再继续查找了
        break;
      }
      x++;
      y--;
      top = y;
      left=x;
    }
    //向回统计所有chess的个数，如果是COUNT个就赢了
    int count = 0;
    x = left;
    y = top;
    while(true){
      if(x==0 || y==MAX || board[y][x]!=chess){
        //如果找到头 或者 下一个子不是chess 就不再继续统计了
        break;
      }
      count++;
      x--;
      y++;
    }
    return count==COUNT;
  }

  public boolean whiteIsWin(int x, int y) {
    //在任何一个方向上赢了，都算赢
    return winOnY(WHITE, x, y) || 
          winOnX(WHITE, x, y) ||
          winOnXY(WHITE, x, y) ||
          winOnYX(WHITE, x, y);
  }
  public boolean blackIsWin(int x, int y) {
    return winOnY(BLACK, x, y) || 
      winOnX(BLACK, x, y) ||
      winOnXY(BLACK, x, y) ||
      winOnYX(BLACK, x, y);
  }

}