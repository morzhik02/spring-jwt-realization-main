package com.example.demoauth.service;

import com.example.demoauth.models.dto.DocCreateDto;
import com.example.demoauth.models.dto.DocInfoDto;
import com.example.demoauth.models.dto.DocSearchDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocService {

    void save(DocCreateDto docCreateDto);

    DocInfoDto findById(Long id);

    List<DocInfoDto> findAll(DocSearchDto docSearchDto);
//
//    void changeStatus(PostChangeStatusDto postChangeStatusDto);
}
