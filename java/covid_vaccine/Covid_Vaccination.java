package covid_vaccine;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
public class Covid_Vaccination extends Database {
    private JFrame frame;
    private JTextField nameField, aadharField, phoneField, emailField, addressField;
    private ButtonGroup vaccineGroup;
    private JLabel statusLabel, statusText;
    private JDatePickerImpl datePicker;
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(() -> {
            try {
                Covid_Vaccination window = new Covid_Vaccination();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Database db = new Database();
        Statement stmt = db.connect();
    }
    public Covid_Vaccination() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 576, 345);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        addLabels();
        addTextFields();
        addRadioButtons();
        addDatePicker();
        addBookButton();
        addStatusLabels();
        addVaccineImage();
    }
    private void addLabels() {
        String[] labels = {"Name", "Aadhar", "Email", "Phone", "Address", "Vaccine Type", "Appointment Date"};
        int[] bounds = {29, 58, 89, 114, 139, 169, 207};
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setFont(new Font("Tahoma", Font.BOLD, 11));
            label.setBounds(106, bounds[i], 150, 20);
            frame.getContentPane().add(label);
        }
    }
    private void addTextFields() {
        nameField = createTextField(26);
        aadharField = createTextField(55);
        emailField = createTextField(80);
        phoneField = createTextField(108);
        addressField = createTextField(139);
    }
    private JTextField createTextField(int yPosition) {
        JTextField textField = new JTextField();
        textField.setBounds(288, yPosition, 151, 20);
        textField.setColumns(10);
        frame.getContentPane().add(textField);
        return textField;
    }
    private void addRadioButtons() {
        String[] vaccines = {"Covishield", "Covaxin", "Sputnik"};
        int xPosition = 219;
        vaccineGroup = new ButtonGroup();
        for (String vaccine : vaccines) {
            JRadioButton radioButton = new JRadioButton(vaccine);
            radioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
            radioButton.setActionCommand(vaccine);
            radioButton.setBounds(xPosition, 169, 90, 27);
            frame.getContentPane().add(radioButton);
            vaccineGroup.add(radioButton);
            xPosition += 90;
        }
    }
    private void addDatePicker() {
        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(288, 207, 151, 27);
        frame.getContentPane().add(datePicker);
    }
    private void addBookButton() {
        JButton bookButton = new JButton("Book Slot");
        bookButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        bookButton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Click.png")).getImage()));
        bookButton.setBounds(106, 252, 132, 31);
        frame.getContentPane().add(bookButton);
        bookButton.addActionListener(e -> handleBooking());
    }
    private void addStatusLabels() {
        statusLabel = new JLabel();
        statusLabel.setBounds(270, 252, 46, 31);
        frame.getContentPane().add(statusLabel);
        statusText = new JLabel();
        statusText.setBounds(336, 252, 121, 31);
        frame.getContentPane().add(statusText);
    }
    private void addVaccineImage() {
        JLabel vaccineImage = new JLabel();
        vaccineImage.setBounds(0, 19, 98, 197);
        vaccineImage.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/inj1.png")).getImage()));
        frame.getContentPane().add(vaccineImage);
    }
    private void handleBooking() {
        String name = nameField.getText();
        String aadhar = aadharField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String vaccine = vaccineGroup.getSelection().getActionCommand();
        Date selectedDate = (Date) datePicker.getModel().getValue();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
        try {
            if (Database.checkVaccine(vaccine, date)) {
                if (Database.pushData(aadhar, name, phone, email, address, vaccine, date)) {
                    setStatus("/OK1.png", "Booked");
                } else {
                    setStatus("/Del.png", "Already Available");
                }
            } else {
                setStatus(null, "Slot not Available");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void setStatus(String imagePath, String statusMessage) {
        if (imagePath != null) {
            statusLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(imagePath)).getImage()));
        }
        statusText.setText(statusMessage);
    }
}
