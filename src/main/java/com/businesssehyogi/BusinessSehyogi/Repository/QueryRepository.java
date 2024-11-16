package com.businesssehyogi.BusinessSehyogi.Repository;

import com.businesssehyogi.BusinessSehyogi.model.Queries;
import com.businesssehyogi.BusinessSehyogi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueryRepository extends JpaRepository<Queries, InterestAreaRepository> {
    Queries findByQueryId(int queryId);

    List<Queries> findByUser(User user);
}
