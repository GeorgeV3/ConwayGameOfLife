
Create a game with the below rules
The rules of the game are:
The game consists of a 10 x 10 grid with each cell having a state of either ‘dead’ or ‘alive’,
represented by ‘0’ and ‘1’.
The game is about the state of the grid evolving, every generation the state of the cells will
change according to the following rules:
1) Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
2) Any live cell with more than three live neighbours dies, as if by overcrowding.
3) Any live cell with two or three live neighbours lives on to the next generation.
4) Any dead cell with exactly three live neighbours becomes a live cell.
A neighbour is defined as a cell directly to the left, right, top, or bottom of the current cell.
Your implementation should have a starting state (can be hard coded) and be able to calculate the
state after the next generation.
For output you can just write the 10x10 grid to the console.
