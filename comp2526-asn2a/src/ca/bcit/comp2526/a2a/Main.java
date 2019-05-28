package ca.bcit.comp2526.a2a;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Drives the program Game of Life.
 * @author jennyly
 * @version 1.0
 */
public final class Main {
     private static final int WIDTH = 25;
     private static final int HEIGHT = 25;
     private static final float SCREEN_SIZE = (float) 0.80;
     private static final float MAX_PERCENT = (float) 100;
     
    private static final Toolkit TOOLKIT;

    static {
        TOOLKIT = Toolkit.getDefaultToolkit();
    }
    
    /**
     * Prevents a static main object from being created.
     */
    private Main() {
    }

    /**
     * Drive the program.
     * @param argv as String[]
     */
    public static void main(final String[] argv) {
        final GameFrame frame;
        final World world;

        RandomGenerator.reset();
        world = new World(WIDTH, HEIGHT);
        world.init();
        frame = new GameFrame(world);
        position(frame);
        frame.init();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Positions the frame.
     * @param frame as GameFrome
     */
    private static void position(final GameFrame frame) {
        final Dimension size;

        size = calculateScreenArea(SCREEN_SIZE, SCREEN_SIZE);
        frame.setSize(size);
        frame.setLocation(centreOnScreen(size));
    }

    /**
     * Centers the screen.
     * @param size as Dimension
     * @return a new Point
     */
    public static Point centreOnScreen(final Dimension size) {
        final Dimension screenSize;

        if (size == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }

        screenSize = TOOLKIT.getScreenSize();

        return (new Point((screenSize.width - size.width) / 2, 
                  (screenSize.height - size.height) / 2));
    }

    /**
     * Calculates the screen dimension.
     * @param widthPercent as float
     * @param heightPercent as float
     * @return area as float
     */
    public static Dimension calculateScreenArea(final float widthPercent, 
              final float heightPercent) {
        final Dimension screenSize;
        final Dimension area;
        final int width;
        final int height;
        final int size;

        if ((widthPercent <= 0.0f) || (widthPercent > MAX_PERCENT)) {
            throw new IllegalArgumentException("widthPercent cannot be " 
        + "<= 0 or > 100 - got: " + widthPercent);
        }

        if ((heightPercent <= 0.0f) || (heightPercent > MAX_PERCENT)) {
            throw new IllegalArgumentException("heightPercent cannot be " 
        + "<= 0 or > 100 - got: " + heightPercent);
        }

        screenSize = TOOLKIT.getScreenSize();
        width = (int) (screenSize.width * widthPercent);
        height = (int) (screenSize.height * heightPercent);
        size = Math.min(width, height);
        area = new Dimension(size, size);

        return (area);
    }
}
