package com.businesssehyogi.BusinessSehyogi.Repository;

import com.businesssehyogi.BusinessSehyogi.model.InterestedPosts;
import com.businesssehyogi.BusinessSehyogi.model.Investor;
import com.businesssehyogi.BusinessSehyogi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestedPostsRepository extends JpaRepository<InterestedPosts, Integer> {
    void deleteByInvestorAndPost(Investor investor, Post post);

    boolean existsByInvestorAndPost(Investor investor, Post post);

    InterestedPosts findByInvestorAndPost(Investor investor, Post post);
}
