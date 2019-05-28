package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Cell.
 * @author jennyly
 * @version 2.0
 */
public class Cell extends JPanel {
    private World world;
    private transient ArrayList<Cell> adjHerbivoreCell;
    private transient ArrayList<Cell> adjPlantCell;
    private transient ArrayList<Cell> adjCarnCell;
    private transient ArrayList<Cell> adjOmniCell;
    private transient ArrayList<Cell> adjEmptyCell;
    private Holdable holdable;
    private JPanel panel;
    private JLabel label;
    private int herbCount;
    private int plantCount;
    private int emptyCount;
    private int carnCount;
    private int omniCount;
    private int x;
    private int y;
    private boolean notMoved;

    /**
     * Constructor.
     * @param world as World
     * @param x as int
     * @param y as int
     */
    public Cell(World world, int x, int y) {
        this.world = world;
        this.x = x;
        this.y = y;
        init();
        notMoved = true;
    }

    /**
     * Setup layout.
     */
    public void init() {
        panel = new JPanel();
        label = new JLabel();
        panel.add(label);
        panel.setBorder(BorderFactory.createMatteBorder(
                1, 1, 0, 0, Color.black));

    }

    /**
     * Creates 3 arrays herbivore, empty, and plant.
     */
    public void createAdjCellsArray() {
        adjHerbivoreCell = new ArrayList<Cell>();
        adjPlantCell = new ArrayList<Cell>();
        adjEmptyCell = new ArrayList<Cell>();
        adjOmniCell = new ArrayList<Cell>();
        adjCarnCell = new ArrayList<Cell>();
    }

    /**
     * Separate adjacent cells to one of the arrays.
     */
    public void addToAdjArray() {
        herbCount = 0;
        plantCount = 0;
        emptyCount = 0;
        carnCount = 0;
        omniCount = 0;
        createAdjCellsArray();
        //System.out.println(x + " " + y + getHoldable());
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {

                if (i >= 0 && j >= 0 && i < world.getRowCount() 
                        && j < world.getColumnCount()) {
                    if (!(i == x && j == y)) {

                        if (world.getCellAt(i, j).getHoldable()
                                .getType() 
                                == Type.PLANT) {
                            adjPlantCell.add(world.getCellAt(i, j));
                            plantCount++;
                        } else if (world.getCellAt(i, j)
                                .getHoldable()
                                .getType() 
                                == Type.HERBIVORE) {
                            adjHerbivoreCell.add(
                                    world.getCellAt(i, j));
                            herbCount++;
                        } else if (world.getCellAt(i, j)
                                .getHoldable()
                                .getType()
                                == Type.CARNIVORE) {
                            adjCarnCell.add(world.getCellAt(i, j));
                            carnCount++;
                        } else if (world.getCellAt(i, j)
                                .getHoldable()
                                .getType()
                                == Type.OMNIVORE) {
                            adjOmniCell.add(
                                    world.getCellAt(i, j));
                            omniCount++;
                        } else {
                            adjEmptyCell.add(world.getCellAt(i, j));
                            emptyCount++;
                        }
                    }
                }
            }
        }
    }

    /**
     * Gets adjHerbArray.
     * @return adjHerbivoreCell as ArrayList
     */
    public ArrayList<Cell> getHerbArray() {
        return adjHerbivoreCell;
    }

    /**
     * Gets adjPlantArray.
     * @return adjPlantCell as ArrayList
     */
    public ArrayList<Cell> getPlantArray() {
        return adjPlantCell;
    }


    /**
     * Gets adjEmptyArray.
     * @return adjEmptyCell as ArrayList
     */
    public ArrayList<Cell> getEmptyArray() {
        return adjEmptyCell;
    }

    /**
     * Gets adjOmniArray.
     * @return adjOmniCell as ArrayList
     */
    public ArrayList<Cell> getOmniArray() {
        return adjOmniCell;
    }

    /**
     * Gets adjCarnArray.
     * @return adjCarnCell as ArrayList
     */
    public ArrayList<Cell> getCarnArray() {
        return adjCarnCell;
    }


    /**
     * Returns the location of the Cell on the World.
     * @return type as Type
     */
    public Type getObjectType() {
        return (holdable.getType());
    }

    /**
     * Gets LivingObject.
     * @return holdable as Holdable
     */
    public Holdable getHoldable() {
        return holdable;
    }

    /**
     * Change holdable.
     * @param obj as Holdable
     */
    public void setHoldable(Holdable obj) {
        holdable = obj;
    }



    /**
     * Gets panel.
     * @return panel as JPanel.
     */
    public JPanel getJPanel() {
        return panel;
    }

    /**
     * Returns herbCount.
     * @return herbCount as int
     */
    public int getHerbCount() {
        return herbCount;
    }

    /**
     * Returns plantCount.
     * @return plantCount as int
     */
    public int getPlantCount() {
        return plantCount;
    }

    /**
     * Returns emptyCount.
     * @return emptyCount as int
     */
    public int getEmptyCount() {
        return emptyCount;
    }

    /**
     * Returns carnCount.
     * @return carnCount as int
     */
    public int getCarnCount() {
        return carnCount;
    }

    /**
     * Returns onmiCount.
     * @return onmiCount as int
     */
    public int getOmniCount() {
        return omniCount;
    }
    /**
     * Returns world.
     * @return world as World
     */
    public World getWorld() {
        return world;
    }

    /**
     * Check is it as notMoved.
     * @return notMoved as boolean
     */
    public boolean hasNotMove() {
        return notMoved;
    }

    /**
     * Changes is notMoved.
     * @param input as boolean
     */
    public void setMoved(boolean input) {
        notMoved = input;
    }
    //     
    //     public int getX() {
    //        return x;
    //     }
    //     
    //     public int getY() {
    //        return y;
    //     }
}
