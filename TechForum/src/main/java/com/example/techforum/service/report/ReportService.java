package com.example.techforum.service.report;

import com.example.techforum.dto.ReportDto;
import com.example.techforum.model.Reports;
import com.example.techforum.repository.IBlogRepo;
import com.example.techforum.service.blog.IBlogService;
import com.example.techforum.service.mailsender.EmailRegister;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.IReportRepo;

import java.util.List;

@Service
public class ReportService implements IReportService{
    @Autowired
    private EmailRegister emailRegister;
    @Autowired
    private IReportRepo reportRepo;

    @Autowired
    private IBlogRepo blogRepo;
    @Override
    public List<Reports> getReports() {
        return reportRepo.getAllReports();
    }



    @Override
    public Reports addNewReports(ReportDto report) {
        return reportRepo.save(dtoToObject(report));
    }

    @Override
    public Page<Reports> findBy(Pageable pageable) {
        Page<Reports> reports = reportRepo.findBy(pageable);
        return reports;
    }

    @Override
    public Reports updateReport(Integer id, ReportDto report) throws MessagingException {
        Reports reports = reportRepo.findById(id).get();
        reports.setStatus(true);
        blogRepo.updateBlogReport(report.getBlog().getId());
        emailRegister.sendEmailReport(report.getUser(), report.getBlog(), report.getContent(), report.getReportDate());
        return reportRepo.save(reports);
    }

    public Reports dtoToObject(ReportDto reportDTO){
        return new Reports(reportDTO);
    }
}
