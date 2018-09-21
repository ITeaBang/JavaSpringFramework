package com.pk.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	// excel.xls 요청을 처리하는 메소드
	@RequestMapping(value = "excel.xls", method = RequestMethod.GET)
	public String excel(Model model) {

		// 1.7 이상에서만 아래 형태로 사용 가능, 그 이하 버전에서는 반드시 <>안에 자료형 기재
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("JavaScript");
		list.add("C");
		list.add("C++");
		list.add("Python");
		list.add("C#");
		list.add("R");
		list.add("Ruby");
		
		model.addAttribute("list", list);

		return "programming";
	}

	// data.pdf 요청을 처리하는 메소드
	@RequestMapping(value = "data.pdf", method = RequestMethod.GET)
	public String pdf(Model model) {

		List<String> list = new ArrayList<>();
		list.add("Oracle-RDBMS");
		list.add("MS-SQL-RDBMS");
		list.add("MYSQL(MariaDB)-RDBMS");
		list.add("ACCESS-RDBMS");
		list.add("Sqlite-RDBMS");
		list.add("MongoDB-NoSQL");
		list.add("Cassandra-NoSQL");

		// db라는 이름으로 list를 저장
		model.addAttribute("db", list);

		// 출력하는 뷰 이름을 db로 설정
		return "db";

	}

	// jsonview.json 요청을 처리하는 메소드
	@RequestMapping(value = "jsonview.json", method = RequestMethod.GET)
	public String jsonview(Model model) {

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "김좌진");
		map.put("phone", "01012345678");
		list.add(map);

		map.put("name", "유관순");
		map.put("phone", "01087654321");
		list.add(map);

		map.put("name", "안중근");
		map.put("phone", "01011112222");
		list.add(map);

		model.addAttribute("list", list);

		return "jsonview";
	}
}