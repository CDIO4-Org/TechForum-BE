package com.example.techforum.repository;

import com.example.techforum.model.Reports;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IReportRepo extends CrudRepository<Reports, Integer> {
}
