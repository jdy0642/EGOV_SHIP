package com.ship.web.pxy;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ship.web.res.Reser;
import com.ship.web.res.ReserMapper;
import com.ship.web.tx.TxMapper;


@Component("resers")
public class ReserProxy extends Proxy{
	@Autowired TxMapper txMapper;
	@Autowired Trunk<String> trunk;
	@Autowired Box<String> box;
	@Autowired ReserMapper reserMapper;
	private char[] charaters = {'0','1','2','3','4','5','6','7','8','9'};
	private String makeResnum() {
		StringBuffer buffer = new StringBuffer();
		Random ran = new Random();

		for (int i = 0; i < 6; i++) {
			buffer.append(charaters[ran.nextInt(charaters.length)]);
		}
		return buffer.toString();
	}
	private String makeResdate() {
		return currentDate();
	}
	private String makeUserponint() {
		List<String> point = Arrays.asList("10000", "20000");
	   	Collections.shuffle(point);
		return point.get(0);
	}
	private String makeRescan() {
		List<String> paycan = Arrays.asList("예약","예약취소");
	   	Collections.shuffle(paycan);
		return paycan.get(0);
	}
	private String makePaynum() {
		StringBuffer buffer = new StringBuffer();
		Random ran = new Random();

		for (int i = 0; i < 4; i++) {
			buffer.append(charaters[ran.nextInt(charaters.length)]);
		}
		return buffer.toString();
	}
	private String makePayamount() {
		List<String> pay = Arrays.asList("10000", "20000");
	   	Collections.shuffle(pay);
		return pay.get(0);
	}
	private String makePayway() {
		List<String> pay = Arrays.asList("카드","이체");
	   	Collections.shuffle(pay);
		return pay.get(0);
	}
	private String makePaycan() {
		List<String> paycan = Arrays.asList("결재","취소");
	   	Collections.shuffle(paycan);
		return paycan.get(0);
	}
	
	private String makeAdmin() {
		String admin = "Hong";
		return admin;
	}
	public Reser makeReser() {
		return new Reser(makeResnum(),makeResdate(),makeUserponint(),makeRescan(),makePaynum(),makePayamount(),makePayway(),makePaycan(),makeAdmin());
	}
	@Transactional
	public void insertReser() {
		for(int i = 0; i < 100; i++) {
			reserMapper.insertReser(makeReser());
		}
	}
	
}
