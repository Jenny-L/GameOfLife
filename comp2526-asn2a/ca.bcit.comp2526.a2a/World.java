package ca.bcit.comp2526.a2a;

import javax.swing.JPanel;

/**
 * World. Contains an array of Cells.
 * @author jennyly
 * @version 1.0
 */
public class World extends JPanel {
     
     private static final int MAX = 100;
     private static final int HERB_MAX = 80;
     private static final int PLANT_MAX = 50;
     private int row;
     private int column;
     private Cell[][] grid;
     
     /**
      * Constructor.
      * @param row as int
      * @param column as int
      */
     public World(int row, int column) {
          this.row = row;
          this.column = column;
          grid = new Cell[row][column];
     }
     
     
     /**
      * Add the appropriate number of herbivore, plants 
      * and empty to their respective arrays.
      */
     public void init() {
          for (int i = 0; i < column; i++) {
               for (int j = 0; j < row; j++) {
                    int random = RandomGenerator.nextNumber(MAX);
                    grid[i][j] = new Cell(World.this, i, j);
                    if (random >= HERB_MAX) {
                         grid[i][j].setHoldable(new Herbivore(grid[i][j]));
                         grid[i][j].getHoldable().init();
                    } else if (random >= PLANT_MAX) {
                         grid[i][j].setHoldable(new Plant(grid[i][j]));
                         grid[i][j].getHoldable().init();
                    } else {
                         grid[i][j].setHoldable(new Holdable(grid[i][j]));
                         grid[i][j].getHoldable().init();
                    }
               }
          }
     }
     
     /**
      * Decrease dayCount by one and if dayCount == 0.
      * Removes dead herbivore, 
      * checks each plant to see if it seeds, 
      * moves remaining plant living Herbivore to one cell.
      */
     public void takeTurn() {
          for (int i = 0; i < row; i++) {
               for (int j = 0; j < column; j++) {
                    if (grid[i][j].getHoldable().getType(grid[i][j]) 
                              == Type.HERBIVORE) {
                         grid[i][j].getHoldable().die();
                    }
               }
          }
          for (int i = 0; i < row; i++) {
               for (int j = 0; j < column; j++) {
                    if (grid[i][j].getHoldable().getType(grid[i][j]) 
                              == Type.PLANT) {
                         grid[i][j].addToAdjArray();
                         grid[i][j].getHoldable().move();
                    }

               }
          }
          for (int i = 0; i < row; i++) {
               for (int j = 0; j < column; j++) {
                    if (grid[i][j].getHoldable().getType(grid[i][j]) 
                              == Type.HERBIVORE) {
                         grid[i][j].addToAdjArray();
                         grid[i][j].getHoldable().move();

                    }
               }
          }
          for (int i = 0; i < row; i++) {
               for (int j = 0; j < column; j++) {
                    grid[i][j].setMoved(true);
               }
          }
          
     }
     
     /**
      * Retrieve the requested Cell from the specified location in the World.
      * @param x as int
      * @param y as column
      * @return Cell location
      */
     public Cell getCellAt(int x, int y) {
          return grid[x][y];
     }
     
     /**
      * Get row count.
      * @return row as int
      */
     public int getRowCount() {
          return row;
     }
     
     /**
      * Get column count.
      * @return column as int
      */
     public int getColumnCount() {
          return column;
     }
     
     
}
