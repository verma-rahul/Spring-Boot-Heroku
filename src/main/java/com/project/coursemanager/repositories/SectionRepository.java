package com.project.coursemanager.repositories;

import com.project.coursemanager.models.Section;
import org.springframework.data.repository.CrudRepository;

public interface SectionRepository  extends CrudRepository<Section, Integer> {
}
