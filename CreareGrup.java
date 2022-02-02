import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class CreareGrup extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreareGrup dialog = new CreareGrup(4);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreareGrup(int idStudent) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 455);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBackground(new Color(230, 230, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCreareGrup = new JLabel("Creare Grup");
			lblCreareGrup.setHorizontalAlignment(SwingConstants.CENTER);
			lblCreareGrup.setForeground(new Color(0, 139, 139));
			lblCreareGrup.setFont(new Font("Arial Narrow", Font.BOLD, 29));
			lblCreareGrup.setBounds(111, 11, 218, 52);
			contentPanel.add(lblCreareGrup);
		}
		
		JLabel lblNewLabel_1_1 = new JLabel("materie:");
		lblNewLabel_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(55, 97, 73, 26);
		contentPanel.add(lblNewLabel_1_1);
		

		String[] materii = new String[20];
		int[] iduri = new int[20];
		int i = 0;
		ConexiuneBD conexiune1 = new ConexiuneBD();
		conexiune1.init();
		conexiune1.toateCursurileStudentului(idStudent);
		
		try {
		      File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\toate_cursurile_studentului.txt");
		      Scanner myReader = new Scanner(myObj);
		      
		      while (myReader.hasNextLine()) {
		    	
		        String data = myReader.nextLine();
		        
		        int number = Integer.parseInt(data);
		        ConexiuneBD conexiune = new ConexiuneBD();
		        conexiune.init();
		        iduri[i] = number;
		        materii[i] = conexiune.getNumeMaterie(number);
		        i++;
		      }
		      myReader.close();
		      if(myObj.delete())
		    	  System.out.println("deleted");
		      else
		    	  System.out.println("could not be deleted");;
		    } catch (FileNotFoundException e) {
		      System.out.println("Eroare la citire");
		      e.printStackTrace();
		    }
		
		JComboBox comboBox = new JComboBox(materii);
		comboBox.setForeground(new Color(128, 0, 128));
		comboBox.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		comboBox.setBounds(191, 97, 193, 26);
		contentPanel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img = new ImageIcon(new ImageIcon("src\\CreareGrup.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(img);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 187, 434, 113);
		contentPanel.add(lblNewLabel);
		
		JButton btnCreare = new JButton("Creare");
		btnCreare.setForeground(new Color(230, 230, 250));
		btnCreare.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnCreare.setBackground(new Color(0, 139, 139));
		btnCreare.setBounds(154, 331, 126, 52);
		contentPanel.add(btnCreare);
		
		btnCreare.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConexiuneBD conexiune = new ConexiuneBD();
				conexiune.init();
				conexiune.creareGrup(iduri[comboBox.getSelectedIndex()], textField.getText());
				setVisible(false);
			}
		});
		
		JLabel lblNewLabel_1_1_1 = new JLabel("nume grup:");
		lblNewLabel_1_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(55, 134, 136, 26);
		contentPanel.add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(128, 0, 128));
		textField.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBounds(191, 134, 193, 26);
		contentPanel.add(textField);
	}
}
