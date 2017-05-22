package it.gabrydx;

import java.net.HttpURLConnection;
import java.net.URL;

public class Internet {

	public static boolean isConnected() {
		boolean connected = false;

		try {
			URL url = new URL("http://www.google.com");
			// System.out.println(url.getHost());
			HttpURLConnection con = (HttpURLConnection) url
					.openConnection();
			con.connect();
			if (con.getResponseCode() == 200){
				System.out.println("Connection established!");
				connected = true;
			}
		} catch (Exception e) {
			//			e.printStackTrace();
			System.out.println("No Connection");
		}

		return connected;
	}

	public static String hasInternet() {
		if (Internet.isConnected())
			return "ON";
		else
			return "OFF";
	}
}
