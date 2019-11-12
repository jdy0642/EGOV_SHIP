package com.ship.web.enums;

public enum SQL {
	CREATE_USER, DROP_USER,CREATE_DB,CREATE_RES,CREATEFUTTAB,CREATEPOSTTAB
	 ,CREATE_GAME, CREATE_LOL,CREATE_REPORT,CREATE_TABLE,DROP_TABLE,CREATE_ADMIN,CREATE_REVENUE;
	
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case CREATE_USER:
			result = "CREATE TABLE USER(" + 
					" USER_ID VARCHAR(10) PRIMARY KEY," + 
					" USER_NAME VARCHAR(20)," + 
					" USER_PW VARCHAR(20)," + 
					" USER_LOC VARCHAR(10)," + 
					" USER_TEL INT(15)," + 
					" USER_POINT VARCHAR(10)," + 
					" AGE VARCHAR(5)," + 
					" GENDER VARCHAR(6)," + 
					" EMAIL VARCHAR(20)," + 
					" SCORE VARCHAR(3)," + 
					" MVP VARCHAR(3)," + 
					" WIN VARCHAR(3)," + 
					" HITMAP VARCHAR(30)," + 
					" KM VARCHAR(30)," + 
					" HEART VARCHAR(30)," + 
					" BOOKMARK VARCHAR(30)," + 
					" LOL_BLACK VARCHAR(30)," + 
					" FUT_BLACK VARCHAR(30)" + 
					")";
			break;
		case CREATEFUTTAB:
			result = "CREATE TABLE FUTSAL (" + 
					"NICKNAME VARCHAR(10) PRIMARY KEY," + 
					"USERID VARCHAR(20)," + 
					"SCORE VARCHAR(10)," +  
					"WIN VARCHAR(20)," + 
					"HITMAP VARCHAR(20)," + 
					"KM VARCHAR(20)," + 
					"HEART VARCHAR(100)," + 
					"FUTBLACK VARCHAR(20)," + 
					"ROPORTNUM VARCHAR(100)" + 
					")";
			break;
		case CREATEPOSTTAB:
			result = "CREATE TABLE POST (" + 
					"POSTNUM VARCHAR(30) INT AUTO_INCREMENT PRIMARY KEY," + 
					"POSTTITLE VARCHAR(30)," + 
					"POSTTEXT VARCHAR(30)," + 
					"IMG VARCHAR(30)," + 
					"INTERLOCK VARCHAR(30)," + 
					"CATEGORY VARCHAR(30)," + 
					"USERID VARCHAR(30)," + 
					"NICKNAME VARCHAR(10), FOREIGN KEY (NICKNAME) REFERENCES FUTSAL (NICKNAME)" + 
					")";
			break;
		case DROP_USER:
			result = "DROP TABLE USER";
			break;
		case CREATE_DB:
			result = "CREATE DATABASE SHIPDB";
			break;
		case CREATE_GAME:
			result = "CREATE TABLE GAME(\r\n" + 
					" GAME_ID VARCHAR(30) PRIMARY KEY,\r\n" + 
					" STADIUM_NAME VARCHAR(30),\r\n" + 
					" STADIUM_LOC VARCHAR(30),\r\n" + 
					" STADIUM__SIZE VARCHAR(30),\r\n" + 
					" STADIUM_TEL VARCHAR(30),\r\n" + 
					" SHOWER VARCHAR(30),\r\n" + 
					" PARKING VARCHAR(30),\r\n" + 
					" GAME_DATE VARCHAR(30),\r\n" + 
					" USER_ID VARCHAR(30)\r\n" + 
					")";
			break;
		case CREATE_RES :
			result = "CREATE TABLE RESERVATION(\r\n" +
                    "RES_NUM VARCHAR(30) PRIMARY KEY,\r\n" +
                    "DATE VARCHAR(30),\r\n" +
                    "USER_POINT VARCHAR(30),\r\n" +
                    "RES_CAN VARCHAR(30),\r\n" +
                    "PAY_NUM VARCHAR(30),\r\n" +
                    "PAY_AMOUNT VARCHAR(30),\r\n" +
                    "PAY_WAY VARCHAR(30),\r\n" +
                    "PAY_CAN VARCHAR(30),\r\n" +
                    "ADMIN_ID VARCHAR(30)\r\n" +
                    ")";
			break;
		case CREATE_LOL : 
			result = "CREATE TABLE LOL(\r\n" + 
					"LOL_NAME VARCHAR(30) PRIMARY KEY,\r\n" + 
					"USER_ID VARCHAR(30),\r\n" + 
					"ROOM_NUM VARCHAR(30),\r\n" + 
					"ROOM_MAKE VARCHAR(30),\r\n" + 
					"INVITE VARCHAR(30),\r\n" + 
					"STARTLOL VARCHAR(30),\r\n" + 
					"LOL_BLACK VARCHAR(30),\r\n" + 
					"REPORT_NUM VARCHAR(30)\r\n" + 
					")";
			break;
		case CREATE_REPORT :
			result = "CREATE TABLE REPORT(\r\n" + 
					"REPORT_NUM VARCHAR(30) PRIMARY KEY,\r\n" + 
					"REPLY VARCHAR(30),\r\n" + 
					"IMG VARCHAR(30),\r\n" + 
					"STADIUM_ID VARCHAR(30),\r\n" + 
					"USER_ID VARCHAR(30)\r\n" + 
					")";
			break;
		case CREATE_TABLE:
			result ="CREATE TABLE USER(USER_ID as uid,USER_NAME as uname,USER_PW as upw)";
			break;
		case DROP_TABLE:
			result = "DROP TABLE USER";
			break;
		case CREATE_ADMIN:
			result = "CREATE TABLE ADMIN(\r\n" + 
					"	AID VARCHAR(20) PRIMARY KEY,\r\n" + 
					"	APW VARCHAR(20),\r\n" + 
					"	ANAME VARCHAR(20)\r\n" + 
					")";
			break;
		case CREATE_REVENUE:
			result = "CREATE TABLE REVENUE(\r\n" + 
					"	INCOME_DAY VARCHAR(30) PRIMARY KEY,\r\n" + 
					"    INCOME_STADIUM VARCHAR(30),\r\n" + 
					"    STADIUM_ID VARCHAR(30),\r\n" + 
					"    DATE VARCHAR(30)\r\n" + 
					")";
			break;
		}
		return result;
	}
}
