import java.awt.BorderLayout;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.SwingConstants;

public class SwingApp extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		// SwingApp app = new SwingApp("Hello World", "Hello World");

		// SwingApp app = new SwingApp();

		SwingApp app = new SwingApp("Hello World");

		app.setVisible(true);

	}

	public SwingApp() {

		this("Hello World", "Hi everyone");

	}

	public SwingApp(String title) {

		this(title, "Hi everyone");

	}

	public SwingApp(String title, String text) {

		super(title);

		setLayout(new BorderLayout());

		JLabel label = new JLabel(text);

		label.setHorizontalAlignment(SwingConstants.CENTER);

		add(label, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(800, 600);

	}

}