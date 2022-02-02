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

import java.util.ArrayList;
import java.util.Scanner;

 

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

 

public class UtilizatoriGasiti extends JDialog {

 

    private JPanel contentPane;

 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UtilizatoriGasiti frame = new UtilizatoriGasiti();
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
    public UtilizatoriGasiti() {
        setBounds(100, 100, 700, 504);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNumeGrup = new JLabel("C\u0103utare utilizatori");
        lblNumeGrup.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumeGrup.setForeground(new Color(0, 139, 139));
        lblNumeGrup.setFont(new Font("Arial Narrow", Font.BOLD, 29));
        lblNumeGrup.setBounds(228, 11, 218, 52);
        contentPane.add(lblNumeGrup);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Utilizatori", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(37, 83, 614, 273);
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
              File myObj = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\universitate\\cautare_utilizator.txt");
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
        
        list.setModel(dlm);
        
        JButton btnNewButton = new JButton("Modific\u0103 date / \u0218terge cont");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String sel = new String("");
        		sel = list.getSelectedValue().toString();
        		ConexiuneBD conexiune = new ConexiuneBD();
				conexiune.init();
        		if (sel.equals("") == false) {
        			String adrEmail = sel.substring(sel.lastIndexOf("	") + 1);
        			ArrayList<String> date = conexiune.getDate(adrEmail);
        			new ModificareDate(date.get(0), date.get(1), date.get(2), date.get(3), date.get(5), date.get(4), date.get(6), date.get(7)).setVisible(true);
        			ConexiuneBD conexiune1 = new ConexiuneBD();
    				conexiune1.init();
        			int tipUser = conexiune1.getTipUser(adrEmail);
        			if (tipUser == 0) {
        				new AnStudiu(adrEmail).setVisible(true);
        			}
        			else {
        				if (tipUser == 1) {
        					new DetaliiProfesor(adrEmail).setVisible(true);
        				}
        			}
        			setVisible(false);
        		}
        	}
        });
        btnNewButton.setBackground(new Color(0, 128, 128));
        btnNewButton.setForeground(new Color(230, 230, 250));
        btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 18));
        btnNewButton.setBounds(213, 380, 249, 52);
        contentPane.add(btnNewButton);
    }
}
