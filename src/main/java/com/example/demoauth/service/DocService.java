package com.example.demoauth.service;

import com.example.demoauth.models.dto.DocChangeStatusDto;
import com.example.demoauth.models.dto.DocCreateDto;
import com.example.demoauth.models.dto.DocInfoDto;
import com.example.demoauth.models.dto.DocSearchDto;

import java.util.List;

public interface DocService {

    void save(DocCreateDto docCreateDto);

    DocInfoDto findById(Long id);

    List<DocInfoDto> findAllByRole(DocSearchDto docSearchDto);
    List<DocInfoDto> findAll(DocSearchDto docSearchDto);

    void changeStatus(DocChangeStatusDto docChangeStatusDto);
}
