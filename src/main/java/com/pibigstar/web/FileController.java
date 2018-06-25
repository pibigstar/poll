package com.pibigstar.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
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

    @GetMapping("uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
