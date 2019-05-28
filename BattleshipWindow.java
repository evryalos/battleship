import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

public class BattleshipWindow extends JFrame implements ActionListener {

    // CONSTANT fields
    private final String UI_STYLE = "Windows";
    private final String APP_NAME = "Battleship";
    private final String VERSION = "v2019.05";
    private final int GRID_SIDE = 16;

    private static final long serialVersionUID = 1L;
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel ourPanel;
    private JButton[][] ourGrid = new JButton[GRID_SIDE][GRID_SIDE];
    private JPanel enemyPanel;
    private JButton[][] enemyGrid = new JButton[GRID_SIDE][GRID_SIDE];

    // Battleship window constructor
    BattleshipWindow() {

        // Set the Look 'n' Feel
        new LookFeel().setUIStyle(UI_STYLE); // Global UI style
        new LookFeel().setUIFont(new FontUIResource("Tahoma", 0, 13)); // Global Font style

        // Set main application window
        frame = new JFrame(APP_NAME);
        frame.setResizable(false); // Fixed size
        frame.setLocationRelativeTo(null); // Center of the screen

        // Set application icon
        ImageIcon icon = new ImageIcon(getClass().getResource("images/appicon.png"));
        frame.setIconImage(icon.getImage());

        // MENU **********************************************************
        // Declare the menu bar and its items
        JMenuBar menuBar;

        JMenu actionsMenu;
        JMenuItem exitItem;

        JMenu helpMenu;
        JMenuItem aboutItem;

        // Set the main menu bar
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // Build the Actions menu item
        actionsMenu = new JMenu("Actions");
        menuBar.add(actionsMenu);

        exitItem = new JMenuItem("Exit", new ImageIcon(BattleshipWindow.class.getResource("/images/icons/exit.png")));
        actionsMenu.add(exitItem);
        exitItem.addActionListener(this);

        // Build the Help menu item
        helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        aboutItem = new JMenuItem("About",
                new ImageIcon(BattleshipWindow.class.getResource("/images/icons/about.png")));
        helpMenu.add(aboutItem);
        aboutItem.addActionListener(this);

        // PANELS **********************************************************

        // The main panel, containing our field and the enemy field
        mainPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(1, 2, 10, 10);
        mainPanel.setLayout(gridLayout);

        // Setting our panel, a 16x16 grid
        for (int i = 0; i < GRID_SIDE; i++) {
            for (int j = 0; j < GRID_SIDE; j++) {
                ourGrid[i][j] = new JButton();
                ourGrid[i][j].setPreferredSize(new Dimension(25, 25));

                try {
                    Image img = ImageIO.read(getClass().getResource("images/game/batship11.gif"));
                    ourGrid[i][j].setIcon(new ImageIcon(img));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

        ourPanel = new JPanel();
        ourPanel.setLayout(new GridLayout(GRID_SIDE, GRID_SIDE, 0, 0));

        for (int i = 0; i < GRID_SIDE; i++) {
            for (int j = 0; j < GRID_SIDE; j++) {
                ourPanel.add(ourGrid[i][j]);
            }
        }

        // Setting enemy panel, a 16x16 grid
        for (int i = 0; i < GRID_SIDE; i++) {
            for (int j = 0; j < GRID_SIDE; j++) {
                enemyGrid[i][j] = new JButton();
                enemyGrid[i][j].setPreferredSize(new Dimension(25, 25));
            }
        }

        enemyPanel = new JPanel();
        enemyPanel.setLayout(new GridLayout(GRID_SIDE, GRID_SIDE, 0, 0));

        for (int i = 0; i < GRID_SIDE; i++) {
            for (int j = 0; j < GRID_SIDE; j++) {
                enemyPanel.add(enemyGrid[i][j]);
            }
        }

        // Concatenate panels
        mainPanel.add(ourPanel);
        mainPanel.add(enemyPanel);

        // Final touches
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center of screen
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
        case ("Exit"): {
            System.exit(0);
            break;
        }

        case ("About"): {
            new AboutWindow().createAboutWindow(APP_NAME, VERSION);
            break;
        }
        }
    }
}