package ca.bcit.comp2526.a2a;

import java.awt.Color;

/**
 * Holdable.
 * @author jennyly
 * @version 1.0
 */
public class Holdable {
     private Cell location;
     private Type type;
     //private Holdable holdable;
     //private boolean moved;
     
     /**
      * Constructor.
      * @param location as Cell
      */
     public Holdable(Cell location) {
          this.location = location;
          location.setHoldable(this);
          type = Type.EMPTY;
     }
     
     /**
      * Change background color to white.
      */
     public void init() {
          location.getJPanel().setBackground(Color.white);
     }
     
     
     /**
      * Gets location.
      * @return the location
      */
     public Cell getLocation() {
          return location;
     }
     
     /**
      * Gets cell type.
      * @param locat as Cell
      * @return type as Type
      */
     public Type getType(Cell locat) {
          return type;
     }
     
     /**
      * Does not move.
      */
     public void move() {
     }
     
     /**
      * Sets holdable.
      * @param holdable as Holdable
      */
//     public void setHoldable(Holdable holdable) {
//          this.holdable = holdable;
//     }
     
     /**
      * Does not die.
      */
     public void die() {
          
     }
     
}

