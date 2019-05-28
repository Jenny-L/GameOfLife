package ca.bcit.comp2526.a2a;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * GameFrame.
 * @author jennyly
 * @version 1.0
 *
 */
public class GameFrame extends JFrame {
    private static final int TIMER = 100;
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
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(world.getRowCount(), 
            world.getColumnCount()));
        add(panel, BorderLayout.CENTER);

        for (int row = 0; row < world.getRowCount(); row++) {
            for (int col = 0; col < world.getColumnCount(); col++) {
                panel.add(world.getCellAt(row, col).getJPanel());
            }
        }

        add(addButton(), BorderLayout.SOUTH);
        
        //addMouseListener(new TurnListener(this));
    }
   
    /**
     * Add buttons to JPanel.
     * @return JPanel
     */
    private JPanel addButton() {
            JPanel panel2 = new JPanel();
            JButton start = new JButton("Start");
            JButton stop = new JButton("Stop");
            JButton save = new JButton("Save");
            JButton load = new JButton("Load");
            panel2.add(start);
            panel2.add(stop);
            panel2.add(save);
            panel2.add(load);
            
            Timer timer = new Timer(TIMER, new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    takeTurn();
                }
            });
            start.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    timer.start();
                }
            });
            stop.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    timer.stop();
                }
            });
            save.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    try {
                        world.saveState();
                    } catch (CouldNotAddException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
          load.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent event) {
                try {
                    world.reloadState();
                } catch (CouldNotRemoveException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
           });
            return panel2;
    }
    
   

//        /**
//         * Inner class ActionListener.
//         * @author jennyly
//         * @version 1.0
//         */
//        public class ButtonListener implements ActionListener {
//    
//            private GameFrame gameOfLife;
//    
//            /**
//             * Constructor.
//             * @param gameOfLife as GameFrame
//             */
//            public ButtonListener(GameFrame gameOfLife) {
//                this.gameOfLife = gameOfLife;
//            }
//    
//            /**
//             * Activates GameFrame when mouse is clicked.
//             * @param e as MouseEvent
//             */
//            public void actionPerformed(ActionEvent e) {
//                gameOfLife.takeTurn();
//            }
//
//            
//    
//        }

    /**
     * Initiates world.take turn when pressed.
     */
    public void takeTurn() {
        world.takeTurn();
        repaint();
    }
}
