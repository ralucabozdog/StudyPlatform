import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class OrarStudent extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrarStudent frame = new OrarStudent();
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
	public OrarStudent() {
		setBackground(new Color(230, 230, 250));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 779, 437);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 743, 122);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(230, 230, 250));
		table.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		table.setForeground(new Color(128, 0, 128));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"8-10", null, null, null, null, null},
				{"10-12", null, null, null, null, null},
				{"12-14", null, null, null, null, null},
				{"14-16", null, null, null, null, null},
				{"16-18", null, null, null, null, null},
				{"18-20", null, null, null, null, null},
				{"20-22", null, null, null, null, null},
			},
			new String[] {
				"Ora", "Luni", "Mar\u021Bi", "Miercuri", "Joi", "Vineri"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setMinWidth(30);
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\OrarStudent.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(286, 227, 177, 159);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Orar");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 26));
		lblNewLabel_1.setBounds(254, 21, 246, 42);
		contentPane.add(lblNewLabel_1);
	}
}