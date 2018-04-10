package com.project.coursemanager.repositories;

import com.project.coursemanager.models.Widget;
import org.springframework.data.repository.CrudRepository;

public interface WidgetRepository  extends CrudRepository<Widget, Integer> {
}

