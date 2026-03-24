package com.company.issuetracker.service;

import com.company.issuetracker.model.*;
import com.company.issuetracker.repository.IssueRepository;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;

@Service
public class IssueService {

    private static final Logger logger = LoggerFactory.getLogger(IssueService.class);

    @Autowired
    private IssueRepository issueRepository;

    public List<Issue> getUnresolvedIssues(Long empId) {
        logger.info("Fetching unresolved issues for employee {}", empId);

        return issueRepository.findByEmployeeIdAndStatus(empId, IssueStatus.UNRESOLVED);
    }

    public List<Issue> getIssuesThisMonth() {
        logger.info("Fetching issues for current month");

        LocalDateTime start = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        LocalDateTime end = LocalDateTime.now();

        return issueRepository.findByCreatedAtBetween(start, end);
    }

    public List<String> getEmployeeNamesThisMonth() {
        logger.info("Fetching employee names who raised issues this month");

        LocalDateTime start = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        LocalDateTime end = LocalDateTime.now();

        return issueRepository.findEmployeeNamesByIssueMonth(start, end);
    }
}