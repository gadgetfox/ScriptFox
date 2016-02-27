import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
//import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
//import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
//import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class GUI implements Runnable {
	
	//primary class and code for the applications GUI interface
    private JTextArea output;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GUI());
    }

    @Override
    public void run() {
        // Create and set up the window.
        JFrame frame = new JFrame("ScriptFox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JSplitPane jSplitPane, jSplitPane2;
        JPanel jPanel1, jPanel2a, jPanel2b;

        jPanel1 = new JPanel();
        jPanel2a = new JPanel();
        jPanel2b = createContentPane();

        jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jPanel2a,
                jPanel2b);
        jSplitPane2.setOneTouchExpandable(true);
        jSplitPane2.setDividerLocation(100);

        jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jPanel1,
                jSplitPane2);
        jSplitPane.setOneTouchExpandable(true);
        jSplitPane.setDividerLocation(150);

        frame.add(jSplitPane);
        frame.setJMenuBar(createMenuBar());

        // Display the window.
        frame.setSize(800, 600);
        frame.setVisible(true);
        
    }
    
    // Menu Bar
    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        //JRadioButtonMenuItem rbMenuItem;
        //JCheckBoxMenuItem cbMenuItem;
        menuBar = new JMenuBar();
        
        // File Group
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_H);
        menu.getAccessibleContext().setAccessibleDescription("File Menu Items");
        menuBar.add(menu);
        
	        //File Group of JMenuItems
	        menuItem = new JMenuItem("New",
	                KeyEvent.VK_T);
	        menuItem.setMnemonic(KeyEvent.VK_A);
	        menu.add(menuItem);
	        
	        menuItem = new JMenuItem("Import",
	                KeyEvent.VK_T);
	        menuItem.setMnemonic(KeyEvent.VK_B);
	        menu.add(menuItem);
	        
	        menuItem = new JMenuItem("Export",
	                KeyEvent.VK_T);
	        menuItem.setMnemonic(KeyEvent.VK_C);
	        menu.add(menuItem);
	        
	        menuItem = new JMenuItem("Exit",
	                KeyEvent.VK_T);
	        menuItem.setMnemonic(KeyEvent.VK_D);
	        menu.add(menuItem);
	        
        // Run Group
        menu = new JMenu("Run");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("Edit Menu Items");
        menuBar.add(menu);
        
	        //File Group of JMenuItems
	        menuItem = new JMenuItem("Run Script",
	                KeyEvent.VK_T);
	        menuItem.setMnemonic(KeyEvent.VK_A);
	        menu.add(menuItem);
        
        // Options Group
        menu = new JMenu("Options");
        menu.setMnemonic(KeyEvent.VK_C);
        menu.getAccessibleContext().setAccessibleDescription("Edit Menu Items");
        menuBar.add(menu);
        
	        //File Group of JMenuItems
	        menuItem = new JMenuItem("Preferences",
	                KeyEvent.VK_T);
	        menuItem.setMnemonic(KeyEvent.VK_A);
	        menu.add(menuItem);
        
        // Help Group
        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription("Edit Menu Items");
        menuBar.add(menu);
        
	        //File Group of JMenuItems
	        menuItem = new JMenuItem("About",
	                KeyEvent.VK_T);
	        menuItem.setMnemonic(KeyEvent.VK_A);
	        menu.add(menuItem);

        return menuBar;
    }

    public JPanel createContentPane() {
        // Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        // Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        // Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }

}
