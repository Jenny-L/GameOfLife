package ca.bcit.comp2526.a2a;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

/**
 * GameFrame.
 * @author jennyly
 * @version 1.0
 *
 */
public class GameFrame extends JFrame {
    private final World world;

    /**
     * Constructor.
     * @param w as World
     */
    public GameFrame(final World w) {
        world = w;
    }

    /**
     * Creates a grid and ass cells to each grid.
     */
    public void init() {
        setTitle("Assignment 2a");
        setLayout(new GridLayout(world.getRowCount(), world.getColumnCount()));

        for (int row = 0; row < world.getRowCount(); row++) {
            for (int col = 0; col < world.getColumnCount(); col++) {
                add(world.getCellAt(row, col).getJPanel());
            }
        }

        addMouseListener(new TurnListener(this));
    }
    
    /**
     * Inner class TurnListener.
     * @author jennyly
     * @version 1.0
     */
    public class TurnListener extends MouseAdapter {
         
         private GameFrame gameOfLife;
         
         /**
          * Constructor.
          * @param gameOfLife as GameFrame
          */
         public TurnListener(GameFrame gameOfLife) {
              this.gameOfLife = gameOfLife;
         }
         
         /**
          * Activates GameFrame when mouse is clicked.
          * @param e as MouseEvent
          */
         public void mouseClicked(MouseEvent e) {
              gameOfLife.takeTurn();
         }
         
    }

    /**
     * Initiates world.take turn when pressed.
     */
    public void takeTurn() {
        world.takeTurn();
        repaint();
    }
}
