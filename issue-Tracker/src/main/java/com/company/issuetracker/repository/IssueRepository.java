
package com.company.issuetracker.repository;

import com.company.issuetracker.model.*;
        import org.springframework.data.jpa.repository.*;
        import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

    List<Issue> findByEmployeeIdAndStatus(Long empId, IssueStatus status);

    List<Issue> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    @Query("SELECT i.employee.name FROM Issue i WHERE i.createdAt BETWEEN :start AND :end")
    List<String> findEmployeeNamesByIssueMonth(LocalDateTime start, LocalDateTime end);
}


//@repository
//list<issur> findemployeeidandstaus )