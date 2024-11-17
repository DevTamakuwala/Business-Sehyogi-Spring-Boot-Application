package com.businesssehyogi.BusinessSehyogi.Repository;

import com.businesssehyogi.BusinessSehyogi.model.Connections;
import com.businesssehyogi.BusinessSehyogi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConnectionsRepository extends JpaRepository<Connections, Integer> {
    Connections findByConnectionId(int connectionId);

    List<Connections> findByFounderUser(User user);
}
