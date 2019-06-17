import java.util.*;
public class KnightBoard{
  private int[][] board;
  private int[][] optboard;
  private int area;
  private int[] posXmove = {1, -1, -2, -2, -1,  1, 2,  2};
  private int[] posYmove = {2,  2,  1, -1, -2, -2, 1, -1};


  private class Block implements Comparable<Block>{
    public int r;
    public int c;
    public Block(int r, int c){
      this.r = r;
      this.c = c;
    }

    public int compareTo(Block other){
      return optboard[r][c] - optboard[other.r][other.c];
    }
  }

  public KnightBoard(int startingRows,int startingCols){
    if (startingRows <= 0 || startingCols <= 0){
      throw new IllegalStateException();
    }
    board = new int [startingRows][startingCols];
    optboard = new int[startingRows][startingCols];
    // fillout();
    for(int i = 0; i < startingRows; i++){
      for(int j = 0; j< startingCols; j++){
        board[i][j] = 0;
        optboard[i][j] = 0;
        for (int k =0; k < posXmove.length; k++){
          if (i + posXmove[k]>= 0 && i + posXmove[k] < board.length && j + posYmove[k] >= 0 && j + posYmove[k] < board.length){
            optboard[i][j]++;
        }
       }
      }
  }
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
    if (board[row][col] != 0){
      return false;
    }
    else{
      board[row][col] = movenumber;
      return true;
      }
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

  public boolean checkstate(){
    int num = 0;
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j <board[0].length; j++){
        if (board[i][j] != 0){
          num++;
        }
      }
    }
    if (num > 0){
      return false;
    }
    return true;
  }

  public boolean solve(int startingRow, int startingCol){
     if (startingRow < 0 || startingCol < 0 || startingRow >= board[0].length || startingCol >= board.length){
       throw new IllegalArgumentException();
     }
     if (!checkstate()){
       throw new IllegalStateException();
     }
     addKnights(startingRow, startingCol, 1);
      return optsolveH(startingRow, startingCol,2);
    }

    //// optimization;
      // public boolean optimzationsolve(int row, int col, int movenumber){
      //   fillout();
      //   board[row][col] = 1;
      //   return optsolveH(row,col);
      // }


        // // 2 3 4 3 2     2 2 2     2 3 3 2    2 3 4 4 3 2
        // // 3 4 6 4 3     2 0 2     3 4 4 2    3 4 6 6 4 3
        // // 4 6 8 6 4     2 2 2     3 4 4 2    4 6 8 8 6 4
        // // 3 4 6 4 3               2 3 3 2    4 6 8 8 6 4
        // // 2 3 4 3 2                          3 4 6 6 4 3
        //                                       2 3 4 4 3 2
        // possible moves : 2, 3, 4, 6, 8

      //   private boolean validmove(int r, int c){
      //     if (r >= 0 && r < board.length && c>=0 && c < board[0].length){
      //       return true;
      //     }
      //     return false;
      //   }
      //
      //   public String fillout(){
      //     for (int i = 0; i < optboard.length; i++){
      //       for (int j = 0; j < optboard[0].length; j++){
      //         board[i][j] = 0;
      //       }
      //     }
      //
      //     String res = "";
      //     for(int i = 0; i < optboard.length; i++){
      //       for(int j = 0; j < optboard[0].length; j++){
      //         //initialize the optboard with 8 moves and change depends on the condition
      //         optboard[i][j] = 8;
      //         //positions which knight can move to 2 possible ways
      //         if ((i == 0 && j == optboard[i].length - 1) || (i == optboard.length -1 && j == 0)
      //         || (i == optboard.length - 1 && j == optboard[i].length - 1) || (i == 0 && j == 0)){
      //           optboard[i][j] = 2;
      //         }
      //         //positions which knight can move to 3 possible ways
      //         if ((i == optboard.length - 2 && j == 0) || (i == optboard.length - 2 && j == optboard[i].length -1)
      //         || (i == optboard.length - 1 && j == optboard[j].length - 2) || (i == 0 && j == optboard[i].length -2)
      //         || (i == 1 && j == optboard[i].length -1) || (i == 1 && j == 0) || (i == 0 && j == 1)){
      //           optboard[i][j] = 3;
      //         }
      //         //positions which knight can move to 4 possible ways
      //         if((i == 1 && j == optboard[i].length - 2) || (i == optboard.length - 2 && j == optboard[i].length - 2)
      //         ||(i == optboard.length - 1 || j == optboard[i].length - 1)  || (i == optboard.length - 2 && j == 1)){
      //           optboard[i][j] = 4;
      //         }
      //         //positions which knight can move to 6 possible ways
      //         if(i == 1 || j == 1 || i == optboard.length - 2|| j == optboard[i].length - 2){
      //           optboard[i][j] = 6;
      //         }
      //         res += " " + optboard[i][j];
      //     }
      //     res += "\n";
      //   }
      //     return res;
      // }

      public String toStringopt(){
        String ans = "";
        for(int i = 0; i < optboard.length; i++){
          for(int j = 0; j < optboard[i].length; j++){
            if (optboard[i][j]< 10){
              ans += " "+optboard[i][i]+" ";
            }
            else {
              ans+= optboard[i][j]+" ";
            }
          }
        }
        return ans;
      }

  private boolean solveH(int row, int col, int movenumber){
    if (movenumber == area + 1){
      return true;
    }
    for (int i = 0; i < 8; i++){
      if (addKnights(row, col, movenumber)){
        if (solveH(row + posXmove[i], col + posYmove[i], movenumber + 1)){
            return true;
          }
        removeKnights(row, col);
        }
    }
    return false;
  }

  public int countSolutions(int startingRow, int startingCol){
    if (startingRow < 0 || startingCol < 0 || startingRow >= board[0].length || startingCol >= board.length){
      throw new IllegalArgumentException();
    }
    if (!checkstate()){
      throw new IllegalStateException();
    }
    return countH(startingRow, startingCol, 1);
  }

  private int countH(int row, int col, int moveNumber){
    int count = 0;
    if(addKnights(row,col,moveNumber)){
      if (moveNumber == area){
        removeKnights(row,col);
        return 1;
      }
      else{
        for(int i = 0; i < 8; i++){
            count += countH(row + posXmove[i], col + posYmove[i], moveNumber + 1);
          }
        }
        removeKnights(row,col);
    }
      return count;
  }


  public static void runTest(int i){
    KnightBoard b;
    int[]m =   {4,5,5,5,5};
    int[]n =   {4,5,4,5,5};
    int[]startx = {0,0,0,1,2};
    int[]starty = {0,0,0,1,2};
    int[]answers = {0,304,32,56,64};
    if(i >= 0 ){
      try{
        int correct = answers[i];
        b = new KnightBoard(m[i%m.length],n[i%m.length]);

        int ans  = b.countSolutions(startx[i],starty[i]);

        if(correct==ans){
          System.out.println("PASS board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans);
        }else{
          System.out.println("FAIL board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans+" vs "+correct);
        }
      }catch(Exception e){
        System.out.println("FAIL Exception case: "+i);

      }
    }
  }

  public static void main(String[] args){
   // for (int i = 0; i < 5; i++){
   //   runTest(i);
   // }
   KnightBoard board = new KnightBoard(5,5);
   System.out.println(board.solve(0,0));
   System.out.println(board);
}



}
