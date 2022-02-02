import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VizualizareNote extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VizualizareNote frame = new VizualizareNote();
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
	public VizualizareNote() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 475);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumeGrup = new JLabel("Notele mele");
		lblNumeGrup.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeGrup.setForeground(new Color(0, 139, 139));
		lblNumeGrup.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblNumeGrup.setBounds(228, 11, 218, 52);
		contentPane.add(lblNumeGrup);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Note", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(30, 74, 614, 273);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 602, 251);
		panel.add(scrollPane);
		
		JList list = new JList();
		list.setForeground(new Color(128, 0, 128));
		list.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		scrollPane.setViewportView(list);
		
		
		DefaultListModel dlm = new DefaultListModel();
		
		
		try {
		      File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\note_student.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        dlm.addElement(data);
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
		
		list.setModel(dlm);
		
		JButton btnAfieazListaStudeni = new JButton("OK");
		
		btnAfieazListaStudeni.setForeground(new Color(230, 230, 250));
		btnAfieazListaStudeni.setFont(new Font("Arial Nova Light", Font.BOLD, 14));
		btnAfieazListaStudeni.setBackground(new Color(0, 139, 139));
		btnAfieazListaStudeni.setActionCommand("OK");
		btnAfieazListaStudeni.setBounds(252, 367, 191, 44);
		contentPane.add(btnAfieazListaStudeni);
		
		btnAfieazListaStudeni.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
	}
}