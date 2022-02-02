import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.border.TitledBorder;

import java.util.Scanner;

import javax.swing.JScrollPane;

public class MembriGrup extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MembriGrup frame = new MembriGrup(1);
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
	public MembriGrup(int idGrup) {
		setBounds(100, 100, 450, 550);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ConexiuneBD conexiune = new ConexiuneBD();
		conexiune.init();
		
		JLabel lblNumeGrup = new JLabel(conexiune.getNumeGrup(idGrup));
		lblNumeGrup.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeGrup.setForeground(new Color(0, 139, 139));
		lblNumeGrup.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblNumeGrup.setBounds(104, 11, 218, 52);
		contentPane.add(lblNumeGrup);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 139, 139));
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(null, "Membri grup", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(29, 71, 376, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		DefaultListModel dlm = new DefaultListModel();
		
		
		try {
		      File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\afisare_membri.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        dlm.addElement(data);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 364, 360);
		panel.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setBackground(new Color(255, 255, 255));
		list.setForeground(new Color(128, 0, 128));
		list.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		
		list.setModel(dlm);
	}
}
