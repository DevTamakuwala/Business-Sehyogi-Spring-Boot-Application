//package com.businesssehyogi.BusinessSehyogi.Repository;
//
//import com.businesssehyogi.BusinessSehyogi.model.Result;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//public interface ResultRepo extends JpaRepository<Result, Integer> {
//
//    @Query("SELECT r FROM Result r JOIN FETCH r.alien a where a.aid = :alienId")
//    List<Result> findResultByAlienId(@Param("alienId") int alienId);
//
//}
