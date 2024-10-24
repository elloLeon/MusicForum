package org.example.avemusicaback.serviceImpl;



import org.example.avemusicaback.Util.OssUtil;
import org.example.avemusicaback.exception.AveMusicaException;
import org.example.avemusicaback.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;


@Service
public class OssServiceImpl implements OssService {

    @Autowired
    OssUtil ossUtil;

    @Override
    public String upload(MultipartFile file) {
        try {
            String fileName = UUID.randomUUID().toString().replace("-","");
            String original = file.getOriginalFilename();
            String fileType = original.substring(original.lastIndexOf("."));
            String newName = fileName + fileType;
            return ossUtil.upload(newName,file.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
            throw AveMusicaException.fileUploadFail();
        }
    }


}
