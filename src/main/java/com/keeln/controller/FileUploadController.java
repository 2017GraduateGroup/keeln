package com.keeln.controller;

import com.keeln.domain.model.ScenicRegionDO;
import com.keeln.manager.ScenicRegionManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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


    @Autowired
    ScenicRegionManager scenicRegionManager;

    /**
     * 上传文件
     *
     * @param scenicRgionId
     * @param request
     */
    @RequestMapping(method = RequestMethod.POST, value = "/handleFileUpload")
    public void handleFileUpload(@RequestParam String scenicRgionId, HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
        /** 构建文件保存的目录* */
        String logoPathDir = "/static/resources/img"
                + dateformat.format(new Date());
        /** 得到文件保存目录的真实路径* */
        String logoRealPathDir = request.getSession().getServletContext()
                .getRealPath(logoPathDir);
        /** 根据真实路径创建目录* */
        File logoSaveFile = new File(logoRealPathDir);
        if (!logoSaveFile.exists())
            logoSaveFile.mkdirs();
        /** 页面控件的文件流* */
        MultipartFile multipartFile = multipartRequest.getFile("file");
        /** 获取文件的后缀* */
        String suffix = multipartFile.getOriginalFilename().substring(
                multipartFile.getOriginalFilename().lastIndexOf("."));
        /** 使用UUID生成文件名称* */
        String logImageName = UUID.randomUUID().toString() + suffix;// 构建文件名称
        /** 拼成完整的文件保存路径加文件* */
        String pathUrl = logoRealPathDir + File.separator + logImageName;
        File file1 = new File(pathUrl);
        try {
            multipartFile.transferTo(file1);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /** 打印出上传到服务器的文件的绝对路径* */
        if(StringUtils.isNotBlank(scenicRgionId)){
            ScenicRegionDO scenicRegionDO = scenicRegionManager.selectByPrimaryKey(Long.valueOf(scenicRgionId));
            if(null != scenicRegionDO){
                scenicRegionDO.setImgurl(pathUrl);
            }
        }
    }
}
