package assignment2;

public class measurement { // class to read the measurements table from database
	private double time , value;

	private String rdfID , name , sub_rdfID;
	
	public measurement( String rdfid , String nm , double t , double v , String sid){
		rdfID = rdfid;
		name = nm; 
		time = t;
		value = v; 
		sub_rdfID = sid;
	}
	
	public String GetrdfID(){ return rdfID; }
	
	public String GetName(){ return name; }	
	
	public String GetSrdfID(){ return sub_rdfID; }
	
	public double GetTime(){ return time; }
	
	public double GetValue(){ return value; }
	
}
