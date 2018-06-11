package assignment2;

import java.util.ArrayList;

public class Sequence {
double x;
ArrayList<TimeSub> cluster;
Centroids centroids;
	public Sequence(double x, ArrayList<TimeSub> cluster, Centroids centroids) {
		this.x = x;
		this.cluster = cluster;
		this.centroids = centroids;
		// TODO Auto-generated constructor stub
	}
	public double Getx() {
		return x;
	}
	public ArrayList<TimeSub> Getcluster() {
		return cluster;
	}
	public Centroids Getcentroid(){
		return centroids;
	}
}
