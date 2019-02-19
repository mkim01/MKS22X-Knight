
public class KnightBoard{
  private int[][] board;
  private int order = 1;
  private int area = board.length * board[0].length;
  private int[] posXmove = {1, -1, -2, -2, -1,  1, 2,  2};
  private int[] posYmove = {2,  2,  1, -1, -2, -2, 1, -1};

  public KnightBoard(int startingRows,int startingCols){
    if (startingRows <= 0 || startingCols <= 0){
      throw new IllegalStateException();
    }
    board = new int [startingRows][startingCols];
    for(int i = 0; i < startingRows; i++){
      for(int j = 0; j< startingCols; j++){
        board[i][j] = 0;
      }
    }
  }

  public String toString(){
    String result = "";
    for(int i = 0 ; i < board.length; i++){
      result += "\n";
      for(int j = 0; j < board[0].length; j++){
        if (area >= 10 || board[i][j] < 10){
          result += "" + board[i][j];
        }
        else{
          result += " "+ board[i][j];
      }
    }
  }
    return result;
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
    for(int i = 0; i < startingRow; i++){
      for(int j = 0; j< startingCol; j++){
        if (board[i][j] != 0){
          throw new IllegalStateException();
        }
      }
    }
    if (startingRow <= 0 || startingCol <= 0){
      throw new IllegalArgumentException();
    }
    //  return solveH(startingrow, startingCol, area);
      return false;
    }

  private boolean solveH(int row, int col, int moveNumber){
    // if (row >= board.length || row <= 0 || col >= board[0].length || col <= 0){
    //       return false;
    // }
    if (moveNumber == area){
      return true;
    }
    for(int i = 0; i < 8; i++){
     if (addKnights(row, col)){
        solveH(row + posXmove[i], col + posYmove[i], moveNumber + 1);
      }
    else{
      removeKnights(row,col);
      }
    }
      return false;
  }

  public int countSolutions(int startingRow, int startingCol){
      return 0;
    }

  // public static void main(String[] args){
  //   KnightBoard board = new KnightBoard(5,5);
  //   System.out.println(board);
  // }
}
