package org.projet1.java.reader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.projet1.java.models.Album;
import org.projet1.java.models.Artiste;
import org.projet1.java.models.Chanson;

public class ReadFile {

	private static Logger logger = Logger.getLogger(ReadFile.class);


	public static void FileReader(Collection<Artiste> artistes, Collection<Album> albums, Collection<Chanson> chansons) {

		List<String> lines;
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
		
		Artiste art = new Artiste();
		Album alb = new Album();
		Chanson chan = new Chanson();
		
		try {
			for (File file : listOfFiles) {
				if(file.getName().contains(".music")){
					
					lines = FileUtils.readLines(file);
					
					for (String line : lines) {
						String[] elements = line.split(",", 7);
						
						art.setCodeArtiste(Integer.decode(elements[0]));
						art.setAlbum(elements[3]);
						art.setNom(elements[1]);
						
						chan.setDureeChanson(Integer.decode(elements[6]));
						chan.setNumChanson(Integer.decode(elements[4]));
						chan.setTitre(elements[5]);
						
						Collection<Chanson> listeChansonsAlbum = new ArrayList<Chanson>();
						listeChansonsAlbum.add(chan);
						
						alb.setCodeAlbum(Integer.decode(elements[2]));
						alb.setNomAlbum(elements[3]);
						alb.setListeChansons(listeChansonsAlbum);						
					}
					
					FileUtils.copyFileToDirectory(file, saveFolder);
					//FileUtils.forceDelete(file);
				}
			}
			

			
		} catch (Exception e) {
			System.out.println("Error while reading in : " + folderPath);
			e.printStackTrace();
		}
	}

}
