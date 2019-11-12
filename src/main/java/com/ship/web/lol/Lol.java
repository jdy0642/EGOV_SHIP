package com.ship.web.lol;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Lazy
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Lol {
	private String lolname,userid,roomnum,roommake,invite,lolstart,lolback,reportnum;
}
