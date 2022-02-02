import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

public class VizualizareNoteProfesor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VizualizareNoteProfesor frame = new VizualizareNoteProfesor(1);
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
	public VizualizareNoteProfesor(int id) {
		setBounds(100, 100, 700, 475);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumeGrup = new JLabel("Vizualizare Note");
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
		list.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		scrollPane.setViewportView(list);
		
		
		DefaultListModel dlm = new DefaultListModel();
		
		
		try {
			File myObj, myObj0, myObj1, myObj2, myObj3; 
			myObj0 = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\note_curs.txt");
			myObj1 = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\note_laborator.txt");
			myObj2 = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\note_seminar.txt");
			myObj3 = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\note_materie.txt");
			if(id == 0) 
				myObj = myObj0;
				else {
					if(id == 1)
						myObj = myObj1;
					else {
						if(id == 2)
							myObj = myObj2;
						else
							myObj = myObj3;
				}
			}
		      
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
		      
		      if(myObj0.delete())
		    	  System.out.println("deleted");
		      else
		    	  System.out.println("could not be deleted");
		      
		      if(myObj1.delete())
			    	  System.out.println("deleted");
			      else
			    	  System.out.println("could not be deleted");
		      
		       if(myObj2.delete())
				    	  System.out.println("deleted");
				      else
				    	  System.out.println("could not be deleted");
				if(myObj3.delete())
					     System.out.println("deleted");
					      else
					    System.out.println("could not be deleted");;
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("Eroare la citire");
		      e.printStackTrace();
		    }
		
		list.setModel(dlm);
		
		JButton btnDescrcare = new JButton("Desc\u0103rcare");
		btnDescrcare.setForeground(new Color(230, 230, 250));
		btnDescrcare.setFont(new Font("Arial Nova Light", Font.BOLD, 14));
		btnDescrcare.setBackground(new Color(0, 139, 139));
		btnDescrcare.setActionCommand("OK");
		btnDescrcare.setBounds(263, 370, 138, 44);
		contentPane.add(btnDescrcare);
		
		btnDescrcare.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					FileWriter fw = new FileWriter("catalog.txt");
					for(int i = 0; i < dlm.getSize(); i++) {
						fw.write((String) dlm.get(i));
					}
					
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				setVisible(false);
			}
		});
	}

}
