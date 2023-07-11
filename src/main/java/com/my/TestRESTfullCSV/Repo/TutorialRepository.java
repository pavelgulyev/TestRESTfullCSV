package com.my.TestRESTfullCSV.Repo;

import com.my.TestRESTfullCSV.Entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}