import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.SwingConstants;

public class SugestiiParticipanti extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SugestiiParticipanti dialog = new SugestiiParticipanti(2);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public SugestiiParticipanti() {
		
	}
	
	public SugestiiParticipanti(int idGrup) {
		setBounds(100, 100, 450, 475);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBackground(new Color(230, 230, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSugestiiParticipani = new JLabel("Sugestii de participan\u021Bi");
			lblSugestiiParticipani.setHorizontalAlignment(SwingConstants.CENTER);
			lblSugestiiParticipani.setForeground(new Color(0, 139, 139));
			lblSugestiiParticipani.setFont(new Font("Arial Narrow", Font.BOLD, 29));
			lblSugestiiParticipani.setBounds(77, 11, 289, 52);
			contentPanel.add(lblSugestiiParticipani);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Participanti sugerati", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(42, 72, 348, 319);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 336, 297);
		panel.add(scrollPane);
		
		JList list = new JList();
		list.setForeground(new Color(128, 0, 128));
		list.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		scrollPane.setViewportView(list);
		
		DefaultListModel dlm = new DefaultListModel();
		
		ConexiuneBD conexiune = new ConexiuneBD();
		conexiune.init();
		conexiune.sugestiiParticipanti(idGrup);
		
		try {
		      File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\sugestii_participanti.txt");
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
	}
}
