package com.pibigstar.web;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pibigstar.utils.FastDFSFile;
import com.pibigstar.utils.FileUtil;

/**
 * 文件上传Controller
 * @author pibigstar
 *
 */
@Controller()
@RequestMapping("/file")
public class FileController extends BaseController{
	
	@GetMapping("toUpload")
	public String toUpload() {
		return "upload";
	}
	
	
	@PostMapping("upload") //new annotation since 4.3
	public String singleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:/file/uploadStatus";
		}
		try {
			// Get the file and save it somewhere
			String path=saveFile(file);
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");
			redirectAttributes.addFlashAttribute("path",
					"file path url '" + path + "'");
		} catch (Exception e) {
			logger.error("upload file failed",e);
		}
		return "redirect:/file/uploadStatus";
	}

	@GetMapping("uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

	/**
	 * @param multipartFile
	 * @return
	 * @throws IOException
	 */
	public String saveFile(MultipartFile multipartFile) throws IOException {
		String[] fileAbsolutePath={};
		String fileName=multipartFile.getOriginalFilename();
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
		byte[] file_buff = null;
		InputStream inputStream=multipartFile.getInputStream();
		if(inputStream!=null){
			int len1 = inputStream.available();
			file_buff = new byte[len1];
			inputStream.read(file_buff);
		}
		inputStream.close();
		FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
		try {
			fileAbsolutePath = FileUtil.upload(file);  //upload to fastdfs
		} catch (Exception e) {
			logger.error("upload file Exception!",e);
		}
		if (fileAbsolutePath==null) {
			logger.error("upload file failed,please upload again!");
		}
		String path=FileUtil.getTrackerUrl()+fileAbsolutePath[0]+ "/"+fileAbsolutePath[1];
		return path;
	}

}
