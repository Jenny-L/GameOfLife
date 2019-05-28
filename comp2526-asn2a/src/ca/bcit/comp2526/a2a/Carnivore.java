package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Carnivore.
 * @author jennyly
 * @version 1.0
 */
public class Carnivore extends LivingObject {
     private static final int MIN_EMPTY = 2;
     private static final int MAX_HUNGER = 7;
     private static final int NUM_MATES = 1;
     private static final int FOOD_COUNT = 2;

     private ArrayList<Cell> food;

     /**
      * Constructor.
      * @param location as Cell
      */
     public Carnivore(Cell location) {
          super(location, Type.CARNIVORE);


     }

     /**
      * Colors the grid magenta.
      */
     public void init() {
          getLocation().getJPanel().setBackground(Color.magenta);
     }

     /**
      * Create new Carnivore.
      * @return ArrayList<Cell>
      * @param locat as Cell
      */
     public LivingObject createLife(Cell locat) {
          return new Carnivore(locat);
     }

     /**
      * Gets Carnivore Array.
      * @return ArrayList<Cell>
      */
     public ArrayList<Cell> getSelfArray() {
          return getLocation().getCarnArray();
     }
     
     /**
      * Counts the amount of mates.
      * @return integer
      */
     public int getSelfCount() {
          return getLocation().getCarnCount();
     }

     /**
      * Add items to the food array.
      * @return food as ArrayList<Cell>
      */
     public ArrayList<Cell> getFoodArray() {
          food = new ArrayList<Cell>();
          for (Cell cell:getLocation().getCarnArray()) {
               food.add(cell);
          }
          for (Cell cell:getLocation().getOmniArray()) {
               food.add(cell);
          }
          for (Cell cell:getLocation().getHerbArray()) {
               food.add(cell);
          }
          return food;
     }

     /**
      * FoodCount.
      * @return numberoffood as int
      */
     public int getFoodCount() {
          return getLocation().getOmniCount() + getLocation().getHerbCount() 
                    + getLocation().getCarnCount();
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
      * @return FOOD_COUNT as int
      */
     public int getMinFood() {
          return FOOD_COUNT;
     }


}
