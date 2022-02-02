import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RenuntareCurs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RenuntareCurs frame = new RenuntareCurs(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RenuntareCurs(int idStudent) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Renun\u021Bare curs");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblNewLabel.setBounds(109, 11, 215, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblCurs = new JLabel("Curs:");
		lblCurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurs.setForeground(new Color(0, 128, 128));
		lblCurs.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblCurs.setBounds(10, 73, 102, 30);
		contentPane.add(lblCurs);
		
		JButton btnNewButton = new JButton("Renun\u021Bare");
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setForeground(new Color(230, 230, 250));
		btnNewButton.setBounds(160, 123, 116, 39);
		contentPane.add(btnNewButton);
		
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
		comboBox.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		comboBox.setBounds(109, 74, 302, 30);
		contentPane.add(comboBox);
		
		
		btnNewButton.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 int id = iduri[comboBox.getSelectedIndex()];
                 ConexiuneBD conexiune = new ConexiuneBD();
                 conexiune.init();
                 String mesajEroare = conexiune.renuntareCurs(idStudent, id);
                 if (mesajEroare != null) {
                        new MesajEroare(mesajEroare).setVisible(true);
                         System.out.println(mesajEroare);
                        }
                        else {
                            setVisible(false);
                        }
                }
        });
	}
}