package com.example.demoauth.utils.specification;

import com.example.demoauth.models.entity.*;
import com.example.demoauth.models.enums.CategoryCode;
import com.example.demoauth.models.enums.StatusCode;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@UtilityClass
public class UserSpec {

    public Specification<User> usernameFilter(String username) {
        return (r, cq, cb) -> cb.equal(r.get(User.Fields.username), username);
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
