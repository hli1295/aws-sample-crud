package com.crud.simpleCrud.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Slf4j
public class storageService {
    //load the bucket

    @Value("${application.bucket.name}")
    private String bucketName;

    //creating client object that can upload, download, delete files on the bucket

    @Autowired
    private AmazonS3 s3Client;

    public String uploadFile(MultipartFile file){
        File fileObj=convMultiToFile(file);


        //creating unique file name
        String fileName=System.currentTimeMillis()+"_"+file.getOriginalFilename();

        //putObject method lets us upload files on s3
        s3Client.putObject(new PutObjectRequest(bucketName,fileName,fileObj));
        fileObj.delete();
        return "File uploaded: "+ fileName;


    }

    private File convMultiToFile(MultipartFile file){
        File convertedFile=new File(file.getOriginalFilename());
        try(FileOutputStream fos=new FileOutputStream(convertedFile)){
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("error converting",e);
        }
        return convertedFile;
    }
}
