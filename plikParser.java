package Lab4;

import java.io.*;
import java.util.*;


public class plikParser {
	private BufferedReader scan;
	private ArrayList<Punkt3d> punkty = new ArrayList<Punkt3d>();
	private Punkt3d p1;
	private double x, y, z;
	private String [] values;
	
	
	public plikParser(String nameFileInput) throws IOException {
		openFile(nameFileInput);
		readFile();
		closeFile();
	}
	
	
	public void openFile(String nameFileInput) {
		try {
			scan = new BufferedReader(new FileReader(nameFileInput));
		} catch (FileNotFoundException e) {
			System.out.print("Not found!");
			e.printStackTrace();
		}
	}
	
	public void readFile() throws NumberFormatException, IOException {
		String line;
		while ((line = scan.readLine()) != null) {
		   values = line.split(",");
		   x = Double.parseDouble(values[0]);
		   y = Double.parseDouble(values[1]);
		   z = Double.parseDouble(values[2]);
		   p1 = new Punkt3d(x, y, z);
		   punkty.add(p1);
	   }
	}
	
	
	public void closeFile() throws IOException {
		scan.close();
	}
	
	public ArrayList<Punkt3d> punktArray() {
		return punkty;
	}
	
		
}

