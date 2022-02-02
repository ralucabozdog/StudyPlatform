import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActivitateSucces extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivitateSucces frame = new ActivitateSucces(2);
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
	public ActivitateSucces(int idActivitate) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Activitatea a fost creatã cu succes!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 25, 434, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(0, 126, 434, 113);
		ImageIcon img = new ImageIcon(new ImageIcon("src\\ActivitateSucces.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		lblNewLabel1.setIcon(img);
		contentPane.add(lblNewLabel1);
		
		JButton okButton = new JButton("Invit\u0103 un profesor");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexiuneBD conexiune = new ConexiuneBD();
				conexiune.init();
				conexiune.totiProfesorii();
				new InvitaProfesor(idActivitate).setVisible(true);
				setVisible(false);
			}
		});
		
		okButton.setForeground(new Color(230, 230, 250));
		okButton.setFont(new Font("Arial Nova Light", Font.BOLD, 14));
		okButton.setBackground(new Color(0, 139, 139));
		okButton.setActionCommand("OK");
		okButton.setBounds(137, 277, 163, 44);
		contentPane.add(okButton);
		
		JLabel lblInvitUnProfesor = new JLabel("Po\u021Bi invita un profesor la aceast\u0103 activitate");
		lblInvitUnProfesor.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvitUnProfesor.setForeground(new Color(128, 0, 128));
		lblInvitUnProfesor.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblInvitUnProfesor.setBounds(0, 63, 434, 32);
		contentPane.add(lblInvitUnProfesor);
	}
}
