package assignment2;

public class substations {
	
	private String rdfID , name , Region;
	
	public substations(String rdfid , String nm , String rg){
		rdfID = rdfid;
		name = nm;
		Region = rg;
	}
	
	public String GetrdfID(){ return rdfID; }
	
	public String GetName(){ return name; }	
	
	public String GetRegion(){ return Region; }

}
