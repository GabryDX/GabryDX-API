package it.gabrydx;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Screenshot {

	public static void esegui() throws HeadlessException, AWTException, IOException {
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File("/screenshot.png"));
	}
	
	public static void main(String[] args) throws HeadlessException, AWTException, IOException {
		esegui();
	}
}
