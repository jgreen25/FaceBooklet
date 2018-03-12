import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class implements a GUI for the FaceBooklet application using
 * the swing framework.
 * @author jgree
 *
 */
public class FaceBookletGUI extends JFrame implements ActionListener {
	
	/**
	 * The button to be pushed when adding a profile.
	 */
	JButton addProfileButton;
	/**
	 * The button to be pushed when removing a profile.
	 */
	JButton removeProfileButton;
	/**
	 * The button to be pushed when searching for a profile.
	 */
	JButton searchProfilesButton;
	/**
	 * The text field that the name to be added, removed, or searched
	 * is put in.
	 */
	JTextField nameTextField;
	/**
	 * The text area that the current profiles are listed in.
	 */
	JTextArea profileTextArea;
	/**
	 * The window that appears when the program must inform the user of something.
	 */
	JOptionPane optionPane;
	/**
	 * When a profile is searched for, the name appears in this text field.
	 */
	JTextField profileInfoNameField;
	/**
	 * When a profile is searched for, the status appears in this text field.
	 */
	JTextField profileInfoStatusField;
	/**
	 * The button to be pushed when altering the information of a profile.
	 */
	JButton updateProfileButton;
	/**
	 * When a profile is being edited, typing a profile into this field and pressing
	 * update profile will add the profile to the other profile's friends list.
	 */
	JTextField profileInfoAddFriendField;
	/**
	 * When a profile is being edited, typing a profile into this field and pressing
	 * update profile will remove the profile from the other profile's friends list.
	 */
	JTextField profileInfoRemoveFriendField;
	/**
	 * This field displays the searched for profile's friends.
	 */
	JTextField profileInfoFriendsField;
	/**
	 * This field contains the picture file path for the profile's picture.
	 */
	JTextField profileInfoPicField;
	/**
	 * This temporary profile helps avoid errors when removing friends from a
	 * profile's friends list.
	 */
	FaceBookletProfile tempProfile;
	/**
	 * This label contains the picture of the searched for profile.
	 */
	JLabel picLabel;
	/**
	 * This button can be pressed when the user is confused, and instructions
	 * will appear.
	 */
	JButton helpButton;
	
	
	/**
	 * The constructor for the FaceBookletGUI class, it creates and adds components
	 * to a FaceBookletFrame which extends JFrame.
	 */
	public FaceBookletGUI() {
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints layoutConst1 = new GridBagConstraints();
		layoutConst1.gridx = 0;
		layoutConst1.gridy = 0;
		layoutConst1.insets = new Insets(0, 10, 10, 10);
		
		JLabel faceBookletLabel = new JLabel("FaceBooklet");
		Font font1 = new Font("Calibri", Font.BOLD, 14);
		faceBookletLabel.setFont(font1);
		this.add(faceBookletLabel, layoutConst1);
		
		GridBagConstraints layoutConst2 = new GridBagConstraints();
		layoutConst2.gridx = 4;
		layoutConst2.gridy = 0;
		
		JLabel profilesLabel = new JLabel("Profiles");
		Font font2 = new Font("Calibri", Font.PLAIN, 12);
		profilesLabel.setFont(font2);
		this.add(profilesLabel, layoutConst2);
		
		GridBagConstraints layoutConst7 = new GridBagConstraints();
		layoutConst7.gridx = 0;
		layoutConst7.gridy = 2;
		
		JLabel instructionsLabel1 = new JLabel("Enter profile name and click one");
		instructionsLabel1.setFont(font2);
		this.add(instructionsLabel1, layoutConst7);
		
		GridBagConstraints layoutConst8 = new GridBagConstraints();
		layoutConst8.gridx = 0;
		layoutConst8.gridy = 3;
		
		JLabel instructionsLabel2 = new JLabel("of the buttons to perform the desired action:");
		instructionsLabel2.setFont(font2);
		this.add(instructionsLabel2, layoutConst8);
		
		GridBagConstraints layoutConst3 = new GridBagConstraints();
		layoutConst3.gridx = 4;
		layoutConst3.gridy = 1;
		
		profileTextArea = new JTextArea(10, 20);
		profileTextArea.setEditable(false);
		JScrollPane profileScrollPane = new JScrollPane(profileTextArea,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(profileScrollPane, layoutConst3);
		
		GridBagConstraints layoutConst4 = new GridBagConstraints();
		layoutConst4.gridx = 0;
		layoutConst4.gridy = 7;
		
		addProfileButton = new JButton("Add Profile");
		addProfileButton.addActionListener(this);
		this.add(addProfileButton, layoutConst4);
		
		GridBagConstraints layoutConst5 = new GridBagConstraints();
		layoutConst5.gridx = 0;
		layoutConst5.gridy = 8;
		
		removeProfileButton = new JButton("Remove Profile");
		removeProfileButton.addActionListener(this);
		this.add(removeProfileButton, layoutConst5);
		
		GridBagConstraints layoutConst6 = new GridBagConstraints();
		layoutConst6.gridx = 0;
		layoutConst6.gridy = 9;
		
		searchProfilesButton = new JButton("Search Profiles");
		searchProfilesButton.addActionListener(this);
		this.add(searchProfilesButton, layoutConst6);
		
		GridBagConstraints layoutConst9 = new GridBagConstraints();
		layoutConst9.gridx = 0;
		layoutConst9.gridy = 6;
		layoutConst9.insets = new Insets(0, 0, 10, 0);
		layoutConst9.fill = GridBagConstraints.HORIZONTAL;
		
		nameTextField = new JTextField(20);
		nameTextField.setEditable(true);
		nameTextField.addActionListener(this);
		this.add(nameTextField, layoutConst9);
		
		GridBagConstraints layoutConst10 = new GridBagConstraints();
		layoutConst10.gridx = 0;
		layoutConst10.gridy = 5;
		layoutConst10.insets = new Insets(10, 0, 0, 0);
		
		JLabel nameLabel = new JLabel("Name:");
		Font font3 = new Font("Calibri", Font.BOLD, 12);
		nameLabel.setFont(font3);
		this.add(nameLabel, layoutConst10);
		
		GridBagConstraints layoutConst11 = new GridBagConstraints();
		layoutConst11.gridx = 4;
		layoutConst11.gridy = 4;
		layoutConst11.insets = new Insets(10, 10, 10, 10);
		
		profileInfoNameField = new JTextField(20);
		profileInfoNameField.setEditable(true);
		profileInfoNameField.addActionListener(this);
		this.add(profileInfoNameField, layoutConst11);
		
		GridBagConstraints layoutConst12 = new GridBagConstraints();
		layoutConst12.gridx = 4;
		layoutConst12.gridy = 6;
		layoutConst12.insets = new Insets(10, 10, 10, 10);
		
		profileInfoStatusField = new JTextField(30);
		profileInfoStatusField.setEditable(true);
		profileInfoStatusField.addActionListener(this);
		this.add(profileInfoStatusField, layoutConst12);
		
		GridBagConstraints layoutConst13 = new GridBagConstraints();
		layoutConst13.gridx = 4;
		layoutConst13.gridy = 15;
		layoutConst13.insets = new Insets(10, 10, 10, 10);
		
		updateProfileButton = new JButton("Update Profile");
		updateProfileButton.addActionListener(this);
		this.add(updateProfileButton, layoutConst13);
		
		GridBagConstraints layoutConst14 = new GridBagConstraints();
		layoutConst14.gridx = 4;
		layoutConst14.gridy = 3;
		
		JLabel profileInfoNameLabel = new JLabel("Name:");
		Font font4 = new Font("Calibri", Font.PLAIN, 12);
		profileInfoNameLabel.setFont(font4);
		this.add(profileInfoNameLabel, layoutConst14);
		
		GridBagConstraints layoutConst15 = new GridBagConstraints();
		layoutConst15.gridx = 4;
		layoutConst15.gridy = 5;
		
		JLabel profileInfoStatusLabel = new JLabel("Status:");
		profileInfoStatusLabel.setFont(font4);
		this.add(profileInfoStatusLabel, layoutConst15);
		
		GridBagConstraints layoutConst20 = new GridBagConstraints();
		layoutConst20.gridx = 4;
		layoutConst20.gridy = 7;
		
		JLabel profileInfoFriendsLabel = new JLabel("Friends:");
		profileInfoFriendsLabel.setFont(font4);
		this.add(profileInfoFriendsLabel, layoutConst20);
		
		GridBagConstraints layoutConst21 = new GridBagConstraints();
		layoutConst21.gridx = 4;
		layoutConst21.gridy = 8;
		
		profileInfoFriendsField = new JTextField(30);
		profileInfoFriendsField.setEditable(false);
		JScrollPane profileInfoFriendsFieldScroll = new JScrollPane(profileInfoFriendsField,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(profileInfoFriendsFieldScroll, layoutConst21);
		
		
		GridBagConstraints layoutConst16 = new GridBagConstraints();
		layoutConst16.gridx = 4;
		layoutConst16.gridy = 9;
		
		JLabel profileInfoAddFriendLabel = new JLabel("Add friend:");
		profileInfoAddFriendLabel.setFont(font4);
		this.add(profileInfoAddFriendLabel, layoutConst16);
		
		GridBagConstraints layoutConst17 = new GridBagConstraints();
		layoutConst17.gridx = 4;
		layoutConst17.gridy = 10;
		
		profileInfoAddFriendField = new JTextField(20);
		profileInfoAddFriendField.setEditable(true);
		this.add(profileInfoAddFriendField, layoutConst17);
		
		GridBagConstraints layoutConst18 = new GridBagConstraints();
		layoutConst18.gridx = 4;
		layoutConst18.gridy = 11;
		
		JLabel profileInfoRemoveFriendLabel = new JLabel("Remove friend:");
		profileInfoRemoveFriendLabel.setFont(font4);
		this.add(profileInfoRemoveFriendLabel, layoutConst18);
		
		GridBagConstraints layoutConst19 = new GridBagConstraints();
		layoutConst19.gridx = 4;
		layoutConst19.gridy = 12;
		
		profileInfoRemoveFriendField = new JTextField(20);
		profileInfoRemoveFriendField.setEditable(true);
		this.add(profileInfoRemoveFriendField, layoutConst19);
		
		GridBagConstraints layoutConst22 = new GridBagConstraints();
		layoutConst22.gridx = 0;
		layoutConst22.gridy = 1;
		
		picLabel = new JLabel();
		this.add(picLabel, layoutConst22);
		
		GridBagConstraints layoutConst23 = new GridBagConstraints();
		layoutConst23.gridx = 4;
		layoutConst23.gridy = 13;
		
		JLabel profileInfoPicLabel = new JLabel("Picture file path:");
		profileInfoPicLabel.setFont(font4);
		this.add(profileInfoPicLabel, layoutConst23);
		
		GridBagConstraints layoutConst24 = new GridBagConstraints();
		layoutConst24.gridx = 4;
		layoutConst24.gridy = 14;
		
		profileInfoPicField = new JTextField(20);
		profileInfoPicField.setEditable(true);
		this.add(profileInfoPicField, layoutConst24);
		
		GridBagConstraints layoutConst25 = new GridBagConstraints();
		layoutConst25.gridx = 0;
		layoutConst25.gridy = 15;
		
		helpButton = new JButton("?");
		helpButton.addActionListener(this);
		this.add(helpButton, layoutConst25);
		
	}
	
	/**
	 * This method is overwritten from the ActionListener interface. It allows
	 * the program to retrieve information about what is in text fields/ what
	 * buttons have been pushed in order to perform the correct actions.
	 * @param   the ActionEvent that has been performed by the user
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		
		JButton sourceEvent = (JButton) event.getSource();
		
		if(sourceEvent == addProfileButton) {
			FaceBookletProfile prof = new FaceBookletProfile(nameTextField.getText());
			FaceBookletDatabase2.addProfile(prof);
			
			profileTextArea.append(nameTextField.getText());
			profileTextArea.append("\n");
		    
		    JOptionPane.showMessageDialog(this, "Profile added.");   
		}
		else if(sourceEvent == removeProfileButton) {
			JOptionPane.showMessageDialog(this, "Hit remove profile button until profile disappears.");
			for(FaceBookletProfile prof: FaceBookletDatabase2.getGraph().keySet()) {
				if(prof.getName().equals(nameTextField.getText())) {
					tempProfile = prof;
					for(FaceBookletProfile prof2: FaceBookletDatabase2.getGraph().keySet()) {
						for(FaceBookletProfile prof3: prof2.getFriends()) {
							if(prof3.getName().equals(prof.getName())) {
								prof2.removeFriend(prof3);
							}
						}
					}
			FaceBookletDatabase2.removeProfile(tempProfile);
			profileTextArea.setText("");
			for(FaceBookletProfile prof2: FaceBookletDatabase2.getGraph().keySet()) {
			    profileTextArea.append(prof2.getName());
				profileTextArea.append("\n");
			}
			nameTextField.setText("");
			profileInfoFriendsField.setText("");
			profileInfoStatusField.setText("");
			profileInfoNameField.setText("");
				    
				        
				}
			}
			JOptionPane.showMessageDialog(this, "Profile removed.");
		}
		else if(sourceEvent == searchProfilesButton) {
			for(FaceBookletProfile prof: FaceBookletDatabase2.getGraph().keySet()) {
				if(prof.getName().equals(nameTextField.getText())) {
					profileInfoNameField.setText(prof.getName());
					profileInfoStatusField.setText(prof.getStatus());
					profileInfoAddFriendField.setText("");
					profileInfoRemoveFriendField.setText("");
					String friends = "";
					for(FaceBookletProfile prof2: prof.getFriends()) {
						friends = friends + prof2.getName() + ", ";
					}
					profileInfoFriendsField.setText(friends);
					profileInfoPicField.setText(prof.getPicPath());
					String path = prof.getPicPath();
					if(path != "") {
						ImageIcon pic = new ImageIcon(path);
						Image pic1 = pic.getImage(); 
						Image newimg = pic1.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); 
						pic = new ImageIcon(newimg);
						picLabel.setIcon(pic);
					}
					else {
						picLabel.setIcon(null);
						picLabel.revalidate();
					}
					return;
				}
		    }
			JOptionPane.showMessageDialog(this, "Profile does not exist.");
	    }
		else if(sourceEvent == updateProfileButton) {
			for(FaceBookletProfile prof: FaceBookletDatabase2.getGraph().keySet()) {
				if(prof.getName().equals(nameTextField.getText())) {
					prof.setName(profileInfoNameField.getText());
					prof.setStatus(profileInfoStatusField.getText());
					if(profileInfoAddFriendField.getText() != "") {
						for(FaceBookletProfile prof2: FaceBookletDatabase2.getGraph().keySet()) {
							if(prof2.getName().equals(profileInfoAddFriendField.getText())) {
								prof.addFriend(prof2);
								String friends = "";
								for(FaceBookletProfile prof3: prof.getFriends()) {
									friends = friends + prof3.getName() + ", ";
								}
								profileInfoFriendsField.setText(friends);
								
							}
						}
					}
					if(profileInfoRemoveFriendField.getText() != "") {
						for(FaceBookletProfile prof4: FaceBookletDatabase2.getGraph().keySet()) {
							if(prof4.getName().equals(profileInfoRemoveFriendField.getText())) {
								prof.removeFriend(prof4);
								String friends = "";
								for(FaceBookletProfile prof5: prof.getFriends()) {
									friends = friends + prof5.getName() + ", ";
								}
								profileInfoFriendsField.setText(friends);
							}
						}
					}
					if(profileInfoPicField.getText() != "") {
						String path = profileInfoPicField.getText();
						prof.setPicPath(path);
						ImageIcon pic = new ImageIcon(path);
						Image pic1 = pic.getImage(); 
						Image newimg = pic1.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); 
						pic = new ImageIcon(newimg);
						picLabel.setIcon(pic);
					}
					
					profileTextArea.setText("");
					for(FaceBookletProfile prof6: FaceBookletDatabase2.getGraph().keySet()) {
						profileTextArea.append(prof6.getName());
						profileTextArea.append("\n");
					}
					profileInfoAddFriendField.setText("");
					profileInfoRemoveFriendField.setText("");
					FaceBookletDatabase2.writeFile();
					JOptionPane.showMessageDialog(this, "Profile updated.");
					return;
				}
			}
			JOptionPane.showMessageDialog(this, "Make sure correct name is in bolded name field on left.");
		}
		else if(sourceEvent == helpButton) {
			JOptionPane.showMessageDialog(this, "Welcome to FaceBooklet. In order to add, " +
		        "remove, and search for profiles, type the desired name under the bolded " +
			    "name label.\nIf added, the name will show up in the list of profiles on the " +
		        "right. If removed, the profile will disappear from this list.\nIf searched " +
			    "for, the profile's information will show up in the text fields on the right." +
		        "\nThe profile's information can be altered by editing the fields and pressing" +
			    " the update profile button.");
		}
	}

}
