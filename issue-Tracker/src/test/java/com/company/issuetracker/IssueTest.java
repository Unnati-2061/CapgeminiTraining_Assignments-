package com.company.issuetracker;

import com.company.issuetracker.api.IssueController;
import com.company.issuetracker.model.Issue;
import com.company.issuetracker.model.IssueStatus;
import com.company.issuetracker.repository.IssueRepository;
import com.company.issuetracker.service.IssueService;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IssueController.class)
public class IssueTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IssueService issueService;

    @Mock
    private IssueRepository issueRepository;

    @InjectMocks
    private IssueService realService;


    @Test
    void testGetUnresolvedIssuesAPI() throws Exception {

        when(issueService.getUnresolvedIssues(1L))
                .thenReturn(List.of(new Issue()));

        mockMvc.perform(get("/issues/employee/1/unresolved"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetIssuesThisMonthAPI() throws Exception {

        when(issueService.getIssuesThisMonth())
                .thenReturn(List.of(new Issue()));

        mockMvc.perform(get("/issues/this-month"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetEmployeeNamesThisMonthAPI() throws Exception {

        when(issueService.getEmployeeNamesThisMonth())
                .thenReturn(List.of("Unnati"));

        mockMvc.perform(get("/issues/employees/this-month"))
                .andExpect(status().isOk());
    }



    @Test
    void testGetUnresolvedIssuesService() {

        MockitoAnnotations.openMocks(this);

        Issue issue = new Issue();
        issue.setStatus(IssueStatus.UNRESOLVED);

        when(issueRepository.findByEmployeeIdAndStatus(1L, IssueStatus.UNRESOLVED))
                .thenReturn(List.of(issue));

        List<Issue> result = realService.getUnresolvedIssues(1L);

        assertEquals(1, result.size());
    }

    @Test
    void testGetIssuesThisMonthService() {

        MockitoAnnotations.openMocks(this);

        Issue issue = new Issue();
        issue.setCreatedAt(LocalDateTime.now());

        when(issueRepository.findByCreatedAtBetween(any(), any()))
                .thenReturn(List.of(issue));

        List<Issue> result = realService.getIssuesThisMonth();

        assertFalse(result.isEmpty());
    }

    @Test
    void testGetEmployeeNamesThisMonthService() {

        MockitoAnnotations.openMocks(this);

        when(issueRepository.findEmployeeNamesByIssueMonth(any(), any()))
                .thenReturn(List.of("Unnati"));

        List<String> result = realService.getEmployeeNamesThisMonth();

        assertEquals("Unnati", result.get(0));
    }
}