package org.projet1.java.reader;

import java.util.ArrayList;
import java.util.Collection;

import org.projet1.java.models.Album;
import org.projet1.java.models.Artiste;
import org.projet1.java.models.Chanson;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Collection<Artiste> artistes = new ArrayList<Artiste>();
		Collection<Album> albums = new ArrayList<Album>();
		Collection<Chanson> chansons = new ArrayList<Chanson>();
		ReadFile.FileReader(artistes, albums, chansons);

	}

}
