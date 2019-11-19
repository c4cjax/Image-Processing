import java.util.Scanner;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/*
Here is a helpful link to understanding Bitwise operations used in this program:
https://www.dyclassroom.com/image-processing-project/how-to-get-and-set-pixel-value-in-java
*/
public class GrayScale {
	public static void main(String args[]) throws IOException{
		
		Scanner kbReader = new Scanner(System.in);
		BufferedImage img = null;
		File f = null;
		
		try {
			System.out.print("Enter image path: ");
			String path = kbReader.next();
			f = new File(path);
			img = ImageIO.read(f);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		int width = img.getWidth();
		int height = img.getHeight();
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				
				int p = img.getRGB(x,y);
				
				int a = (p>>24) & 0xff;
				int r = (p>>16) & 0xff;
				int g = (p>>8) & 0xff;
				int b = p & 0xff;
				
				int avg = (r+g+b)/3;
				
				p = (a<<24)|(avg<<16)|(avg<<8)|avg;
				
				img.setRGB(x, y, p);
			}
		}
		
		try{
			f = new File("D:\\ImagesTester\\Out.jpg"); 
			ImageIO.write(img, "jpg", f); 
			System.out.println("Completed.");
	    } catch(IOException e) { 
	    	System.out.println(e); 
	    } 
	}
}
