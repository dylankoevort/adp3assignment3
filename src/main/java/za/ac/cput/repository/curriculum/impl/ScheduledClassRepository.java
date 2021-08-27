package za.ac.cput.repository.curriculum.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.curriculum.ScheduledClass;

@Repository
public interface ScheduledClassRepository extends JpaRepository<ScheduledClass, String> {
}
