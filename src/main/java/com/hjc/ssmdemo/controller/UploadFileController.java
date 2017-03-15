package com.hjc.ssmdemo.controller;

import com.hjc.ssmdemo.common.ResponseStatusConstant;
import com.hjc.ssmdemo.response.ResponseBase;
import com.hjc.ssmdemo.util.GenerateFileName;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bravowhale on 2017/3/15.
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadFileController {

    public static final Logger logger = LoggerFactory.getLogger(UploadFileController.class);

    @Value("${fileserver.dir}")
    private String fileServerDir;

    @ResponseBody
    @RequestMapping(value = "/uploadFile")
    public ResponseBase upload(@RequestParam("file")MultipartFile upfile, HttpServletRequest request){
        ResponseBase response = new ResponseBase(ResponseStatusConstant.SUCCESS,"上传成功！");
        String originalfileName = upfile.getOriginalFilename();
        String fileName = GenerateFileName.generateFileName(originalfileName);
        logger.info(originalfileName+" "+fileName);
        File file = new File(fileServerDir, fileName);
        try {
            FileUtils.copyInputStreamToFile(upfile.getInputStream(),file);
//            upfile.transferTo(file);
        }catch (IOException e){
            response.setResponseStatusConstant(ResponseStatusConstant.FAILURE);
            response.setMessage("上传失败");
        }

        return response;
    }

}
