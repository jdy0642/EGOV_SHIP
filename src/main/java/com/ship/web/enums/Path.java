package com.ship.web.enums;

public enum Path {
	UPLOAD_PATH;
	@Override
	public String toString() {
		String result = "";
		switch(this) {
			case UPLOAD_PATH:
			result = "C:\\Users\\user\\git\\EGOV_SHIP\\src\\main\\webapp\\resources\\upload\\temp";
			break;
		}
		
		return result;
	}
}
