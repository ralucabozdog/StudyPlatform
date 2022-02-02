import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AdaugareMaterie extends JFrame {

	private JPanel contentPane;
	private JTextField txtEadsa;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdaugareMaterie frame = new AdaugareMaterie();
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
	public AdaugareMaterie() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 272);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Ad\u0103uga\u021Bi o nou\u0103 materie");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(79, 11, 296, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNume = new JLabel("nume:");
		lblNume.setForeground(new Color(0, 128, 128));
		lblNume.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		lblNume.setBounds(47, 73, 82, 29);
		contentPane.add(lblNume);
		
		JLabel lblDescriere = new JLabel("descriere:");
		lblDescriere.setForeground(new Color(0, 128, 128));
		lblDescriere.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		lblDescriere.setBounds(47, 118, 82, 29);
		contentPane.add(lblDescriere);
		
		txtEadsa = new JTextField();
		txtEadsa.setForeground(new Color(128, 0, 128));
		txtEadsa.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		txtEadsa.setBounds(134, 80, 256, 20);
		contentPane.add(txtEadsa);
		txtEadsa.setColumns(10);
		
		textField = new JTextField();
		textField.setForeground(new Color(128, 0, 128));
		textField.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		textField.setColumns(10);
		textField.setBounds(134, 125, 256, 20);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Ad\u0103ugare");
		btnNewButton.setForeground(new Color(230, 230, 250));
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 21));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(163, 160, 124, 48);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mesajEroare = new String();
               
                ConexiuneBD conexiune = new ConexiuneBD();
                conexiune.init();
                mesajEroare = conexiune.adaugareMaterie(txtEadsa.getText(), textField.getText());
               
                if(mesajEroare != null) {
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