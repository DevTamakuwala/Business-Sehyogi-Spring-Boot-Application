package com.businesssehyogi.BusinessSehyogi.Repository;

import com.businesssehyogi.BusinessSehyogi.DTO.loginDTO;
import com.businesssehyogi.BusinessSehyogi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    boolean existsByUserNameIgnoreCase(String username);

    @Query("SELECT new com.businesssehyogi.BusinessSehyogi.DTO.loginDTO(u.userId, u.userName, u.password, u.visible) FROM User u WHERE u.userName = :username")
    loginDTO login(@Param("username") String username);
}
