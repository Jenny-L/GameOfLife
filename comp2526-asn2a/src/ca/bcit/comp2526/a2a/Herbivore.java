package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Herbivore.
 * @author jennyly
 * @version 1.0
 *
 */
public class Herbivore extends LivingObject {
    private static final int MIN_EMPTY = 1;
    private static final int MAX_HUNGER = 10;
    private static final int NUM_MATES = 2;
    private static final int FOOD_COUNT = 2;

    /**
     * Constructor.
     * @param location as Cell
     */
    public Herbivore(Cell location) {
        super(location, Type.HERBIVORE);


    }

    /**
     * Sets the background to yellow.
     */
    public void init() {
        getLocation().getJPanel().setBackground(Color.yellow);

    }

    /**
     * Creates a new herbivore.
     * @return Herbivore
     * @param locat as Cell
     */
    public LivingObject createLife(Cell locat) {
        return new Herbivore(locat);
    }

    /**
     * Gets Mates.
     * @return ArrayList<Cell>
     */
    public ArrayList<Cell> getSelfArray() {
        return getLocation().getHerbArray();
    }

    /**
     * Get amount of mates.
     * @return int
     */
    public int getSelfCount() {
        return getLocation().getHerbCount();
    }

    /**
     * Get food.
     * @return ArrayList<Cell>
     */
    public ArrayList<Cell> getFoodArray() {
        return getLocation().getPlantArray();

    }

    /**
     * Get amount of food.
     * @return int
     */
    public int getFoodCount() {
        return getLocation().getPlantCount();
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
