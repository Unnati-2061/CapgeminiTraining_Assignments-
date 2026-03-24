package com.company.issuetracker.api;

import com.company.issuetracker.model.Issue;
import com.company.issuetracker.service.IssueService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssueController {

    private static final Logger logger = LoggerFactory.getLogger(IssueController.class);

    @Autowired
    private IssueService issueService;

    @GetMapping("/employee/{id}/unresolved")
    public ResponseEntity<List<Issue>> getUnresolved(@PathVariable Long id) {
        logger.info("API hit for unresolved issues");

        return ResponseEntity.ok(issueService.getUnresolvedIssues(id));
    }

    @GetMapping("/this-month")
    public ResponseEntity<List<Issue>> getThisMonth() {
        return ResponseEntity.ok(issueService.getIssuesThisMonth());
    }

    @GetMapping("/employees/this-month")
    public ResponseEntity<List<String>> getEmployeeNames() {
        return ResponseEntity.ok(issueService.getEmployeeNamesThisMonth());
    }
}