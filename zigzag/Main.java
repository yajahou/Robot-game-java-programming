//scp /Users/yajahoubah/eclipse-workspace/zigzag/src/zigzag/Main.java pi@192.168.59.74:./Documents
//cd Documents
//javac -cp SwiftBotAPI-5.1.0.jar Main.java
//java -cp SwiftBotAPI-5.1.0.jar Main.java
package zigzag;

import swiftbot.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class Zigzag {
	public static SwiftBotAPI sb = new SwiftBotAPI();
	public static Zigzag main = new Zigzag(); 

	public static void main(String[] args) {
		//prompt user to scan QR code
		System.out.println("Welcome to the zigzag drawing tool! Lets create some zigzag drawings with the robot");
		System.out.println(" scan the QR code to start Zigzag");
		//to start running 
		QRCode QR = new QRCode();
		QR.main();
        sb.enableButton(Button.A, () -> {
			System.out.println("Button A has been pressed");
			// read QR code
			QR.read();
        });
		
	}
	
	public void ultrasound() {
		double distance = main.sb.useUltrasound();
		System.out.println("Distance from obstacle: " + distance + "cm");
	}
}

class QRCode {
	Zigzag main;
	public static SwiftBotAPI sb;
	boolean running;
	public void main() {
		sb = main.sb;
		this.running = true;
		
		//while (this.running) {
			
		//}
	}
	public String read() {
		try {
			System.out.println("yes");
			BufferedImage image = sb.getQRImage();
			String code = sb.decodeQRImage(image);
			System.out.println("code: "+code);
			return code;
			
		} catch (Exception e) {
			String invalid = "Invalid input, please scan QR code again ";
			System.out.println(invalid);
			return "";
		}
	} 
	//verify amount and length
	public Boolean verify (int amount,int length) {
		if (amount>=1 && amount<=8) {
			if (length>=15 && length <=85) {
				return true;
		    
			}
			
		}
		return false;
	}

}



