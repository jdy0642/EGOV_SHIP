package com.ship.web.brd;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ship.web.cmm.IConsumer;
import com.ship.web.cmm.ISupplier;
import com.ship.web.pxy.PageProxy;
import com.ship.web.pxy.Trunk;
import com.ship.web.pxy.Box;
import com.ship.web.pxy.FileProxy;
import com.ship.web.utl.Printer;

@RestController
@RequestMapping("/articles")
public class ArticleCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ArticleCtrl.class);
	@Autowired Article article;
	@Autowired Printer p;
	@Autowired ArticleMapper articleMapper;
	@Autowired Box<Article> box;
	@Autowired Trunk<Object> trunk;
	@Autowired PageProxy pager;
	@Autowired FileProxy fileMgr;
	
	@PostMapping("/")
	public Map<?,?> write(@RequestBody Article param) {
		logger.info("롸이트");
		IConsumer<Article> c = t -> articleMapper.insertArticle(param);
		c.accept(param);
		ISupplier<String> s =()-> articleMapper.countArticle();
		trunk.put(Arrays.asList("msg","count"),
				Arrays.asList("SUCCESS",s.get()));
		return trunk.get();
	}
	@GetMapping("/page/{pageno}/size/{pageSize}")
	public Map<?,?>  list(@PathVariable String pageno,
			@PathVariable String pageSize){
		System.out.println("넘어온 페이지 넘버: "+pageno);
		pager.setPageNum(pager.integer(pageno));
		pager.setPageSize(pager.integer(pageSize));
		pager.paging();
		box.clear();
		ISupplier<List<Article>> s = () -> articleMapper.selectList(pager);
		p.accept("해당 페이지\n"+s.get());
		trunk.put(Arrays.asList("articles", "pxy"), Arrays.asList(s.get(),pager));
		return trunk.get();
	}

	@PutMapping("/{artseq}")
	public Map<?,?> updateArticle(@PathVariable String artseq, @RequestBody Article param) {
		logger.info("수정"+param);
		IConsumer<Article> c = t -> articleMapper.updateArticle(param);
		c.accept(param);
		logger.info("수정2");
		trunk.put(Arrays.asList("msg"), Arrays.asList("SUCCESS"));
		return trunk.get();
	} 
	@DeleteMapping("/{artseq}")
	public Map<?,?> deleteArticle(@PathVariable String artseq, @RequestBody Article param) {
		logger.info("삭제");
		IConsumer<Article> c = t -> articleMapper.deleteArticle(param);
		c.accept(param);
		logger.info("삭제2");
		trunk.put(Arrays.asList("msg"), Arrays.asList("SUCCESS"));
		return trunk.get();
	} 
	@GetMapping("/count")
	public Map<?,?> count() {
		logger.info("카운트");
		ISupplier<String> s = () -> articleMapper.countArticle(); 
		logger.info("카운트2/"+s.get());
		trunk.put(Arrays.asList("count"), Arrays.asList(s.get()));
		return trunk.get();
	}
	@PostMapping("/fileupload")
	public void fileupload(MultipartFile[] uploadFile) {
		fileMgr.fileupload(uploadFile);
	}
	
	
}
