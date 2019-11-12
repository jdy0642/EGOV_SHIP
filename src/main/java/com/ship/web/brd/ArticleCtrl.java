package com.ship.web.brd;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ship.web.cmm.IConsumer;
import com.ship.web.cmm.ISupplier;
<<<<<<< HEAD
import com.ship.web.pxy.PageProxy;
import com.ship.web.pxy.Trunk;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> sjw
=======
>>>>>>> ljs
=======
>>>>>>> hsc1
=======
>>>>>>> yyh
import com.ship.web.pxy.Box;
import com.ship.web.pxy.PageProxy;
import com.ship.web.pxy.Trunk;
import com.ship.web.utl.Printer;

@RestController
@RequestMapping("/articles")
public class ArticleCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ArticleCtrl.class);
	@Autowired Article article;
	@Autowired Printer printer;
	@Autowired ArticleMapper articleMapper;
	@Autowired Box<Article> box;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	@Qualifier PageProxy pager;
	@Autowired Trunk<Object> trunk;
	
=======
//	@SuppressWarnings("rawtypes")
	@Autowired PageProxy pager;
	@Autowired Trunk<Object> trunk;
=======
	@Autowired PageProxy pager;
	@SuppressWarnings("rawtypes")
	@Autowired Trunk<Object> map;
>>>>>>> hsc1
	

>>>>>>> sjw
=======
	@Autowired PageProxy pager;
	@Autowired Trunk<Object> trunk;
=======
	@Qualifier PageProxy pager;
	@Autowired Trunk<Object> trunk;
>>>>>>> yyh
	
>>>>>>> ljs
	@PostMapping("/")
	public Map<?,?> write(@RequestBody Article param) {
		logger.info("롸이트");
		IConsumer<Article> c = t -> articleMapper.insertArticle(param);
		Supplier<Integer> y = () -> articleMapper.artseqMax();
		param.setArtseq(String.format("%d",y.get()+1));
		c.accept(param);
		System.out.println("\n"+param.getArtseq()+"       "+y.get());
		ISupplier<String> s =()-> articleMapper.countArticle();
<<<<<<< HEAD
<<<<<<< HEAD
		trunk.put(Arrays.asList("msg","count"),
				Arrays.asList("SUCCESS",s.get()));
		return trunk.get();
=======
		map.put(Arrays.asList("msg","count"),
				Arrays.asList("SUCCESS",s.get()));
		return map.get();
>>>>>>> hsc1
=======
		trunk.put(Arrays.asList("msg","count"),
				Arrays.asList("SUCCESS",s.get()));
		return trunk.get();
>>>>>>> yyh
	}
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> sjw
=======
	
>>>>>>> ljs
	@GetMapping("/page/{pageno}/size/{pageSize}")
	public Map<?,?>  list(@PathVariable String pageno,
			@PathVariable String pageSize){
		System.out.println("넘어온 페이지 넘버: "+pageno);
		pager.setPageNum(pager.integer(pageno));
		pager.setPageSize(pager.integer(pageSize));
		pager.paging();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		box.clear();
=======
>>>>>>> sjw
=======
		box.clear();
>>>>>>> ljs
		ISupplier<List<Article>> s = () -> articleMapper.selectList(pager);
		printer.accept("해당 페이지\n"+s.get());
		trunk.put(Arrays.asList("articles", "pxy"), Arrays.asList(s.get(),pager));
		return trunk.get();
=======
		ISupplier<List<Article>> s = () -> articleMapper.selectList(pager);
		printer.accept("해당 페이지\n"+s.get());
		map.put(Arrays.asList("articles", "pxy"), Arrays.asList(s.get(),pager));
		return map.get();
>>>>>>> hsc1
=======
		box.clear();
		ISupplier<List<Article>> s = () -> articleMapper.selectList(pager);
		printer.accept("해당 페이지\n"+s.get());
		trunk.put(Arrays.asList("articles", "pxy"), Arrays.asList(s.get(),pager));
		return trunk.get();
>>>>>>> yyh
	}
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> sjw
=======
	
>>>>>>> ljs
	@PutMapping("/{artseq}")
	public Map<?,?> updateArticle(@PathVariable String artseq, @RequestBody Article param) {
		logger.info("수정"+param);
		IConsumer<Article> c = t -> articleMapper.updateArticle(param);
		c.accept(param);
		logger.info("수정2");
<<<<<<< HEAD
<<<<<<< HEAD
		trunk.put(Arrays.asList("msg"), Arrays.asList("SUCCESS"));
		return trunk.get();
=======
		map.put(Arrays.asList("msg"), Arrays.asList("SUCCESS"));
		return map.get();
>>>>>>> hsc1
=======
		trunk.put(Arrays.asList("msg"), Arrays.asList("SUCCESS"));
		return trunk.get();
>>>>>>> yyh
	} 
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> sjw
=======
	
>>>>>>> ljs
	@DeleteMapping("/{artseq}")
	public Map<?,?> deleteArticle(@PathVariable String artseq, @RequestBody Article param) {
		logger.info("삭제");
		IConsumer<Article> c = t -> articleMapper.deleteArticle(param);
		c.accept(param);
		logger.info("삭제2");
<<<<<<< HEAD
<<<<<<< HEAD
		trunk.put(Arrays.asList("msg"), Arrays.asList("SUCCESS"));
		return trunk.get();
=======
		map.put(Arrays.asList("msg"), Arrays.asList("SUCCESS"));
		return map.get();
>>>>>>> hsc1
=======
		trunk.put(Arrays.asList("msg"), Arrays.asList("SUCCESS"));
		return trunk.get();
>>>>>>> yyh
	} 
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> sjw
=======
	
>>>>>>> ljs
	@GetMapping("/count")
	public Map<?,?> count() {
		logger.info("카운트");
		ISupplier<String> s = () -> articleMapper.countArticle(); 
		logger.info("카운트2/"+s.get());
<<<<<<< HEAD
<<<<<<< HEAD
		trunk.put(Arrays.asList("count"), Arrays.asList(s.get()));
		return trunk.get();
	}
<<<<<<< HEAD
<<<<<<< HEAD
	@GetMapping("/fileupload")
	public void fileUpload() {
		
=======
	
	@GetMapping("/{artseq}/fileupload")
	public void fileUpload(@PathVariable String artseq) {
		logger.info("파일업로드 진입 : {}", artseq);
>>>>>>> sjw
=======
	@GetMapping("/fileupload")
	public void fileUpload() {
		
>>>>>>> ljs
=======
		map.put(Arrays.asList("count"), Arrays.asList(s.get()));
		return map.get();
	}
	@GetMapping("/fileupload")
	public void fileUpload() {
		
>>>>>>> hsc1
=======
		trunk.put(Arrays.asList("count"), Arrays.asList(s.get()));
		return trunk.get();
	}
	@GetMapping("/fileupload")
	public void fileUpload() {
		
>>>>>>> yyh
	}
}
