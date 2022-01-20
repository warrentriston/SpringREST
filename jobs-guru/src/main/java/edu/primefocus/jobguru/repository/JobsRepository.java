package edu.primefocus.jobguru.repository;

import edu.primefocus.jobguru.dataaccessobject.Jobs;
import edu.primefocus.jobguru.dataaccessobject.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Long> {
}
