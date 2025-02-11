package com.csm.backend.scm_backend.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity                                // Marks this class it maps to a table in the database
@Table(name="user_contacts")          // Customize the table name 
public class Contact {

	

@Id                                 //@Id → Marks id as the primary key of the entity.
@GeneratedValue(strategy = GenerationType.UUID)
private String id;

@NotBlank(message = "Name is required")                           // @NotBlank → Ensures that the name field is not empty or null.
@Size(max = 100, message = "Name cannot exceed 100 characters")    //@Size(max = 100) → Restricts the name length to a maximum of 100 characters.
private String name;

@NotBlank(message = "Email is required")                           //@NotBlank → The email field cannot be empty.
@Email(message = "Invalid email format")                //@Email → Ensures that the email is in a valid format (e.g., user@example.com).
private String email;

@NotBlank(message = "Phone number is required")                //@NotBlank → Phone number cannot be empty.
@Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")  //@Pattern(regexp = "\\d{10}") → Ensures that the phone number contains exactly 10 digits.
private String phoneNumber;

@Size(max = 500, message = "Address cannot exceed 500 characters")
private String address;
@Column(length = 1000)
private String picture;

@Lob                                             // @Lob → Specifies this field can store large amounts of text (CLOB).
@NotBlank(message = "Description  is required")
private String description;
private boolean favorite=false;

@Size(max = 500, message = "Website link cannot exceed 500 characters")
@Pattern(regexp = "https?://[\\w.-]+(?:\\.[\\w.-]+)+(?:/.*)?",               //@Pattern(...) → Validates that the input is a properly formatted website URL.
message = "Invalid website link format")
private String websiteLink;

@Size(max = 500, message = "linkedIn Link cannot exceed 500 characters")
@Pattern(regexp = "https?://(www\\.)?linkedin\\.com/.*", 
message = "Invalid LinkedIn link format")
private String linkedInLink;

@Size(max = 500, message = "instagram Link cannot exceed 500 characters")
@Pattern(regexp = "https?://(www\\.)?instagram\\.com/.*", 
message = "Invalid Instagram link format")
private String instagramLink;

@Size(max = 500, message = "Cloudinary image public ID cannot exceed 500 characters")
private String cloudinaryImagePublicId;


//ManyToMany that's means one user can have multiple contact 
     @ManyToOne     //@ManyToOne: Specifies the relationship where multiple contacts can be associated with a single user.
     @JsonBackReference
	 private User user;
     
    
public Contact() {
	// TODO Auto-generated constructor stub
}


public Contact(String id, String name, String email, String phoneNumber, String address, String picture,
		String description, boolean favorite, String websiteLink, String linkedInLink, String instagramLink,
		String cloudinaryImagePublicId, User user) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.address = address;
	this.picture = picture;
	this.description = description;
	this.favorite = favorite;
	this.websiteLink = websiteLink;
	this.linkedInLink = linkedInLink;
	this.instagramLink = instagramLink;
	this.cloudinaryImagePublicId = cloudinaryImagePublicId;
	this.user = user;
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


public String getPhoneNumber() {
	return phoneNumber;
}


public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getPicture() {
	return picture;
}


public void setPicture(String picture) {
	this.picture = picture;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public boolean isFavorite() {
	return favorite;
}


public void setFavorite(boolean favorite) {
	this.favorite = favorite;
}


public String getWebsiteLink() {
	return websiteLink;
}


public void setWebsiteLink(String websiteLink) {
	this.websiteLink = websiteLink;
}


public String getLinkedInLink() {
	return linkedInLink;
}


public void setLinkedInLink(String linkedInLink) {
	this.linkedInLink = linkedInLink;
}


public String getInstagramLink() {
	return instagramLink;
}


public void setInstagramLink(String instagramLink) {
	this.instagramLink = instagramLink;
}


public String getCloudinaryImagePublicId() {
	return cloudinaryImagePublicId;
}


public void setCloudinaryImagePublicId(String cloudinaryImagePublicId) {
	this.cloudinaryImagePublicId = cloudinaryImagePublicId;
}


public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}


}



