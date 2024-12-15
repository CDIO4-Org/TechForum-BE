package com.example.techforum.service.report;

import com.example.techforum.dto.ReportDto;
import com.example.techforum.model.Reports;

import java.util.List;

public interface IReportService {
    List<Reports> getReports();
    Reports addNewReports(ReportDto report);
}
