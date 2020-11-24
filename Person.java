package com.poised.project;

/**
 * Poised Project Person Class
 * This class is the super class for type Person
 * @author Patrick Mutanho
 * @since version 1.00
 * @version 1, 11 Nov 2020
 */


public class Person  {
	
  //define attributes for the class
	private String telephoneNumber;
	private String name;
	private String emailAdrress;
    private String physicalAdrress;
	private String profession;
	
	
	/**
	 * @param telephoneNumber String object which is assigned a telephone number
	 * @param name String object which is assigned a Person objects' Name
	 * @param emailAdrress String object which is assigned a Person objects' emailaddress
	 * @param physicalAdrress String object which is assigned a Person objects'  physicalAdrress
	 * @param profession String object which is assigned a Person objects'  profession
	 * @since version 1.00
	 */
	public Person (String name, String telephoneNumber, 
		String emailAdrress, String physicalAdrress, String profession) {
		
		this.emailAdrress = emailAdrress;
		this.name = name;
		this.physicalAdrress = physicalAdrress;
		this.telephoneNumber = telephoneNumber;
		this.profession = profession;
		
		}
	
 
	/**
	 * <p>
	 * The set Name method
	 * @param personName It is the name of person	
	 * @since version 1.00
	 */
	public void setName (String personName) {
		 name = personName;
	}
	
	/**
	 * <p>
	 * The set profession method
	 * @param personProfession the person profession of person	
	 * @since version 1.00
	 */
	public void setProfession (String personProfession) {
		profession = personProfession;
	}
	
	/**
	 * <p>
	 * The get emailAdrress method
	 * @return emailAdrress returns the person's emailAdrress
	 * @since version 1.00
	 */
	public  String getEmailAdrress() {
		return emailAdrress;
	}


	/**
	 * <p>
	 * The set emailAdrress  method
	 * @param personEmailAdrress the person emailAdrress of a person	
	 * @since version 1.00
	 */
	public void setEmailAdrress(String personEmailAdrress) {
		emailAdrress = personEmailAdrress;
	}

	/**
	 * <p>
	 * The get physicalAdrress method
	 * @return physicalAdrress returns the person's emailAdrress
	 * @since version 1.00
	 */
	public String getPhysicalAdrress() {
		return physicalAdrress;
	}

	/**
	 * <p>
	 * The setphysicalAdrress  method
	 * @param physicalAdrr the person physicalAdrress of a person	
	 * @since version 1.00
	 */
	public void setPhysicalAdrress(String physicalAdrr) {
		physicalAdrr = physicalAdrress;
	}

	/**
	 * <p>
	 * The get person's name method
	 * @return name returns the person's name
	 * @since version 1.00
	 */
	public  String getName() {
		return name;
	}

	/**
	 * <p>
	 * The get person's telephoneNumber method
	 * @return telephoneNumber returns the person's telephoneNumber
	 * @since version 1.00
	 */
	public  String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * <p>
	 * The get person's profession method
	 * @return profession returns the person's profession
	 * @since version 1.00
	 */
	public  String getProfession() {
		return profession;
	}

	/**
	 * <p>
	 * The setPersonTelephone method
	 * @param personTelephone It is the person personTelephone of a person	
	 * @since version 1.00
	 */
	public void setTelephoneNumber (String personTelephone) {
		telephoneNumber = personTelephone;
	}
}

	
	
	
