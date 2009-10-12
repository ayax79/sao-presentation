package org.yestech.user;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

import lombok.Data;

@Entity
@Data
@Indexed
public class User {
	
	@Id 
	@GeneratedValue 
	private Long id;
	
	@Version 
	private Long version;
	
	@Field(store = Store.YES, index = Index.TOKENIZED) 
	private String firstname;
	
	@Field(store = Store.YES, index = Index.TOKENIZED) 
	private String lastname;
	
	@IndexedEmbedded 
	@Embedded 
	Address address;

}
