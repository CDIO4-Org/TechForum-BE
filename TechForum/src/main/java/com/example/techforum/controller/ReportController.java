package com.example.techforum.controller;

import com.example.techforum.dto.ReportDto;
import com.example.techforum.model.Reports;
import com.example.techforum.service.report.IReportService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class ReportController {
    @Autowired
    private IReportService reportService;

    @PostMapping("/addNewReports")
    public ResponseEntity<Reports> addNewReports(@RequestBody @Valid ReportDto report) {
        Reports saveReports = reportService.addNewReports(report);
        return new ResponseEntity<>(saveReports,HttpStatus.CREATED);
    }
    @GetMapping("/getPageReport")
    public ResponseEntity<Page<Reports>> getPageReport(
            @RequestParam(defaultValue = "0") int page, // Trang bắt đầu, mặc định là 0
            @RequestParam(defaultValue = "1") int size,
            @RequestParam(defaultValue = "reportDate,asc") String[] sort// Kích thước mỗi trang, mặc định là 10
    ) {
        Sort.Direction direction = Sort.Direction.fromString(sort[1]);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));

        Page<Reports> reports = reportService.findBy(pageable);
        return ResponseEntity.ok(reports);
    }

    @PutMapping("/updateReport/{id}")
    public ResponseEntity<Reports> updateReport(@PathVariable("id") Integer id, @RequestBody ReportDto report) throws MessagingException {
        return new ResponseEntity<>(reportService.updateReport(id,report),HttpStatus.OK);
    }
}


