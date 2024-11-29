package com.businesssehyogi.BusinessSehyogi.Repository;

import com.businesssehyogi.BusinessSehyogi.model.InterestedPosts;
import com.businesssehyogi.BusinessSehyogi.model.Investor;
import com.businesssehyogi.BusinessSehyogi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestedPostsRepository extends JpaRepository<InterestedPosts, Integer> {
    void deleteByInvestorAndPost(Investor investor, Post post);

    boolean existsByInvestorAndPost(Investor investor, Post post);

    InterestedPosts findByInvestorAndPost(Investor investor, Post post);

    List<InterestedPosts> findByPost(Post post);

    List<InterestedPosts> findByInvestor(Investor investor);
}
