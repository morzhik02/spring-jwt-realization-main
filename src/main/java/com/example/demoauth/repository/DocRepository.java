package com.example.demoauth.repository;

import com.example.demoauth.models.entity.Doc;
import com.example.demoauth.models.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocRepository extends JpaRepository<Doc, Long> {
    Page<Doc> findAllByUser(User user, Pageable pageable);

//    Page<Post> findAllByDistrict(District district, Pageable pageable);
//
//    Page<Post> findAllByCity(City city, Pageable pageable);
}
