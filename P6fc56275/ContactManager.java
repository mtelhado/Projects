import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Miguel Telhado 56275
 *
 */

public class ContactManager {
	
	//the line separator
	private final String EOL = System.getProperty("line.separator");
	
	//the name of the manager of contacts
	private String managerName;
	//the the list of contacts by name
	private Map<String,Contact> nameContactList;
	//the list of contacts by phone
	private Map<String,Contact> phoneContactList;
	//a log of information
	private StringBuilder log = new StringBuilder();
	
	/**
	 * the constructor of this class
	 * 
	 * @param managerName the name of the manager
	 */
	
	public ContactManager(String managerName){
		this.managerName = managerName;
		nameContactList = new HashMap<String,Contact>();
		phoneContactList = new HashMap<String,Contact>();
	}
	
	/**
	 * a method that finds or creates a contact by name
	 * 
	 * @param contactName the name of the contact
	 * @return the contact
	 */
	
	public Contact contactByName(String contactName) {
		if(nameContactList.containsKey(contactName)) {
			return nameContactList.get(contactName);
		}else {
			Contact newContact = new Contact(contactName,null,null,null,null);
			nameContactList.put(contactName, newContact);
			log.append("New contact created: " + contactName);
			log.append(EOL);
			return newContact;
		}
	}
	
	/**
	 * a method that finds or creates a contact by phone number
	 * 
	 * @param phoneNumber
	 * @return
	 */
	
	public Contact contactByPhone(String phoneNumber) {
		if(phoneContactList.containsKey(phoneNumber)) {
			return phoneContactList.get(phoneNumber);
		}else {
			Contact newContact = new Contact(null,phoneNumber,null,null,null);
			phoneContactList.put(phoneNumber, newContact);
			log.append("New contact created: " + phoneNumber);
			log.append(EOL);
			return newContact;
		}
	}
	
	/**
	 * a method that edits the name of a contact
	 * 
	 * @param contactKey the key of the contact
	 * @param newName the new name of this contact
	 * @return if the contact exist and if there isn't a contact who's name is newName
	 */
	
	public boolean editContactName(String contactKey, String newName) {
		
		Contact contact;
		
		if(nameContactList.containsKey(contactKey)) {
			contact = nameContactList.get(contactKey);
			if(contact.getName().equals(newName)) {
				return false;
			}else {
				contact.setName(newName);
				return true;
			}
		}else if(phoneContactList.containsKey(contactKey)) {
			contact = phoneContactList.get(contactKey);
			contact.setName(newName);
			nameContactList.put(contactKey, contact);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * a method that edits a phone number of a contact
	 * 
	 * @param contactKey the key of the contact
	 * @param newPhone the new phone number
	 * @param oldPhone the old phone number
	 * @return if the contact exists and there isn't a contact who has the phone number newPhone
	 */
	
	public boolean editContactPhone(String contactKey, String newPhone, String oldPhone) {
		
		Contact contact;
		
		if(nameContactList.containsKey(contactKey)) {
			contact = nameContactList.get(contactKey);
			
			if(contact.getPhones().contains(newPhone)) {
				return false;
			}else {
				if(oldPhone == null) {
					contact.addPhone(newPhone);
					phoneContactList.put(contactKey, contact);
					return true;
				}else {
					for(String phone : contact.getPhones()) {
						if(phone.equals(oldPhone)) {
							phone = newPhone;
						}
					}
					contact.upDatePhone(oldPhone, newPhone);
					return true;
				}
			}
		}else if(phoneContactList.containsKey(contactKey)) {
			contact = phoneContactList.get(contactKey);
			
			if(contact.getPhones().contains(newPhone)) {
				return false;
			}else {
				if(oldPhone == null) {
					contact.addPhone(newPhone);
					return true;
				}else {
					for(String phone : contact.getPhones()) {
						if(phone.equals(oldPhone)) {
							phone = newPhone;
						}
					}				
					contact.upDatePhone(oldPhone, newPhone);
					return true;
				}
			}
		}else {
			return false;
		}
		
	}
	
	/**
	 * a method that adds or edits the additional information of a contact
	 * 
	 * @param contactKey the key of the contact
	 * @param address the address
	 * @param email the email
	 * @param date the date
	 * @return if the contact exists
	 */
	
	public boolean editContactOptionalInfo(String contactKey, String address, String email, LocalDate date) {
		Contact contact;
		
		if(nameContactList.containsKey(contactKey)) {
			contact = nameContactList.get(contactKey);
			
			if(address != null) {
				contact.setAddress(address);
			}
			
			if(email != null) {
				contact.setEmail(email);
			}
			
			if(date != null) {
				contact.setDate(date);
			}
			
			return true;
		}else if(phoneContactList.containsKey(contactKey)) {
			contact = phoneContactList.get(contactKey);
			
			if(address != null) {
				contact.setAddress(address);
			}
			
			if(email != null) {
				contact.setEmail(email);
			}
			
			if(date != null) {
				contact.setDate(date);
			}
			
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * a method that finds the name of a contact by phone number
	 * 
	 * @param phone the phone number
	 * @return the contact name or null if the phone number doesn't exist or doesn't have a associated name
	 */
	
	public String getNameFromPhone(String phone) {
		
		Contact contact;
		
		if(phoneContactList.containsKey(phone)) {
			contact = phoneContactList.get(phone);
			if(contact.getName() != null) {
				return contact.getName();
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	
	/**
	 * a method that finds the phone number of a contact by name
	 * 
	 * @param name the name 
	 * @return the contact phone number or null if the name doesn't exist or doesn't have a associated phone number
	 */
	
	public String getPhoneFromName(String name) {
		
		Contact contact;
		
		if(nameContactList.containsKey(name)) {
			contact = nameContactList.get(name);
			if(contact.getPhone() != null) {
				return contact.getPhone();
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	
	/**
	 * a method that returns the contact information in text form
	 * 
	 * @param contactKey the key of the contact
	 * @return the contact info or null if contact doesn't exist
	 */
	
	public String getInfo(String contactKey) {
		if(nameContactList.containsKey(contactKey)) {
			return nameContactList.get(contactKey).toString();
		}else if(phoneContactList.containsKey(contactKey)) {
			return phoneContactList.get(contactKey).toString();
		}else {
			return null;
		}
	}
	
	/**
	 * a method that removes a contact from the two tables
	 * 
	 * @param contactKey the key of the contact
	 */
	
	public void remove (String contactKey) {
		nameContactList.remove(contactKey);
		phoneContactList.remove(contactKey);
	}
	
	/**
	 * a method that gets the log of info
	 * 
	 * @return the log
	 */
	
	public String getLog() {
		return log.toString();
	}
	
	/**
	 * a method that returns the name of the manager of the contacts
	 * 
	 * @return the name of the manager
	 */

	public String getManagerName() {
		return this.managerName;
	}
	
}
