package assignment2;

import java.util.ArrayList;

public class Centroids {
	double V_CLAR,Angle_CLAR,V_AMHE,Angle_AMHE;
	double V_WINL,Angle_WINL,V_BOWM,Angle_BOWM;
	double V_TROY,Angle_TROY,V_MAPL,Angle_MAPL;
	double V_GRAN,Angle_GRAN,V_WAUT,Angle_WAUT;
	double V_CROSS,Angle_CROSS;
	
	public Centroids(double V_CLAR,double Angle_CLAR,double V_AMHE,double Angle_AMHE,double V_WINL,double Angle_WINL,double V_BOWM,double Angle_BOWM,
					double V_TROY,double Angle_TROY,double V_MAPL,double Angle_MAPL,double V_GRAN,double Angle_GRAN,double V_WAUT,double Angle_WAUT,
					double V_CROSS,double Angle_CROSS) {
		this.V_CLAR = V_CLAR;
		this.Angle_CLAR = Angle_CLAR;
		
		this.V_AMHE = V_AMHE;
		this.Angle_AMHE = Angle_AMHE;
		
		this.V_WINL = V_WINL;
		this.Angle_WINL = Angle_WINL;
		
		this.V_BOWM = V_BOWM;
		this.Angle_BOWM = Angle_BOWM;
		
		this.V_TROY = V_TROY;
		this.Angle_TROY = Angle_TROY;
		
		this.V_MAPL =  V_MAPL;
		this.Angle_MAPL = Angle_MAPL;
		
		this.V_GRAN = V_GRAN;
		this.Angle_GRAN = Angle_GRAN;
		
		this.V_WAUT = V_WAUT;
		this.Angle_WAUT= Angle_WAUT;
		
		this.V_CROSS = V_CROSS;
		this.Angle_CROSS = Angle_CROSS;
		
	}
	public ArrayList<Double> CLAR_Cen(){ 
		ArrayList<Double> CLAR_Cen = new ArrayList<Double>();
		CLAR_Cen.add(V_CLAR);
		CLAR_Cen.add(Angle_CLAR);
		return CLAR_Cen;
	}
	public ArrayList<Double> AMHE_Cen(){ 
		ArrayList<Double> AMHE_Cen = new ArrayList<Double>();
		AMHE_Cen.add(V_AMHE);
		AMHE_Cen.add(Angle_AMHE);
		return AMHE_Cen;
	}
	public ArrayList<Double> WINL_Cen(){ 
		ArrayList<Double> WINL_Cen = new ArrayList<Double>();
		WINL_Cen.add(V_WINL);
	    WINL_Cen.add(Angle_WINL);
		return WINL_Cen;
	}
	public ArrayList<Double> BOWM_Cen(){ 
		ArrayList<Double> BOWM_Cen = new ArrayList<Double>();
		BOWM_Cen.add(V_BOWM);
		BOWM_Cen.add(Angle_BOWM);
		return BOWM_Cen;
	}
	public ArrayList<Double> TROY_Cen(){ 
		ArrayList<Double> TROY_Cen = new ArrayList<Double>();
		TROY_Cen.add(V_TROY);
		TROY_Cen.add(Angle_TROY);
		return TROY_Cen;
	}
	public ArrayList<Double> MAPL_Cen(){ 
		ArrayList<Double> MAPL_Cen = new ArrayList<Double>();
		MAPL_Cen.add(V_MAPL);
		MAPL_Cen.add(Angle_MAPL);
		return MAPL_Cen;
	}
	public ArrayList<Double> GRAN_Cen(){ 
		ArrayList<Double> GRAN_Cen = new ArrayList<Double>();
		GRAN_Cen.add(V_GRAN);
		GRAN_Cen.add(Angle_GRAN);
		return GRAN_Cen;
	}
	public ArrayList<Double> WAUT_Cen(){ 
		ArrayList<Double> WAUT_Cen = new ArrayList<Double>();
		WAUT_Cen.add(V_WAUT);
		WAUT_Cen.add(Angle_WAUT);
		return WAUT_Cen;
	}
	public ArrayList<Double> CROSS_Cen(){ 
		ArrayList<Double> CROSS_Cen = new ArrayList<Double>();
		CROSS_Cen.add(V_CROSS);
		CROSS_Cen.add(Angle_CROSS);
		return CROSS_Cen;
	}
	
}
