package com.upload;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Brian in 22:08 2018/1/3
 */
@Controller
@RequestMapping("/file")
public class UploadController {
    private static Logger logger = LoggerFactory.getLogger(UploadController.class);

    @RequestMapping(value = "/upload")
    public String doUpload(){

        return "file/upload";
    }

    @RequestMapping(value = "/doupload", method = RequestMethod.POST)
    public String douploadFile(@RequestParam("file")  MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            logger.info("process files:{}", file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:\\tmp\\", System.currentTimeMillis()+file.getOriginalFilename()));
        }
        return "file/uploadOk";
    }
}
