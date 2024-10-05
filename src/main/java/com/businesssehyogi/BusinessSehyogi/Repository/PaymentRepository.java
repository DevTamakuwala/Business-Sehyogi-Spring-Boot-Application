package com.businesssehyogi.BusinessSehyogi.Repository;

import com.businesssehyogi.BusinessSehyogi.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("SELECT COUNT(p) > 0 FROM Payment p JOIN p.users u JOIN p.posts po WHERE u.userId = :userId AND po.postId = :postId")
    boolean hasUserPaidForPost(@Param("userId") int userId, @Param("postId") int postId);
}
