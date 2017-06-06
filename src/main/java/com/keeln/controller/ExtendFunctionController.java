package com.keeln.controller;

import com.keeln.domain.model.BizResult;
import com.keeln.domain.model.ScenicRegionDO;
import com.keeln.domain.query.ScenicRegionQuery;
import com.keeln.manager.ScenicRegionManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * Created by Xianrui Ke on 2017/6/6.
 */
@RestController
@RequestMapping("extend")
public class ExtendFunctionController {

    @Autowired
    ScenicRegionManager scenicRegionManager;

    @RequestMapping("searchRegionByKey")
    public BizResult searchRegionByKey(@RequestParam String key){
        BizResult bizResult = new BizResult();
        ScenicRegionQuery scenicRegionQuery = new ScenicRegionQuery();
        if(StringUtils.isNotBlank(key)){
            scenicRegionQuery.createCriteria().andTitleLike(key);
            List<ScenicRegionDO> scenicRegionDOList = scenicRegionManager.selectByQuery(scenicRegionQuery);
            if(scenicRegionDOList.size() > 0){
                bizResult.setCode("1");
                bizResult.setMessage("success");
                bizResult.setList(scenicRegionDOList);
            }
        }
        bizResult.setCode("0");
        bizResult.setMessage("fail");
        return bizResult;
    }

    @RequestMapping("uploadFile")
    public BizResult uploadFile(@RequestParam("file") MultipartFile file) {
        BizResult bizResult = new BizResult();
        if (!file.isEmpty()) {
            try {
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                // 还有关于文件格式限制、文件大小限制，详见：中配置。
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                bizResult.setCode("0");
                bizResult.setMessage("fail" + e.getMessage());
                return bizResult;
            } catch (IOException e) {
                e.printStackTrace();
                bizResult.setCode("0");
                bizResult.setMessage("fail" + e.getMessage());
                return bizResult;
            }
            bizResult.setCode("1");
            bizResult.setMessage("success");
            return bizResult;
        } else {
            bizResult.setCode("0");
            bizResult.setMessage("file is empty");
            return bizResult;
        }
    }
}
