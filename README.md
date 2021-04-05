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
## Resources:
Output files: http://www.holmes3d.net/graphics/teapot/ \
//formula wyprowadzenie \
ParaView app: https://www.paraview.org/ 
# Result:
## Teapot
![czajnik_new](https://user-images.githubusercontent.com/72127610/113522513-4c75e480-95a1-11eb-8488-9af8d702e547.jpg)
## Teacup
![teacup_new](https://user-images.githubusercontent.com/72127610/113522514-4ed83e80-95a1-11eb-8818-d14569a86e6d.jpg)
## Spoon
![spoon_new](https://user-images.githubusercontent.com/72127610/113522515-513a9880-95a1-11eb-9855-9d20272f78c3.jpg)
