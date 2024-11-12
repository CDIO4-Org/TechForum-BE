package service.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IReportRepo;

@Service
public class ReportService implements IReportService{
    @Autowired
    private IReportRepo reportRepo;
}
