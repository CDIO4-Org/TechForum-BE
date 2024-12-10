package com.example.techforum.repository;

import com.example.techforum.model.Reports;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IReportRepo extends CrudRepository<Reports, Integer> {
    @Query(value = "select * from reports", nativeQuery = true)
    List<Reports> getAllReports();
}
