package com.henrik86.blog.repository;

import com.henrik86.blog.domain.UserExtra;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the UserExtra entity.
 */
@SuppressWarnings("unused")
public interface UserExtraRepository extends JpaRepository<UserExtra,Long> {

}
