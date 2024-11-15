package com.example.techforum.service.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.techforum.repository.IReportRepo;

@Service
public class ReportService implements IReportService{
    @Autowired
    private IReportRepo reportRepo;
}
