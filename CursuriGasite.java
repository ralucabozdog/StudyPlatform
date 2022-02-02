import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.border.TitledBorder;

import java.util.Scanner;

import javax.swing.JScrollPane;

public class CursuriGasite extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CursuriGasite frame = new CursuriGasite();
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
	public CursuriGasite() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 475);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumeGrup = new JLabel("Cautare cursuri");
		lblNumeGrup.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeGrup.setForeground(new Color(0, 139, 139));
		lblNumeGrup.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblNumeGrup.setBounds(228, 11, 218, 52);
		contentPane.add(lblNumeGrup);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cursuri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(30, 74, 614, 273);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 602, 251);
		panel.add(scrollPane);
		
		JList list = new JList();
		list.setForeground(new Color(128, 0, 128));
		list.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		scrollPane.setViewportView(list);
		
		
		DefaultListModel dlm = new DefaultListModel();
		
		
		try {
		      File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\cautare_curs.txt");
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
		
		JButton btnAfieazListaStudeni = new JButton("Afi\u0219eaz\u0103 lista studen\u021Bi");
		
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
				String str = (String) list.getSelectedValue();
				
				String numeMaterie = str.substring(0, str.indexOf('\t'));
				
				String numeProf = str.substring(str.lastIndexOf(':') + 1, str.lastIndexOf(' '));
				
				String strictNumeProf = numeProf.substring(numeProf.indexOf('\t') + 1, numeProf.lastIndexOf('\t'));
				
				String prenumeProf = str.substring(str.indexOf(numeProf) + numeProf.length() + 1, str.length());
				
				String strictPrenumeProf = prenumeProf.substring(prenumeProf.indexOf('\t') + 1);

				ConexiuneBD conexiune = new ConexiuneBD();
				conexiune.init();
				int idActivitate = conexiune.gasireActivitate(numeMaterie, strictNumeProf, strictPrenumeProf);
				
				
				ConexiuneBD conexiune1 = new ConexiuneBD();
				conexiune1.init();
				conexiune1.afisareStudenti(idActivitate);
				new AfisareStudenti().setVisible(true);
				setVisible(false);
			}
		});
	}
	
	
}
