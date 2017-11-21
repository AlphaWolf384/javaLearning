import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class MainScreen extends javax.swing.JFrame {

	private static JPanel contentPane;
	static ServerSocket ss;
	static Socket s;
	static BufferedReader br;
	static InputStreamReader isr;
	static String message = "";
	public static JLabel mainLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
				ss = new ServerSocket(7777);
					
				System.out.println("Server running at 7777");
				s = ss.accept();
				isr = new InputStreamReader(s.getInputStream());
				br = new BufferedReader(isr);
				message = br.readLine();
				System.out.println(message);
				mainLabel.setText(message);
				isr.close();
				br.close();
				ss.close();
				s.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		mainLabel = new JLabel("Nothing");
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(mainLabel, BorderLayout.CENTER); 
	}
}
