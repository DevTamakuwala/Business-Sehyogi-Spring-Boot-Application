package com.businesssehyogi.BusinessSehyogi.Repository;

import com.businesssehyogi.BusinessSehyogi.model.Comment;
import com.businesssehyogi.BusinessSehyogi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Integer> {
    Long countByPost(Post post);

    List<Comment> findByPost(Post post);
}
