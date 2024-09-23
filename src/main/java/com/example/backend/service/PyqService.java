package com.example.backend.service;

import com.example.backend.Dao.PyqDao;
import com.example.backend.entity.Pyq;
import com.example.backend.entity.QCloudCOS;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
@MapperScan("com.example.backend.Dao")
public class PyqService {
    @Autowired
    private QCloudCOS qCloudCOS;
    @Autowired
    private PyqDao pyqDao;

    public Long insertPyq(MultipartFile image,String text,Long userId) throws Exception{
        Pyq newPyq = new Pyq();
        newPyq.setContent(text);
        newPyq.setCreateTime(new Date());
        newPyq.setDeleted(0);
        newPyq.setUserid(userId);
        String imgUrl=qCloudCOS.sendObject(image);
        newPyq.setImgUrl(imgUrl);
        int insertResult = pyqDao.insertPyq(newPyq);
        if(insertResult<0){
            //throw new
        }
        return newPyq.getUuid();
    }
}
