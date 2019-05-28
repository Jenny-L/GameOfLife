package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.util.ArrayList;
/**
 * Omnivore.
 * @author jennyly
 * @version 1.0
 */
public class Omnivore extends LivingObject {
     private static final int MIN_EMPTY = 3;
     private static final int MAX_HUNGER = 2;
     private static final int NUM_MATES = 1;
     private static final int FOOD_COUNT = 3;

     private ArrayList<Cell> food;

     /**
     * Constructor.
     * @param location as Cell
     */
    public Omnivore(Cell location) {
  
         super(location, Type.OMNIVORE);

    }
    
    /**
     * Change background blue.
     */
    public void init() {
         getLocation().getJPanel().setBackground(Color.blue);
    }

    /**
     * Creates a new Omnivore.
     * @param locat as Cell
     * @return ArrayList<Cell>
     */
    public LivingObject createLife(Cell locat) {
        return new Omnivore(locat);
    }
    
    /**
     * Gets Mates.
     * @return ArrayList<Cell>
     */
    public ArrayList<Cell> getSelfArray() {
         return getLocation().getOmniArray();
    }
    
    /**
     * Gets number of mates.
     * @return int
     */
    public int getSelfCount() {
             return getLocation().getOmniCount();
    }
    
    /**
     * Creates a foodarray.
     * @return ArrayList<Cell>
     */
    public ArrayList<Cell> getFoodArray() {
         food = new ArrayList<Cell>();
         for (Cell cell:getLocation().getCarnArray()) {
              food.add(cell);
         }
         for (Cell cell:getLocation().getPlantArray()) {
              food.add(cell);
         }
         for (Cell cell:getLocation().getHerbArray()) {
              food.add(cell);
         }
         for (Cell cell:getLocation().getOmniArray()) {
              food.add(cell);
         }
         return food;
    }
  
    /**
     * Get number of Food.
     * @return int
     */
    public int getFoodCount() {
         return getLocation().getPlantCount() + getLocation().getHerbCount() 
                   + getLocation().getCarnCount() 
                   + getLocation().getOmniCount();
    }
     
    /**
     * getMinEmpty.
     * @return MIN_EMPTY as int
     */
     public int getMinEmpty() {
         return MIN_EMPTY;
     }
     
     /**
      * getMaxHunger.
      * @return MAX_HUNGER as int
      */
     public int getMaxHunger() {
           return MAX_HUNGER;
      }
    
     /**
      * getMinMates.
      * @return NUM_MATES as int
      */
    public int getMinMates() {
         return NUM_MATES;
    }
    
    /**
     * getMinFood.
     * @return MIN_FOOD as int
     */
    public int getMinFood() {
         return FOOD_COUNT;
    }
}
