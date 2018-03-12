import javax.swing.JFrame;

/**
 * This class contains a main method that creates the GUI object and
 * runs the application.
 * @author jgree
 *
 */
public class FaceBooklet {
	
	/**
	 * The main method creates the GUI and performs needed operations
	 * so that the application runs as intended. It calls the readFile() method
	 * so that the data from the file can be read into the program. It then
	 * iterates through the graph in order to display that information for 
	 * each profile that has already be initialized.
	 * @param args
	 */
	public static void main(String[] args) {
		
		FaceBookletGUI faceBookletFrame = new FaceBookletGUI();
		faceBookletFrame.setSize(1000, 700);
		faceBookletFrame.setLocation(500, 500);
		faceBookletFrame.setResizable(false);
		faceBookletFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		faceBookletFrame.setLocation(500, 350);
		faceBookletFrame.setVisible(true);
		
		FaceBookletDatabase2.readFile();
		
		for(FaceBookletProfile prof: FaceBookletDatabase2.getGraph().keySet()) {
			faceBookletFrame.profileTextArea.append(prof.getName());
			faceBookletFrame.profileTextArea.append("\n");
		}	
	}
}
