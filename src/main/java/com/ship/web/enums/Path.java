package com.ship.web.enums;

public enum Path {
	UPLOAD_PATH, CRAWLING_TARGET;
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case UPLOAD_PATH:
			result = "C:\\Users\\user\\git\\EGOV_SHIP\\src\\main\\webapp\\resources\\upload\\";
			break;
		
		case CRAWLING_TARGET:
			result= "https://talk.op.gg/s/lol/free?page=";
			break;
		}
		return result;
    }
}
