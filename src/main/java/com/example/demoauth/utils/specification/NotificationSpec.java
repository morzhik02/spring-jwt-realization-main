package com.example.demoauth.utils.specification;

import com.example.demoauth.models.entity.Doc;
import com.example.demoauth.models.entity.Notification;
import com.example.demoauth.models.entity.User;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;

@UtilityClass
public class NotificationSpec {

    public Specification<Notification> docOrderByCreatedDate() {
        return (r, cq, cb) -> {
            Path<Notification> field = r.get(Notification.Fields.createdAt);
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
