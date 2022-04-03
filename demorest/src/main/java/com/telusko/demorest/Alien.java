package com.telusko.demorest;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement                              


public class Alien {

		private String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
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
		private int id;
		
		
		Alien()
		{
			id=0;
			name="not found";
		}
		
		
		List<Alien> la;
		
}
