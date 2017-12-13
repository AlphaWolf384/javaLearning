import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class Main_Scan extends JFrame {

	public static JPanel contentPane;
	public static JTable table;
	public static JTextField ScanField;
	static String code = "";
	private static String[] col = {"Data","Time"};	// Column Title
	static Object[] row = new Object[2];		// Creating two blocks per line
	static DefaultTableModel model;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Scan frame = new Main_Scan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("Scanning");
	}
		
			
	

	/**
	 * Create the frame.
	 */
	public Main_Scan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJklUsb = new JLabel("JKL USB");
		lblJklUsb.setBounds(12, 12, 55, 16);
		contentPane.add(lblJklUsb);
		
		JButton btnExport = new JButton("Export");
		btnExport.setBounds(12, 40, 98, 26);
		contentPane.add(btnExport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 80, 860, 470);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data", "TimeStamp"
			}
		));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(col);

		// USB Scanner test for keyboard emulation to take data input
		// USB Scanner are programmed to press enter after scan
		// TODO Ability to use multiple scanners for multiple entries
		ScanField = new JTextField();
		ScanField.setBounds(122, 43, 750, 20);
		contentPane.add(ScanField);
		ScanField.setColumns(10);
		ScanField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				code = ScanField.getText();
				LocalDateTime Timestamp = LocalDateTime.now();
				System.out.printf("Scanned: " + code);
				System.out.println("");
				System.out.println(Timestamp);
				System.out.println("");
			
				row[0] = code.toString();
				row[1] = Timestamp;
			
				model.addRow(row);
				try {
				    Thread.sleep(100);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				ScanField.setText("");
			}
		});
	}
}
