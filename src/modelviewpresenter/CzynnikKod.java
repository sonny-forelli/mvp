package modelviewpresenter;

import static java.lang.Math.log;



public class CzynnikKod {
	
	private final int id;
	
	private final String x1;
	private final double xmax;
	private final double xmin;
	
	private double wsp1;
	private double wsp2;
	
	private String fullString;
	private String kod;
	// private String cwKod;
	
	public CzynnikKod (Czynnik c){
		
		this.id=c.getCzynnikId();
		this.x1=c.getOznaczenie();
		this.xmax=c.getWartoscMax();
		this.xmin=c.getWartoscMin();
                
                kod();
		
		
	}
        public CzynnikKod (int id, String ozn, double wMax, double wMin){
            
            this.id=id;
            this.x1=ozn;
            this.xmax=wMax;
            this.xmin=wMin;
            
            kod();
        }
        
	private void kod(){
		wsp1=2/(log(xmax)-log(xmin));
		wsp2=((2*(-(log(xmax))))/(log(xmax)-(log(xmin))))+1;// minus
		String znak="";
        if(getWsp2()>=0)znak="+";
		kod="("+Double.toString(getWsp1())+" ln "+x1+" "+znak+Double.toString(getWsp2())+")";
		
		String licznik="2(ln"+x1+" - ln"+Double.toString(xmax)+")";
		String mianownik="ln"+Double.toString(xmax)+" - ln"+Double.toString(10);
		
		fullString="x"+Integer.toString(id)+" = "+licznik+" / "+mianownik+" = " +getKod();
		
		
		
	}

    /**
     * @return the wsp1
     */
    public double getWsp1() {
        return wsp1;
    }

    /**
     * @return the wsp2
     */
    public double getWsp2() {
        return wsp2;
    }

    /**
     * @return the fullString
     */
    public String getFullString() {
        return fullString;
    }

    /**
     * @return the kod
     */
    public String getKod() {
        return kod;
    }

   
		
	
	
	
	
}