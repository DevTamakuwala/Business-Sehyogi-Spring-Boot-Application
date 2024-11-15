package com.businesssehyogi.BusinessSehyogi.Repository;

import com.businesssehyogi.BusinessSehyogi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT p FROM Post p WHERE p.visible = true ORDER BY p.noOfLikes DESC, p.dateAndTime DESC")
    List<Post> findPostsSortedByLikesAndUploadDate();

    @Query("SELECT p FROM Post p WHERE p.user.userId = :userId")
    List<Post> findByUserUserId(@Param("userId") int userId);

    @Query("SELECT p FROM Post p ORDER BY (p.noOfInterested + p.noOfLikes + SIZE(p.comments)) DESC")
    List<Post> findTopPosts();

}
