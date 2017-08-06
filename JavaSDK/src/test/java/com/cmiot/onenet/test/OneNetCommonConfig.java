package com.cmiot.onenet.test;

public class OneNetCommonConfig {
	public static String apikey = "F0pGpqI9wxFFy152cuTvG50AMPA=";
	
	public static enum DeviceProtocol{
		
		Http("HTTP协议","HTTP"),
		EDP("EDP协议", "EDP");

		private String description;

		private String key;

		private DeviceProtocol(String description, String key) {
			this.description = description;
			this.key = key;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
	}
}
