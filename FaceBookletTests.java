import junit.framework.*;

/**
 * The FaceBookletTests class uses the junit framework in order to test
 * the methods that return a value in the FaceBookletProfile class.
 * It extends TestCase, and thus overrides the setUp and tearDown methods.
 * @author jgree
 *
 */
public class FaceBookletTests extends TestCase {
	
	/**
	 * These FaceBookletProfile objects are what the tests are run on.
	 */
	FaceBookletProfile prof1;
	FaceBookletProfile prof2;
	FaceBookletProfile prof3;
	FaceBookletProfile prof4;
	FaceBookletProfile prof5;
	
	/**
	 * This method sets up the FaceBookletProfile objects that are to
	 * be used in the tests. This is called before every test method is
	 * executed.
	 */
	@Override
	public void setUp() {
		prof1 = new FaceBookletProfile("Jack Green");
		prof2 = new FaceBookletProfile("Teddy Bruschi");
		prof3 = new FaceBookletProfile("");
		prof4 = new FaceBookletProfile("X Y Z");
		prof5 = new FaceBookletProfile("Todd Graham");
		prof1.setStatus("Hi");
		prof2.setStatus("Cooking in the kitchen.");
		prof3.setStatus("Raining cats and dogs");
		prof4.setStatus("My name Jeff.");
		prof5.setStatus("");
		prof2.addFriend(prof5);
		prof3.addFriend(prof5);
		prof3.addFriend(prof4);
		prof4.addFriend(prof3);
		prof4.addFriend(prof5);
		prof5.addFriend(prof2);
		prof5.addFriend(prof3);
		prof5.addFriend(prof4);
	}
	
	/**
	 * This method tears down each FaceBookletProfile object that
	 * was created in the set up method. It is run after every test
	 * method is executed.
	 */
	@Override
	public void tearDown() {
		prof1 = null;
		prof2 = null;
		prof3 = null;
		prof4 = null;
		prof5 = null;
	}
	
	/**
	 * This method tests the getName() method within the FaceBookletProfiles
	 * class using the junit framework.
	 */
	public void testGetName() {
		assertEquals("Jack Green", prof1.getName());
		assertEquals("Teddy Bruschi", prof2.getName());
		assertEquals("", prof3.getName());
		assertEquals("X Y Z", prof4.getName());
		assertEquals("Todd Graham", prof5.getName());
	}
	
	/**
	 * This method tests the getStatus() method within the FaceBookletProfiles
	 * class using the junit framework.
	 */
	public void testGetStatus() {
		assertEquals("Hi", prof1.getStatus());
		assertEquals("Cooking in the kitchen.", prof2.getStatus());
		assertEquals("Raining cats and dogs", prof3.getStatus());
		assertEquals("My name Jeff.", prof4.getStatus());
		assertEquals("", prof5.getStatus());
	}
	
	/**
	 * This method tests the getID() method within the FaceBookletProfiles
	 * class using the junit framework.
	 */
	public void testGetID() {
		assertEquals(1, prof1.getID());
		assertEquals(2, prof2.getID());
		assertEquals(3, prof3.getID());
		assertEquals(4, prof4.getID());
		assertEquals(5, prof5.getID());
	}
}
