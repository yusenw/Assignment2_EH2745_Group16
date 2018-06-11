package assignment2;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;



public class Assignment2 {
	
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost/";
		static final String DISABLE_SSL = "?useSSL=false";
		static ArrayList<substations> Sub;
		static ArrayList<measurement> Meas;
		static ArrayList<measurement> MeasKNN;
		
		public static void main (String[] agrs) throws ClassNotFoundException, SQLException  {
			
			String User = JOptionPane.showInputDialog("Enter your SQL server username");
			String Pass = JOptionPane.showInputDialog("Enter your SQL server password");
			String name = JOptionPane.showInputDialog("Enter Database name (Default: subtables)");


			Sub = getsubstation(User , Pass , name); //input of the substations table to java 
			Meas = getmeasure(User , Pass , name);	//input of the measurements table to java 
			
			ArrayList<TimeSub> Meas1 = new ArrayList<TimeSub>();
			
			
			for (int i=0; i<200;i++) {
				Meas1.add(new TimeSub(i,Meas));
			}
//			System.out.println(Meas1.size());

			ArrayList<CostFunction> cost = new ArrayList<CostFunction>();
			for(int i=0;i<100;i++) {
			/////////////////////////
		    /// K -Means++ Method /// separate the centroids from each other as much as possible
		    ////////////////////////  used in initialization
			ArrayList<Centroids> centroids = initialization(Meas1);
			double diff1=10,diff2=10,diff3=10,diff4=10;
			Clusters clusters = null;

				while(diff1>1e-3||diff2>1e-3||diff3>1e-3||diff4>1e-3) {
					clusters = distance(Meas1,centroids);
					 ArrayList<Centroids> newcentroids =new_centroids(clusters);
					diff1 = cal_diff(centroids,newcentroids,0);
					diff2 = cal_diff(centroids,newcentroids,1);
					diff3 = cal_diff(centroids,newcentroids,2);
					diff4 = cal_diff(centroids,newcentroids,3);
					centroids = newcentroids;
				}
				cost.add(new CostFunction(clusters,centroids));
				
			}
			
			int minIndex = 0;
			for(int t=0;t<cost.size();t++) {
				if(cost.get(t).cost()<cost.get(minIndex).cost()) {
					minIndex = t;
				}
			}
			
			
			
/////////////////////////			  
			  Double aveV_1 = (cost.get(minIndex).GetCentroids().get(0).CLAR_Cen().get(0)+
					           cost.get(minIndex).GetCentroids().get(0).AMHE_Cen().get(0)+
					           cost.get(minIndex).GetCentroids().get(0).WINL_Cen().get(0)+
					           cost.get(minIndex).GetCentroids().get(0).BOWM_Cen().get(0)+
					           cost.get(minIndex).GetCentroids().get(0).TROY_Cen().get(0)+
					           cost.get(minIndex).GetCentroids().get(0).MAPL_Cen().get(0)+
					           cost.get(minIndex).GetCentroids().get(0).GRAN_Cen().get(0)+
					           cost.get(minIndex).GetCentroids().get(0).WAUT_Cen().get(0)+
					           cost.get(minIndex).GetCentroids().get(0).CROSS_Cen().get(0))/(double)9;
			  
			  Double aveV_2 = (cost.get(minIndex).GetCentroids().get(0).CLAR_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(1).AMHE_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(1).WINL_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(1).BOWM_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(1).TROY_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(1).MAPL_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(1).GRAN_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(1).WAUT_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(1).CROSS_Cen().get(0))/(double)9;
			  
			  Double aveV_3 = (cost.get(minIndex).GetCentroids().get(0).CLAR_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(2).AMHE_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(2).WINL_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(2).BOWM_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(2).TROY_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(2).MAPL_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(2).GRAN_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(2).WAUT_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(2).CROSS_Cen().get(0))/(double)9;
			  
			  Double aveV_4 = (cost.get(minIndex).GetCentroids().get(0).CLAR_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(3).AMHE_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(3).WINL_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(3).BOWM_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(3).TROY_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(3).MAPL_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(3).GRAN_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(3).WAUT_Cen().get(0)+
			           cost.get(minIndex).GetCentroids().get(3).CROSS_Cen().get(0))/(double)9;
			  
			  
			 
			  Sequence CL1 = new Sequence(aveV_1,cost.get(minIndex).Getcluster1(),cost.get(minIndex).GetCentroids().get(0));
			  Sequence CL2 = new Sequence(aveV_2,cost.get(minIndex).Getcluster2(),cost.get(minIndex).GetCentroids().get(1));
			  Sequence CL3 = new Sequence(aveV_3,cost.get(minIndex).Getcluster3(),cost.get(minIndex).GetCentroids().get(2));
			  Sequence CL4 = new Sequence(aveV_4,cost.get(minIndex).Getcluster4(),cost.get(minIndex).GetCentroids().get(3));
			  double[] cenV = new double[] {CL1.Getx(),CL2.Getx(),CL3.Getx(),CL4.Getx()};
			  Arrays.sort(cenV);
			  
              
			  ArrayList<ArrayList<TimeSub>> CLUSTERS = new ArrayList<ArrayList<TimeSub>>();
			  ArrayList<TimeSub> CLUSTER1 = null;
			  CLUSTERS.add(CLUSTER1);
			  ArrayList<TimeSub> CLUSTER2 = null;
			  CLUSTERS.add(CLUSTER2);
			  ArrayList<TimeSub> CLUSTER3 = null;
			  CLUSTERS.add(CLUSTER3);
			  ArrayList<TimeSub> CLUSTER4 = null;
			  CLUSTERS.add(CLUSTER4);
			  
			  Centroids CENTER[] = new Centroids[4];
			  
			  for(int i=0;i<4;i++) {
				 if(cenV[i] == CL1.Getx()) {
					 CLUSTERS.set(i, CL1.Getcluster());
					 CENTER[i] = CL1.Getcentroid();					 
				 }
				 if(cenV[i] == CL2.Getx()) {
					 CLUSTERS.set(i, CL2.Getcluster());
					 CENTER[i] = CL2.Getcentroid();	
				 }
				 if(cenV[i] == CL3.Getx()) {
					 CLUSTERS.set(i, CL3.Getcluster());
					 CENTER[i] = CL3.Getcentroid();	

				 }
				 if(cenV[i] == CL4.Getx()) {
					 CLUSTERS.set(i, CL4.Getcluster());
					 CENTER[i] = CL4.Getcentroid();	
				 }
			  }
			  
			  
	    		  Double drop14_2 = Vol_drop(CENTER[1].CLAR_Cen().get(0),CENTER[1].CLAR_Cen().get(1),
	    				                     CENTER[1].BOWM_Cen().get(0),CENTER[1].BOWM_Cen().get(1));
	    		  Double drop45_2 = Vol_drop(CENTER[1].TROY_Cen().get(0),CENTER[1].TROY_Cen().get(1),
		                                     CENTER[1].BOWM_Cen().get(0),CENTER[1].BOWM_Cen().get(1));
	    		  Double drop49_2 = Vol_drop(CENTER[1].CROSS_Cen().get(0),CENTER[1].CROSS_Cen().get(1),
		                                     CENTER[1].BOWM_Cen().get(0),CENTER[1].BOWM_Cen().get(1));
	    		  Double drop56_2 = Vol_drop(CENTER[1].TROY_Cen().get(0),CENTER[1].TROY_Cen().get(1),
		                                     CENTER[1].MAPL_Cen().get(0),CENTER[1].MAPL_Cen().get(1));
	    		  Double drop36_2 = Vol_drop(CENTER[1].MAPL_Cen().get(0),CENTER[1].MAPL_Cen().get(1),
		                                     CENTER[1].WINL_Cen().get(0),CENTER[1].WINL_Cen().get(1));
	    		  Double drop89_2 = Vol_drop(CENTER[1].CROSS_Cen().get(0),CENTER[1].CROSS_Cen().get(1),
		                                     CENTER[1].WAUT_Cen().get(0),CENTER[1].WAUT_Cen().get(1));
	    		  Double drop67_2 = Vol_drop(CENTER[1].MAPL_Cen().get(0),CENTER[1].MAPL_Cen().get(1),
		                                     CENTER[1].GRAN_Cen().get(0),CENTER[1].GRAN_Cen().get(1));
	    		  Double drop28_2 = Vol_drop(CENTER[1].AMHE_Cen().get(0),CENTER[1].AMHE_Cen().get(1),
		                                     CENTER[1].WAUT_Cen().get(0),CENTER[1].WAUT_Cen().get(1));
	    		  Double drop78_2 = Vol_drop(CENTER[1].WAUT_Cen().get(0),CENTER[1].WAUT_Cen().get(1),
		                                     CENTER[1].GRAN_Cen().get(0),CENTER[1].GRAN_Cen().get(1));
	    		  
	    		  Double drop14_3 = Vol_drop(CENTER[2].CLAR_Cen().get(0),CENTER[2].CLAR_Cen().get(1),
		                                     CENTER[2].BOWM_Cen().get(0),CENTER[2].BOWM_Cen().get(1));
                  Double drop45_3 = Vol_drop(CENTER[2].TROY_Cen().get(0),CENTER[2].TROY_Cen().get(1),
                                             CENTER[2].BOWM_Cen().get(0),CENTER[2].BOWM_Cen().get(1));
                  Double drop49_3 = Vol_drop(CENTER[2].CROSS_Cen().get(0),CENTER[2].CROSS_Cen().get(1),
                                             CENTER[2].BOWM_Cen().get(0),CENTER[2].BOWM_Cen().get(1));
                  Double drop56_3 = Vol_drop(CENTER[2].TROY_Cen().get(0),CENTER[2].TROY_Cen().get(1),
                                             CENTER[2].MAPL_Cen().get(0),CENTER[2].MAPL_Cen().get(1));
                  Double drop36_3 = Vol_drop(CENTER[2].MAPL_Cen().get(0),CENTER[2].MAPL_Cen().get(1),
                                             CENTER[2].WINL_Cen().get(0),CENTER[2].WINL_Cen().get(1));
                  Double drop89_3 = Vol_drop(CENTER[2].CROSS_Cen().get(0),CENTER[2].CROSS_Cen().get(1),
                                             CENTER[2].WAUT_Cen().get(0),CENTER[2].WAUT_Cen().get(1));
                  Double drop67_3 = Vol_drop(CENTER[2].MAPL_Cen().get(0),CENTER[2].MAPL_Cen().get(1),
                                             CENTER[2].GRAN_Cen().get(0),CENTER[2].GRAN_Cen().get(1));
                  Double drop28_3 = Vol_drop(CENTER[2].AMHE_Cen().get(0),CENTER[2].AMHE_Cen().get(1),
                                             CENTER[2].WAUT_Cen().get(0),CENTER[2].WAUT_Cen().get(1));
                  Double drop78_3 = Vol_drop(CENTER[2].WAUT_Cen().get(0),CENTER[2].WAUT_Cen().get(1),
                                             CENTER[2].GRAN_Cen().get(0),CENTER[2].GRAN_Cen().get(1));
                  
                  
              if((drop14_2>0.4||drop45_2>0.4||drop49_2>0.4||drop56_2>0.4||drop36_2>0.4||drop89_2>0.4||drop67_2>0.4||drop28_2>0.4||drop78_2>0.4)
            	  &&(drop14_3<1e-3||drop36_3<1e-3||drop28_3<1e-3))
              {
            	  ArrayList<TimeSub> temp = CLUSTERS.get(1);
            	  CLUSTERS.set(1, CLUSTERS.get(2));
            	  CLUSTERS.set(2, temp);           	  
              }
	    		  
			    System.out.println("the size of the first cluster is "+CLUSTERS.get(0).size());
				System.out.println("the size of the second cluster is "+CLUSTERS.get(1).size());
				System.out.println("the size of the third cluster is "+CLUSTERS.get(2).size());
				System.out.println("the size of the fourth cluster is "+CLUSTERS.get(3).size());
			
			
			ArrayList<TimeSub> Cluster1 = new ArrayList<TimeSub>();
			
			
			
			/////////////////KNN
			
			ArrayList<TimeSub> Cluster1_KNN = CLUSTERS.get(0);
			ArrayList<TimeSub> Cluster2_KNN = CLUSTERS.get(1);
			ArrayList<TimeSub> Cluster3_KNN = CLUSTERS.get(2);
			ArrayList<TimeSub> Cluster4_KNN = CLUSTERS.get(3);
					
			
			System.out.println("KNN starts!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			MeasKNN = getanValues(User , Pass , name);
			int knn = 30;
//			System.out.println(MeasKNN.size());
			ArrayList<TimeSub> Meas2 = new ArrayList<TimeSub>();
			for (int i=0; i<20;i++) {
				Meas2.add(new TimeSub(i,MeasKNN));
			}
			System.out.println(Meas2.size());
			
			ArrayList<TimeSub> testType1 = new ArrayList<TimeSub>();
			ArrayList<TimeSub> testType2 = new ArrayList<TimeSub>();
			ArrayList<TimeSub> testType3 = new ArrayList<TimeSub>();
			ArrayList<TimeSub> testType4 = new ArrayList<TimeSub>();
			ArrayList<Dis_Time> res;
			for (int i=0;i<Meas2.size();i++) {
				ArrayList<Dis_Time> dis_total = new ArrayList<Dis_Time>();
				for(int j=0;j<Meas1.size();j++) {
					dis_total.add(new Dis_Time(Meas1.get(j).Gettime_Posi(), Meas1.get(j),Meas2.get(i)));
				}
				res = sort_dis(dis_total, knn);
				int Num_C1=0,Num_C2=0,Num_C3=0,Num_C4=0;
				for(int t=0;t<res.size();t++) {
					Dis_Time W1 = res.get(t);
					for(int m=0;m<Cluster1_KNN.size();m++) {
						if(W1.Gettime()==Cluster1_KNN.get(m).Gettime_Posi()) {
							Num_C1++;
							break;
						}
					}
					for(int m=0;m<Cluster2_KNN.size();m++) {
						if(W1.Gettime()==Cluster2_KNN.get(m).Gettime_Posi()) {
							Num_C2++;
							break;
						}
					}
					for(int m=0;m<Cluster3_KNN.size();m++) {
						if(W1.Gettime()==Cluster3_KNN.get(m).Gettime_Posi()) {
							Num_C3++;
							break;
						}
					}
					for(int m=0;m<Cluster4_KNN.size();m++) {
						if(W1.Gettime()==Cluster4_KNN.get(m).Gettime_Posi()) {
							Num_C4++;
							break;
						}
					}
				}
				//System.out.printf("Num_C1:"+Num_C1+"\tNum_C2:"+Num_C2+"\tNum_C3:"+Num_C3+"\tNum_C4:"+Num_C4+"\n");
				int[] all_num ={Num_C1,Num_C2,Num_C3,Num_C4};
				int maxIndex = 0;
				//find the most common label
				for(int t=0;t<4;t++) {
					if(all_num[t]>all_num[maxIndex]) {
						maxIndex = t;
					}
				}
			//System.out.printf("the maximum index is "+maxIndex+"\n");
				switch(maxIndex) {
				case 0:
					testType1.add(Meas2.get(i));
					break;
				case 1:
					testType2.add(Meas2.get(i));
					break;
				case 2:
					testType3.add(Meas2.get(i));
					break;
				case 3:
					testType4.add(Meas2.get(i));
					break;
				}
			}
		

			
////////////////////////////////////////////////  GUI PART ////////////////////////////////////////////////////////////			

		ArrayList<Double[]> GUIkMEANS1 = new ArrayList<Double[]>();
		ArrayList<Double[]> GUIkMEANS2= new ArrayList<Double[]>();
		ArrayList<Double[]> GUIkMEANS3= new ArrayList<Double[]>();
		ArrayList<Double[]> GUIkMEANS4= new ArrayList<Double[]>();
		
		
		for (int i = 0 ; i < CLUSTERS.get(0).size(); i++){
		
			Double[]GUIkMEANS1list = new Double[2];
			GUIkMEANS1list[0]=CLUSTERS.get(0).get(i).Gettime_Posi();
			GUIkMEANS1list[1] = (double)1;
			GUIkMEANS1.add(GUIkMEANS1list);	
		}
		
		for (int i = 0 ; i < CLUSTERS.get(1).size(); i++){
			
			Double[]GUIkMEANS2list = new Double[2];
			GUIkMEANS2list[0]=CLUSTERS.get(1).get(i).Gettime_Posi();
			GUIkMEANS2list[1] = (double)2;
			GUIkMEANS2.add(GUIkMEANS2list);	
		}
		
		for (int i = 0 ; i < CLUSTERS.get(2).size(); i++){
			
			Double[]GUIkMEANS3list = new Double[2];
			GUIkMEANS3list[0]=CLUSTERS.get(2).get(i).Gettime_Posi();
			GUIkMEANS3list[1] = (double)3;
			GUIkMEANS3.add(GUIkMEANS3list);	
		}
		
		for (int i = 0 ; i < CLUSTERS.get(3).size(); i++){
			
			Double[]GUIkMEANS4list = new Double[2];
			GUIkMEANS4list[0]=CLUSTERS.get(3).get(i).Gettime_Posi();
			GUIkMEANS4list[1] = (double)4;
			GUIkMEANS4.add(GUIkMEANS4list);	
		}


		String[][]GUIkMEANS1Table = new String[GUIkMEANS1.size()][2];       
		String[][]GUIkMEANS2Table = new String[GUIkMEANS2.size()][2];
		String[][]GUIkMEANS3Table = new String[GUIkMEANS3.size()][2];
		String[][]GUIkMEANS4Table = new String[GUIkMEANS4.size()][2];



		for (int i = 0 ; i < GUIkMEANS1.size() ; i++){
			GUIkMEANS1Table[i][0]= Double.toString(GUIkMEANS1.get(i)[0]+1);
			GUIkMEANS1Table[i][1]= Double.toString(GUIkMEANS1.get(i)[1]);
		}
		

		for (int i = 0 ; i < GUIkMEANS2.size() ; i++){
			GUIkMEANS2Table[i][0]=Double.toString(GUIkMEANS2.get(i)[0]+1);
			GUIkMEANS2Table[i][1]=Double.toString(GUIkMEANS2.get(i)[1]);
		}

		for (int i = 0 ; i < GUIkMEANS3.size() ; i++){
			GUIkMEANS3Table[i][0]=Double.toString(GUIkMEANS3.get(i)[0]+1);
			GUIkMEANS3Table[i][1]=Double.toString(GUIkMEANS3.get(i)[1]);
		}

		for (int i = 0 ; i < GUIkMEANS4.size() ; i++){
			GUIkMEANS4Table[i][0]=Double.toString(GUIkMEANS4.get(i)[0]+1);
			GUIkMEANS4Table[i][1]=Double.toString(GUIkMEANS4.get(i)[1]);
		}
		
		
				
		ArrayList<Double[]> GUIkNN1 = new ArrayList<Double[]>();
		ArrayList<Double[]> GUIkNN2= new ArrayList<Double[]>();
		ArrayList<Double[]> GUIkNN3= new ArrayList<Double[]>();
		ArrayList<Double[]> GUIkNN4= new ArrayList<Double[]>();
		
		
		for (int i = 0; i < testType1.size();  i++ ) {
			Double[]GUIkNN1list = new Double[2];
			GUIkNN1list[0] = testType1.get(i).Gettime_Posi();
			GUIkNN1list[1] = (double)1;
			GUIkNN1.add(GUIkNN1list);
		}
		
		for (int i = 0; i < testType2.size();  i++ ) {
			Double[]GUIkNN2list = new Double[2];
			GUIkNN2list[0] = testType2.get(i).Gettime_Posi();
			GUIkNN2list[1] = (double)2;
			GUIkNN2.add(GUIkNN2list);
		}
		
		for (int i = 0; i < testType3.size();  i++ ) {
			Double[]GUIkNN3list = new Double[2];
			GUIkNN3list[0] = testType3.get(i).Gettime_Posi();
			GUIkNN3list[1] = (double)3;
			GUIkNN3.add(GUIkNN3list);
		}
		
		for (int i = 0; i < testType4.size();  i++ ) {
			Double[]GUIkNN4list = new Double[2];
			GUIkNN4list[0] = testType4.get(i).Gettime_Posi();
			GUIkNN4list[1] = (double)4;
			GUIkNN4.add(GUIkNN4list);
		}
		



		String[][]GUIkNN1Table = new String[GUIkNN1.size()][2];      
		String[][]GUIkNN2Table = new String[GUIkNN2.size()][2];
		String[][]GUIkNN3Table = new String[GUIkNN3.size()][2];
		String[][]GUIkNN4Table = new String[GUIkNN4.size()][2];



		for (int i = 0 ; i < GUIkNN1.size() ; i++){
			GUIkNN1Table[i][0]= Double.toString(GUIkNN1.get(i)[0]+1);
			GUIkNN1Table[i][1]= Double.toString(GUIkNN1.get(i)[1]);
		}
		

		for (int i = 0 ; i < GUIkNN2.size() ; i++){
			GUIkNN2Table[i][0]=Double.toString(GUIkNN2.get(i)[0]+1);
			GUIkNN2Table[i][1]=Double.toString(GUIkNN2.get(i)[1]);
		}

		for (int i = 0 ; i < GUIkNN3.size() ; i++){
			GUIkNN3Table[i][0]=Double.toString(GUIkNN3.get(i)[0]+1);
			GUIkNN3Table[i][1]=Double.toString(GUIkNN3.get(i)[1]);
		}

		for (int i = 0 ; i < GUIkNN4.size() ; i++){
			GUIkNN4Table[i][0]=Double.toString(GUIkNN4.get(i)[0]+1);
			GUIkNN4Table[i][1]=Double.toString(GUIkNN4.get(i)[1]);
		}
		
		
		
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUI frame = new GUI(GUIkMEANS1Table , GUIkMEANS2Table , GUIkMEANS3Table , GUIkMEANS4Table , GUIkNN1Table , GUIkNN2Table , GUIkNN3Table , GUIkNN4Table);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						KmeansGUITable frame = new KmeansGUITable(GUIkMEANS1Table , GUIkMEANS2Table , GUIkMEANS3Table , GUIkMEANS4Table);
						frame.setVisible(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		
		
		 public static ArrayList<Dis_Time> sort_dis(ArrayList<Dis_Time> arr,int knn) {
			 	quickSort(arr, 0, arr.size() - 1);
		        ArrayList<Dis_Time> res = new ArrayList<Dis_Time>();
		        for (int i = 0; i < knn; i++) {
		        	res.add(arr.get(i));
		        }
		        return res;
		    }

		 private static void quickSort(ArrayList<Dis_Time> arr, int start, int end) {
		        if (start >= end) return;
		        int index = start, i = start, j = end + 1;
		        while (true) {
		        	 while (arr.get(++i).GetKNN_dis() <= arr.get(index).GetKNN_dis()) if (i == end) break;
			         while (arr.get(--j).GetKNN_dis() >= arr.get(index).GetKNN_dis()) if (j == index) break;
		            if (j <= i) break;
		            Dis_Time temp = arr.get(i);
		            arr.set(i, arr.get(j));
		            arr.set(j, temp);
		        }
		        Dis_Time temp = arr.get(j);
		        arr.set(j, arr.get(index));
		        arr.set(index, temp);
		        index = j;
		        quickSort(arr, start, index - 1);
		        quickSort(arr, index + 1, end);
		    }	
		
		
		
		
		public static ArrayList<Centroids> new_centroids(Clusters clusters) {
			double V_CLAR=0,Angle_CLAR=0,V_AMHE=0,Angle_AMHE=0;
			double V_WINL=0,Angle_WINL=0,V_BOWM=0,Angle_BOWM=0;
			double V_TROY=0,Angle_TROY=0,V_MAPL=0,Angle_MAPL=0;
			double V_GRAN=0,Angle_GRAN=0,V_WAUT=0,Angle_WAUT=0;
			double V_CROSS=0,Angle_CROSS=0;
			
			ArrayList<TimeSub> cluster1 = clusters.Getcluster1();
			ArrayList<TimeSub> cluster2 = clusters.Getcluster2();
			ArrayList<TimeSub> cluster3 = clusters.Getcluster3();
			ArrayList<TimeSub> cluster4 = clusters.Getcluster4();
			
			ArrayList<Centroids> centroids = new ArrayList<Centroids>();
			
			int Index1 = cluster1.size();
			int Index2 = cluster2.size();
			int Index3 = cluster3.size();
			int Index4 = cluster4.size();
			
			for(int i=0;i<Index1;i++) {
				V_CLAR += cluster1.get(i).CLAR().get(1);
				Angle_CLAR += cluster1.get(i).CLAR().get(2);
				
				V_AMHE += cluster1.get(i).AMHE().get(1);
				Angle_AMHE += cluster1.get(i).AMHE().get(2);
				
				V_WINL += cluster1.get(i).WINL().get(1);
				Angle_WINL += cluster1.get(i).WINL().get(2);
				
				V_BOWM += cluster1.get(i).BOWM().get(1);
				Angle_BOWM += cluster1.get(i).BOWM().get(2);
				
				V_TROY += cluster1.get(i).TROY().get(1);
				Angle_TROY += cluster1.get(i).TROY().get(2);
				
				V_MAPL += cluster1.get(i).MAPL().get(1);
				Angle_MAPL += cluster1.get(i).MAPL().get(2);
				
				V_GRAN += cluster1.get(i).GRAN().get(1);
				Angle_GRAN += cluster1.get(i).GRAN().get(2);
				
				V_WAUT += cluster1.get(i).WAUT().get(1);
				Angle_WAUT += cluster1.get(i).WAUT().get(2);
				
				V_CROSS += cluster1.get(i).CROSS().get(1);
				Angle_CROSS += cluster1.get(i).CROSS().get(2);
			}
			
			Centroids C0 = new Centroids(V_CLAR/Index1,Angle_CLAR/Index1,V_AMHE/Index1,Angle_AMHE/Index1,V_WINL/Index1,Angle_WINL/Index1,
										 V_BOWM/Index1,Angle_BOWM/Index1,V_TROY/Index1,Angle_TROY/Index1,V_MAPL/Index1,Angle_MAPL/Index1,
										 V_GRAN/Index1,Angle_GRAN/Index1,V_WAUT/Index1,Angle_WAUT/Index1,V_CROSS/Index1,Angle_CROSS/Index1);
			centroids.add(C0);
			
		    V_CLAR=0;Angle_CLAR=0;V_AMHE=0;Angle_AMHE=0;
			V_WINL=0;Angle_WINL=0;V_BOWM=0;Angle_BOWM=0;
		    V_TROY=0;Angle_TROY=0;V_MAPL=0;Angle_MAPL=0;
			V_GRAN=0;Angle_GRAN=0;V_WAUT=0;Angle_WAUT=0;
			V_CROSS=0;Angle_CROSS=0;
			
			for(int i=0;i<Index2;i++) {
				V_CLAR += cluster2.get(i).CLAR().get(1);
				Angle_CLAR += cluster2.get(i).CLAR().get(2);
				
				V_AMHE += cluster2.get(i).AMHE().get(1);
				Angle_AMHE += cluster2.get(i).AMHE().get(2);
				
				V_WINL += cluster2.get(i).WINL().get(1);
				Angle_WINL += cluster2.get(i).WINL().get(2);
				
				V_BOWM += cluster2.get(i).BOWM().get(1);
				Angle_BOWM += cluster2.get(i).BOWM().get(2);
				
				V_TROY += cluster2.get(i).TROY().get(1);
				Angle_TROY += cluster2.get(i).TROY().get(2);
				
				V_MAPL += cluster2.get(i).MAPL().get(1);
				Angle_MAPL += cluster2.get(i).MAPL().get(2);
				
				V_GRAN += cluster2.get(i).GRAN().get(1);
				Angle_GRAN += cluster2.get(i).GRAN().get(2);
				
				V_WAUT += cluster2.get(i).WAUT().get(1);
				Angle_WAUT += cluster2.get(i).WAUT().get(2);
				
				V_CROSS += cluster2.get(i).CROSS().get(1);
				Angle_CROSS += cluster2.get(i).CROSS().get(2);
			}
			Centroids C1 = new Centroids(V_CLAR/Index2,Angle_CLAR/Index2,V_AMHE/Index2,Angle_AMHE/Index2,V_WINL/Index2,Angle_WINL/Index2,
										 V_BOWM/Index2,Angle_BOWM/Index2,V_TROY/Index2,Angle_TROY/Index2,V_MAPL/Index2,Angle_MAPL/Index2,
										 V_GRAN/Index2,Angle_GRAN/Index2,V_WAUT/Index2,Angle_WAUT/Index2,V_CROSS/Index2,Angle_CROSS/Index2);
			centroids.add(C1);
			
			V_CLAR=0;Angle_CLAR=0;V_AMHE=0;Angle_AMHE=0;
			V_WINL=0;Angle_WINL=0;V_BOWM=0;Angle_BOWM=0;
			V_TROY=0;Angle_TROY=0;V_MAPL=0;Angle_MAPL=0;
			V_GRAN=0;Angle_GRAN=0;V_WAUT=0;Angle_WAUT=0;
			V_CROSS=0;Angle_CROSS=0;

			for(int i=0;i<Index3;i++) {
				V_CLAR += cluster3.get(i).CLAR().get(1);
				Angle_CLAR += cluster3.get(i).CLAR().get(2);
				
				V_AMHE += cluster3.get(i).AMHE().get(1);
				Angle_AMHE += cluster3.get(i).AMHE().get(2);
				
				V_WINL += cluster3.get(i).WINL().get(1);
				Angle_WINL += cluster3.get(i).WINL().get(2);
				
				V_BOWM += cluster3.get(i).BOWM().get(1);
				Angle_BOWM += cluster3.get(i).BOWM().get(2);
				
				V_TROY += cluster3.get(i).TROY().get(1);
				Angle_TROY += cluster3.get(i).TROY().get(2);
				
				V_MAPL += cluster3.get(i).MAPL().get(1);
				Angle_MAPL += cluster3.get(i).MAPL().get(2);
				
				V_GRAN += cluster3.get(i).GRAN().get(1);
				Angle_GRAN += cluster3.get(i).GRAN().get(2);
				
				V_WAUT += cluster3.get(i).WAUT().get(1);
				Angle_WAUT += cluster3.get(i).WAUT().get(2);
				
				V_CROSS += cluster3.get(i).CROSS().get(1);
				Angle_CROSS += cluster3.get(i).CROSS().get(2);
			}
			Centroids C2 = new Centroids(V_CLAR/Index3,Angle_CLAR/Index3,V_AMHE/Index3,Angle_AMHE/Index3,V_WINL/Index3,Angle_WINL/Index3,
					 					 V_BOWM/Index3,Angle_BOWM/Index3,V_TROY/Index3,Angle_TROY/Index3,V_MAPL/Index3,Angle_MAPL/Index3,
					 					 V_GRAN/Index3,Angle_GRAN/Index3,V_WAUT/Index3,Angle_WAUT/Index3,V_CROSS/Index3,Angle_CROSS/Index3);
			centroids.add(C2);
			
			V_CLAR=0;Angle_CLAR=0;V_AMHE=0;Angle_AMHE=0;
			V_WINL=0;Angle_WINL=0;V_BOWM=0;Angle_BOWM=0;
			V_TROY=0;Angle_TROY=0;V_MAPL=0;Angle_MAPL=0;
			V_GRAN=0;Angle_GRAN=0;V_WAUT=0;Angle_WAUT=0;
			V_CROSS=0;Angle_CROSS=0;

			for(int i=0;i<Index4;i++) {
				V_CLAR += cluster4.get(i).CLAR().get(1);
				Angle_CLAR += cluster4.get(i).CLAR().get(2);
				
				V_AMHE += cluster4.get(i).AMHE().get(1);
				Angle_AMHE += cluster4.get(i).AMHE().get(2);
				
				V_WINL += cluster4.get(i).WINL().get(1);
				Angle_WINL += cluster4.get(i).WINL().get(2);
				
				V_BOWM += cluster4.get(i).BOWM().get(1);
				Angle_BOWM += cluster4.get(i).BOWM().get(2);
				
				V_TROY += cluster4.get(i).TROY().get(1);
				Angle_TROY += cluster4.get(i).TROY().get(2);
				
				V_MAPL += cluster4.get(i).MAPL().get(1);
				Angle_MAPL += cluster4.get(i).MAPL().get(2);
				
				V_GRAN += cluster4.get(i).GRAN().get(1);
				Angle_GRAN += cluster4.get(i).GRAN().get(2);
				
				V_WAUT += cluster4.get(i).WAUT().get(1);
				Angle_WAUT += cluster4.get(i).WAUT().get(2);
				
				V_CROSS += cluster4.get(i).CROSS().get(1);
				Angle_CROSS += cluster4.get(i).CROSS().get(2);
			}
			Centroids C3 = new Centroids(V_CLAR/Index4,Angle_CLAR/Index4,V_AMHE/Index4,Angle_AMHE/Index4,V_WINL/Index4,Angle_WINL/Index4,
					 					 V_BOWM/Index4,Angle_BOWM/Index4,V_TROY/Index4,Angle_TROY/Index4,V_MAPL/Index4,Angle_MAPL/Index4,
					 					 V_GRAN/Index4,Angle_GRAN/Index4,V_WAUT/Index4,Angle_WAUT/Index4,V_CROSS/Index4,Angle_CROSS/Index4);
			centroids.add(C3);
//			System.out.println("the size of the centroids"+centroids.size()+"\n");
			return centroids;
		}
		
		
		public static Clusters distance(ArrayList<TimeSub> Meas1, ArrayList<Centroids> centroids) {
			ArrayList<TimeSub> cluster1 = new ArrayList<TimeSub>();
			ArrayList<TimeSub> cluster2 = new ArrayList<TimeSub>();
			ArrayList<TimeSub> cluster3 = new ArrayList<TimeSub>();
			ArrayList<TimeSub> cluster4 = new ArrayList<TimeSub>();
			
			double dis1,dis2,dis3,dis4;
			int Index1=0,Index2=0,Index3=0,Index4=0;
			for(int i=0;i<Meas1.size();i++) {
					dis1 = Math.sqrt(cal_dis(centroids.get(0),Meas1.get(i)));
					dis2 = Math.sqrt(cal_dis(centroids.get(1),Meas1.get(i)));
					dis3 = Math.sqrt(cal_dis(centroids.get(2),Meas1.get(i)));
					dis4 = Math.sqrt(cal_dis(centroids.get(3),Meas1.get(i)));
			
//					System.out.printf("%f \t %f \t %f \t %f \n",dis1,dis2,dis3,dis4);
					//find the minimum distance;
					double[] all_dis ={dis1,dis2,dis3,dis4};
					int minIndex = 0;
					for(int t=0;t<4;t++) {
						if(all_dis[t]<all_dis[minIndex]) {
							minIndex = t;
						}
					}
//					System.out.println("the minumin distance is "+all_dis[minIndex]+"\n");
//					System.out.println("its index is "+minIndex+"\n");
					
					if(minIndex==0) {
						cluster1.add(new TimeSub(i,Meas));
						Index1++;
					}
					else if(minIndex==1) {
						cluster2.add(new TimeSub(i,Meas));
						Index2++;
					}
					else if(minIndex==2) {
						cluster3.add(new TimeSub(i,Meas));
						Index3++;
					}
					else{
						cluster4.add(new TimeSub(i,Meas));
						Index4++;
					}
					
			}

			Clusters clusters = new Clusters(cluster1,cluster2,cluster3,cluster4);
			return clusters;
			
		}
		public static double cal_dis(Centroids centroids_i,TimeSub Meas1_i){
		double DIS = Math.pow(Meas1_i.CLAR().get(1)-centroids_i.CLAR_Cen().get(0), 2)+Math.pow(Meas1_i.CLAR().get(2)-centroids_i.CLAR_Cen().get(1), 2)
		   			+Math.pow(Meas1_i.AMHE().get(1)-centroids_i.AMHE_Cen().get(0), 2)+Math.pow(Meas1_i.AMHE().get(2)-centroids_i.AMHE_Cen().get(1), 2)
		   			+Math.pow(Meas1_i.WINL().get(1)-centroids_i.WINL_Cen().get(0), 2)+Math.pow(Meas1_i.WINL().get(2)-centroids_i.WINL_Cen().get(1), 2)
		   			+Math.pow(Meas1_i.BOWM().get(1)-centroids_i.BOWM_Cen().get(0), 2)+Math.pow(Meas1_i.BOWM().get(2)-centroids_i.BOWM_Cen().get(1), 2)
		   			+Math.pow(Meas1_i.TROY().get(1)-centroids_i.TROY_Cen().get(0), 2)+Math.pow(Meas1_i.TROY().get(2)-centroids_i.TROY_Cen().get(1), 2)
		   			+Math.pow(Meas1_i.MAPL().get(1)-centroids_i.MAPL_Cen().get(0), 2)+Math.pow(Meas1_i.MAPL().get(2)-centroids_i.MAPL_Cen().get(1), 2)
		   			+Math.pow(Meas1_i.GRAN().get(1)-centroids_i.GRAN_Cen().get(0), 2)+Math.pow(Meas1_i.GRAN().get(2)-centroids_i.GRAN_Cen().get(1), 2)
		   			+Math.pow(Meas1_i.WAUT().get(1)-centroids_i.WAUT_Cen().get(0), 2)+Math.pow(Meas1_i.WAUT().get(2)-centroids_i.WAUT_Cen().get(1), 2)
		   			+Math.pow(Meas1_i.CROSS().get(1)-centroids_i.CROSS_Cen().get(0), 2)+Math.pow(Meas1_i.CROSS().get(2)-centroids_i.CROSS_Cen().get(1), 2);
		return DIS;
		}
		
		
		public static  ArrayList<Centroids> initialization(ArrayList<TimeSub> Meas1){
			double d_1 = Math.random();
			ArrayList<Double> dis_1 = new ArrayList<Double>() ;
			ArrayList<Double> dis_2 = new ArrayList<Double>() ;
			ArrayList<Double> dis_3 = new ArrayList<Double>() ;
			ArrayList<Double> Proba1 = new ArrayList<Double>();
			ArrayList<Double> Proba2 = new ArrayList<Double>();
			ArrayList<Double> Proba3 = new ArrayList<Double>();
			ArrayList<Centroids> centroids = new ArrayList<Centroids>();
			int d1 = (int)(d_1*200);
			TimeSub p1 = new TimeSub(d1,Meas);
			centroids.add(new Centroids(p1.CLAR().get(1),p1.CLAR().get(2),p1.AMHE().get(1),p1.AMHE().get(2),p1.WINL().get(1),p1.WINL().get(2),
										 p1.BOWM().get(1),p1.BOWM().get(2),p1.TROY().get(1),p1.TROY().get(2),p1.MAPL().get(1),p1.MAPL().get(2),
										 p1.GRAN().get(1),p1.GRAN().get(2),p1.WAUT().get(1),p1.WAUT().get(2),p1.CROSS().get(1),p1.CROSS().get(2)));
			double sum = 0;
			for (int i=0;i<Meas1.size();i++) {
				double x = cal_dis(centroids.get(0),Meas1.get(i));
				dis_1.add(new Double(x));
				sum = sum + x;
			}
			
			//calculate the probabilities for the next centroid(2)
			for(int i=0;i<Meas1.size();i++) {
				Proba1.add(new Double(dis_1.get(i)/sum));
			}
			double d_2 = Math.random();
			double sumP = 0;
			int IndexP=0;
			for(int i=0;i<Meas1.size();i++) {
				if(d_2>=sumP) {
					sumP = sumP + Proba1.get(i);
				}
				else {
					IndexP = i-1;
					break;
				}
			}
			double d2 = IndexP;
			TimeSub p2 = new TimeSub(IndexP,Meas);
			centroids.add(new Centroids(p2.CLAR().get(1),p2.CLAR().get(2),p2.AMHE().get(1),p2.AMHE().get(2),p2.WINL().get(1),p2.WINL().get(2),
					 p2.BOWM().get(1),p2.BOWM().get(2),p2.TROY().get(1),p2.TROY().get(2),p2.MAPL().get(1),p2.MAPL().get(2),
					 p2.GRAN().get(1),p2.GRAN().get(2),p2.WAUT().get(1),p2.WAUT().get(2),p2.CROSS().get(1),p2.CROSS().get(2)));
			
			
			sum = 0;
			for (int i=0;i<Meas1.size();i++) {
				double x1 = cal_dis(centroids.get(0),Meas1.get(i));
				double x2 = cal_dis(centroids.get(1),Meas1.get(i));
				dis_2.add(new Double(Math.min(x1, x2)));
				sum = sum + Math.min(x1, x2);
			}
			//calculate the probabilities for the next centroid(3)
			for(int i=0;i<Meas1.size();i++) {
				Proba2.add(new Double(dis_2.get(i)/sum));
			}
			double d_3 = Math.random();
			sumP = 0;
			IndexP=0;
			for(int i=0;i<Meas1.size();i++) {
				if(d_3>=sumP) {
					sumP = sumP + Proba2.get(i);
				}
				else {
					IndexP = i-1;
					break;
				}
			}
			double d3 = IndexP;
			TimeSub p3 = new TimeSub(IndexP,Meas);
			centroids.add(new Centroids(p3.CLAR().get(1),p3.CLAR().get(2),p3.AMHE().get(1),p3.AMHE().get(2),p3.WINL().get(1),p3.WINL().get(2),
					 p3.BOWM().get(1),p3.BOWM().get(2),p3.TROY().get(1),p3.TROY().get(2),p3.MAPL().get(1),p3.MAPL().get(2),
					 p3.GRAN().get(1),p3.GRAN().get(2),p3.WAUT().get(1),p3.WAUT().get(2),p3.CROSS().get(1),p3.CROSS().get(2)));

			
			sum = 0;
			for (int i=0;i<Meas1.size();i++) {
				double x1 = cal_dis(centroids.get(0),Meas1.get(i));
				double x2 = cal_dis(centroids.get(1),Meas1.get(i));
				double x3 = cal_dis(centroids.get(2),Meas1.get(i));
				dis_3.add(new Double(Math.min(Math.min(x1, x2), x3)));
				sum = sum + Math.min(Math.min(x1, x2), x3);
			}
			//calculate the probabilities for the next centroid(4)
			for(int i=0;i<Meas1.size();i++) {
				Proba3.add(new Double(dis_3.get(i)/sum));
			}
			double d_4 = Math.random();
			sumP = 0;
			IndexP=0;
			for(int i=0;i<Meas1.size();i++) {
				if(d_4>=sumP) {
					sumP = sumP + Proba3.get(i);
				}
				else {
					IndexP = i-1;
					break;
				}
			}
			double d4 = IndexP;
			TimeSub p4 = new TimeSub(IndexP,Meas);
			centroids.add(new Centroids(p4.CLAR().get(1),p4.CLAR().get(2),p4.AMHE().get(1),p4.AMHE().get(2),p4.WINL().get(1),p4.WINL().get(2),
										p4.BOWM().get(1),p4.BOWM().get(2),p4.TROY().get(1),p4.TROY().get(2),p4.MAPL().get(1),p4.MAPL().get(2),
									    p4.GRAN().get(1),p4.GRAN().get(2),p4.WAUT().get(1),p4.WAUT().get(2),p4.CROSS().get(1),p4.CROSS().get(2)));
		
//			System.out.printf("d1:"+d1+"\td2:"+d2+"\td3:"+d3+"\td4:"+d4+"\n");		
			return centroids;
		}
		
		public static double cal_diff(ArrayList<Centroids> old_centroids,ArrayList<Centroids> new_centroids,int p) {
			double diff;
			diff = Math.sqrt(Math.pow(new_centroids.get(p).CLAR_Cen().get(0)-old_centroids.get(p).CLAR_Cen().get(0), 2)+Math.pow(new_centroids.get(p).CLAR_Cen().get(1)-old_centroids.get(p).CLAR_Cen().get(1), 2)
			 				+Math.pow(new_centroids.get(p).AMHE_Cen().get(0)-old_centroids.get(p).AMHE_Cen().get(0), 2)+Math.pow(new_centroids.get(p).AMHE_Cen().get(1)-old_centroids.get(p).AMHE_Cen().get(1), 2)
			 				+Math.pow(new_centroids.get(p).WINL_Cen().get(0)-old_centroids.get(p).WINL_Cen().get(0), 2)+Math.pow(new_centroids.get(p).WINL_Cen().get(1)-old_centroids.get(p).WINL_Cen().get(1), 2)
			 				+Math.pow(new_centroids.get(p).BOWM_Cen().get(0)-old_centroids.get(p).BOWM_Cen().get(0), 2)+Math.pow(new_centroids.get(p).BOWM_Cen().get(1)-old_centroids.get(p).BOWM_Cen().get(1), 2)
			 				+Math.pow(new_centroids.get(p).TROY_Cen().get(0)-old_centroids.get(p).TROY_Cen().get(0), 2)+Math.pow(new_centroids.get(p).TROY_Cen().get(1)-old_centroids.get(p).TROY_Cen().get(1), 2)
			 				+Math.pow(new_centroids.get(p).MAPL_Cen().get(0)-old_centroids.get(p).MAPL_Cen().get(0), 2)+Math.pow(new_centroids.get(p).MAPL_Cen().get(1)-old_centroids.get(p).MAPL_Cen().get(1), 2)
			 				+Math.pow(new_centroids.get(p).GRAN_Cen().get(0)-old_centroids.get(p).GRAN_Cen().get(0), 2)+Math.pow(new_centroids.get(p).GRAN_Cen().get(1)-old_centroids.get(p).GRAN_Cen().get(1), 2)
			 				+Math.pow(new_centroids.get(p).WAUT_Cen().get(0)-old_centroids.get(p).WAUT_Cen().get(0), 2)+Math.pow(new_centroids.get(p).WAUT_Cen().get(1)-old_centroids.get(p).WAUT_Cen().get(1), 2)
			 				+Math.pow(new_centroids.get(p).CROSS_Cen().get(0)-old_centroids.get(p).CROSS_Cen().get(0), 2)+Math.pow(new_centroids.get(p).CROSS_Cen().get(1)-old_centroids.get(p).CROSS_Cen().get(1), 2));
			return diff;
		}
		public static ArrayList<substations> getsubstation(String USER , String PASS , String tname) throws ClassNotFoundException, SQLException { 
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);
			// Open a connection
			Connection conn = DriverManager.getConnection(DB_URL+DISABLE_SSL, USER, PASS);
		    Statement stm;
		    stm = conn.createStatement();
		    String sqll = "USE "+tname+" ;";
		    stm.executeUpdate(sqll);
		    String sql = "SELECT * FROM substations;";
		    ResultSet rst;
		    rst = stm.executeQuery(sql);
		    ArrayList<substations> subList = new ArrayList<substations>();
		    while (rst.next()) {
		    	substations sub = new substations(rst.getString("rdfid"), rst.getString("name"), rst.getString("region_id"));
		        subList.add(sub);
		    }
		    conn.close();
		    return subList;
		}
		public static ArrayList<measurement> getmeasure(String USER , String PASS , String tname) throws ClassNotFoundException, SQLException { 
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);
			// Open a connection
			Connection conn = DriverManager.getConnection(DB_URL+DISABLE_SSL, USER, PASS);
		    Statement stm;
		    stm = conn.createStatement();
		    String sqll = "USE "+tname+" ;";
		    stm.executeUpdate(sqll);
		    String sql = "SELECT * FROM measurements ORDER BY time LIMIT 0,10000;";
		    ResultSet rst;
		    rst = stm.executeQuery(sql);
		    ArrayList<measurement> measList = new ArrayList<measurement>();
		    while (rst.next()) {
		    	measurement meas = new measurement(rst.getString("rdfid"), rst.getString("name"), rst.getDouble("time"), rst.getDouble("value"), rst.getString("sub_rdfid"));
		        measList.add(meas);
		    }
		    
		    conn.close();
		    return measList;
		}
		public static ArrayList<measurement> getanValues(String USER , String PASS , String tname) throws ClassNotFoundException, SQLException { 
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);
			// Open a connection
			Connection conn = DriverManager.getConnection(DB_URL+DISABLE_SSL, USER, PASS);
		    Statement stm;
		    stm = conn.createStatement();
		    String sqll = "USE "+tname+" ;";
		    stm.executeUpdate(sqll);
		    String sql = "SELECT * FROM analog_values ORDER BY time LIMIT 0,10000;";
		    ResultSet rst;
		    rst = stm.executeQuery(sql);
		    ArrayList<measurement> anVList = new ArrayList<measurement>();
		    while (rst.next()) {
		    	measurement anV = new measurement(rst.getString("rdfid"), rst.getString("name"), rst.getDouble("time"), rst.getDouble("value"), rst.getString("sub_rdfid"));
		        anVList.add(anV);
		    }
		    
		    conn.close();
		    return anVList;
		}
		
		public static double Vol_drop (double V1 , double a1 , double V2 , double a2){
			return Math.sqrt( (Math.pow((V1*Math.cos(Math.toRadians(a1))-V2*Math.cos(Math.toRadians(a2))),2)) 
					        + (Math.pow((V1*Math.sin(Math.toRadians(a1))-V2*Math.sin(Math.toRadians(a2))),2)) );
		}
}
