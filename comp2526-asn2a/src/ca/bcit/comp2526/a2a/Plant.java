package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Plant.
 * @author jennyly
 * @version 1.0
 */
public class Plant extends LivingObject {
    private static final int MIN_EMPTY = 3;
    private static final int MAX_HUNGER = -1; //does not apply to plant
    private static final int NUM_MATES = 2;
    private static final int FOOD_COUNT = -1; // does not apply to plant


    /**
     * Constructor.
     * @param location as Cell
     */
    public Plant(Cell location) {
        super(location, Type.PLANT);
        // TODO Auto-generated constructor stub
    }

    /**
     * Sets background to green.
     */
    public void init() {
        getLocation().getJPanel().setBackground(Color.green);
    }

    /**
     * Get mateArray.
     * @return ArrayList<Cell>
     */
    public ArrayList<Cell> getSelfArray() {
        return getLocation().getPlantArray();
    }

    /**
     * Get mate count.
     * @return int
     */
    public int getSelfCount() {
        return getLocation().getPlantCount();
    }

    /**
     * Get food array.
     * @return null
     */
    public ArrayList<Cell> getFoodArray() {
        return null;

    }

    /**
     * Get food count.
     * @return int
     */
    public int getFoodCount() {
        return -1;
    }

    /**
     * Create new Plant.
     * @param locat as Cell
     * @return Plant
     */
    public LivingObject createLife(Cell locat) {
        return new Plant(locat);
    }

    /**
     * Get MinEmpty.
     * @return MIN_EMPTY as int
     */
    public int getMinEmpty() {
        return MIN_EMPTY;
    }

    /**
     * Get MaxHunger.
     * @return MAX_HUNGER as int
     */
    public int getMaxHunger() {
        return MAX_HUNGER;
    }

    /**
     * Get MinMates.
     * @return NUM_MATES as int
     */
    public int getMinMates() {
        return NUM_MATES;
    }

    /**
     * Get MinFood.
     * @return MIN_FOOD as int
     */
    public int getMinFood() {
        return FOOD_COUNT;
    }
}
