import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AsignareCursuri extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsignareCursuri frame = new AsignareCursuri();
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
	public AsignareCursuri() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAsignare = new JLabel("Asignare");
		lblAsignare.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsignare.setForeground(new Color(0, 139, 139));
		lblAsignare.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblAsignare.setBounds(102, 11, 218, 52);
		contentPane.add(lblAsignare);
		
		JLabel lblNewLabel_1 = new JLabel("nume profesor:");
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1.setBounds(21, 74, 136, 26);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(128, 0, 128));
		textField.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBounds(198, 74, 193, 26);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_2 = new JLabel("prenume profesor:");
		lblNewLabel_1_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(21, 110, 162, 26);
		contentPane.add(lblNewLabel_1_2);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(128, 0, 128));
		textField_1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(198, 110, 193, 26);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("activitate:");
		lblNewLabel_1_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(21, 184, 112, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		String[] activitati = {"curs", "laborator", "seminar"};
		JComboBox comboBox_1 = new JComboBox(activitati);
		comboBox_1.setForeground(new Color(128, 0, 128));
		comboBox_1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		comboBox_1.setBounds(198, 184, 193, 26);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("materie:");
		lblNewLabel_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(21, 147, 136, 26);
		contentPane.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(128, 0, 128));
		textField_2.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(198, 147, 193, 26);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel1 = new JLabel("");
		ImageIcon img = new ImageIcon(new ImageIcon("src\\AsignareCursuri.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		lblNewLabel1.setIcon(img);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(0, 238, 434, 113);
		contentPane.add(lblNewLabel1);
		
		JButton btnAsignare = new JButton("Asignare");
		btnAsignare.setForeground(new Color(230, 230, 250));
		btnAsignare.setFont(new Font("Arial Nova Light", Font.BOLD, 14));
		btnAsignare.setBackground(new Color(0, 139, 139));
		btnAsignare.setActionCommand("OK");
		btnAsignare.setBounds(148, 384, 138, 44);
		contentPane.add(btnAsignare);
		
		btnAsignare.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 ConexiuneBD conexiune1 = new ConexiuneBD();
                 conexiune1.init();
                 String contractProf = conexiune1.getNrContract(textField.getText(),  textField_1.getText());
            	
                ConexiuneBD conexiune = new ConexiuneBD();
                conexiune.init();
                String mesajEroare = conexiune.asignareProfCurs(textField.getText(), textField_1.getText(), contractProf, textField_2.getText(), (String) comboBox_1.getSelectedItem());
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
