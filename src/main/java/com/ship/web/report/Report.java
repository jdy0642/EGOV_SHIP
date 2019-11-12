package com.ship.web.report;

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
public class Report {
	private String reportnum,reply,img,stadiumid,userid;
}
