package com.keeln.controller;

import com.keeln.domain.model.BizResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Xianrui Ke on 2017/6/6.
 */
@Slf4j
@RestController
@RequestMapping("fileUpload")
public class FileUploadController {
    public static final String ROOT = "upload-dir";

    @Autowired
    private final ResourceLoader resourceLoader;
    @Autowired
    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 图片读取
     * @param filename
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}")
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 上传文件
     * @param file
     * @param redirectAttributes
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/handleFileUpload")
    public BizResult handleFileUpload(@RequestParam("file") MultipartFile file,
                                      RedirectAttributes redirectAttributes, HttpServletRequest request) {
        System.out.println(request.getParameter("member"));
        BizResult bizResult = new BizResult();
        if (!file.isEmpty()) {
            try {
                Files.copy(file.getInputStream(), Paths.get(ROOT, file.getOriginalFilename()));
                redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded " + file.getOriginalFilename() + "!");
            } catch (IOException|RuntimeException e) {
                redirectAttributes.addFlashAttribute("message", "Failued to upload " + file.getOriginalFilename() + " => " + e.getMessage());
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to upload " + file.getOriginalFilename() + " because it was empty");
        }
        return bizResult;
    }
}
