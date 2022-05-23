package com.repository;

import com.entities.Authority;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface AuthorityRepository extends JpaRepository<Authority, Integer>, JpaSpecificationExecutor<Authority> {

    Optional<Authority> findByAuthorityName(String name);

    Page<Authority> findAllByAuthorityNameLike(String authorityName, Pageable pageable);

    // 1.admin 2, user, 3, staff
    Set<Authority> findAllByIdIn(List<Integer> ids);
}
