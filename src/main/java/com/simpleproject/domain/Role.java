package com.simpleproject.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role extends BasicEntity {

	public Role() {
		super();
	}

	public Role(String name) {
		super();
		this.name = name;
	}

}
