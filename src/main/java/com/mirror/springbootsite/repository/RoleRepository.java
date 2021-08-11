package com.mirror.springbootsite.repository;

import com.mirror.springbootsite.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("from Role role where role.role in (:role)")
    Set<Role> getRolesByRoleNames(@Param("role") String...roles);

}
