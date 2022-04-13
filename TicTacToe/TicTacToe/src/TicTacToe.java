import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	JButton reset = new JButton();
	JButton start = new JButton();
	JPanel menuButtons = new JPanel();
	boolean playerOneTurn;

	TicTacToe() {

		// Frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		// Title
		textfield.setBackground(new Color(25, 25, 25));
		textfield.setForeground(new Color(52, 104, 237));
		textfield.setFont(new Font("Cambria", Font.BOLD, 50));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);

		title.setLayout(new BorderLayout());
		title.setBounds(0, 0, 400, 100);

		// Buttons
		buttonPanel.setLayout(new GridLayout(3, 3));
		buttonPanel.setBackground(new Color(150, 150, 150));

		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("Cambria", Font.BOLD, 25));
			buttons[i].setBackground(new Color(22, 48, 115));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			buttons[i].setEnabled(false);
		}

		start.setHorizontalAlignment(JLabel.CENTER);
		start.setBackground(new Color(25, 25, 25));
		start.setForeground(new Color(52, 104, 237));
		start.setFont(new Font("Cambria", Font.BOLD, 25));
		start.setText("Start Game");
		start.setOpaque(true);
		start.setBounds(0, 0, 400, 100);
		start.addActionListener(this);
		start.setEnabled(true);

		reset.setHorizontalAlignment(JLabel.CENTER);
		reset.setBackground(new Color(25, 25, 25));
		reset.setForeground(new Color(52, 104, 237));
		reset.setFont(new Font("Cambria", Font.BOLD, 25));
		reset.setText("Reset Game");
		reset.setOpaque(true);
		reset.setBounds(0, 0, 400, 100);
		reset.addActionListener(this);
		reset.setEnabled(false);

		title.add(textfield);

		JPanel menuButtons = new JPanel();
		menuButtons.add(start);
		menuButtons.add(reset);
		menuButtons.setBackground(new Color(25, 25, 25));
		menuButtons.setForeground(new Color(52, 104, 237));

		start.setBounds(0, 300, 400, 25);
		frame.add(title, BorderLayout.NORTH);
		frame.add(buttonPanel);
		frame.add(menuButtons, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 9; i++) {

			if (e.getSource() == start) {
				buttons[i].setEnabled(true);
				firstTurn();
				reset.setEnabled(true);
				start.setEnabled(false);
			}

			if (e.getSource() == reset) {
				start.setEnabled(true);
				reset.setEnabled(false);
				buttons[i].setEnabled(false);
				textfield.setText("Tic-Tac-Toe");
				if (buttons[i].getText() == "X") {
					buttons[i].setText("");
					buttons[i].setBackground(new Color(22, 48, 115));

				}
				if (buttons[i].getText() == "O") {
					buttons[i].setText("");
					buttons[i].setBackground(new Color(22, 48, 115));

				}

			}

			if (e.getSource() == buttons[i]) {
				if (playerOneTurn) {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0, 0, 0));
						buttons[i].setText("X");
						playerOneTurn = false;
						textfield.setText("O's Turn");
						check();
					}
				} else {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0, 0, 0));
						buttons[i].setText("O");
						playerOneTurn = true;
						textfield.setText("X's Turn");
						check();
					}

				}
			}
		}
	}

	public void firstTurn() {

		for (int i = 9; i < 9; i++) {
			buttons[i].setEnabled(true);
		}

		if (random.nextInt(2) == 0) {
			for (int i = 9; i < 9; i++) {
				buttons[i].setEnabled(true);
			}
			playerOneTurn = true;
			textfield.setText("X's Turn");

		} else {
			playerOneTurn = false;
			for (int i = 9; i < 9; i++) {
				while(playerOneTurn == false);
			}
			
			textfield.setText("O's Turn");
		}
			

		

	}

	public void check() {
		// Check X Victory
		if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
			xVictory(0, 1, 2);
		}

		if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
			xVictory(3, 4, 5);
		}

		if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
			xVictory(6, 7, 8);
		}

		if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
			xVictory(0, 3, 6);
		}

		if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
			xVictory(1, 4, 7);
		}

		if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
			xVictory(2, 5, 8);
		}

		if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
			xVictory(0, 4, 8);
		}

		if ((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
			xVictory(2, 4, 6);
		}

		// Check O Victory
		if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
			oVictory(0, 1, 2);
		}

		if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
			oVictory(3, 4, 5);
		}

		if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
			oVictory(6, 7, 8);
		}

		if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
			oVictory(0, 3, 6);
		}

		if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
			oVictory(1, 4, 7);
		}

		if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {
			oVictory(2, 5, 8);
		}

		if ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) {
			oVictory(0, 4, 8);
		}

		if ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) {
			oVictory(2, 4, 6);
		}
	}

	public void xVictory(int a, int b, int c) {

		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
			start.setEnabled(false);

		}

		textfield.setText("X has won.");

	}

	public void oVictory(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
			start.setEnabled(false);
		}

		textfield.setText("O has won.");

	}
}
