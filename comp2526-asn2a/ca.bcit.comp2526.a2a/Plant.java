package ca.bcit.comp2526.a2a;

import java.awt.Color;

/**
 * Plant.
 * @author jennyly
 * @version 1.0
 */
public class Plant extends LivingObject {
     private static final int MIN_EMPTY = 3;
     private Cell location;
     private Type type;


     /**
      * Constructor.
      * @param location as Cell
      */
     public Plant(Cell location) {
          super(location);
          this.location = location;
          type = Type.PLANT;
          // TODO Auto-generated constructor stub
     }

     /**
      * Sets background to green.
      */
     public void init() {
          location.getJPanel().setBackground(Color.green);
     }
     
     /**
      * Puts plant on specific cell.
      * @param location2 as Cell
      */
     public void setCell(Cell location2) {
     
     }
     
     /**
      * Adds an additional plant if at least 2 neighbours are plants
      * and if there is at least 3 empty spaces.
      */
     public void move() {
          if (location.getPlantCount() >= 2 
                    && location.getEmptyCount() >= MIN_EMPTY) {
               int index = RandomGenerator.nextNumber(location.getEmptyCount());
               Cell selectedCell = location.getEmptyArray().get(index);
               new Plant(selectedCell).init();
          }
     }
     
     /**
      * No plant die method is needed.
      */
     public void die() {
          
     }
     
     /**
      * Gets cell type.
      * @param location2 as Cell
      * @return type
      */
     public Type getType(Cell location2) {
          return type;
     }
     
     
}
