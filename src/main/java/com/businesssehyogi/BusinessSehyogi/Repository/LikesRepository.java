package com.businesssehyogi.BusinessSehyogi.Repository;

import com.businesssehyogi.BusinessSehyogi.model.Like;
import com.businesssehyogi.BusinessSehyogi.model.Post;
import com.businesssehyogi.BusinessSehyogi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikesRepository extends JpaRepository<Like, Integer> {

    // Spring Data JPA will automatically generate the query based on method name
    List<Like> findByPost(Post post);

    long countByPost(Post post);

    // Method to find a Like by user and post
    boolean existsByUserAndPost(User user, Post post);

    Like findByUserAndPost(User user, Post post);
    // Or you can use a custom query if needed:
    // @Query("SELECT l FROM Like l WHERE l.post.postId = :postId")
    // List<Like> findLikesByPostId(@Param("postId") int postId);
}
