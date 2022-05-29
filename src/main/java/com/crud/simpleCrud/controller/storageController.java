package com.crud.simpleCrud.controller;

import com.crud.simpleCrud.config.StorageConfig;
import com.crud.simpleCrud.service.storageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class storageController {

    @Autowired
    private storageService service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value="file")MultipartFile file){
        return new ResponseEntity<>(service.uploadFile(file), HttpStatus.OK);
    }


}
