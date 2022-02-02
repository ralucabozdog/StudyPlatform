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
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AlegeMaterie extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlegeMaterie frame = new AlegeMaterie(1);
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
	public AlegeMaterie(int idProf) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlegeMateriai = new JLabel("Alege materia \u0219i activitatea");
		lblAlegeMateriai.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlegeMateriai.setForeground(new Color(0, 139, 139));
		lblAlegeMateriai.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblAlegeMateriai.setBounds(10, 11, 416, 52);
		contentPane.add(lblAlegeMateriai);
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("materie:");
		lblNewLabel_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(55, 86, 73, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox comboBox_1 = new JComboBox(new Object[]{"curs", "laborator", "seminar", "nota finala"});
		comboBox_1.setForeground(new Color(128, 0, 128));
		comboBox_1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		comboBox_1.setBounds(191, 128, 193, 26);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("activitate:");
		lblNewLabel_1_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(55, 128, 112, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnOk = new JButton("OK");
		btnOk.setForeground(new Color(230, 230, 250));
		btnOk.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		btnOk.setBackground(new Color(0, 139, 139));
		btnOk.setBounds(150, 212, 147, 52);
		contentPane.add(btnOk);
		
		String[] materii = new String[20];
		int[] iduri = new int[20];
		int i = 0;
		ConexiuneBD conexiune1 = new ConexiuneBD();
		conexiune1.init();
		conexiune1.toateMateriileProfesorului(idProf);
		
		try {
		      File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\toate_materiile_profesorului.txt");
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
		    	  System.out.println("could not be deleted");
		    } catch (FileNotFoundException e) {
		      System.out.println("Eroare la citire");
		      e.printStackTrace();
		    }
		
		JComboBox comboBox = new JComboBox(materii);
		comboBox.setForeground(new Color(128, 0, 128));
		comboBox.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		comboBox.setBounds(191, 86, 193, 26);
		contentPane.add(comboBox);
		
		
		btnOk.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String mesajEroare = new String();
				ConexiuneBD conexiune = new ConexiuneBD();
				conexiune.init();
				
				if(comboBox_1.getSelectedIndex() == 0)
					mesajEroare = conexiune.vizualizareNoteCurs(idProf, iduri[comboBox.getSelectedIndex()]);
				else {
					if(comboBox_1.getSelectedIndex() == 1)
						mesajEroare = conexiune.vizualizareNoteLaborator(idProf, iduri[comboBox.getSelectedIndex()]);
					else {
						if(comboBox_1.getSelectedIndex() == 2)
							mesajEroare = conexiune.vizualizareNoteSeminar(idProf, iduri[comboBox.getSelectedIndex()]);
						else
							mesajEroare = conexiune.vizualizareNoteMaterie(idProf);
					}
				}
				
				if(mesajEroare != null) {
					new MesajEroare(mesajEroare).setVisible(true);
				}
				else {
					
				}
				
				setVisible(false);
			}
		});
	}
}
