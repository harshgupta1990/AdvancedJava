package com.telusko;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
@Entity
public class Alien {

		@Id
		private int id;
		
		private String name;
		
		
		
		
		public int getId() {
			return id;
		}
		@Override
		public String toString() {
			return "Alien [name=" + name + ", id=" + id + "]";
		}
		public void setId(int id) {
			this.id = id;
		}
		
		
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
		Alien()
		{
			id=0;
			name="not found";
		}
		
		
		
		
}
