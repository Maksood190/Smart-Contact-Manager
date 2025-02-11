package com.csm.backend.scm_backend.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//import org.springframework.data.repository.query.parser.Part.IgnoreCaseType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


// This is Entity class and its represent database table   

@Entity
@Table(name="users")   // Its used for customize our table(means @Table used to change the table name)
public class User {

	@Id               // @Id → Marks the id field as the primary key.
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column( nullable = false)              // Ensures this column cannot be null
	@NotBlank(message="user is required")  // Ensures the value is not empty or blank
	private String name;
	
	@NotBlank(message = "Email is required")  //@NotBlank → Email cannot be empty
    @Email(message = "Invalid email format")  //@Email → Ensures the email is in a valid format (e.g., user@example.com).
	private String email;
	 
	@NotBlank(message = "Password is required")     //@NotBlank → Password cannot be empty.
    @Size(min = 8, message = "Password must be at least 8 characters long")  //@Size(min = 8) → Ensures the password has at least 8 characters.
	private String password;
	
	@Lob                  // Allows storing large text content
	private String about;
	@Column(length = 1000)
	private String profilePicture;
	@Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
	private String phoneNumber;
	private boolean enabled=false;        //Indicates if the user is active (true = active, false = inactive).
	private boolean eamilVerified=true;  //emailVerified → true if email verification is completed.
	private boolean phoneVerified=false;  //phoneVerified → true if phone verification is completed.
	
		

@Enumerated(value = EnumType.STRING)
// SELF GOOGLE , FACEBOOK, TWITTER, GITHUB, LINKDIN
private Providers provider=Providers.SELF;   //provider → Indicates whether the user signed up using Google, Facebook, Twitter, etc.
private String providerUserId;              //providerUserId → Stores the unique ID assigned by the provider (e.g., Google user ID)
private String emailToken;              //  Stores a token used for email verification (sent to the user via email).



//linkedHashSet i am using becouse i want to order maintain of the contact
//OneToMany thats means  one contact can have only one users  can not used one contact multiple users  
@OneToMany(mappedBy="user",fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
               // One User can have multiple contacts.
               //fetch = FetchType.LAZY → Contacts are loaded only when needed (improves performance).
               // cascade = CascadeType.ALL → Any change in User (create/update/delete) reflects in Contact
               //orphanRemoval = true → If a contact is removed from the contacts set, it is deleted from the database.
  
@JsonManagedReference
private Set<Contact> contacts=new LinkedHashSet<>();  //LinkedHashSet<> → Maintains the order of contacts while ensuring uniqueness.


public User() {
	// TODO Auto-generated constructor stub
}


public User(String id, String name, String email, String password, String about, String profilePicture,
		String phoneNumber, boolean enabled, boolean eamilVerified, boolean phoneVerified, Providers provider,
		String providerUserId, String emailToken, Set<Contact> contacts) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.about = about;
	this.profilePicture = profilePicture;
	this.phoneNumber = phoneNumber;
	this.enabled = enabled;
	this.eamilVerified = eamilVerified;
	this.phoneVerified = phoneVerified;
	this.provider = provider;
	this.providerUserId = providerUserId;
	this.emailToken = emailToken;
	this.contacts = contacts;
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getAbout() {
	return about;
}


public void setAbout(String about) {
	this.about = about;
}


public String getProfilePicture() {
	return profilePicture;
}


public void setProfilePicture(String profilePicture) {
	this.profilePicture = profilePicture;
}


public String getPhoneNumber() {
	return phoneNumber;
}


public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}


public boolean isEnabled() {
	return enabled;
}


public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}


public boolean isEamilVerified() {
	return eamilVerified;
}


public void setEamilVerified(boolean eamilVerified) {
	this.eamilVerified = eamilVerified;
}


public boolean isPhoneVerified() {
	return phoneVerified;
}


public void setPhoneVerified(boolean phoneVerified) {
	this.phoneVerified = phoneVerified;
}


public Providers getProvider() {
	return provider;
}


public void setProvider(Providers provider) {
	this.provider = provider;
}


public String getProviderUserId() {
	return providerUserId;
}


public void setProviderUserId(String providerUserId) {
	this.providerUserId = providerUserId;
}


public String getEmailToken() {
	return emailToken;
}


public void setEmailToken(String emailToken) {
	this.emailToken = emailToken;
}


public Set<Contact> getContacts() {
	return contacts;
}


public void setContacts(Set<Contact> contacts) {
	this.contacts = contacts;
}



	
}
