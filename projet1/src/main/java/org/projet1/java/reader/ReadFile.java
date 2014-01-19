package org.projet1.java.reader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
		scanner.close();
		
		File folder = new File(folderPath);
		File [] listOfFiles = folder.listFiles();
		SimpleDateFormat date = new SimpleDateFormat();
		date.applyPattern("yyyyMMDD_HHmmSS");
		Date today = new Date();
		
		File saveFolder = new File(folderPath + "\\processed_" + date.format(today));
		
		try {
			FileUtils.forceMkdir(saveFolder);
		} catch (IOException e1) {
			System.out.println("Error while creating " + saveFolder);
			e1.printStackTrace();
		}
		
		try {
			for (File file : listOfFiles) {
				if(file.getName().contains(".music")){
					
					result += FileUtils.readFileToString(file);
					FileUtils.copyFileToDirectory(file, saveFolder);
					FileUtils.forceDelete(file);
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
