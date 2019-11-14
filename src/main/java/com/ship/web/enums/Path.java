package com.ship.web.enums;

public enum Path {
	UPLOAD_PATH, CRAWLING_TARGET;
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case UPLOAD_PATH:
			result = "D:\\";
			break;
		case CRAWLING_TARGET:
			result = "C:\\Users\\User\\govern\\eGovFrame-3.8\\workspace\\ship\\src\\main\\webapp\\resources\\upload\\temp";
			break;
		}
        return result;
    }
}
