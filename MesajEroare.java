import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MesajEroare extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MesajEroare dialog = new MesajEroare("alabala");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MesajEroare(String mesajEroare) {
		setBounds(100, 100, 450, 395);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(230, 230, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Re\u00EEncearc\u0103");
			okButton.setForeground(new Color(230, 230, 250));
			okButton.setFont(new Font("Arial Nova Light", Font.BOLD, 14));
			okButton.setBackground(new Color(0, 139, 139));
			okButton.setBounds(150, 264, 138, 44);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
			
			okButton.addActionListener((ActionListener) new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setVisible(false);
				}
			});
		}
		
		JLabel lblNewLabel = new JLabel(mesajEroare);
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 25, 434, 66);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("");
		ImageIcon img = new ImageIcon(new ImageIcon("src\\MesajEroare.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		lblNewLabel1.setIcon(img);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(0, 113, 434, 113);
		contentPanel.add(lblNewLabel1);
	}
}
