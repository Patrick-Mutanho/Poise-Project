package com.poised.project;

/**
 * Poised Project Project Class
 * This class is the super class for type Project
 * @author Patrick Mutanho
 * @since version 1.00
 * @version 1, 11 Nov 2020
 */



public  class Project  {
	
	
	private double projectNumber, erfNumber;
	private double chargeFee;
	private double amountDue;
	private double amountPaid;
	private String projectName, buildingType;
	String completeDate;
	private String deadlineDate;
	private String siteAdrress, startDate ;
	private String projectStatus;
	private Person client;
	private Person architect;
	private Person contractor;
	
	
	
	/**
	    * @param projectNumber double object which is assigned a projectNumber
	    * @param chargeFee object which is assigned a Person objects' chargeFee
	    * @param amountDue object which is assigned a Person objects' amountDue
	    * @param amountPaid object which is assigned a Person objects' amountDue
	    * @param erfNumber object which is assigned a Person objects'  erfNumber
	    * @param projectName  object which is assigned a Person objects'  profession
	    * @param buildingType object which is assigned a Person objects' buildingType
	    * @param completeDate  object which is assigned a Person objects' completeDate
	    * @param deadlineDate object which is assigned a Person objects' deadlineDate
	    * @param siteAdrress object which is assigned a Person objects'  siteAdrress
	    * @param startDate  object which is assigned a Person objects'  startDate
	    * @param projectStatus  object which is assigned a Person objects' projectStatus
	    * @param client  object which is assigned a Person objects'  client
	    * @param contractor object which is assigned a Person objects' contractor
	    * @param architect object which is assigned a Person objects' architect
	    * @since version 1.00
	    */
	//Class constructor
	public Project(double projectNumber, double erfNumber,
			double chargeFee, double amountDue, double  amountPaid,
			String projectName,String buildingType, 
			String siteAdrress, String startDate, 
			String completeDate, String deadlineDate,String projectStatus,
			Person client,Person architect,Person contractor) {
      
		this.amountDue = amountDue;
		this.buildingType = buildingType;
		this.chargeFee = chargeFee;
		this.completeDate = completeDate;
		this.deadlineDate = deadlineDate;
		this.erfNumber = erfNumber;
		this.projectName = projectName;
		this.projectNumber = projectNumber ;
		this.siteAdrress = siteAdrress;
		this.startDate = startDate;
		this.amountPaid = amountPaid;
		this.projectStatus  = projectStatus;
		this.client =client;
		this.architect =architect;
		this.contractor = contractor;
	
	}
	
	
	/**
	 * <p>
	 * The set projectName method
	 * @param name name of project	
	 * @since version 1.00
	 */
	public void setProjectName (String name) {
		projectName = name;
	}
	 
	/**
	 * <p>
	 * The set buildType method
	 * @param buildType describes the building	
	 * @since version 1.00
	 */
	public void setBuildingType (String buildType) {
		buildingType = buildType;
	}
	
	
	/**
	 * <p>
	 * The set adressSite method
	 * @param  adressSite details of the physical address of the site	
	 * @since version 1.00
	 */
	public void setSiteAdress (String adressSite) {
		siteAdrress = adressSite;
	}
	
	
	/**
	 * <p>
	 * The set projectStartDate method
	 * @param  projectStartDate details of start dat for the project
	 * @since version 1.00
	 */
	public void setStartDate (String projectStartDate) {
	    startDate = projectStartDate;	
	}

	/**
	 * <p>
	 * The set projectCompleteDate method
	 * @param  projectCompleteDate details of complete date for the project
	 * @since version 1.00
	 */
	public void setCompleteDate (String projectCompleteDate) {
		completeDate = projectCompleteDate;
	}
	
	
	/**
	 * <p>
	 * The set projectDeadlineDate method
	 * @param  projectDeadlineDate details of complete date for the project
	 * @since version 1.00
	 */
	public  void setDeadlineDate (String projectDeadlineDate) {
		deadlineDate = projectDeadlineDate;
	}
	
	/**
	 * <p>
	 * The set ProjectId method
	 * @param ProjectId the number of the project respective of the total number of projects
	 * @since version 1.00
	 */
	public void setProjectNumber (int ProjectId) {
		projectNumber = ProjectId;
	}
	
 
	/**
	 * <p>
	 * The set erfNumb method
	 * @param erfNumb It is the erfNumber number of the project respective of the total number of projects
	 * @since version 1.00
	 */
	public void setErfNumber (int erfNumb) {
		erfNumber = erfNumb;
	}
	
