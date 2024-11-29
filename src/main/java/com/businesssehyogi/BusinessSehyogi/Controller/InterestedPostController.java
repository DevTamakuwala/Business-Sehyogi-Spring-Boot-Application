package com.businesssehyogi.BusinessSehyogi.Controller;

import com.businesssehyogi.BusinessSehyogi.Repository.InterestedPostsRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.InvestorRepository;
import com.businesssehyogi.BusinessSehyogi.Repository.PostRepository;
import com.businesssehyogi.BusinessSehyogi.Service.sendEmail;
import com.businesssehyogi.BusinessSehyogi.model.InterestedPosts;
import com.businesssehyogi.BusinessSehyogi.model.Investor;
import com.businesssehyogi.BusinessSehyogi.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class InterestedPostController {

    @Autowired
    InterestedPostsRepository interestedPostsRepository;

    @Autowired
    InvestorRepository investorRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    sendEmail email;

    @GetMapping("/getAllInterestedPosts")
    public List<InterestedPosts> getAllInterestedPosts() {
        return interestedPostsRepository.findAll();
    }

    @GetMapping("/getAllInterestedPostsOfInvestor/{investorId}")
    public List<InterestedPosts> getAllInterestedPostsOfInvestor(@PathVariable("investorId") int investorId) {
        Investor investor = investorRepository.findByInvestorId(investorId);
        return interestedPostsRepository.findByInvestor(investor);
    }

    @PostMapping("/addInterestedPost")
    public String addInterestedPost(@RequestParam("investorId") int investorId, @RequestParam("postId") int postId) {
        Investor investor = investorRepository.findByInvestorId(investorId);
        Post post = postRepository.findByPostId(postId);

        if (investor != null && post != null) {
            boolean alreadyInterested = interestedPostsRepository.existsByInvestorAndPost(investor, post);
            InterestedPosts interestedPosts1 = interestedPostsRepository.findByInvestorAndPost(investor, post);
            if (alreadyInterested) {
                interestedPostsRepository.deleteById(interestedPosts1.getInterestedPostId());
                return "Interest Deleted";
            } else {
                InterestedPosts interestedPosts = new InterestedPosts(investor, post);

                interestedPostsRepository.save(interestedPosts);
                email.sendMail(investor.getUserId().getEmail(), "Details of the post that you have interacted.",
                        "Recently you have shown your interest to one post on our platform, Here are all the information that you may required for connection with the owner." +
                                "\nPost:\n" + post.getAbstractContent() + " " +
                                "\nPoster name: " + post.getUser().getFirstName() + " " + post.getUser().getLastName() + "" +
                                "\nContact info: " +
                                "\nEmail address: " + post.getUser().getEmail() + " " +
                                "\n\nThank you for using our platform." +
                                "\nFeel free to connect with us using businesssehyogi@gmail.com" +
                                "\nTeam Business Sehyogi");

                email.sendMail(post.getUser().getEmail(), "Hurray \uD83C\uDF89\uD83C\uDF89\uD83C\uDF89, One investor is interested in your IDEA",
                        "Recently One more investor has shown their interest in your business idea, This can be the good opportunity to grow your business." +
                                "\nHere are all the information that you may required for connection with the Investor." +
                                "\nPost:\n" + post.getAbstractContent() + " " +
                                "\nInvestor name: " + investor.getUserId().getFirstName() + " " + investor.getUserId().getLastName() +
                                "\nContact info: " +
                                "\nEmail address: " + investor.getUserId().getEmail() + " " +
                                "\n\nThank you for using our platform." +
                                "\nFeel free to connect with us using businesssehyogi@gmail.com" +
                                "\nTeam Business Sehyogi");
                return "Interested";
            }
        } else {
            return "User not found.";
        }
    }

    @GetMapping("/getAllInterestForPost")
    public List<InterestedPosts> getAllInterestForPost(@RequestParam("postId") int postId) {
        Post post = postRepository.findByPostId(postId);
        return interestedPostsRepository.findByPost(post);
    }
}
