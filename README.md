# Bezier surface
3D objects using Bezier surfaces. \
I used the ParaView application to render objects. \
Also, I derive a formula for the Bezier surface of the third degree.
## Code explanation
###  class plikParser 
Variable initialization: \
class BufferedReader - reading from file. \
ArrayList<Punkt3d> punkty - list for points from file. \
class Punkt3d - for more convenient storage of points. \
double x, y, z - coordinate value for point. \
String [] values - to hold lines from a file.
```java
  	private BufferedReader scan;
	private ArrayList<Punkt3d> punkty = new ArrayList<Punkt3d>();
	private Punkt3d p1;
	private double x, y, z;
	private String [] values;
```
`method openFile` \
Creating a BufferedReader object to be read from a input file.
String nameFileInput - file path.
```java
    	scan = new BufferedReader(new FileReader(nameFileInput))
```
`method readFile()` \
Read lines from the input file while they are.\
Write a line into the values array (it consists of the three elements).\
And then we assign each element of rhe array to a variable, or our coordinate.\
Create a point from these coordinates. Add it to the list.
```java
   	 String line;
	 while ((line = scan.readLine()) != null) {
		  values = line.split(",");
		  x = Double.parseDouble(values[0]);
		  y = Double.parseDouble(values[1]);
		  z = Double.parseDouble(values[2]);
		  p1 = new Punkt3d(x, y, z);
		  punkty.add(p1);
	 }
```
`method closeFile()` - close the file.\
Return list of points received from input file.
```java
          public ArrayList<Punkt3d> punktArray() {
		  return punkty;
	  }
```
###  class platBeziere - the most important
This class contains one static method to generate a subsidiary points. \
As parametrs this method takes: \
String nameFileInput - path to input file.\
String nameFileOutput - path to output file.\
int surface - the number of Beziere surfaces.\
Reading from input file.\
```java
	 plikParser pl = new plikParser(nameFileInput);
```
The lists for points and coordinates for subsidiary points.
```java
	 List<Punkt3d> punktiki = new ArrayList<>();
	 List<Punkt3d> temp = new ArrayList<>();
	 double px;
	 double py;
	 double pz;
```
x - initial index.\
y - end index.\
We transfer the list of points from the input file to the empty list `punktiki`.
```java
	 int x = 0, y = 16;
	 punktiki = pl.punktArray();
```
Using the class PrintWriter, open the output file for writing.\
In the first line we write the name of the coordinates(it is needed in the future for the program ParaView)
```java
	PrintWriter zapis = new PrintWriter(nameFileOutput);
	zapis.println("x,y,z");
```
Loop through the number of surfaces and add 15 points from the list `punktiki` to the temporary list.\
Using the method sublist, making small lists of 15 points. 
```java
	for(int p = 0; p < surface; p++) {
		temp = punktiki.subList(x, y);
		...
```
Write down the entered formula above for the coordinates.
```java
	for(double v = 0.0; v <= 1.0; v+=0.001) {
                for(double w = 0.0; w <= 1.0; w+=0.001) {
        		px = (temp.get(0).getX()*Math.pow(1-v, 3)+3*v*temp.get(1).getX()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(2).getX()+temp.get(3).getX()*Math.pow(v, 3))*(Math.pow(1-w, 3))+(temp.get(4).getX()*Math.pow(1-v, 3)+3*v*temp.get(5).getX()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(6).getX()+temp.get(7).getX()*Math.pow(v, 3))*(3*w*Math.pow(1-w, 2))+(temp.get(8).getX()*Math.pow(1-v, 3)+3*v*temp.get(9).getX()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(10).getX()+temp.get(11).getX()*Math.pow(v, 3))*(3*w*w*(1-w))+(temp.get(12).getX()*Math.pow(1-v, 3)+3*v*temp.get(13).getX()*Math.pow(1-v, 2)+3*v*v*(1-v)*temp.get(14).getX()+temp.get(15).getX()*Math.pow(v, 3))*(Math.pow(w, 3));	...				
```
Write the resulting coordinates to the output file.\		
```java
	 zapis.print(px +","+ py +","+ pz);
         zapis.println();
```
Clean the list and take the next 15 points.
```java
	 temp.clear();
```
Close output file.
```java
	zapis.close();
```		
 ###  class main - call the method formBeziera for generating points.
```java
	String sciezkaTeacup = "src/Lab4/teacup.txt";
	String sciezkaTeacupOut = "src/Lab4/teacup_new.txt";
	platBeziere.formBeziera(sciezkaTeacup, sciezkaTeacupOut, 26);
	...
```
Link to download the output files(because the file size is very large): https://drive.google.com/file/d/1uYVI0hrfylFzAAqQLKaWajIJSeU05V9x/view?usp=sharing					   
## Resources:
Output files: http://www.holmes3d.net/graphics/teapot/ \
Formula: ![Lab4](https://user-images.githubusercontent.com/72127610/113593918-492d3800-9637-11eb-9ebb-b1a4417a8ed0.jpg)
ParaView app: https://www.paraview.org/ 
# Result:
## Teapot
![czajnik_new](https://user-images.githubusercontent.com/72127610/113522513-4c75e480-95a1-11eb-8488-9af8d702e547.jpg)
## Teacup
![teacup_new](https://user-images.githubusercontent.com/72127610/113522514-4ed83e80-95a1-11eb-8818-d14569a86e6d.jpg)
## Spoon
![spoon_new](https://user-images.githubusercontent.com/72127610/113522515-513a9880-95a1-11eb-9855-9d20272f78c3.jpg)
