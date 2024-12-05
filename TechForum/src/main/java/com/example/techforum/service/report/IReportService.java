package com.example.techforum.service.report;

import com.example.techforum.dto.BlogDto;
import com.example.techforum.dto.ReportDto;
import com.example.techforum.model.Blogs;
import com.example.techforum.model.Categories;
import com.example.techforum.model.Reports;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IReportService {
    List<Reports> getReports();
    Reports addNewReports(ReportDto report);
}
