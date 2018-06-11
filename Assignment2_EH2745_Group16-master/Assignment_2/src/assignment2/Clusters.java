package assignment2;

import java.util.ArrayList;

public class Clusters {
	 ArrayList<TimeSub> cluster1 = new ArrayList<TimeSub>();
	 ArrayList<TimeSub> cluster2 = new ArrayList<TimeSub>();
	 ArrayList<TimeSub> cluster3 = new ArrayList<TimeSub>();
	 ArrayList<TimeSub> cluster4 = new ArrayList<TimeSub>();
	
	public Clusters(ArrayList<TimeSub> cluster1, ArrayList<TimeSub> cluster2, ArrayList<TimeSub> cluster3, ArrayList<TimeSub> cluster4) {
		this.cluster1 = cluster1;
		this.cluster2 = cluster2;
		this.cluster3 = cluster3;
		this.cluster4 = cluster4;
	}
	
	public ArrayList<TimeSub>  Getcluster1(){
		return cluster1;
	}
	public ArrayList<TimeSub>  Getcluster2(){
		return cluster2;
	}
	public ArrayList<TimeSub>  Getcluster3(){
		return cluster3;
	}
	public ArrayList<TimeSub>  Getcluster4(){
		return cluster4;
	}
}
