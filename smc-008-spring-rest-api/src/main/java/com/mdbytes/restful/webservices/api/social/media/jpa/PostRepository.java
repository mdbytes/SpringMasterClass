package com.mdbytes.restful.webservices.api.social.media.jpa;

import com.mdbytes.restful.webservices.api.social.media.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
