import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.plaf.FontUIResource;

public class BattleshipWindow extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JFrame frame;

    // CONSTANT fields
    private final String UI_STYLE = "Windows";
    private final String APP_NAME = "Battleship";
    private final String VERSION = "v2019.05";

    // Battleship window constructor
    BattleshipWindow() {

        // Set the Look 'n' Feel
        new LookFeel().setUIStyle(UI_STYLE); // Global UI style
        new LookFeel().setUIFont(new FontUIResource("Tahoma", 0, 13)); // Global Font style

        // Set main application window
        frame = new JFrame(APP_NAME);
        frame.setSize(800, 450); // Window dimensions
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

        // Final touches
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