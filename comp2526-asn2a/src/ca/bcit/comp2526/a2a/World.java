package ca.bcit.comp2526.a2a;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * World. Contains an array of Cells.
 * 
 * @author jennyly
 * @version 1.0
 */
public class World extends JPanel {

    private static final int MAX = 100;
    private static final int HERB_MAX = 80;
    private static final int PLANT_MAX = 50;
    private static final int CARN_MAX = 40;
    private static final int OMNI_MAX = 32;
    private int row;
    private int column;
    private Cell[][] grid;
  

    /**
     * Constructor.
     * 
     * @param row
     *            as int
     * @param column
     *            as int
     */
    public World(int row, int column) {
        this.row = row;
        this.column = column;
        grid = new Cell[row][column];
    }

    /**
     * Creates DoubleLinkedList to to copy world to.
     * @return list
     * @throws CouldNotAddException as Exception
     */
    public DoubleLinkedList<Holdable> copyToList() throws CouldNotAddException {
        DoubleLinkedList<Holdable> list = new DoubleLinkedList<>();
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                list.addToEnd(grid[i][j].getHoldable());
            }
        }
        return list;
    }

    /**
     * Serializes a file.
     * @return String thedirectory
     */
    public String saveFile() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "GOL save files", "out");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(getParent());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getCurrentDirectory().toString() 
                    + "/" + chooser.getSelectedFile().getName();
        }
        return null;

    }

    private String getFile() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "GOL save files", "o");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(getParent());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println(chooser.getCurrentDirectory().toString()
                    + "/" + chooser.getSelectedFile().getName());
            return chooser.getCurrentDirectory().toString() 
                    + "/" + chooser.getSelectedFile().getName();

        }
        return null;
    }

    /**
     * Saves the state of the file.
     * @throws CouldNotAddException as Exception
     */
    public void saveState() throws CouldNotAddException {
        try {
            FileOutputStream fileOut = new FileOutputStream(saveFile());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            System.out.println(copyToList().size());
            out.writeObject(copyToList());
            out.close();
            fileOut.close();
            System.out.printf("Serialized data saved");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Reload the save files and place it init() the world again.
     * @throws CouldNotRemoveException as Exception
     */
    public void reloadState() throws CouldNotRemoveException {
        //ArrayList<Holdable> list = new ArrayList<Holdable>();
        try {
            String f = getFile();
            if (f != null) {

            FileInputStream fileIn = new FileInputStream(f);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            DoubleLinkedList<Holdable> list = 
                    (DoubleLinkedList<Holdable>) in.readObject();
            Holdable temp = null;
            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {
                    
                    temp = list.removeFromFront();
                    temp.setLocation(grid[i][j]);
                    grid[i][j].setHoldable(temp);
                    temp.init();
                    
                }
            }
            // reloads the world
            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {
                    grid[i][j].createAdjCellsArray();
                    grid[i][j].addToAdjArray();
                }
            }
            System.out.println("new cells loaded");
            in.close();
            fileIn.close();
            }
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("File not found");
            c.printStackTrace();
            return;
        }
    }

    /**
     * Add the appropriate number of herbivore, plants and empty 
     * to their respective arrays.
     */
    public void init() {
        // RandomGenerator.reset();
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                int random = RandomGenerator.nextNumber(MAX);
                grid[i][j] = new Cell(World.this, i, j);
                if (random >= HERB_MAX) {
                    grid[i][j].setHoldable(new Herbivore(grid[i][j]));
                    grid[i][j].getHoldable().init();
                } else if (random >= PLANT_MAX) {
                    grid[i][j].setHoldable(new Plant(grid[i][j]));
                    grid[i][j].getHoldable().init();
                } else if (random >= CARN_MAX) {
                    grid[i][j].setHoldable(new Carnivore(grid[i][j]));
                    grid[i][j].getHoldable().init();
                } else if (random >= OMNI_MAX) {
                    grid[i][j].setHoldable(new Omnivore(grid[i][j]));
                    grid[i][j].getHoldable().init();
                } else {
                    grid[i][j].setHoldable(new Holdable(grid[i][j]));
                    grid[i][j].getHoldable().init();
                }
            }
        }
    }

    /**
     * Decrease dayCount by one and if dayCount == 0. Removes dead herbivore,
     * checks each plant to see if it seeds, moves remaining plant living
     *  Herbivore to one cell.
     */
    public void takeTurn() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j].addToAdjArray();
                grid[i][j].getHoldable().die();
            }
        }
        //System.out.println("moved");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j].getHoldable().getType() == Type.HERBIVORE) {
                    grid[i][j].addToAdjArray();
                    grid[i][j].getHoldable().move();
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j].getHoldable().getType() == Type.OMNIVORE) {
                    grid[i][j].addToAdjArray();
                    grid[i][j].getHoldable().move();
                    // System.out.println("OMNIVORE moved from ("+i+","+j+") to
                    // ("+omnivore.getLocation().getX()+"
                    // ,"+omnivore.getLocation().getY());
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j].getHoldable().getType() == Type.CARNIVORE) {
                    grid[i][j].addToAdjArray();
                    grid[i][j].getHoldable().move();
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j].addToAdjArray();
                grid[i][j].getHoldable().reproduce();

            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j].setMoved(true);
            }
        }

    }

    /**
     * Retrieve the requested Cell from the specified location in the World.
     * 
     * @param x
     *            as int
     * @param y
     *            as column
     * @return Cell location
     */
    public Cell getCellAt(int x, int y) {
        return grid[x][y];
    }

    /**
     * Get row count.
     * 
     * @return row as int
     */
    public int getRowCount() {
        return row;
    }

    /**
     * Get column count.
     * 
     * @return column as int
     */
    public int getColumnCount() {
        return column;
    }

}
