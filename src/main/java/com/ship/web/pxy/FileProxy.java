package com.ship.web.pxy;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ship.web.enums.Path;
@Component("filemgr")
public class FileProxy extends Proxy{
	public void fileupload(MultipartFile[] uploadFile) {
		String uploadFolder = Path.UPLOAD_PATH.toString();
		File uploadPath = new File(uploadFolder,getFolder());
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		for(MultipartFile f : uploadFile) {
			String fname = f.getOriginalFilename();
			System.out.println("오리지날파일명: "+fname);
			String extension = fname.substring(fname.lastIndexOf(".")+1);
			fname = fname.substring(fname.lastIndexOf("\\")+1,fname.lastIndexOf("."));
			System.out.println("파일명: "+fname);
			System.out.println("확장자: "+extension);
			File saveFile = new File(uploadPath,fname+"_"+UUID.randomUUID().toString()+"."+extension);
			try {
				f.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public String getFolder() {
		return currentDate().replace("-",File.separator);
	}
}
