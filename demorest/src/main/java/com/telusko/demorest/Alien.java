package com.telusko.demorest;

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
		public int getPoints() {
			return points;
		}
		public void setPoints(int points) {
			this.points = points;
		}
		private int points;
}
