package covid_vaccine;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.Collator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Covid_Vaccination extends Database {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private SpringLayout springLayout;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Covid_Vaccination window = new Covid_Vaccination();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Database d = new Database();
		Statement stmt = d.connect();
	}

	/**
	 * Create the application.
	 */
	public Covid_Vaccination() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	String date, aadhar, phone, email, address;
	private SpringLayout springLayout_1;
	private SpringLayout springLayout_2;
	private SpringLayout springLayout_3;
	private JTextField textField_5;
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 576, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aadhar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(106, 58, 61, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(106, 89, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhone.setBounds(106, 114, 61, 14);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblVaccinetype = new JLabel("Vaccine Type");
		lblVaccinetype.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVaccinetype.setBounds(106, 169, 91, 27);
		frame.getContentPane().add(lblVaccinetype);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(106, 139, 61, 19);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(106, 29, 66, 18);
		frame.getContentPane().add(lblName);
		
		JLabel lblNewLabel_3_1 = new JLabel("Appointment Date");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setBounds(106, 207, 110, 20);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		textField = new JTextField();
		textField.setBounds(288, 26, 151, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(288, 55, 151, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(288, 80, 151, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(288, 108, 151, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(288, 139, 151, 19);
		frame.getContentPane().add(textField_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Covishield");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton.setActionCommand("Covishield");
		rdbtnNewRadioButton.setBounds(219, 169, 88, 27);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Covaxin");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_1.setActionCommand("Covaxin");
		rdbtnNewRadioButton_1.setBounds(309, 169, 73, 27);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Sputnik");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_2.setActionCommand("Sputnik");
		rdbtnNewRadioButton_2.setBounds(384, 169, 73, 27);
		
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		final JLabel lblNewLabel_1 = new JLabel("");
	    lblNewLabel_1.setBounds(270, 252, 46, 31);
	    frame.getContentPane().add(lblNewLabel_1);
	    
	    final JLabel lblNewLabel_1_1 = new JLabel("");
	    lblNewLabel_1_1.setBounds(336, 252, 121, 31);
	    frame.getContentPane().add(lblNewLabel_1_1);
		
		final ButtonGroup G = new ButtonGroup();
		G.add(rdbtnNewRadioButton);
        G.add(rdbtnNewRadioButton_1);
        G.add(rdbtnNewRadioButton_2);
				
				
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
	    datePicker.setBounds(288, 207,151, 27);
	    frame.getContentPane().add(datePicker);
	    
	    JButton btnNewButton = new JButton("Book Slot");
	    btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
	    Image img=new ImageIcon(this.getClass().getResource("/Click.png")).getImage();
	    btnNewButton.setIcon(new ImageIcon(img));
	    
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		
	    		 String name=textField.getText();
	    		
	             String aadhar=textField_1.getText();
	            
	             String phone=textField_2 .getText();
	           
	             String email=textField_3 .getText();
	            
	             String address=textField_4.getText();
	           
	             String btn=G.getSelection().getActionCommand(); 
	             
	     
	             
	             Date selectedDate = (Date) datePicker.getModel().getValue();
		            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		            date = df.format(selectedDate);
		            
		            
		            
		            try {
		            	
		            	if (Database.checkVaccine(btn, date)) {
		            		
							
		            	if(Database.pushData(aadhar,name,phone,email,address,btn,date)) {
		            		//lblNewLabel_1.setText("Booked");
		            		//lblNewLabel_1.setIconTextGap("/OK1.png");
		            		//lblNewLabel_1.setIcon("/OK1.png");
		            		Image img3=new ImageIcon(this.getClass().getResource("/OK1.png")).getImage();
		            		lblNewLabel_1.setIcon(new ImageIcon(img3));
		            		
		            		//lblNewLabel_1_1.setForeground(Color.GREEN);
		            		lblNewLabel_1_1.setText("Booked");
		            		
		            	}
		            	else
		            	{
		            		//lblNewLabel_1.setText("Already Booked");
		            		Image img4=new ImageIcon(this.getClass().getResource("/Del.png")).getImage();
		            		lblNewLabel_1.setIcon(new ImageIcon(img4));
		            		lblNewLabel_1_1.setText("Already Available");
		            		
		            	}
		            }
		            	else
		            	{
		            		lblNewLabel_1.setText("Slot not Available");
		            	}
		            }
		            catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    		
	    	}
	    });
	    btnNewButton.setBounds(106, 252, 132, 31);
	    frame.getContentPane().add(btnNewButton);
	    
	    
	    
	    JLabel lblNewLabel_2 = new JLabel("");
	    Image img1=new ImageIcon(this.getClass().getResource("/inj1.png")).getImage();
	    lblNewLabel_2.setIcon(new ImageIcon(img1));
	    
	    lblNewLabel_2.setBounds(0, 19, 98, 197);
	    frame.getContentPane().add(lblNewLabel_2);
	    
	    textField_5 = new JTextField();
	    textField_5.setColumns(10);
	    textField_5.setBounds(288, 138, 151, 20);
	    frame.getContentPane().add(textField_5);
	    
	    
	    
	    
		
	}
}
