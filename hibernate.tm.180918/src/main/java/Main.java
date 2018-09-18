import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.pk.dao.GoodDao;
import com.pk.domain.Good;

public class Main {

	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		/*GoodDao dao = context.getBean(GoodDao.class);
		Good good = new Good();
		good.setCode(7);
		good.setName("citrus");
		good.setManufacture("korea");
		good.setPrice(1000);
	
		dao.insertGood(good);*/
		
/*		GoodDao dao = context.getBean(GoodDao.class);
		Good good = new Good();
		good.setCode(7);
		good.setName("pineapple");
		good.setManufacture("korea");
		good.setPrice(1500);
		
		dao.updateGood(good);*/
		
/*		GoodDao dao = context.getBean(GoodDao.class);
		Good good = new Good();
		good.setCode(7);
		
		dao.deleteGood(good);*/
		
		GoodDao dao = context.getBean(GoodDao.class);
		List<Good> list = dao.list();
		for(Good good : list) {
			System.out.println(good);
		}
		
		// 데이터 1개 가져오기
		System.out.println("================");
		System.out.println(dao.get(6));
		System.out.println(dao.get(12));

		context.close();
	}
}
