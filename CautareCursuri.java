import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
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
import javax.swing.JButton;

public class CautareCursuri extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CautareCursuri frame = new CautareCursuri();
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
	public CautareCursuri() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 381);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCutareCursuri = new JLabel("C\u0103utare curs");
		lblCutareCursuri.setHorizontalAlignment(SwingConstants.CENTER);
		lblCutareCursuri.setForeground(new Color(0, 139, 139));
		lblCutareCursuri.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblCutareCursuri.setBounds(112, 11, 218, 52);
		contentPane.add(lblCutareCursuri);
		
		JLabel lblNewLabel_1_1 = new JLabel("materie:");
		lblNewLabel_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(48, 74, 136, 26);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(128, 0, 128));
		textField.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBounds(184, 74, 193, 26);
		contentPane.add(textField);

		JLabel lblNewLabel1 = new JLabel("");
		ImageIcon img = new ImageIcon(new ImageIcon("src\\CautareCursuri.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		lblNewLabel1.setIcon(img);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(0, 122, 434, 113);
		contentPane.add(lblNewLabel1);
		
		JButton btnCautare = new JButton("Cautare");
		btnCautare.setForeground(new Color(230, 230, 250));
		btnCautare.setFont(new Font("Arial Nova Light", Font.BOLD, 14));
		btnCautare.setBackground(new Color(0, 139, 139));
		btnCautare.setActionCommand("OK");
		btnCautare.setBounds(148, 261, 138, 44);
		contentPane.add(btnCautare);
		
		
		
		btnCautare.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String mesajEroare = new String();
				
				ConexiuneBD c = new ConexiuneBD ();
				c.init();
				mesajEroare = c.cautareCurs(textField.getText());
				
				if(mesajEroare != null) {
					new MesajEroare(mesajEroare).setVisible(true);
				}
				else {
					setVisible(false);
					new CursuriGasite().setVisible(true);
				}
			}
		});
	}

}
