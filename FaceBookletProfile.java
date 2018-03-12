import java.util.ArrayList;

/**
 * FaceBookletProfile class creates the ability to create a profile by
 * initializing a FaceBookletProfile object. It has fields that allow
 * the profile to contain specific information about the user, as well
 * as appropriate setter and getter methods.
 * @author jgree
 *
 */
public class FaceBookletProfile extends FaceBookletNode {
	
	/**
	 * The counter field is incremented every time a profile is created.
	 * It is used to assign profiles unique IDs.
	 */
	private static int counter;
	/**
	 * The ID field's value is determined by the counter field's value
	 * at the time that a profile is created. The ID is a way to
	 * identify the profile.
	 */
	private int ID;
	/**
	 * The picPath field is what determines the picture associated with the profile.
	 */
	private String picPath;
	/**
	 * The name field is the name of the person who the profile belongs to.
	 */
	private String name;
	/**
	 * The status field's value is what the profile's owner wants to express.
	 */
	private String status;
	/**
	 * The temp field is used in the removeFriend method in order to keep track of
	 * the appropriate profile to delete. It helps to avoid errors associates with
	 * simultaneous edits of a container.
	 */
	private int temp;
	/**
	 * The friendsList field is the ArrayList which the profiles' friends are stored in.
	 */
	private ArrayList<FaceBookletProfile> friendsList = new ArrayList<FaceBookletProfile>();
	
	/**
	 * FaceBookletProfile's constructor, it sets the name associated
	 * with the profile, as well as assigns each profile a unique ID
	 * using a static counter.
	 * @param name    the String that the name field is assigned
	 */
	public FaceBookletProfile(String name) {
		counter += 1;
		this.ID = counter;
		this.name = name;
	}
	
	/**
	 * This method allows the program to obtain the name
	 * associated with a specific profile.
	 * @return   the name field of the profile
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * Allows the program to set the name associated with
	 * a specific profile.
	 * @param name    the String that the name field is assigned
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method allows the program to access the status
	 * associated with the profile.
	 * @return   the status field of the profile
	 */
	@Override
	public String getStatus() {
		return status;
	}
	
	/**
	 * Allows the program to set the status associated with
	 * a specific profile.
	 * @param status    the String that the status field is assigned
	 */
	@Override
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * This method allows the program to add a friend in the
	 * form of a FaceBookletProfile object to another FaceBookletProfile's
	 * friends list, which is an ArrayList. Does not add if the profile
	 * is already in the friends list. The reciprocal is also performed.
	 * @param friend   the FaceBookletProfile that is to be added to the friends list
	 */
	@Override
	public void addFriend(FaceBookletProfile friend) {
		for(FaceBookletProfile prof: this.getFriends()) {
			if(prof.equals(friend)) {
				return;
			}
		}
		this.friendsList.add(friend);
		friend.friendsList.add(this);
	}
	
	/**
	 * This method allows removal of a friend from a friends list.
	 * The friend's list is also updated.
	 * @param   the FaceBookletProfile that is to be removed from the friends list
	 */
	@Override
	public void removeFriend(FaceBookletProfile friend) {
		for(int i = 0; i < this.getFriends().size(); i++) {
			if(this.getFriends().get(i).getName().equals(friend.getName())) {
				temp = i;
				break;
			}
		}
		if(temp < this.getFriends().size()) {
			int ind = this.friendsList.indexOf(friend);
			this.friendsList.get(ind).friendsList.remove(this);
			this.friendsList.remove(temp);
			
		}
	}
	
	/**
	 * This method allows the program to retrieve the friends list
	 * associated with a specific profile.
	 * @return   the ArrayList of friends of the profile
	 */
	@Override
	public ArrayList<FaceBookletProfile> getFriends() {
		return friendsList;
	}
	
	/**
	 * This method allows the program to retrieve the ID
	 * associated with a specific profile.
	 * @return   the ID of the profile
	 */
	@Override
	public int getID() {
		return ID;
	}
	
	/**
	 * This method allows the retrieval of the current value of
	 * the counter field.
	 * @return    the counter value
	 */
	public static int getCounter() {
		return counter;
	}
	
	/**
	 * This method sets the value of the counter, which keeps track
	 * of how many FaceBookeltProfile objects have been created. This
	 * is necessary because when the program is fired up, it must
	 * remember the previous counter value and the counter must be
	 * set to that previous value.
	 * @param count   the int that the counter field is set to
	 */
	public static void setCounter(int count) {
		counter = count;
	}
	
	/**
     *This method allows the program to set the ID field for a profile.
     *This is useful for restoring data in between runs of the program.
     *@param   the int value that the ID field is set to
	 */
	@Override
	public void setID(int x) {
		ID = x;
	}
	
	/**
	 * This method allows the program to set the picPath field
	 * for a profile, specifically when one is input into the corresponding
	 * field in the GUI.
	 * @param   the String that the picPath field is set to
	 */
	@Override
	public void setPicPath(String path) {
		this.picPath = path;
	}
	
	/**
	 * This method allows the program to retrieve the picPath field
	 * of a specific profile.
	 * @return   the picPath field value of the profile
	 */
	@Override
	public String getPicPath() {
		return picPath;
	}
}