import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.Date;
import java.util.Random;

public class UserInterface extends JFrame implements ActionListener {

    // top bar with a menu of 4 items
    // 1st item: date and time printed in a text box
    // 2nd item: text box contents written to text file "log.txt"
    // 3rd item: frame background color changes to random hue of green,
    // with the menu displaying the initial random hue each time.
    // 4th item: program exits
    private JMenuBar menuBar;
    private JMenu optionsMenu;
    private JMenuItem displayDate;
    private JMenuItem dateToText;
    private JMenuItem colorChange;
    private JMenuItem exitItem;
    private JTextField dateTimeField;

    // Constructor
    UserInterface() {
        // Builds frame
        this.setTitle("User Interface 1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.GREEN);

        menuBar = new JMenuBar(); // Builds new menu bar

        optionsMenu = new JMenu("Options");  // Builds new "File" menu bar option

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
        optionsMenu.add(displayDate);
        optionsMenu.add(dateToText);
        optionsMenu.add(colorChange);
        optionsMenu.add(exitItem);
        menuBar.add(optionsMenu);
        this.setJMenuBar(menuBar);
        this.add(dateTimeField);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displayDate) {  // identify what triggered the event
            String currentDateAndTime = new Date().toString(); // Date class converted to String (toString)
            dateTimeField.setText(currentDateAndTime);

        }
        if (e.getSource() == dateToText) {
            try (FileWriter writer = new FileWriter("log.txt")) {
                writer.write(dateTimeField.getText());
                JOptionPane.showMessageDialog(this,"Save successful!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Save unsuccessful: " + ex.getMessage());
            }
        }
        if (e.getSource() == colorChange) {
            Random randomGreen = new Random();  // Create a Random object to generate random number
            int green = randomGreen.nextInt(256);  // Generate a random int between 0-255
            this.getContentPane().setBackground(new Color(0,green,0));  // Use the random green
            JOptionPane.showMessageDialog(this,"Background color changed to: " + green);

        }
        if (e.getSource() == exitItem) {
            System.exit(0);
        }



    }
}





