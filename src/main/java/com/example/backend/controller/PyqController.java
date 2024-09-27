package com.example.backend.controller;


import com.example.backend.entity.Pyq;
import com.example.backend.entity.QCloudCOS;
import com.example.backend.service.PyqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/share")
public class PyqController {
    @Autowired
    private QCloudCOS qCloudCOS;
    @Autowired
    private PyqService pyqService;
//    @PostMapping
//        String url = qCloudCOS.sendObject(file);
//        return url;
//    }
    @PostMapping
    public String addPyq(@RequestParam(value = "image", required = false) MultipartFile image,  // 接收图片文件
                         @RequestParam("text") String text) throws Exception {
        //pyqService.insertPyq(image,text,(long)4);
        try {
            Long uuid= pyqService.insertPyq(image,text,(long)4);
            if(uuid!=null){
                return uuid.toString();
            }else {
                return "null";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
