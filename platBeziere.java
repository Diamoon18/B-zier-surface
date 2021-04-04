package Lab4;



import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



public class platBeziere {
	
	static public void formBeziera() throws IOException {
		plikParser pl = new plikParser();
		List<Punkt3d> punktiki = new ArrayList<>();
		List<Punkt3d> temp = new ArrayList<>();
		
		double px;
	    double py;
	    double pz; 
	    
	    int x = 0, y = 16;
	    punktiki = pl.punktArray();
	   
	    PrintWriter zapis = new PrintWriter("src/Lab4/teacup_new.txt");
	    int ilPlatTeacup = 26;
	    
	    /*
	    PrintWriter zapis = new PrintWriter("src/Lab4/spoon_new.txt");
	    int ilPlatSpoon = 16;
	    */
	    
	    /*
	    PrintWriter zapis = new PrintWriter("src/Lab4/teapot_new.txt");
	    int ilPlatTeapot = 32;
	     */
	    
	    zapis.println("x,y,z");
	    
	    for(int p = 0; p < ilPlatTeacup; p++) {
			temp = punktiki.subList(x, y);
			
        	for(double v = 0.0; v <= 1.0; v+=0.001) {
        		for(double w = 0.0; w <= 1.0; w+=0.001) {
        			px = (temp.get(0).getX()*Math.pow(1-v, 3)+3*v*temp.get(1).getX()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(2).getX()+temp.get(3).getX()*Math.pow(v, 3))
        					*(Math.pow(1-w, 3))+(temp.get(4).getX()*Math.pow(1-v, 3)+3*v*temp.get(5).getX()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(6).getX()+temp.get(7).getX()*Math.pow(v, 3))
        					*(3*w*Math.pow(1-w, 2))+(temp.get(8).getX()*Math.pow(1-v, 3)+3*v*temp.get(9).getX()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(10).getX()+temp.get(11).getX()*Math.pow(v, 3))
        					*(3*w*w*(1-w))+(temp.get(12).getX()*Math.pow(1-v, 3)+3*v*temp.get(13).getX()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(14).getX()+temp.get(15).getX()*Math.pow(v, 3))
        					*(Math.pow(w, 3));
        			py = (temp.get(0).getY()*Math.pow(1-v, 3)+3*v*temp.get(1).getY()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(2).getY()+temp.get(3).getY()*Math.pow(v, 3))
        					*(Math.pow(1-w, 3))+(temp.get(4).getY()*Math.pow(1-v, 3)+3*v*temp.get(5).getY()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(6).getY()+temp.get(7).getY()*Math.pow(v, 3))
        					*(3*w*Math.pow(1-w, 2))+(temp.get(8).getY()*Math.pow(1-v, 3)+3*v*temp.get(9).getY()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(10).getY()+temp.get(11).getY()*Math.pow(v, 3))
        					*(3*w*w*(1-w))+(temp.get(12).getY()*Math.pow(1-v, 3)+3*v*temp.get(13).getY()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(14).getY()+temp.get(15).getY()*Math.pow(v, 3))
        					*(Math.pow(w, 3));
        			pz = (temp.get(0).getZ()*Math.pow(1-v, 3)+3*v*temp.get(1).getZ()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(2).getZ()+temp.get(3).getZ()*Math.pow(v, 3))
        					*(Math.pow(1-w, 3))+(temp.get(4).getZ()*Math.pow(1-v, 3)+3*v*temp.get(5).getZ()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(6).getZ()+temp.get(7).getZ()*Math.pow(v, 3))
        					*(3*w*Math.pow(1-w, 2))+(temp.get(8).getZ()*Math.pow(1-v, 3)+3*v*temp.get(9).getZ()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(10).getZ()+temp.get(11).getZ()*Math.pow(v, 3))
        					*(3*w*w*(1-w))+(temp.get(12).getZ()*Math.pow(1-v, 3)+3*v*temp.get(13).getZ()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(14).getZ()+temp.get(15).getZ()*Math.pow(v, 3))
        					*(Math.pow(w, 3));
        			zapis.print(px +","+ py +","+ pz);
        			zapis.println();
        			
        		}
        	}
        	temp.clear();
        	
	    }
        zapis.close();
	}
}
	
	
	

