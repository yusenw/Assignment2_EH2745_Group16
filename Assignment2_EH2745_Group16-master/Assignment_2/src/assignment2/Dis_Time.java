package assignment2;

public class Dis_Time {
 //	static double dis;
double time;
TimeSub Meas1_i;
TimeSub Meas2_i;
double dis;
	public Dis_Time(double time,TimeSub Meas1_i,TimeSub Meas2_i) {
		this.time = time;
		this.Meas1_i = Meas1_i;
		this.Meas2_i = Meas2_i;
		dis = Math.sqrt(Math.pow(Meas2_i.CLAR().get(1)-Meas1_i.CLAR().get(1), 2)+Math.pow(Meas2_i.CLAR().get(2)-Meas1_i.CLAR().get(2),2)
		 			   +Math.pow(Meas2_i.AMHE().get(1)-Meas1_i.AMHE().get(1), 2)+Math.pow(Meas2_i.AMHE().get(2)-Meas1_i.AMHE().get(2),2)
		 			   +Math.pow(Meas2_i.WINL().get(1)-Meas1_i.WINL().get(1), 2)+Math.pow(Meas2_i.WINL().get(2)-Meas1_i.WINL().get(2),2)
		 			   +Math.pow(Meas2_i.BOWM().get(1)-Meas1_i.BOWM().get(1), 2)+Math.pow(Meas2_i.BOWM().get(2)-Meas1_i.BOWM().get(2),2)
		 			   +Math.pow(Meas2_i.TROY().get(1)-Meas1_i.TROY().get(1), 2)+Math.pow(Meas2_i.TROY().get(2)-Meas1_i.TROY().get(2),2)
		 			   +Math.pow(Meas2_i.MAPL().get(1)-Meas1_i.MAPL().get(1), 2)+Math.pow(Meas2_i.MAPL().get(2)-Meas1_i.MAPL().get(2),2)
		 			   +Math.pow(Meas2_i.GRAN().get(1)-Meas1_i.GRAN().get(1), 2)+Math.pow(Meas2_i.GRAN().get(2)-Meas1_i.GRAN().get(2),2)
		 			   +Math.pow(Meas2_i.WAUT().get(1)-Meas1_i.WAUT().get(1), 2)+Math.pow(Meas2_i.WAUT().get(2)-Meas1_i.WAUT().get(2),2)
		 			   +Math.pow(Meas2_i.CROSS().get(1)-Meas1_i.CROSS().get(1), 2)+Math.pow(Meas2_i.CROSS().get(2)-Meas1_i.CROSS().get(2),2));
	}
	public double GetKNN_dis() {
		return dis;
	}
	public double Gettime() {
		return time;
	}
	
	
	
//	public static double[] dis_label() {
//		double[] dis_label = new double [2];
//		dis_label[0] = dis;
//		dis_label[0] = time;
//		return dis_label;
//		
//	}
}