	/**
	 * <p>
	 * The set chargedFee method
	 * @param chargedFee It is the chargeFee for doing the project
	 * @since version 1.00
	 */
	public void setChargeFee (double chargedFee) {
		chargeFee = chargedFee;
	}
	
	
	/**
	 * <p>
	 * The set setAmountPaid method
	 * @param paidAmount It is the paidAmount by the client thus far for doing the project
	 * @since version 1.00
	 */
	public  void setAmountPaid(double paidAmount) {
		 amountPaid = paidAmount;
  }
	
	/**
	 * <p>
	 * The set projectStatus method
	 * @param projectStatus1 It is the current status of the project whether its completed or not
	 * @since version 1.00
	 */
	public void setProjectStatus(String projectStatus1) {
		projectStatus = projectStatus1;
		
	}

	/**
	 * <p>
	 * The get  projectNumber method
	 * @return projectNumber returns the project number
	 * @since version 1.00
	 */
	public double getProjectNumber() {
		return projectNumber;
	}
  
	/**
	 * <p>
	 * The get getErfNumber method
	 * @return getErfNumber returns the erfNumber
	 * @since version 1.00
	 */
	
	public double getErfNumber() {
		return erfNumber;
	}

	
	/**
	 * <p>
	 * The get amountDue method
	 * @return amountDue returns the amountDue
	 * @since version 1.00
	 */
	public double getAmountDue() {
		return amountDue;
	}

	/**
	 * <p>
	 * The get deadlineDate method
	 * @return deadlineDate returns the deadlineDate
	 * @since version 1.00
	 */
	
	public String getDeadline() {
		return deadlineDate;
	}

	/**
	 * <p>
	 * The get siteAdrress method
	 * @return siteAdrressreturns the siteAdrress
	 * @since version 1.00
	 */
	public String getSiteAdrress() {
		return siteAdrress;
	}

	/**
	 * <p>
	 * The get projectStatus method
	 * @return projectStatus returns the projectStatus
	 * @since version 1.00
	 */
	public String getProjectStatus() {
		return projectStatus;
	}
	
	
	/**
	 * <p>
	 * The get chargeFee method
	 * @return chargeFee returns the chargeFee
	 * @since version 1.00
	 */
	public double getChargeFee() {
		return chargeFee;
	}

	/**
	 * <p>
	 * The get amountPaid method
	 * @return amountPaid returns the amountPaid
	 * @since version 1.00
	 */
	public  double getAmountPaid() {
		return amountPaid;
	}

	/**
	 * <p>
	 * The get ProjectName method
	 * @return ProjectName returns the ProjectName
	 * @since version 1.00
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * <p>
	 * The get buildingType method
	 * @return buildingType returns the buildingType
	 * @since version 1.00
	 */
	public String getBuildingType() {
		return buildingType;
	}

	
	/**
	 * <p>
	 * The get completeDate method
	 * @return completeDate returns the completeDate
	 * @since version 1.00
	 */
	public String getCompleteDate() {
		return completeDate;
	}

	/**
	 * <p>
	 * The get startDate method
	 * @return startDate returns the startDate
	 * @since version 1.00
	 */
	public String getStartDate() {
		return startDate;
	}
	
	
	/**
	 * <p>
	 * The set client method
	 * @param personclient  It is client object
	 * @since version 1.00
	 */
	public void setClient (Person personclient) {
		client = personclient;
	}
	
	/**
	 * <p>
	 * The set architect method
	 * @param personArchitect It is It is architect object
	 * @since version 1.00
	 */
	public void setArchitect (Person personArchitect) {
		architect = personArchitect;
	}
	
	
	/**
	 * <p>
	 * The set contractor method
	 * @param personContractor It is It is architect object
	 * @since version 1.00
	 */
	public void setContractor (Person personContractor) {
		contractor = personContractor;
	}
	
	/**
	 * <p>
	 * The get client method
	 * @return client returns the client
	 * @since version 1.00
	 */
	public Person getClient() {
		return client;
	}
	
	/**
	 * <p>
	 * The get architect method
	 * @return architect returns the architect
	 * @since version 1.00
	 */
	public Person getArchitect() {
		return architect;
	}
	
	/**
	 * <p>
	 * The get contractor method
	 * @return contractor returns the contractor
	 * @since version 1.00
	 */
	public Person getContractor() {
		return contractor;
	}
	
}
