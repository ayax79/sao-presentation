package org.yestech.user;

import javax.persistence.Embeddable;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

import lombok.Data;

@Data
@Embeddable
public class Address {
	
	@Field(store = Store.YES, index = Index.TOKENIZED) 
	private String street;
	
	@Field(store = Store.YES, index = Index.TOKENIZED) 
	private String city;

}
