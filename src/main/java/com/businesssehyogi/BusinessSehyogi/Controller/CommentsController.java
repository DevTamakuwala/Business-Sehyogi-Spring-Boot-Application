package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.CommentsRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.PostRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.UserRepository;
import com.businesssehyogi.BusinessSehyogi.model.Comment;
import com.businesssehyogi.BusinessSehyogi.model.Post;
import com.businesssehyogi.BusinessSehyogi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.DELETE})
public class CommentsController {

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    // get all comments
    @GetMapping("/getComments")
    public List<Comment> getComments() {
        return commentsRepository.findAll();
    }

    //add comment
    @PostMapping("/addComment/{postId}/{userId}")
    public Comment addComment(@PathVariable("postId") int postId, @PathVariable("userId") int userId, @RequestParam("comment") String comment) {
        User user = userRepository.findByUserId(userId).orElse(null);
        Post post = postRepository.findByPostId(postId);

        if (user != null) {
            var date = LocalDateTime.now();
            Comment comment1 = new Comment(comment, post, date, user, true);
            commentsRepository.save(comment1);
            // Update the like count in the post
            post.setNoOfComments(commentsRepository.countByPost(post));
            postRepository.save(post);
            return comment1;
        } else {
            return null;
        }
    }

    //get comments for one post
    @GetMapping("/getCommentForPost/{postId}")
    public List<Comment> getCommentForPost(@PathVariable("postId") int postId) {
//        Pageable pageable = PageRequest.of(page, size);
        Post post = postRepository.findByPostId(postId);
        return commentsRepository.findByPost(post);
    }

    // delete comment
    @DeleteMapping("/deleteComment/{commentId}")
    public String deleteComment(@PathVariable("commentId") int commentId) {
        if (commentsRepository.existsById(commentId)) {
            commentsRepository.deleteById(commentId);
            return "Comment deleted successfully.";
        } else {
            return "Comment not found.";
        }
    }
}
