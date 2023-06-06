package com.mdbytes.restful.webservices.api.social.media.jpa;

import com.mdbytes.restful.webservices.api.social.media.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
