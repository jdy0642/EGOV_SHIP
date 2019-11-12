package com.ship.web.brd;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ship.web.cmm.IConsumer;
import com.ship.web.cmm.IPredicate;
import com.ship.web.cmm.ISupplier;
import com.ship.web.pxy.PageProxy;
import com.ship.web.pxy.ProxyMap;
import com.ship.web.utl.Printer;

@RestController
@RequestMapping("/articles")
public class ArticleCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ArticleCtrl.class);
	@Autowired Article article;
	@Autowired Printer printer;
	@Autowired ArticleMapper articleMapper;
	@Autowired List<Article> list;
	@Qualifier PageProxy pager;
	@Qualifier ProxyMap box;
	
	@PostMapping("/")
	public Map<?,?> write(@RequestBody Article param) {
		logger.info("롸이트");
		param.setBoardtype("게시판");
		IConsumer<Article> c = t -> articleMapper.insertArticle(param);
		c.accept(param);
		ISupplier<String> s =()-> articleMapper.countArticle();
		box.accept(Arrays.asList("msg","count"),
				Arrays.asList("SUCCESS",s.get()));
		return box.get();
	}
	//
	@GetMapping("/page/{pageno}/size/{pageSize}")
	public Map<?,?>  list(@PathVariable String pageno,
			@PathVariable String pageSize){
		System.out.println("넘어온 페이지 넘버: "+pageno);
		pager.setPageNum(pager.integer(pageno));
		pager.setPageSize(pager.integer(pageSize));
		pager.paging();
		list.clear();
		ISupplier<List<Article>> s = () -> articleMapper.selectList(pager);
		printer.accept("해당 페이지\n"+s.get());
		box.accept(Arrays.asList("articles", "pxy"), Arrays.asList(s.get(),pager));
		return box.get();
	}
	@PutMapping("/{artseq}")
	public Map<?,?> updateArticle(@PathVariable String artseq, @RequestBody Article param) {
		logger.info("수정"+param);
		IConsumer<Article> c = t -> articleMapper.updateArticle(param);
		c.accept(param);
		logger.info("수정2");
		box.accept(Arrays.asList("msg"), Arrays.asList("SUCCESS"));
		return box.get();
	} 
	@DeleteMapping("/{artseq}")
	public Map<?,?> deleteArticle(@PathVariable String artseq, @RequestBody Article param) {
		logger.info("삭제");
		IConsumer<Article> c = t -> articleMapper.deleteArticle(param);
		c.accept(param);
		logger.info("삭제2");
		box.accept(Arrays.asList("msg"), Arrays.asList("SUCCESS"));
		return box.get();
	} 
	@GetMapping("/count")
	public Map<?,?> count() {
		logger.info("카운트");
		ISupplier<String> s = () -> articleMapper.countArticle(); 
		logger.info("카운트2/"+s.get());
		box.accept(Arrays.asList("count"), Arrays.asList(s.get()));
		return box.get();
	}
}
