import java.util.ArrayList;
public class KnightBoard{
  private int[][] board;
  private int area;
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
    area  = board.length * board[0].length;
  }

  public String toString(){
    String result = "";
    for(int i = 0 ; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        result += " ";
        if (area >= 10){
          if (board[i][j] >= 10){
            result += board[i][j];
          }
          else{
            result += " " + board[i][j];
          }
        }
        else{
          result += " " + board[i][j];
        }
      }
        result += "\n";
    }
      return result;
  }

  private boolean addKnights(int row, int col, int movenumber){
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length){
      return false;
    }
    if (board[row][col] == 0){
      board[row][col] = movenumber;
      return true;
    }
      return false;
    }

  private boolean removeKnights(int row, int col){
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length){
      return false;
    }
    if (board[row][col] != 0){
      board[row][col] = 0;
      return true;
    }
    return false;
  }

  public boolean solve(int startingRow, int startingCol){
     if (startingRow < 0 || startingCol < 0 || startingRow >= data[0].length || startingCol >= data.length){
       throw new IllegalArgumentException();
     }
      return solveH(startingRow, startingCol, 0);
    }

  private boolean solveH(int row, int col, int moveNumber){
    if (moveNumber == area){
      return true;
    }
    for (int i = 0; i < 8; i++){
      if (addKnights(row, col,moveNumber)){
        if (solveH(row + posXmove[i], col + posYmove[i], moveNumber + 1)){
            return true;
          }
        removeKnights(row, col);
        }
    }
    return false;
  }

  public int countSolutions(int startingRow, int startingCol){
    return countH(startingRow, startingCol, 1);
  }

  private int countH(int row, int col, int moveNumber){
    int count = 0;
    if (startingRow < 0 || startingCol < 0 || startingRow >= data[0].length || startingCol >= data.length){
      throw new IllegalArgumentException();
    }
    if(addKnights(row,col,moveNumber)){
      if (moveNumber == area){
        removeKnights(row,col);
        return 1;
      }
      else{
        for(int i = 0; i < 8; i++){
            count += countH(row + posXmove[i], col + posYmove[i], moveNumber + 1);
    //        removeKnights(row + posXmove[i], col + posYmove[i]);
          }
        }
        removeKnights(row,col);
    }
      return count;
  }

  public void optcountmoves(int row, int col, ArrayList<Integer[][]> nextMoves){
    // int priority;
    // int xvals;
    // int yvals;
    // for (int i = 0; i < 8; i++){
    //   priority[i] = nextMoves.get()
    // }
    // if(addKnights(row,col,moveNumber)){
    //   if (moveNumber == area){
    //     removeKnights(row,col);
    //     return 1;
    //   }
    //   else{
    //     for(int i = 0; i < 8; i++){
    //       if (!(row < 0 || col < 0 || row >= board.length || col >= board[0].length)){
    //         smove = board[row + posXmove[i]][col + posYmove[i]]
    //         nextMoves.add(smove);
    //         smove = 0;
    //       }
    //     }
    //     if  (smoves != board[i]
    //   }
    // }
    //sort the arraylist
    // for (int i = 0; i < nextMoves.size(); i += 2;){
    //   for (int j = 0; j <nextMoves.size(); j++){
    //     nextMoves[i] = nextMoves[j];
    //   }
    // }
    }

   public static void main(String[] args){
    KnightBoard board = new KnightBoard(10,10);
  //  System.out.println(board.countSolutions(0,0));
    System.out.println(board);
  }
}
