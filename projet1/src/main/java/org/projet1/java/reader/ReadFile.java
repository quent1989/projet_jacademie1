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

		logger.info("Dans FileReader");
		List<String> lines;
		System.out.println("Please enter folder's path : ");
		Scanner scanner = new Scanner(System.in);
		String folderPath = scanner.nextLine();
		scanner.close();
		logger.info("Récupération du path des fichiers .music");
		
		File folder = new File(folderPath);
		logger.info("Listing des fichiers contenus dans le dossier");
		File [] listOfFiles = folder.listFiles();
		logger.info("Formatage de la date pour créer un dossier au format processes_YYYYMMDD_HHmmSS");
		SimpleDateFormat date = new SimpleDateFormat();
		date.applyPattern("yyyyMMDD_HHmmSS");
		Date today = new Date();
		
		logger.info("Création du dossier d'archivage");
		File saveFolder = new File(folderPath + "\\processed_" + date.format(today));		
		try {
			FileUtils.forceMkdir(saveFolder);
			logger.info("Dossier créé avec succès");
		} catch (IOException e1) {
			System.out.println("Error while creating " + saveFolder);
			e1.printStackTrace();
		}
		
		try {
			logger.info("Lecture des fichiers du dossier");
			for (File file : listOfFiles) {
				if(file.getName().contains(".music")){
					
					logger.info("Lecture ligne par ligne");
					lines = FileUtils.readLines(file);					
					
					for (String line : lines) {
						
						logger.info("Fragmentation des lignes");
						String[] elements = line.split(",", 7);
						
						Artiste art = new Artiste();
						Album alb = new Album();
						Chanson chan = new Chanson();
						
						logger.info("Enregistrement des informations contenues sur la ligne");
						
						art.setCodeArtiste(Integer.decode(elements[0]));
						art.setAlbum(elements[3]);
						art.setNom(elements[1]);
						
						chan.setDureeChanson(Integer.decode(elements[6]));
						chan.setNumChanson(Integer.decode(elements[4]));
						chan.setTitre(elements[5]);
						chan.setNomAlbum(elements[3]);
						
						Collection<Chanson> listeChansonsAlbum = new ArrayList<Chanson>();
						listeChansonsAlbum.add(chan);
						
						alb.setCodeAlbum(Integer.decode(elements[2]));
						alb.setNomAlbum(elements[3]);
						alb.setListeChansons(listeChansonsAlbum);
						
						logger.info("Ajout des objets aux collections idoines");
						artistes.add(art);
						albums.add(alb);
						chansons.add(chan);
					}
					
					logger.info("Copie du fichier lu dans le dossier processed");
					FileUtils.copyFileToDirectory(file, saveFolder);
					// La ligne suivante est commentée afin de pouvoir 
					//exécuter plusieurs fois le traitement sur un même fichier .music
					logger.info("Suppression du fichier traité dans le dossier source");
					//FileUtils.forceDelete(file);
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error while reading in : " + folderPath);
			e.printStackTrace();
		}
	}

}
