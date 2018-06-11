package assignment2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;

import java.awt.Font;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GUI(String[][]cluster1 , String[][]cluster2 , String[][]cluster3 , String[][]cluster4 , String[][]knn1 , String[][]knn2 , 
			String[][]knn3 , String[][]knn4) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("EH2745 Assignment 2");
		setBounds(100, 100, 797, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		
		JButton btnKnn = new JButton(" K-means method for clustering");
		btnKnn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				KmeansGUITable  kmeanstable = new KmeansGUITable(cluster1 , cluster2 , cluster3 , cluster4);
				kmeanstable.setVisible(true);
			}
		});
		btnKnn.setFont(new Font("Calibri", Font.BOLD, 40));
		btnKnn.setBounds(29, 41, 729, 172);
		contentPane.add(btnKnn);
		
		JButton button = new JButton(" KNN method for classification");
		button.setFont(new Font("Calibri", Font.BOLD, 40));
		button.setBounds(29, 256, 729, 135);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				KNNGUITable  knntable = new KNNGUITable(knn1 , knn2 , knn3 , knn4);
				knntable.setVisible(true);
			}
		});
	}
}
