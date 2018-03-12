import java.util.ArrayList;

/**
 * FaceBookletNode is an abstract class that outlines the methods
 * for different types of nodes that could be created on FaceBooklet.
 * For example, profiles, groups, communities would all implement
 * these methods.
 * @author jgree
 *
 */
public abstract class FaceBookletNode {
	
	public abstract String getName();
	public abstract void setName(String name);
	public abstract String getStatus();
	public abstract void setStatus(String status);
	public abstract void addFriend(FaceBookletProfile friend);
	public abstract void removeFriend(FaceBookletProfile friend);
	public abstract ArrayList<FaceBookletProfile> getFriends();
	public abstract int getID();
	public abstract void setID(int x);
	public abstract String getPicPath();
	public abstract void setPicPath(String path);
}