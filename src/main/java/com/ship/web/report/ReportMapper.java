package com.ship.web.report;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface ReportMapper {
	public void createReportTalbe(HashMap<String,String> paramMap);
}
