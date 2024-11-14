package com.dolgosheev.to_do_list.repository;

import com.dolgosheev.to_do_list.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {

}
