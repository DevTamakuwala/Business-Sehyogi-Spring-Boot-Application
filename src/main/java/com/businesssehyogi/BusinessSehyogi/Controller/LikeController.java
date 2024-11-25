package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.LikesRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.PostRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.UserRepository;
import com.businesssehyogi.BusinessSehyogi.model.Like;
import com.businesssehyogi.BusinessSehyogi.model.Post;
import com.businesssehyogi.BusinessSehyogi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class LikeController {

    @Autowired
    LikesRepository likesRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    //get all likes for admin
    @GetMapping("/getAllLikes")
    public List<Like> getAllLikes() {
        return likesRepository.findAll();
    }

    // add new like
    @PostMapping("/addLike/{userId}/{postId}")
    public String addLike(@PathVariable("userId") int userId, @PathVariable("postId") int postId) {
        // Retrieve the User object using userId
        User user = userRepository.findByUserId(userId).orElse(null);

        // Retrieve the Post object using postId
        Post post = postRepository.findByPostId(postId);

        // Check if user and post are valid
        if (user != null && post != null) {
            // Check if the user has already liked the post
            boolean alreadyLiked = likesRepository.existsByUserAndPost(user, post);
            Like like1 = likesRepository.findByUserAndPost(user, post);
            if (alreadyLiked) {
                likesRepository.deleteById(like1.getLikeId());
                return "User has already liked this post!";
            } else {
                // Create a new Like object
                Like like = new Like(user, post);

                // Save the Like object in the repository
                likesRepository.save(like);

                // Update the like count in the post
                post.setNoOfLikes(likesRepository.countByPost(post));
                postRepository.save(post);

                return "Like added successfully!";
            }
        } else {
            return "User or Post not found!";
        }
    }


    //get likes for post to show
    @GetMapping("/getLikes/{postId}")
    public List<Like> getLikesForPost(@PathVariable("postId") int postId) {
        // Retrieve the Post object using postId
        Post post = postRepository.findById(postId).orElse(null);

        if (post != null) {
            // Get all likes for the specified post
            return likesRepository.findByPost(post);
        } else {
            return null; // Or handle the case where the post is not found
        }
    }


    //get total number of likes
    @GetMapping("/getTotalLikesOfPost/{postId}")
    public Long getTotalLikesOfPost(@PathVariable("postId") int postId) {
        // Retrieve the Post object using postId
        Post post = postRepository.findById(postId).orElse(null);

        if (post != null) {
            // Get all likes for the specified post
            return likesRepository.countByPost(post);
        } else {
            return null; // Or handle the case where the post is not found
        }
    }
}
