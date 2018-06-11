package assignment2;

import java.util.ArrayList;

public class CostFunction {
	ArrayList<TimeSub> cluster1 = new ArrayList<TimeSub>();
	ArrayList<TimeSub> cluster2 = new ArrayList<TimeSub>();
	ArrayList<TimeSub> cluster3 = new ArrayList<TimeSub>();
	ArrayList<TimeSub> cluster4 = new ArrayList<TimeSub>();
	Clusters clusters;
	ArrayList<Centroids> centroids = new ArrayList<Centroids>();
	
	public CostFunction(Clusters clusters,ArrayList<Centroids> centroids) {
		this.cluster1 = clusters.Getcluster1();
		this.cluster2 = clusters.Getcluster2();
		this.cluster3 = clusters.Getcluster3();
		this.cluster4 = clusters.Getcluster4();
		this.centroids = centroids;
	}
	public double cost() {
		double dis1=0,dis2=0,dis3=0,dis4=0,cost;
		for(int i =0;i<cluster1.size();i++) {
			dis1 += Math.sqrt(Math.pow(cluster1.get(i).CLAR().get(1)-centroids.get(0).CLAR_Cen().get(0), 2)+Math.pow(cluster1.get(i).CLAR().get(2)-centroids.get(0).CLAR_Cen().get(1), 2)
							 +Math.pow(cluster1.get(i).AMHE().get(1)-centroids.get(0).AMHE_Cen().get(0), 2)+Math.pow(cluster1.get(i).AMHE().get(2)-centroids.get(0).AMHE_Cen().get(1), 2)
							 +Math.pow(cluster1.get(i).WINL().get(1)-centroids.get(0).WINL_Cen().get(0), 2)+Math.pow(cluster1.get(i).WINL().get(2)-centroids.get(0).WINL_Cen().get(1), 2)
							 +Math.pow(cluster1.get(i).BOWM().get(1)-centroids.get(0).BOWM_Cen().get(0), 2)+Math.pow(cluster1.get(i).BOWM().get(2)-centroids.get(0).BOWM_Cen().get(1), 2)
							 +Math.pow(cluster1.get(i).TROY().get(1)-centroids.get(0).TROY_Cen().get(0), 2)+Math.pow(cluster1.get(i).TROY().get(2)-centroids.get(0).TROY_Cen().get(1), 2)
							 +Math.pow(cluster1.get(i).MAPL().get(1)-centroids.get(0).MAPL_Cen().get(0), 2)+Math.pow(cluster1.get(i).MAPL().get(2)-centroids.get(0).MAPL_Cen().get(1), 2)
							 +Math.pow(cluster1.get(i).GRAN().get(1)-centroids.get(0).GRAN_Cen().get(0), 2)+Math.pow(cluster1.get(i).GRAN().get(2)-centroids.get(0).GRAN_Cen().get(1), 2)
							 +Math.pow(cluster1.get(i).WAUT().get(1)-centroids.get(0).WAUT_Cen().get(0), 2)+Math.pow(cluster1.get(i).WAUT().get(2)-centroids.get(0).WAUT_Cen().get(1), 2)
							 +Math.pow(cluster1.get(i).CROSS().get(1)-centroids.get(0).CROSS_Cen().get(0), 2)+Math.pow(cluster1.get(i).CROSS().get(2)-centroids.get(0).CROSS_Cen().get(1), 2));
		}
		for(int i =0;i<cluster2.size();i++) {
			dis2 += Math.sqrt(Math.pow(cluster2.get(i).CLAR().get(1)-centroids.get(1).CLAR_Cen().get(0), 2)+Math.pow(cluster2.get(i).CLAR().get(2)-centroids.get(1).CLAR_Cen().get(1), 2)
							 +Math.pow(cluster2.get(i).AMHE().get(1)-centroids.get(1).AMHE_Cen().get(0), 2)+Math.pow(cluster2.get(i).AMHE().get(2)-centroids.get(1).AMHE_Cen().get(1), 2)
							 +Math.pow(cluster2.get(i).WINL().get(1)-centroids.get(1).WINL_Cen().get(0), 2)+Math.pow(cluster2.get(i).WINL().get(2)-centroids.get(1).WINL_Cen().get(1), 2)
							 +Math.pow(cluster2.get(i).BOWM().get(1)-centroids.get(1).BOWM_Cen().get(0), 2)+Math.pow(cluster2.get(i).BOWM().get(2)-centroids.get(1).BOWM_Cen().get(1), 2)
							 +Math.pow(cluster2.get(i).TROY().get(1)-centroids.get(1).TROY_Cen().get(0), 2)+Math.pow(cluster2.get(i).TROY().get(2)-centroids.get(1).TROY_Cen().get(1), 2)
							 +Math.pow(cluster2.get(i).MAPL().get(1)-centroids.get(1).MAPL_Cen().get(0), 2)+Math.pow(cluster2.get(i).MAPL().get(2)-centroids.get(1).MAPL_Cen().get(1), 2)
							 +Math.pow(cluster2.get(i).GRAN().get(1)-centroids.get(1).GRAN_Cen().get(0), 2)+Math.pow(cluster2.get(i).GRAN().get(2)-centroids.get(1).GRAN_Cen().get(1), 2)
							 +Math.pow(cluster2.get(i).WAUT().get(1)-centroids.get(1).WAUT_Cen().get(0), 2)+Math.pow(cluster2.get(i).WAUT().get(2)-centroids.get(1).WAUT_Cen().get(1), 2)
							 +Math.pow(cluster2.get(i).CROSS().get(1)-centroids.get(1).CROSS_Cen().get(0), 2)+Math.pow(cluster2.get(i).CROSS().get(2)-centroids.get(1).CROSS_Cen().get(1), 2));
		}
		for(int i=0;i<cluster3.size();i++) {
			dis3 += Math.sqrt(Math.pow(cluster3.get(i).CLAR().get(1)-centroids.get(2).CLAR_Cen().get(0), 2)+Math.pow(cluster3.get(i).CLAR().get(2)-centroids.get(2).CLAR_Cen().get(1), 2)
							 +Math.pow(cluster3.get(i).AMHE().get(1)-centroids.get(2).AMHE_Cen().get(0), 2)+Math.pow(cluster3.get(i).AMHE().get(2)-centroids.get(2).AMHE_Cen().get(1), 2)
							 +Math.pow(cluster3.get(i).WINL().get(1)-centroids.get(2).WINL_Cen().get(0), 2)+Math.pow(cluster3.get(i).WINL().get(2)-centroids.get(2).WINL_Cen().get(1), 2)
							 +Math.pow(cluster3.get(i).BOWM().get(1)-centroids.get(2).BOWM_Cen().get(0), 2)+Math.pow(cluster3.get(i).BOWM().get(2)-centroids.get(2).BOWM_Cen().get(1), 2)
							 +Math.pow(cluster3.get(i).TROY().get(1)-centroids.get(2).TROY_Cen().get(0), 2)+Math.pow(cluster3.get(i).TROY().get(2)-centroids.get(2).TROY_Cen().get(1), 2)
							 +Math.pow(cluster3.get(i).MAPL().get(1)-centroids.get(2).MAPL_Cen().get(0), 2)+Math.pow(cluster3.get(i).MAPL().get(2)-centroids.get(2).MAPL_Cen().get(1), 2)
							 +Math.pow(cluster3.get(i).GRAN().get(1)-centroids.get(2).GRAN_Cen().get(0), 2)+Math.pow(cluster3.get(i).GRAN().get(2)-centroids.get(2).GRAN_Cen().get(1), 2)
							 +Math.pow(cluster3.get(i).WAUT().get(1)-centroids.get(2).WAUT_Cen().get(0), 2)+Math.pow(cluster3.get(i).WAUT().get(2)-centroids.get(2).WAUT_Cen().get(1), 2)
							 +Math.pow(cluster3.get(i).CROSS().get(1)-centroids.get(2).CROSS_Cen().get(0), 2)+Math.pow(cluster3.get(i).CROSS().get(2)-centroids.get(2).CROSS_Cen().get(1), 2));
		}
		for(int i=0;i<cluster4.size();i++) {
			dis4 += Math.sqrt(Math.pow(cluster4.get(i).CLAR().get(1)-centroids.get(3).CLAR_Cen().get(0), 2)+Math.pow(cluster4.get(i).CLAR().get(2)-centroids.get(3).CLAR_Cen().get(1), 2)
							 +Math.pow(cluster4.get(i).AMHE().get(1)-centroids.get(3).AMHE_Cen().get(0), 2)+Math.pow(cluster4.get(i).AMHE().get(2)-centroids.get(3).AMHE_Cen().get(1), 2)
							 +Math.pow(cluster4.get(i).WINL().get(1)-centroids.get(3).WINL_Cen().get(0), 2)+Math.pow(cluster4.get(i).WINL().get(2)-centroids.get(3).WINL_Cen().get(1), 2)
							 +Math.pow(cluster4.get(i).BOWM().get(1)-centroids.get(3).BOWM_Cen().get(0), 2)+Math.pow(cluster4.get(i).BOWM().get(2)-centroids.get(3).BOWM_Cen().get(1), 2)
							 +Math.pow(cluster4.get(i).TROY().get(1)-centroids.get(3).TROY_Cen().get(0), 2)+Math.pow(cluster4.get(i).TROY().get(2)-centroids.get(3).TROY_Cen().get(1), 2)
							 +Math.pow(cluster4.get(i).MAPL().get(1)-centroids.get(3).MAPL_Cen().get(0), 2)+Math.pow(cluster4.get(i).MAPL().get(2)-centroids.get(3).MAPL_Cen().get(1), 2)
							 +Math.pow(cluster4.get(i).GRAN().get(1)-centroids.get(3).GRAN_Cen().get(0), 2)+Math.pow(cluster4.get(i).GRAN().get(2)-centroids.get(3).GRAN_Cen().get(1), 2)
							 +Math.pow(cluster4.get(i).WAUT().get(1)-centroids.get(3).WAUT_Cen().get(0), 2)+Math.pow(cluster4.get(i).WAUT().get(2)-centroids.get(3).WAUT_Cen().get(1), 2)
							 +Math.pow(cluster4.get(i).CROSS().get(1)-centroids.get(3).CROSS_Cen().get(0), 2)+Math.pow(cluster4.get(i).CROSS().get(2)-centroids.get(3).CROSS_Cen().get(1), 2));
		}
		cost = dis1+dis2+dis3+dis4;
		return cost;
	}
	public ArrayList<Centroids> GetCentroids(){
		return centroids;
	}
	public ArrayList<TimeSub> Getcluster1(){
		return cluster1;
	}
	public ArrayList<TimeSub> Getcluster2(){
		return cluster2;
	}
	public ArrayList<TimeSub> Getcluster3(){
		return cluster3;
	}
	public ArrayList<TimeSub> Getcluster4(){
		return cluster4;
	}
}
