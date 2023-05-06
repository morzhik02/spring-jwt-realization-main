package com.example.demoauth.service.impl;

import com.example.demoauth.exception.DiplomaCoreException;
import com.example.demoauth.models.dto.DocChangeStatusDto;
import com.example.demoauth.models.dto.DocCreateDto;
import com.example.demoauth.models.dto.DocInfoDto;
import com.example.demoauth.models.dto.DocSearchDto;
import com.example.demoauth.models.entity.*;
import com.example.demoauth.models.enums.StatusCode;
import com.example.demoauth.repository.DocCategoryRepository;
import com.example.demoauth.repository.DocRepository;
import com.example.demoauth.repository.DocStatusRepository;
import com.example.demoauth.repository.UserRepository;
import com.example.demoauth.service.DocService;
import com.example.demoauth.service.EmailService;
import com.example.demoauth.service.UserService;
import com.example.demoauth.utils.ApiMessages;
import com.example.demoauth.utils.JwtUtil;
import com.example.demoauth.utils.specification.DocSpec;
import com.example.demoauth.utils.specification.SpecificationBuilder;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class DocServiceImpl implements DocService {

    DocRepository docRepository;
    DocCategoryRepository docCategoryRepository;
    DocStatusRepository docStatusRepository;
    UserRepository userRepository;

    UserService userService;
    EmailService emailService;

    @Override
    @Transactional
    public void save(DocCreateDto docCreateDto) {
        try {
            String username = JwtUtil.getUsername();
            Doc doc = new Doc();
            doc.setCategory(docCategoryRepository.findByCode(docCreateDto.getCategory()));
            doc.setStatus(docStatusRepository.findByCode(StatusCode.NEW));
            doc.setDescription(docCreateDto.getDescription());
            doc.setUser(userRepository.getByUsername(username));
            doc.setCreatedBy(username);
            doc.setLastModifiedDate(LocalDateTime.now());
            doc.setLastModifiedBy(username);
            doc.setCreatedDate(LocalDateTime.now());
            docRepository.save(doc);
        } catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public DocInfoDto findById(Long id) {
        Doc doc = getDoc(id);
        DocInfoDto docInfoDto = new DocInfoDto();
        docInfoDto.setId(doc.getId());
        docInfoDto.setStatus(doc.getStatus().getName());
        docInfoDto.setCategory(doc.getCategory().getName());
        String description = doc.getDescription();
        if (description != null){
            docInfoDto.setDescription(description);
        }
        User manager = doc.getManager();
        if(manager != null) {
            docInfoDto.setManager(doc.getManager().getLastname() + " " + doc.getManager().getFirstname() + " " + doc.getManager().getMidname());
        }
        User user = doc.getUser();
        if(user != null) {
            docInfoDto.setUser(doc.getUser().getLastname() + " " + doc.getUser().getFirstname() + " " + doc.getUser().getMidname());
            docInfoDto.setFaculty(doc.getUser().getFaculty().getName());
            docInfoDto.setProgram(doc.getUser().getProgram().getName());
            docInfoDto.setStudentIIN(doc.getUser().getStud_iin());
            docInfoDto.setStudFirstName(doc.getUser().getFirstname());
            docInfoDto.setStudLastName(doc.getUser().getLastname());
            docInfoDto.setStudMidName(doc.getUser().getMidname());
        }
        docInfoDto.setWorkDate(doc.getWorkDate());
        docInfoDto.setClosedDate(doc.getClosedDate());

        return docInfoDto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocInfoDto> findAll(DocSearchDto dto) {
        User user = userService.findByUsername(JwtUtil.getUsername());
        String username = JwtUtil.getUsername();
        String role = JwtUtil.getRole();
        Specification<Doc> docSpec = new SpecificationBuilder<>();

//        switch (role) {
//            case "ROLE_USER" -> docSpec.and(DocSpec.userFilter(user.getId()));
//       }
        if (Objects.nonNull(dto.getDateFrom()) && Objects.nonNull(dto.getDateTo())) {
            docSpec.and(DocSpec.dateFilter(dto.getDateFrom(), dto.getDateTo()));
        }
//        if (Objects.nonNull(dto.getCategory())) {
//            docSpec.and(DocSpec.categoryFilter(dto.getCategory()));
//        }
//        if (Objects.nonNull(dto.getStatus())) {
//            docSpec.and(DocSpec.statusFilter(dto.getStatus()));
//        }
        docSpec.and(DocSpec.docOrderByCreatedDate());
        List<Doc> docs = docRepository.findAll(docSpec);
        List<DocInfoDto> docInfoDtos = new ArrayList<>();
        for (Doc doc : docs){
            DocInfoDto docInfoDto = new DocInfoDto();
            docInfoDto.setId(doc.getId());
            DocStatus status = doc.getStatus();
            if (status != null) {
                docInfoDto.setStatus(status.getName());
            }
            DocCategory category = doc.getCategory();
            if(category != null) {
                docInfoDto.setCategory(category.getName());
            }
            docInfoDto.setDescription(doc.getDescription());
            User student = doc.getUser();
            if(student != null){
                docInfoDto.setUser(student.getLastname() + " "
                                + student.getFirstname() + " "
                                + student.getMidname());
                docInfoDto.setStudLastName(student.getLastname());
                docInfoDto.setStudFirstName(student.getFirstname());
                docInfoDto.setStudMidName(student.getMidname());
                UserFaculty faculty = student.getFaculty();
                if (faculty != null){
                    docInfoDto.setFaculty(faculty.getName());
                }
                docInfoDto.setStudentIIN(student.getStud_iin());
                EducationalProgram program = student.getProgram();
                if (program != null) {
                    docInfoDto.setProgram(program.getName());
                }
            }
            User manager = doc.getManager();
            if (manager != null) {
                docInfoDto.setManager(manager.getLastname() + " "
                                    + manager.getFirstname() + " "
                                    + manager.getMidname());
            }
            docInfoDto.setWorkDate(doc.getWorkDate());
            docInfoDto.setClosedDate(doc.getClosedDate());
            docInfoDtos.add(docInfoDto);
        }
        return docInfoDtos;
    }

    @Override
    @Transactional
    public void changeStatus(DocChangeStatusDto docChangeStatusDto) {
        Doc doc = getDoc(docChangeStatusDto.getId());
        User student = userRepository.getByUsername(doc.getUser().getUsername());
        String studentEmail = student.getEmail();
        String docId = docChangeStatusDto.getId().toString();
        String statusCode = docChangeStatusDto.getStatusCode().toString();
        String username = JwtUtil.getUsername();
        User user = userRepository.getByUsername(username);
        String managerFullName = "";
        if(user != null) {
            managerFullName += user.getLastname() + " " + user.getFirstname() + " " + user.getMidname();
        }
        doc.setStatus(docStatusRepository.findByCode(docChangeStatusDto.getStatusCode()));
        if(statusCode == StatusCode.IN_PROGRESS.toString()){
            doc.setWorkDate(LocalDateTime.now());
            doc.setManager(userRepository.getByUsername(username));
            doc.setLastModifiedBy(username);
            doc.setLastModifiedDate(LocalDateTime.now());
            emailService.sendEmail(studentEmail,
                    "Ваше обращение №" + docId + " взяли в работу",
                    "Добрый день!\n" +
                            "\n" +
                            "Вашего обращения №" + docId + " взято в работу " + managerFullName +
                            "\n" + "\n" +
                            "Это письмо создано автоматически. Отвечать на него не нужно\n" +
                            "\n" +
                            "С уважением, Ваш универ");
            log.info("Send in progress message to " + studentEmail);
        } else if (statusCode == StatusCode.CLOSED.toString()){
            doc.setClosedDate(LocalDateTime.now());
            doc.setManager(userRepository.getByUsername(username));
            doc.setLastModifiedBy(username);
            doc.setLastModifiedDate(LocalDateTime.now());
            emailService.sendEmail(studentEmail,
                    "Рассмотрение Вашего обращения №" + docId + " завершено",
                    "Добрый день!\n" +
                            "\n" +
                            "Рассмотрение Вашего обращения №" + docId + " завершено\n" +
                            "Скачать его можно будет в разделе Архив заявок\n" +
                            "\n" + "\n" +
                            "Это письмо создано автоматически. Отвечать на него не нужно\n" +
                            "\n" +
                            "С уважением, Ваш универ");
            log.info("Send closed message to " + studentEmail);
        }
        docRepository.save(doc);

    }

    private Doc getDoc(Long id) {
        return docRepository.findById(id).orElseThrow(() -> new DiplomaCoreException(
                HttpStatus.BAD_REQUEST, ApiMessages.DOC_NOT_FOUND, "Doc with this id not found"));
    }
}
