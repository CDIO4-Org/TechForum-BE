package com.example.techforum.service.report;

import com.example.techforum.dto.ReportDto;
import com.example.techforum.model.Reports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.IReportRepo;

import java.util.List;

@Service
public class ReportService implements IReportService{
    @Autowired
    private IReportRepo reportRepo;

    @Override
    public List<Reports> getReports() {
        return reportRepo.getAllReports();
    }



    @Override
    public Reports addNewReports(ReportDto report) {
        return reportRepo.save(dtoToObject(report));
    }
    public Reports dtoToObject(ReportDto reportDTO){
        return new Reports(reportDTO);
    }
}
