package com.pibigstar.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pibigstar.common.Constant;

/**
 * 文件上传Controller
 * @author pibigstar
 *
 */
@Controller()
@RequestMapping("/file")
public class FileController extends BaseController{

	private final String upload_path = Constant.DEFAULT_FILE_UPLOAD_PATH;

	@GetMapping("toUpload")
	public String index() {
		return "upload";
	}

	/**
	 * 上传
	 * @param file
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping("upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "请选择文件进行上传");
			return "redirect:/file/uploadStatus";
		}

		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(upload_path+file.getOriginalFilename());
			Files.write(path, bytes);

			redirectAttributes.addFlashAttribute("message","成功上传文件： '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/file/uploadStatus";
	}

	/**
	 * 下载
	 * @param res
	 * @throws IOException
	 */
	@GetMapping("download")  
	public void download(HttpServletResponse res) throws IOException {

		String fileName = "Main.jpg";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("E://temp/"+ fileName)));
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("success");
	}

	@GetMapping("uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}
}
