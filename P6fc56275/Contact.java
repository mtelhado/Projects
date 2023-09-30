package P6fc56275;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Miguel Telhado 56275
 *
 */

public class Contact {
	
	//the line separator
	private final String EOL = System.getProperty("line.separator");
	
	//the name of the contact
	private String name;
	//the phone numbers for this contact
	private List<String> phoneNumbers;
	//the address for this contact
	private String address;
	//the email for this contact
	private String email;
	//the date of this contact
	private LocalDate date;

	/**
	 * the constructor for this class
	 * 
	 * @param name the name of this contact
	 * @param phoneNumber the phone numbers of this contact
	 * @param address the address for this contact
	 * @param email the email for this this contact
	 * @param date the date of this contact
	 */
	
	public Contact(String name,String phoneNumber , String address , String email , LocalDate date) {
		this.name = name;
		
		this.phoneNumbers = new ArrayList<String>();
		if(phoneNumber != null) {
			phoneNumbers.add(phoneNumber);
		}
		
		this.address = address;
		this.email = email;
		this.date = date;
	}
	
	/**
	 * a method to obtain the name of the contact
	 * 
	 * @return the name of this contact
	 */
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * a method to obtain the phone numbers of this contact
	 * 
	 * @return the phone numbers of this contact
	 */
	
	public List<String> getPhones(){
		return this.phoneNumbers;
	}
	
	/**
	 * the method to obtain the first phone number associated with this contact
	 * 
	 * @return the first phone number associated this contact
	 */
	
	public String getPhone() {
		if(this.phoneNumbers.isEmpty()) {
			return null;
		}else {
			return this.phoneNumbers.get(0);
		}
	}
	
	/**
	 * a method to obtain the address of this contact
	 * 
	 * @return the address of this contact
	 */
	
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * a method to obtain the email of this contact
	 * 
	 * @return the email of this contact
	 */
	
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * a method to obtain the date of this contact
	 * 
	 * @return the date of this contact
	 */
	
	public LocalDate getDate() {
		return this.date;
	}
	
	/**
	 * a method to change the name of the contact 
	 * 
	 * @param newName the new name for the contact
	 */
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
	 * a method to change the address the contact
	 * 
	 * @param newAddress the new address for the contact
	 */
	
	public void setAddress(String newAddress) {
		this.address = newAddress;
	}
	
	/**
	 * a method to change the email of the contact
	 * 
	 * @param newEmail the new email of the contact
	 */
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	/**
	 * a method to change the date of the contact
	 * 
	 * @param newDate the new date for this contact
	 */
	
	public void setDate(LocalDate newDate) {
		this.date = newDate;
	}
	
	/**
	 * a method that obtains a copy of the contact
	 * 
	 * @return this copy of this contact
	 */
	
	public Contact copy() {
		Contact copy = new Contact(getName() , getPhone() , getAddress() , getEmail() , getDate());
		
		for(int i = 1 ; i < getPhones().size() ; i++) {
			copy.addPhone(getPhones().get(i));
		}
		
		return copy;
	}
	
	/**
	 * a method to add a new phone number associated with this contact
	 * 
	 * @param newNumber the phone number to add
	 */
	
	public void addPhone(String newNumber) {
		phoneNumbers.add(newNumber);
	}
	
	/**
	 * a method that returns a textual representation for the contact
	 */
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Contact: ");
		sb.append(EOL);
		
		sb.append("name = ");
		if(getName() == null) {
			sb.append("None");
		}else {
			sb.append(getName());
		}
		sb.append(EOL);
		
		sb.append("phones = ");
		if(getPhones().isEmpty()) {
			sb.append("None");
		}else {
			for(String number : getPhones()) {
				sb.append(number);
				sb.append(",");
			}
		}
		sb.append(EOL);
		
		sb.append("address = ");
		if(getAddress() == null) {
			sb.append("None");
		}else {
			sb.append(getAddress());
		}
		sb.append(EOL);
		
		sb.append("email = ");
		if(getEmail() == null) {
			sb.append("None");
		}else {
			sb.append(getEmail());
		}
		sb.append(EOL);
		
		sb.append("date = ");
		if(getDate() == null) {
			sb.append("None");
		}else {
			sb.append(getDate().toString());
		};
		sb.append(EOL);
		
		return sb.toString();
	}
	
	/**
	 * a method that changes a number of a contact
	 * 
	 * @param knownNumber the number that is supposed to be changed
	 * @param updatedNumber the new number
	 */
	
	public void upDatePhone(String knownNumber,String updatedNumber) {
		if(getPhones().contains(knownNumber)) {
			for(int i = 0 ; i < getPhones().size() ; i++) {
				if(getPhones().get(i).equals(knownNumber)) {
					getPhones().set(i, updatedNumber);
				}
			}
		}
	}
}





