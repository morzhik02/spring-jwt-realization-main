package com.example.demoauth.utils.specification;

import com.example.demoauth.models.entity.*;
import com.example.demoauth.models.enums.CategoryCode;
import com.example.demoauth.models.enums.StatusCode;
import com.example.demoauth.service.UserService;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import java.util.Date;
import java.util.List;

@UtilityClass
public class DocSpec {
    public Specification<Doc> userFilter(Long userId) {
        return (r, cq, cb) -> cb.equal(r.get(Doc.Fields.user).get(BaseEntity.Fields.id), userId);
    }

    public Specification<Doc> managerFilter(Long managerId) {
        return (r, cq, cb) -> cb.equal(r.get(Doc.Fields.manager).get(BaseEntity.Fields.id), managerId);
    }

    public Specification<Doc> categoryFilter(CategoryCode category) {
        return (r, cq, cb) -> cb.equal(r.get(Doc.Fields.category).get(DocCategory.Fields.code),
                category);
    }

    public Specification<Doc> statusFilter(StatusCode status) {
        return (r, cq, cb) -> cb.equal(r.get(Doc.Fields.status).get(DocStatus.Fields.code), status);
    }

    public Specification<Doc> docIdFilter(Long id) {
        return (r, cq, cb) -> cb.equal(r.get(BaseEntity.Fields.id), id);
    }

    public Specification<Doc> withStatusesFilter(List<StatusCode> statuses) {
        return (r, cq, cb) -> r.get(Doc.Fields.status).get(DocStatus.Fields.code).in(statuses);
    }

    public Specification<Doc> managerLoginFilter(String managerLogin) {
        return (r, cq, cb) -> cb.equal(r.get(Doc.Fields.manager).get(User.Fields.username), managerLogin);
    }

    public Specification<Doc> facultyFilter(String facultyId) {
        return (r, cq, cb) -> cb.equal(r.get(Doc.Fields.user).get(User.Fields.faculty), facultyId);
    }

    public Specification<Doc> dateFilter(Date dateFrom, Date dateTo) {
        return (r, cq, cb) -> cb.and(cb.greaterThanOrEqualTo(r.get(Doc.Fields.createdAt), dateFrom),
                cb.lessThan(r.get(Doc.Fields.createdAt), DateUtils.addDays(dateTo, 1)));
    }

    public Specification<Doc> docOrderByCreatedDate() {
        return (r, cq, cb) -> {
            Path<Doc> field = r.get(Doc.Fields.createdAt);
            switchDirection(Sort.Direction.DESC, cq, cb, field);
            return cb.and();
        };
    }

    private void switchDirection(
            Sort.Direction direction, CriteriaQuery<?> cq, CriteriaBuilder cb, Path<?> field) {
        switch (direction) {
            case ASC:
                cq.orderBy(cb.asc(field));
                break;
            case DESC:
                cq.orderBy(cb.desc(field));
                break;
        }
    }


}
