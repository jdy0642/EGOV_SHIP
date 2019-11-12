package com.ship.web.enums;

public enum Path {
<<<<<<< HEAD
	UPLOAD_PATH;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	
=======
>>>>>>> sjw
=======
>>>>>>> ljs
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case UPLOAD_PATH:
<<<<<<< HEAD
<<<<<<< HEAD
			result = "C:\\Users\\User\\govern\\eGovFrame-3.8\\workspace\\ship\\src\\main\\webapp\\resources\\upload\\temp";
=======
			result = "C:\\Users\\User\\Java\\EGOV_SHIP\\src\\main\\webapp\\resources\\upload\\temp";
			break;
>>>>>>> sjw
=======
			result = "C:\\Users\\User\\git\\EGOV_SHIP\\src\\main\\webapp\\resources\\upload\\temp";
			break;
		
>>>>>>> ljs
		}
=======
	@Override
	public String toString() {
		String result = "";
		switch(this) {
			case UPLOAD_PATH:
			result = "C:\\Users\\user\\git\\EGOV_SHIP\\src\\main\\webapp\\resources\\upload\\temp";
			break;
		}
		
>>>>>>> hsc1
		return result;
	}
=======
	 UPLOAD_PATH;
    @Override
    public String toString() {
        String result = "";
        switch (this) {
        case UPLOAD_PATH:
            result = "C:\\Users\\User\\git\\EGOV_SHIP\\src\\main\\webapp\\resources\\upload\\temp";
            break;
        }
        return result;
    }
>>>>>>> yyh
}
