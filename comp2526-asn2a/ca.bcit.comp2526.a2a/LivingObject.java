package ca.bcit.comp2526.a2a;

/**
 * Abstract class LivingObject.
 * @author jennyly
 * @version 1.0
 */
public abstract class LivingObject extends Holdable {
     private int dayCountDown;
     private Cell location;

     /**
      * Constructor.
      * @param location cell
      */
     public LivingObject(Cell location) {
          super(location);
          this.location = location;
     }
     
     /**
      * Abstract init().
      */
     public abstract void init();
     
     /**
      * Abstract setCell.
      * @param locat as Cell
      */
     public abstract void setCell(Cell locat);
     
     /**
      * Abstract die().
      */
     public abstract void die();
     
     /**
      * Abstract move().
      */
     public abstract void move();
     
     /**
      * Gets daysleft.
      * @return the dayCountDown
      */
     public int getDayCountDown() {
          return dayCountDown;
     }
     
     /**
      * Gets location.
      * @return location
      */
     public Cell getLocation() {
          return location;
     }

}
