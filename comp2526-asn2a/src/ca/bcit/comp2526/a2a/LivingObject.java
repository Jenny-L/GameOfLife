package ca.bcit.comp2526.a2a;

import java.util.ArrayList;


/**
 * Abstract class LivingObject.
 * @author jennyly
 * @version 1.0
 */
public abstract class LivingObject extends Holdable {
     private int dayCountDown;

     /**
      * Constructor.
      * @param location cell
      * @param type Type
      */
     public LivingObject(Cell location, Type type) {
          super(location, type);
          this.setDayCountDown();
     }
     
     /**
      * Abstract init().
      */
     public abstract void init();
     
     /**
      * SetCell.
      * @param locat as Cell
      */
     public void setCell(Cell locat) {
        super.setLocation(locat);
        locat.setHoldable(this);
        init();
     }
     
     
     
     /**
      * Kills Object if dayCountDown is zero.
      */
     public void die() {
        if (dayCountDown == 0) {
           new Holdable(getLocation()).init();
        }
     }
     
     /**
      * Move to a food source near by to eat food source if available.
      */
     public void eat() {
        int index;
        Cell selectedCell;
        if (getFoodArray() != null) {
           
           if (getFoodCount() > 0) {
              dayCountDown = getMaxHunger();
               index = RandomGenerator.nextNumber(getFoodCount());
               selectedCell = getFoodArray().get(index);
            
               if (getLocation().hasNotMove()) {
                  new Holdable(getLocation()).init();
                  this.setCell(selectedCell);
        
                  getLocation().setMoved(false);
               }
            } else if (getLocation().getEmptyCount() != 0) {
               index = RandomGenerator.nextNumber(getLocation()
                       .getEmptyCount());
               selectedCell = getLocation().getEmptyArray().get(index);
               
               if (getLocation().hasNotMove()) {
                  dayCountDown--;
                  new Holdable(getLocation()).init();
                  this.setCell(selectedCell);
                
                  
                  getLocation().setMoved(false);
               }
            } else {
               dayCountDown--;
               getLocation().setMoved(false);
            }
        }
        
     }
     
     /**
      * Cell reproduce a LivingObject as it's own type 
      * if all conditions are satisfied.
      */
     public void reproduce() {
        if (getSelfCount() >= getMinMates() && getLocation()
                .getEmptyCount() >= getMinEmpty()
              && getFoodCount() >= getMinFood() && dayCountDown != 0) {
           int index = RandomGenerator.nextNumber(getLocation()
                   .getEmptyCount());
           Cell selectedCell = getLocation().getEmptyArray().get(index);
           createLife(selectedCell).init();
           
        }
        
     }
     
     /**
      * Gets selfArray from child.
      * @return ArrayList<Cell>
      */
     public abstract ArrayList<Cell> getSelfArray();
     
     /**
      * Gets self count from child.
      * @return int
      */
     public abstract int getSelfCount();
     
     /**
      * Creates a LivingObject at a particular cell.
      * @param locat as Cell
      * @return LivingObject
      */
     public abstract LivingObject createLife(Cell locat);
     
     /**
      * Calls the eat().
      */
     public void move() {
        this.eat();
        
     }
     
     /**
      * Gets foodArray.
      * @return ArrayList<Cell>
      */
     public abstract ArrayList<Cell> getFoodArray();
     
     /**
      * Gets FoodCount.
      * @return int
      */
     public abstract int getFoodCount();
    
     /**
      * Gets daysleft.
      * @return the dayCountDown
      */
     public int getDayCountDown() {
          return dayCountDown;
     }
     
     /**
      * Sets daycountDown to maxHunger.
      */
     private void setDayCountDown() {
        dayCountDown = getMaxHunger();
     }
     
     /**
      * Gets location.
      * @return location
      */
     public Cell getLocation() {
          return super.getLocation();
     }
   
     /**
      * GetMinEmpty from child.
      * @return int MIN_EMPTY
      */
     public abstract int getMinEmpty();
     
     /**
      * getMaxHunger from child.
      * @return int MAX_HUNGER
      */
     public abstract int getMaxHunger();
     
     /**
      * getMinFood from child.
      * @return int MIN_FOOD
      */
     public abstract int getMinFood();
     
     /**
      * getMinMates from child.
      * @return int as MIN_MATES
      */
     public abstract int getMinMates();

}
