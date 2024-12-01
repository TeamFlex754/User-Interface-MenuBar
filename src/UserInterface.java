import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class UserInterface extends JFrame implements ActionListener {

    // top bar with a menu of 4 items
    // 1st item: date and time printed in a text box
    // 2nd item: text box contents written to text file "log.txt"
    // 3rd item: frame background color changes to random hue of green,
    // with the menu displaying the initial random hue each time.
    // 4th item: program exits
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem displayDate;
    private JMenuItem dateToText;
    private JMenuItem colorChange;
    private JMenuItem exitItem;
    private JTextField dateTimeField;

    // Constructor
    UserInterface() {
        // Builds frame parameters
        this.setTitle("User Interface 1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());

        menuBar = new JMenuBar(); // Builds new menu bar

        fileMenu = new JMenu("File");  // Builds new "File" menu bar option

        // Creates new items to use in the menu option, in this case for the "File" option
        displayDate = new JMenuItem("Display Date and Time");
        dateToText = new JMenuItem("Write to Text File");
        colorChange = new JMenuItem("Change Background");
        exitItem = new JMenuItem("Exit");

        // Text field to display the date and time
        dateTimeField = new JTextField(30);
        dateTimeField.setText("Current Date and Time will display here");
        dateTimeField.setEditable(false);

        // Action listeners for user input
        displayDate.addActionListener(this);
        dateToText.addActionListener(this);
        colorChange.addActionListener(this);
        exitItem.addActionListener(this);

        // Adds the components to the file menu, menu bar, and frame
        fileMenu.add(displayDate);
        fileMenu.add(dateToText);
        fileMenu.add(colorChange);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
        this.add(dateTimeField);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displayDate) {
            String currentDateAndTime = new Date().toString(); // Date class with toString
            dateTimeField.setText(currentDateAndTime);
        }
        if (e.getSource() == dateToText) {

        }
        if (e.getSource() == colorChange) {

        }
        if (e.getSource() == exitItem) {
            System.exit(0);
        }



    }
}





