package com.ship.web.report;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ship.web.enums.SQL;
import com.ship.web.usr.UserCtrl;
import com.ship.web.utl.Printer;

@RestController
@RequestMapping("/reports")
public class ReportCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ReportCtrl.class);
	@Autowired Report report;
	@Autowired Printer p;
	@Autowired Map<String,Object> map;
	@Autowired ReportMapper reportMapper;
	
	@GetMapping("/create/report")
	public Map<?,?> createReportTable(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_REPORT", SQL.CREATE_REPORT.toString());
		p.accept("report테이블 생성쿼리:"+paramMap.get("CREATE_REPORT"));
		Consumer<HashMap<String, String>> c = t -> reportMapper.createReportTalbe(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
		
	}
}
