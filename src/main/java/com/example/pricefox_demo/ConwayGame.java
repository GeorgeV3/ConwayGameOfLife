package com.example.pricefox_demo;


import lombok.Getter;

@Getter
public class ConwayGame {

  private static int M = 10, N = 10;

  /**
   * Create and initial the grid. O = present a Dead Cell 1 = present a Live Cell
   */
  static int[][] initialGrid = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
      {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
      {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
  };


  public static void runGame() {
    displayingTheGrid(initialGrid, "Original Generation" + "\n");
    nextGeneration(initialGrid, M, N);
  }

  /**
   * Generate the next level of cells base of 4 conditions
   * <p>
   * O = is a Dead Cell
   * <p>
   * 1 = is a Live Cell
   *
   * @param grid =the starting grid
   * @param M
   * @param N
   */
  private static void nextGeneration(int[][] grid, int M, int N) {
    int[][] future = new int[M][N];

    for (int l = 1; l < M - 1; l++) {
      for (int m = 1; m < N - 1; m++) {
        // finding no Of Neighbours that are alive
        int aliveNeighbours = 0;
        for (int i = -1; i <= 1; i++) {
          for (int j = -1; j <= 1; j++) {
            aliveNeighbours += grid[l + i][m + j];
          }
        }

        // The cell needs to be subtracted from
        // its neighbours as it was counted before
        aliveNeighbours -= grid[l][m];

        //Conditions for next generation cells

        //1)Underpopulation: Cell has lower than 2 live cells and it is dies
        if ((grid[l][m] == 1) && (aliveNeighbours < 2)) {
          future[l][m] = 0;
        }

        //2)Overcrowding: Cell has more than 3 live and it is dies
        else if ((grid[l][m] == 1) && (aliveNeighbours > 3)) {
          future[l][m] = 0;
        }

        //3)Next generation Cell has 2 or 3 live cells
        else if ((grid[l][m] == 0) && (aliveNeighbours == 3 || aliveNeighbours == 2)) {
          future[l][m] = 1;
        }

        //4)Dead cell: Cell with exactly 3 live cells become live
        else if ((grid[l][m] == 0) && (aliveNeighbours == 3)) {
          future[l][m] = 1;
        }
        // Remains the same
        else {
          future[l][m] = grid[l][m];
        }
      }
    }

    displayingTheGrid(future, "Next generation" + "\n");
  }

  /**
   * Print the grid to console , where A is for Alive cell and D is for Dead cell
   */
  private static void displayingTheGrid(int[][] grid, String msg) {
    System.out.println(msg);
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (grid[i][j] == 0) {
          System.out.print("D");
        } else {
          System.out.print("A");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

}
