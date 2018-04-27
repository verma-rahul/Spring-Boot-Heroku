package com.project.coursemanager.repositories;

import com.project.coursemanager.models.Module;
import org.springframework.data.repository.CrudRepository;

public interface ModuleRepository  extends CrudRepository<Module, Integer> {
}
