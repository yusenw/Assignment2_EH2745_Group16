package assignment2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.SwingConstants;


import java.awt.Font;

public class KmeansGUITable extends JFrame {


	private JPanel contentPane;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;

	
	public KmeansGUITable(String[][]Cluster1 , String[][]Cluster2 , String[][]Cluster3 , String[][]Cluster4) {
		
		String[] columnheaders = {"Times" , "Cluster"};
		setBounds(100, 100, 962, 570);
		setTitle("K-Means Clustering");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 47, 453, 199);
		contentPane.add(scrollPane);
				
		table_4 = new JTable(Cluster1 , columnheaders);
		scrollPane.setViewportView(table_4);
		

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(481, 47, 453, 199);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable(Cluster2 , columnheaders);
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 318, 453, 199);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable(Cluster3 , columnheaders);
		scrollPane_2.setViewportView(table_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(481, 318, 453, 199);
		contentPane.add(scrollPane_3);
		
		table_3 = new JTable(Cluster4 , columnheaders);
		scrollPane_3.setViewportView(table_3);
		
		JLabel lblNewLabel = new JLabel("High load rate during peak hours");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel.setBounds(81, 0, 326, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblLowLoadRate = new JLabel("Shut down of generator for maintenance");
		lblLowLoadRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblLowLoadRate.setFont(new Font("Calibri", Font.BOLD, 15));
		lblLowLoadRate.setBounds(566, 0, 326, 49);
		contentPane.add(lblLowLoadRate);
		
		JLabel lblDisconnectionOfA = new JLabel("Disconnection of a line for maintenance");
		lblDisconnectionOfA.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisconnectionOfA.setFont(new Font("Calibri", Font.BOLD, 15));
		lblDisconnectionOfA.setBounds(81, 269, 326, 49);
		contentPane.add(lblDisconnectionOfA);
		
		JLabel lblShutDownOf = new JLabel("Low load rate during night");
		lblShutDownOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblShutDownOf.setFont(new Font("Calibri", Font.BOLD, 15));
		lblShutDownOf.setBounds(566, 269, 326, 49);
		contentPane.add(lblShutDownOf);
		
	}
}
