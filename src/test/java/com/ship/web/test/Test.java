package com.ship.web.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> loc = Arrays.asList("서울, 경기, 충청");
	   	Collections.shuffle(loc);
		System.out.println();
	}
}
