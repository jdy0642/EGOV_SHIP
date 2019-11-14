package com.ship.web.pxy;

import java.io.File;
import java.util.UUID;

import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ship.web.enums.Path;

@Component("fm")
public class FileProxy extends Proxy{
	public void fileupload(MultipartFile[] uploadFile) {
		String uploadFolder = Path.UPLOAD_PATH.toString();
		File uploadPath = makeDir(uploadFolder,getFolder());
		if(uploadPath.exists() == false) uploadPath.mkdirs();
		for(MultipartFile file : uploadFile) {
			String fname = file.getOriginalFilename();
			fname = fname.substring(fname.lastIndexOf("\\")+1);
			File saveFile = makeFile(uploadPath, fname);
			if(saveFile.exists() == false) {
				String exetension = fname.substring(fname.lastIndexOf("."));
				saveFile = makeFile(uploadPath,
						fname.substring(0,fname.lastIndexOf("."))
						+UUID.randomUUID().toString()+exetension);
			}
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getFolder() {
		return currentDate().replace("-", "_");
	}
}
