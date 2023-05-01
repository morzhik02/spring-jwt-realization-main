package com.example.demoauth.service.impl;

import com.example.demoauth.models.entity.DocStatus;
import com.example.demoauth.repository.DocStatusRepository;
import com.example.demoauth.service.DocStatusService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DocStatusServiceImpl implements DocStatusService {

    DocStatusRepository docStatusRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DocStatus> findAll() {
        return docStatusRepository.findAll();
    }
}
