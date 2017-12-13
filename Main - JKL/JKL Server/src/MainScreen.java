import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.JTextComponent;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Color;

public class MainScreen extends JFrame {

	public static JPanel contentPane;
	public static JLabel lblIp;
	static JLabel lblPort;
	static JLabel lblPing;
	static JLabel lblStatus;
	public JButton	btnConnect;
	public JButton btnDisconnect;
	public static JButton btnData;
	static ServerSocket ss;
	static Socket s;
	static BufferedReader br;
	static InputStreamReader isr;
	static String message = "";
	
	private static String ip;
	private static int port = 7777; // TODO Add Adjustable port number
	static JTable table;
	
	private static String[] col = {"Data","Time"}; // TODO Avaiable to add more title columns
	static Object[] row = new Object[2]; // Creating two blocks per line
	
	//static DefaultTableModel model = (DefaultTableModel) table.getModel();
	static DefaultTableModel model;
	private JTextField USBField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws java.net.UnknownHostException {
		
		// Create MainScreen and Components
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				// Main Frame setup
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		try {
			while (true) {
				// Loops until Input is answered by Enter button

				// This code will get data from JKL app only!!!

				ss = new ServerSocket(port);
				System.out.println("Server running at " + port);
				// BUG: lblStatus refused to change text and causing program to crash, Issue: WIP
				//lblStatus.setText("Status: Connected");	
				s = ss.accept();

				isr = new InputStreamReader(s.getInputStream());
				br = new BufferedReader(isr);
				// Server Socket connection is completed and code will excute now below
				message = br.readLine();

				System.out.println(message);
				System.out.println(LocalDateTime.now());
				
				row[0] = message.toString(); 
				row[1] = LocalDateTime.now().toString();
				
				model.addRow(row);
									
				System.out.println();
				System.out.println("Testing for confirmation");					 
				System.out.println(row[0]);
				System.out.println(row[1]);
				
				// Code is concluded and will wrap up
				isr.close();
				br.close();
				ss.close();
				s.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//lblStatus.setText("Status: Disconnected");
		}
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Data Storer here
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 85, 862, 466);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setRowSelectionAllowed(false);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			// Default setup
			new Object[][] {
				
			},
			new String[] {
				"Data", "Time"
			}
		));
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(col); 	// Identify Column names as col is being called in top
		
		JLabel lblIp = new JLabel("IP: 255.255.255.255");	// IP Address default number
		lblIp.setBounds(12, 34, 112, 14);
		contentPane.add(lblIp);
		
		JLabel lblPort = new JLabel("Port: -");		// Default Port Number
		lblPort.setBounds(12, 59, 112, 14);
		contentPane.add(lblPort);
		
		JLabel lblPing = new JLabel("Ping");	// Ping Pong Button
		lblPing.setHorizontalAlignment(SwingConstants.CENTER);
		lblPing.setBounds(669, 44, 89, 23);
		contentPane.add(lblPing);
		
		JLabel lblTitle = new JLabel("JKL Server");		// Title Textbox
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setBounds(12, 10, 100, 16);
		contentPane.add(lblTitle);
		
		JButton btnData = new JButton("Ping");		// Will switch back forth as 'Ping' and 'Pong'
		btnData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblPing.getText() == "Ping") {
					lblPing.setText("Pong");
				}
				else {
					lblPing.setText("Ping");
				}
			}
		});
		btnData.setBounds(669, 10, 89, 23);
		contentPane.add(btnData);
		
		JButton btnImport = new JButton("Import");				// Inserting existing Excel to list
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ExcelFunction.xlImport();			// Calls xlImport function in ExcelFunction.java
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnImport.setBounds(776, 10, 98, 26);
		contentPane.add(btnImport);
			
		JButton btnExport = new JButton("Export");				// Exporing all obtained data into created new excel spreadsheet
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ExcelFunction.xlExport();				// Calls xlExport function in ExcelFunction.java
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnExport.setBounds(776, 48, 98, 26);
		contentPane.add(btnExport);
		
		// If JKL is not being used or USB Scanners are being used
		// Code will execute here as keyboard emulation
		// TODO Create multiple USB entries to add lines in lists as multiple scanning
		// USB Scanner are programmed to press enter after scanning and could use more coding
		USBField = new JTextField();
		USBField.setToolTipText("");
		USBField.setBounds(105, 31, 546, 20);
		contentPane.add(USBField);
		USBField.setColumns(10);
		USBField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				message = USBField.getText();
				LocalDateTime Timestamp = LocalDateTime.now();
				System.out.printf("Scanned: " + message);
				System.out.println("");
				System.out.println(Timestamp);
				System.out.println("");
			
				row[0] = message.toString();
				row[1] = Timestamp;
			
				model.addRow(row);
				try {
				    Thread.sleep(100);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				USBField.setText("");
			}
		});


		// Button to establish connections between JKL phone app to Computer 
		// Computer will get data from phone and display it in ScrollPane	
		JLabel lblTitle2 = new JLabel("Enter the Data Below via App or USB Scanner");
		lblTitle2.setBounds(105, 10, 546, 16);
		contentPane.add(lblTitle2);
		
		// IP Address and Host Port Info
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println("IP Address: " + ip);
			System.out.println("Port: " + port);

			lblIp.setText("IP: " + ip);
			lblPort.setText("Port: " + port);	
		
		} catch (java.net.UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			lblIp.setText("IP: null");
			lblPort.setText("Port: null");
		}
	}
}

