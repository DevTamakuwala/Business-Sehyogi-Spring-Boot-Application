package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.DTO.AbstractPostResponse;
import com.businesssehyogi.BusinessSehyogi.DTO.FullPostResponse;
import com.businesssehyogi.BusinessSehyogi.DTO.PostRequest;
import com.businesssehyogi.BusinessSehyogi.Repository.InterestAreaRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.PaymentRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.PostRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.UserRepo;
import com.businesssehyogi.BusinessSehyogi.model.InterestArea;
import com.businesssehyogi.BusinessSehyogi.model.Post;
import com.businesssehyogi.BusinessSehyogi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private InterestAreaRepository interestAreaRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/getPostForHomePage/{userId}")
    public List<Object> getPostForHomePage(@PathVariable int userId) {
        List<Post> posts = postRepository.findPostsSortedByLikesAndUploadDate();
        List<Object> result = new ArrayList<>();

        for (Post post : posts) {
            boolean hasPaid = paymentRepository.hasUserPaidForPost(userId, post.getPostId());

            if (hasPaid) {
                // If user has paid, return the full content with images and links
                FullPostResponse fullPostResponse = new FullPostResponse(
                        post.getPostId(),
                        post.getDateAndTime(),
                        post.getAbstractContent(),
                        post.getContent(),
                        post.getNoOfLikes(),
                        post.getNoOfInterested(),
                        post.isVisible(),
                        post.getViews(),
                        post.isBoostedPost(),
                        post.getImages(),
                        post.getLinks()
                );
                result.add(fullPostResponse);
            } else {
                // If user hasn't paid, return only the abstract content with images and links
                result.add(new AbstractPostResponse(
                        post.getPostId(),
                        post.getDateAndTime(),
                        post.getAbstractContent(),
                        post.getNoOfLikes(),
                        post.getNoOfInterested(),
                        post.isVisible(),
                        post.getViews(),
                        post.isBoostedPost()
                ));
            }
        }

        return result;
    }

    // Fetch a single post by ID, applying payment check for content visibility
    @GetMapping("/getPostById/{userId}/{postId}")
    public ResponseEntity<Object> getPostById(@PathVariable int userId, @PathVariable int postId) {
        Optional<Post> postOptional = postRepository.findById(postId);

        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            boolean hasPaid = paymentRepository.hasUserPaidForPost(userId, postId);

            if (hasPaid) {
                // Return full post content if the user has paid
                FullPostResponse fullPostResponse = new FullPostResponse(
                        post.getPostId(),
                        post.getDateAndTime(),
                        post.getAbstractContent(),
                        post.getContent(),
                        post.getNoOfLikes(),
                        post.getNoOfInterested(),
                        post.isVisible(),
                        post.getViews(),
                        post.isBoostedPost(),
                        post.getImages(),
                        post.getLinks()
                );
                return ResponseEntity.ok(fullPostResponse);
            } else {
                // Return only abstract content if the user hasn't paid
                AbstractPostResponse abstractPostResponse = new AbstractPostResponse(
                        post.getPostId(),
                        post.getDateAndTime(),
                        post.getAbstractContent(),
                        post.getNoOfLikes(),
                        post.getNoOfInterested(),
                        post.isVisible(),
                        post.getViews(),
                        post.isBoostedPost()
                );
                return ResponseEntity.ok(abstractPostResponse);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getPosts")
    public List<Object> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<Object> result = new ArrayList<>();

        for (Post post : posts) {
            FullPostResponse fullPostResponse = new FullPostResponse(
                    post.getPostId(),
                    post.getDateAndTime(),
                    post.getAbstractContent(),
                    post.getContent(),
                    post.getNoOfLikes(),
                    post.getNoOfInterested(),
                    post.isVisible(),
                    post.getViews(),
                    post.isBoostedPost(),
                    post.getImages(),
                    post.getLinks()
            );
            result.add(fullPostResponse);
        }

        return result;
    }

    @GetMapping("/getPostsForFounder/{userId}")
    public List<Post> getPostsForFounder(@PathVariable("userId") int userId) {
        return postRepository.findByUserUserId(userId);
    }


    @GetMapping("/getPostById/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable int id) {
        Optional<Post> post = postRepository.findById(id);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable int id) {
        Post post = postRepository.findById(id).orElse(new Post());
        if (post.isVisible()) {
            post.setVisible(false);
            postRepository.save(post);
            return "Post deleted successfully..!!";
        }
        return "";
    }

    @PostMapping("/addPost")
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest) {
        // Fetch the User and InterestArea entities based on the IDs in the request
        Optional<User> userOptional = userRepo.findById(postRequest.getUserId());
        Optional<InterestArea> areaOptional = interestAreaRepository.findById(postRequest.getAreaId());

        if (userOptional.isEmpty() || areaOptional.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        Post post = new Post();
        post.setDateAndTime(postRequest.getDateAndTime());
        post.setAbstractContent(postRequest.getAbstractContent());
        post.setContent(postRequest.getContent());
        post.setNoOfLikes(postRequest.getNoOfLikes());
        post.setNoOfInterested(postRequest.getNoOfInterested());
        post.setVisible(postRequest.isVisible());
        post.setViews(postRequest.getViews());
        post.setBoostedPost(postRequest.isBoostedPost());
        post.setUser(userOptional.get());
        post.setAreaOfPost(areaOptional.get());
        Post savedPost = postRepository.save(post);
        return ResponseEntity.ok(savedPost);
    }


    @PutMapping("updatePost/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post postDetails) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            post.setDateAndTime(LocalDateTime.now());
            post.setAbstractContent(postDetails.getAbstractContent());
            post.setContent(postDetails.getContent());
            post.setNoOfLikes(postDetails.getNoOfLikes());
            post.setNoOfInterested(postDetails.getNoOfInterested());
            post.setVisible(postDetails.isVisible());
            post.setViews(postDetails.getViews());
            post.setBoostedPost(postDetails.isBoostedPost());
            post.setUser(postDetails.getUser());
            post.setAreaOfPost(postDetails.getAreaOfPost());
            return ResponseEntity.ok(postRepository.save(post));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
