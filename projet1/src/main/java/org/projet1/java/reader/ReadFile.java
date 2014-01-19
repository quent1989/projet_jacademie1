package org.projet1.java.reader;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;

public class ReadFile {

	private static Logger logger = Logger.getLogger(ReadFile.class);


	public static String FileReader() {

		String result = "";
		System.out.println("Please enter folder's path : ");
		Scanner scanner = new Scanner(System.in);
		String folderPath = scanner.nextLine();
		
		File folder = new File(folderPath);
		File [] listOfFiles = folder.listFiles();
		Date date = new Date();
		
		try {
			for (File file : listOfFiles) {
				if(file.getName().contains(".music")){
					result += FileUtils.readFileToString(file) + " ";
					File saveFolder = new File(folderPath + "\\processed_" + new Date());
					FileUtils.forceMkdir(saveFolder);
					FileUtils.copyFileToDirectory(file, saveFolder);
					
				}
			}
			
			return result;
			
		} catch (Exception e) {
			System.out.println("Error while reading in : " + folderPath);
			e.printStackTrace();
			return null;
		}
	}

}
