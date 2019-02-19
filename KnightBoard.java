
public class KnightBoard{
  private int[][] board;
  private int order = 1;

  public KnightBoard(int startingRows,int startingCols){
    board = new int [startingRows][startingCols];
    order  = 0;
    if (startingRows <= 0 || startingCols <= 0){
      throw new IllegalStateException();
    }
  }

  public String toString(){
    // String result = "";
    // for(int i = 0 ; i < startingRows; i++){
    //   result += "\n";
    //   for(int j = 0; j < startingCols; j++){
    //     if(board[i][j] == ){;
    //     }
    //     else{
    //       board[i][j]
    //     }
    //   }
    // }
    return "";
  }

  public boolean addKnights(int row, int col){
    if (row <= 0 || col <= 0){
      throw new IllegalArgumentException();
    }
    if (board[row][col] == 0){
      board[row][col] = order;
      order ++;
      return true;
    }
      return false;
    }

  public boolean removeKnights(int row, int col){
    if (row <= 0 || col <= 0){
      throw new IllegalArgumentException();
    }
    if (board[row][col] != 0){
      board[row][col] = 0;
      return true;
    }
    return false;
  }

  public boolean solve(int startingRow, int startingCol){
    // for(int i = 0; i < startingRow; i++){
    //   for(int j = 0; j< startingCol; j++){
    //     if (board[i][j] != 0){
    //       throw new IllegalStateException();
    //     }
    //   }
    // }
    // if (startingRow < 0 || startingCol < 0){
    //   return false;
    // }
    //   return solveH(startingrow, startingCol);
    return false;
    }

  private boolean solveH(int row, int col, int moveNumber){
    // if (moveNumber == 0){return true}
    // if (addKnights(row,col)){
    //   if (solveH(row + 1, col + 2, moveNumber - 1) || solveH(row + 2, col + 1, moveNumber - 1)
    //       || solveH(row - 1, col - 2, moveNumber - 1) || solveH(row - 2, col - 1, moveNumber - 1)){
    //         return true;
    //       }
    //   else{
    //     removeKnights(row, col);
    //   }
    // }
      return false;
  }

  public int countSolutions(int startingRow, int startingCol){
      return 0;
    }
  }
