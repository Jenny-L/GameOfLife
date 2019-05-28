package ca.bcit.comp2526.a2a;

import java.awt.Color;

/**
 * Herbivore.
 * @author jennyly
 * @version 1.0
 *
 */
public class Herbivore extends LivingObject {
     private static final int MAX_HUNGER = 10;
     private int dayCountDown;
     private Type type;
     private Cell location;

     /**
      * Constructor.
      * @param location as Cell
      */
     public Herbivore(Cell location) {
          super(location);
          this.location = location;
          type = Type.HERBIVORE;
          dayCountDown = MAX_HUNGER;

     }

     /**
      * Sets the background to yellow.
      */
     public void init() {
          location.getJPanel().setBackground(Color.yellow);
     }

     /**
      * Puts a herbivore on a specific cell.
      * @param locat as Cell
      */
     public void setCell(Cell locat) {
          this.location = locat;
          locat.setHoldable(this);
          init();
     }

     /**
      * Moves herbivore one cell where it eats the plant if cell contain plant.
      */
     public void move() {
          this.die();
          int index;
          Cell selectedCell;
          
          
          if (location.getPlantCount() > 0) {
               dayCountDown = MAX_HUNGER;
               //System.out.println("reset days left:" + dayCountDown);
               index = RandomGenerator.nextNumber(
                     location.getPlantArray().size());
               selectedCell = location.getPlantArray().get(index);

               if (location.hasNotMove()) {
                    //System.out.println(" moved");
                    new Holdable(location).init();
                    this.setCell(selectedCell);
                    
                    location.setMoved(false);
               }
          } else {
               index = RandomGenerator.nextNumber(
                      location.getEmptyArray().size());
               selectedCell = location.getEmptyArray().get(index);

               if (location.hasNotMove()) {
                    dayCountDown--;
                    new Holdable(location).init();
                    this.setCell(selectedCell);
                    //System.out.println("moved to empty" + location.getX() 
                    //+ location.getY());
                    location.setMoved(false);
                    
               }
          }
          

     }

     /**
      * Sets square back to blank if herbivore hasn't eaten in 10 turns.
      */
     public void die() {
          //System.out.println("days left:" + dayCountDown);
          if (dayCountDown <= 0) {
               new Holdable(location).init();
          }
     }

     /**
      * Get type.
      * @param locat as Cell
      * @return type as Type
      */
     public Type getType(Cell locat) {
          return type;
     }


}
