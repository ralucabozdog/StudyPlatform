import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class InscriereGrup extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriereGrup frame = new InscriereGrup(1);
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
	public InscriereGrup(int idStudent) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Grupuri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(33, 85, 614, 273);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 602, 251);
		panel.add(scrollPane);
		
		JList list = new JList();
		list.setForeground(new Color(128, 0, 128));
		list.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		scrollPane.setViewportView(list);
		
		JLabel lblnscriereGrup = new JLabel("\u00CEnscriere grup");
		lblnscriereGrup.setHorizontalAlignment(SwingConstants.CENTER);
		lblnscriereGrup.setForeground(new Color(0, 128, 128));
		lblnscriereGrup.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblnscriereGrup.setBounds(225, 11, 215, 39);
		contentPane.add(lblnscriereGrup);
		
		JButton btnNewButton = new JButton("\u00CEnscriere");
		btnNewButton.setForeground(new Color(230, 230, 250));
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(278, 390, 116, 39);
		contentPane.add(btnNewButton);
		
		DefaultListModel dlm = new DefaultListModel();
		
		int[] vector = new int[100];
	    int i = 0;
		try {
		      File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\toate_grupurile.txt");
		      Scanner myReader = new Scanner(myObj);
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        
		        String nb = data.substring(0,1);
		        int number = Integer.parseInt(nb);
		        vector[i] = number;
		        i++;
		        
		        String dataModified = data.substring(2);
		        dlm.addElement(dataModified);
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
		
		list.setModel(dlm);
		
		btnNewButton.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConexiuneBD conexiune = new ConexiuneBD();
				conexiune.init();
				
				int index = list.getSelectedIndex();
				int idGrup = vector[index];
				
				String mesajEroare = conexiune.inscriereGrup(idStudent, idGrup);
				
				if(mesajEroare!= null) {
					new MesajEroare(mesajEroare).setVisible(true);
				}
				else {
					setVisible(false);
				}

			}
		});
	}
}
