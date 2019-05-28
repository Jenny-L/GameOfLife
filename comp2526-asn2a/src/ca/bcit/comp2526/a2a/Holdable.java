package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.io.Serializable;

/**
 * Holdable.
 * 
 * @author jennyly
 * @version 1.0
 */
public class Holdable implements Serializable {

    private static final long serialVersionUID = 2082247339590048100L;
    private transient Cell location;
    private Type type;
    // private Holdable holdable;
    // private boolean moved;

    /**
     * Constructor.
     * 
     * @param location
     *            as Cell
     * @param type
     *            as Type
     */
    public Holdable(Cell location, Type type) {
        this.location = location;
        location.setHoldable(this);
        this.type = type;
    }

    /**
     * Constructor.
     * 
     * @param location
     *            as Cell
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
     * 
     * @return the location
     */
    public Cell getLocation() {
        return location;
    }

    /**
     * Sets location.
     * 
     * @param locat
     *            as Cell
     */
    public void setLocation(Cell locat) {
        location = locat;
    }

    /**
     * Gets cell type.
     * 
     * @return type as Type
     */
    public Type getType() {
        return type;
    }

    /**
     * Does not move.
     */
    public void move() {
    }

    /**
     * Does not reproduce.
     */
    public void reproduce() {

    }

    /**
     * Does not die.
     */
    public void die() {

    }



}
