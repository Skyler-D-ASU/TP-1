package guiSetOneTimePassword;

import database.Database;
/*******
 * <p> Title: ControllerSetOneTimePassword. </p>
 * 
 * <p>
 * Description: This class controls the Set One-Time Password functionality
 * available to administrators.
 * 
 * The administrator selects an existing user and assigns a one-time password
 * to that user's account. The one-time password temporarily replaces the
 * user's existing password. After the user successfully logs in using the
 * one-time password, the system requires the user to establish a new
 * password.
 *
 * The class has been written assuming that the View or the Model are the only class methods that
 * can invoke these methods.  This is why each has been declared as "protected".  Do not change any
 * of these methods to public.</p>
 * 
 * @author Nicholas Yeremin
 * 
 * @version 1.00		2026-09-14 Initial version
 */

public class ControllerSetOneTimePassword {

	//Default Constructor is not used.
	public ControllerSetOneTimePassword() {
	}
	
	//Reference to the database.
	private static Database theDatabase = applicationMain.FoundationsMain.database;
	
	protected static void doSelectUser() {
		ViewSetOneTimePassword.theSelectedUser =
				ViewSetOneTimePassword.combobox_SelectUser.getValue();
		
		if (ViewSetOneTimePassword.theSelectedUser == null) {
			return;
		}
		
		if (ViewSetOneTimePassword.theSelectedUser.compareTo("<Select a User>") == 0) {
			return;
		}
		
		theDatabase.getUserAccountDetails(ViewSetOneTimePassword.theSelectedUser);
	}
	
	protected static void performReturn() {
		guiAdminHome.ViewAdminHome.displayAdminHome(
				ViewSetOneTimePassword.theStage,
				ViewSetOneTimePassword.theUser);
	}
}
