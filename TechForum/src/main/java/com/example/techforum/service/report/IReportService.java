package com.example.techforum.service.report;

import com.example.techforum.dto.ReportDto;
import com.example.techforum.model.Reports;
import jakarta.mail.MessagingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IReportService {
    List<Reports> getReports();
    Reports addNewReports(ReportDto report);
    Page<Reports> findBy(Pageable pageable);
    Reports updateReport(Integer id,ReportDto report) throws MessagingException;
}
