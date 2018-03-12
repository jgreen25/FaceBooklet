import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

/**
 * FaceBooklet is a program that allows creation, deletion, and manipulation of
 * profiles in a social network. When the program is closed and re-run, the data
 * from the previous run should be present. In terms of the manipulation of the
 * profiles, a profile's name, status, picture, and friends can be changed.
 * @author jgree
 *
 */
public class FaceBookletDatabase2 {
	
	/**
	 * The faceBookletGraph is the map which the profiles and their friendsLists are stored in.
	 */
	public static Map<FaceBookletProfile, ArrayList<FaceBookletProfile>> faceBookletGraph = new HashMap<FaceBookletProfile, ArrayList<FaceBookletProfile>>();
	/**
	 * This is the file that the information is written to and read from in order
	 * to keep information in the program between runs.
	 */
	static File faceBookletDatabase = new File("faceBookletDatabase.txt");
	/**
	 * The FileWriter that helps to write to the file.
	 */
	static FileWriter fileWriter;
	/**
	 * The BufferedWriter that helps to write to the file.
	 */
	static BufferedWriter bufferedWriter;
	/**
	 * The FileInputStream that helps to read the file.
	 */
	static FileInputStream fileInputStream;
	/**
	 * The Scanner that helps to read the file.
	 */
	static Scanner scnr;
	
	/**
	 * This method allows the addition of a profile to the graph.
	 * The profile is added, and then the new graph information is
	 * written to the file as to keep it up to date. It calls getFriends()
	 * and writeFile().
	 * @param profile   the FaceBookletProfile that is being added
	 */
	public static void addProfile(FaceBookletProfile profile) {
		faceBookletGraph.put(profile, profile.getFriends());
		writeFile();
	}
	
	/**
	 * This method writes the information in the faceBookletGraph into
	 * a text file so that the information can be stored in between runs
	 * of the application. The information is written using a for loop.
	 * It calls getCounter(), getID(), getName(), getStatus(), and getPicPath().
	 */
	public static void writeFile() {
		try {
			fileWriter = new FileWriter(faceBookletDatabase);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(Integer.toString(FaceBookletProfile.getCounter()));
			bufferedWriter.newLine();
			for(FaceBookletProfile prof: faceBookletGraph.keySet()) {
				bufferedWriter.write(Integer.toString(prof.getID()));
				bufferedWriter.newLine();
				bufferedWriter.write(prof.getName());
				bufferedWriter.newLine();
				if(prof.getStatus() != null) {
					bufferedWriter.write(prof.getStatus());
				}
				else {
					bufferedWriter.write("");
				}
				bufferedWriter.newLine();
				if(prof.getPicPath() != null) {
					bufferedWriter.write(prof.getPicPath());
				}
				else {
					bufferedWriter.write("");
				}
				bufferedWriter.newLine();
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		finally {
			if(bufferedWriter != null) {
				try {
					bufferedWriter.close();
				}
				catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * This method allows removal of a profile from the faceBookletGraph.
	 * It then writes the new graph information to the text file. It calls
	 * the writeFile() method.
	 * @param profile    the FaceBookletProfile that is to be removed from the graph
	 */
	public static void removeProfile(FaceBookletProfile profile) {
		faceBookletGraph.remove(profile);
		writeFile();
	}
	
	/**
	 * The readFile() method is called when the program is started. It checks
	 * for a file and if it is present, reads the information from the file
	 * and sets up the program with that information. It uses a while loop in
	 * order to read all of the information. It calls setID(), setStatus(),
	 * setPicPath(), and addProfile().
	 */
	public static void readFile() {
		try {
			if(faceBookletDatabase.exists()) {
				fileInputStream = new FileInputStream("faceBookletDatabase.txt");
				scnr = new Scanner(fileInputStream);
				
				FaceBookletProfile.setCounter(Integer.parseInt(scnr.nextLine()));
				while(scnr.hasNext()) {
					int ID = Integer.parseInt(scnr.nextLine());
					String name = scnr.nextLine();
					String status = scnr.nextLine();
					String path = scnr.nextLine();
					FaceBookletProfile prof = new FaceBookletProfile(name);
					prof.setID(ID);
					prof.setStatus(status);
					prof.setPicPath(path);
				    FaceBookletDatabase2.addProfile(prof);
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		finally {
			if(fileInputStream != null) {
				try {
					fileInputStream.close();
				}
				catch(IOException ex) {
					ex.printStackTrace();
				}
			}
			if(scnr != null) {
				scnr.close();
			}
		}
	}
	
	/**
	 * This method returns the faceBookletGraph which holds all of the
	 * profiles' information. This is useful so that the profiles' information
	 * can be accessed in other classes.
	 * @return   the faceBookletGraph Map
	 */
	public static Map<FaceBookletProfile, ArrayList<FaceBookletProfile>> getGraph() {
		return faceBookletGraph;
	}
	

}
