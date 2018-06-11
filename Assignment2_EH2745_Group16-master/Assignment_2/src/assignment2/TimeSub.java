package assignment2;

import java.util.ArrayList;

public class TimeSub {
	int time;
//	int sub_num;
	ArrayList<measurement> Meas;
	
	public TimeSub(int time,ArrayList<measurement> Meas) {
		this.time = time;
//		this.sub_num = sub_num;	
		this.Meas = Meas;
	}
	public double Gettime_Posi() {
		return (double)time;
	}
	
	public ArrayList<Double> CLAR(){ 
		ArrayList<Double> CLAR_info = new ArrayList<Double>();
		CLAR_info.add(Meas.get((time)*18).GetTime());
		CLAR_info.add(Meas.get((time)*18).GetValue());
		CLAR_info.add(Meas.get((time)*18+1).GetValue());	
		
		return CLAR_info;
	}

	public ArrayList<Double> AMHE(){ 
		ArrayList<Double> AMHE_info = new ArrayList<Double>();
		AMHE_info.add(Meas.get((time)*18+2).GetTime());
		AMHE_info.add(Meas.get((time)*18+2).GetValue());
		AMHE_info.add(Meas.get((time)*18+3).GetValue());
		
		return AMHE_info;
	}	
	
	public ArrayList<Double> WINL(){ 
		ArrayList<Double>  WINL_info = new ArrayList<Double>();
		WINL_info.add(Meas.get((time)*18+4).GetTime());
		WINL_info.add(Meas.get((time)*18+4).GetValue());
		WINL_info.add(Meas.get((time)*18+5).GetValue());

		return WINL_info;
	}
	
	public ArrayList<Double>  BOWM(){ 
		ArrayList<Double>  BOWM_info = new ArrayList<Double>();
		BOWM_info.add(Meas.get((time)*18+6).GetTime());
		BOWM_info.add(Meas.get((time)*18+6).GetValue());
		BOWM_info.add(Meas.get((time)*18+7).GetValue());

		return BOWM_info;
		}
	
	public ArrayList<Double> TROY(){ 
		ArrayList<Double>  TROY_info = new ArrayList<Double>();
		TROY_info.add(Meas.get((time)*18+8).GetTime());
		TROY_info.add(Meas.get((time)*18+8).GetValue());
		TROY_info.add(Meas.get((time)*18+9).GetValue());
		
		return TROY_info;
	}
	
	public ArrayList<Double> MAPL(){ 
		ArrayList<Double>  MAPL_info = new ArrayList<Double>();
		MAPL_info.add(Meas.get((time)*18+10).GetTime());
		MAPL_info.add(Meas.get((time)*18+10).GetValue());
		MAPL_info.add(Meas.get((time)*18+11).GetValue());
		
		return MAPL_info;
		}
	
	public ArrayList<Double> GRAN(){
		ArrayList<Double>  GRAN_info = new ArrayList<Double>();
		GRAN_info.add(Meas.get((time)*18+12).GetTime());
		GRAN_info.add(Meas.get((time)*18+12).GetValue());
		GRAN_info.add(Meas.get((time)*18+13).GetValue());
		
		return GRAN_info;
	}
	
	public ArrayList<Double> WAUT(){ 
		ArrayList<Double>  WAUT_info = new ArrayList<Double>();
		WAUT_info.add(Meas.get((time)*18+14).GetTime());
		WAUT_info.add(Meas.get((time)*18+14).GetValue());
		WAUT_info.add(Meas.get((time)*18+15).GetValue());
		
		return WAUT_info;
	}
	
	public ArrayList<Double> CROSS(){ 
		ArrayList<Double>  CROSS_info = new ArrayList<Double>();
		CROSS_info.add(Meas.get((time)*18+16).GetTime());
		CROSS_info.add(Meas.get((time)*18+16).GetValue());
		CROSS_info.add(Meas.get((time)*18+17).GetValue());
		
		return CROSS_info;
	}
}
