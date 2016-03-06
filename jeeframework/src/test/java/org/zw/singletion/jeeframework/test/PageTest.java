package org.zw.singletion.jeeframework.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.zw.singleton.jeeframework.modules.appinterface.joke.entity.AppJoke;
import org.zw.singleton.jeeframework.modules.appinterface.joke.service.AppJokeService;
import org.zw.singleton.jeeframework.modules.basis.page.Page;

public class PageTest extends  BaseTest{

	@Autowired
	public AppJokeService qal ;
	@Test
	public void test() {
		List<AppJoke> pageSelect = qal.pageSelect(new AppJoke());
		System.err.println(pageSelect.size());
		
		Page<AppJoke> pageSelect2 = qal.pageSelect(new Page<AppJoke>(new AppJoke(1),1,5));
		System.err.println(pageSelect2.getDataList().size());
		for (int i = 0; i < pageSelect2.getDataList().size(); i++) {
			System.err.println(pageSelect2.getDataList().get(i).getTitle());
		}
	}

}
