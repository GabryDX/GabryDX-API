/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gabrydx.takepage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author Emanuele Bruno
 */

public class TakePage {

	public static String takePage(String url_string){
		// These two need to be declared outside the try/catch
		// so that they can be closed in the finally block.
		HttpURLConnection urlConnection = null;
		BufferedReader reader = null;

		// Will contain the result response as a string.
		String res = null;

		try {
			// Construct the URL for the query
			URL url = new URL(url_string);

			// Create the request, and open the connection
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.connect();

			// Read the input stream into a String
			InputStream inputStream = urlConnection.getInputStream();
			StringBuffer buffer = new StringBuffer();
			if (inputStream == null) {
				// Nothing to do.
				return null;
			}
			reader = new BufferedReader(new InputStreamReader(inputStream,StandardCharsets.UTF_8));

			String line;
			while ((line = reader.readLine()) != null) {

				buffer.append(line + "\n");
			}

			if (buffer.length() == 0) {
				// Stream was empty. No point in parsing.
				return null;
			}
			res = buffer.toString();
		} catch (IOException e) {
			System.out.println("Error");
			// If the code didn't successfully get the data, there's no point in attemping
			// to parse it.
			return null;
		} finally{
			if (urlConnection != null) {
				urlConnection.disconnect();
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (final IOException e) {
					System.out.println("Error");
				}
			}
		}
		return res;
	}  
}
