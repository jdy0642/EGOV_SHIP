package com.ship.web.res;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Lazy
public class Reser {
	private String resnum, resdate, userponint, rescan, payamount, payway, paycan, paynum, adminid;
}
